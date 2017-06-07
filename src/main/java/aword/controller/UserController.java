package aword.controller;

import aword.entity.Response;
import aword.entity.User;
import aword.security.IgnoreSecurity;
import aword.security.TokenManager;
import aword.security.web.WebContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Lee on 2017/5/13 0013.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final String DEFAULT_TOKEN_NAME = "X-Token";

    @Autowired
    private UserService userService;

    @Autowired
    private TokenManager tokenManager;


    /**
     * 登录，成功时加入token
     * @param httpServletResponse
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)//如果需要验证的url需要使用RequestMapping注解，我设置了一个切面，用来拦截这个注解，如果需要不拦截这个url，可以使用@IgnoreSecurity，详见类SecurityAspect
    @IgnoreSecurity
    public Response login(@RequestBody User user, HttpServletResponse httpServletResponse){
        User checkedUser=userService.checkUserPassword(user);
        if (checkedUser!=null){
            String token=tokenManager.createToken(checkedUser.getName());//加入token到cookie
            Cookie tokenCookie=new Cookie(DEFAULT_TOKEN_NAME,token);
            tokenCookie.setMaxAge(-1);//关闭浏览器即清除Cookie
            httpServletResponse.addCookie(tokenCookie);
            checkedUser.setPassword(null);
            return new Response().success(checkedUser);
        }
        return new Response().failure("login_failure");
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/signin" ,method = RequestMethod.POST)
    @IgnoreSecurity
    public Response signin(@RequestBody User user){
        userService.signIn(user);
        return new Response().success();
    }

    /**
     * 在header拿到该token，然后移除该token
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public Response logout() {
        String token = WebContext.getRequest().getHeader(DEFAULT_TOKEN_NAME);
        tokenManager.removeToken(token);
        return new Response().success();
    }

    //todo 邮箱验证以及通过验证邮箱找回密码的需求


}
