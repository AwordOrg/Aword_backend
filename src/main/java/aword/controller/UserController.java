package aword.controller;

import aword.entity.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lee on 2017/5/13 0013.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public Response login(){
        return new Response().success();
    }


}
