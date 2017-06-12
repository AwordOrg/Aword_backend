import aword.BackendApp;
import aword.entity.User;
import aword.entity.Word;
import aword.repository.UserDao;
import aword.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.BDDMockito.given;

/**
 * Created by Lee on 2017/6/12 0012.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BackendApp.class})
@Transactional
public class UserServiceTest {
//    @MockBean
//    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    public void checkUserPasswordTest(){
        User user=new User();
        user.setName("lee");
        user.setPassword("lee");
//        given(this.userDao.findByName("lee")).willReturn(user);
        User checkUser=userService.checkUserPassword(user);
        Assert.assertEquals(user.getName(),checkUser.getName());
        Assert.assertEquals(user.getPassword(),checkUser.getPassword());
    }


    @Test
    public void signInTest() throws Exception {
        User user=new User();
        user.setName("lee");
        user.setPassword("lee");
        userService.signIn(user);
    }

    @Test
    public void addWordToWordList0Test(){
        Word word=new Word();
        word.setName("test");
        word.setMean("测试");
        word.setStatus(0);
        word.setCount(0);
        word.setSymbol("test");

        userService.addWordToWordList0(word,"lee");
    }
}
