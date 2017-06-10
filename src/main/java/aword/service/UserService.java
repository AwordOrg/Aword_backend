package aword.service;

import aword.entity.User;
import aword.entity.Word;
import aword.repository.UserDao;
import aword.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lee on 2017/6/10 0010.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User checkUserPassword(User user) {
        String userName=user.getName();
        String password=user.getPassword();
        if (StringUtil.isEmpty(userName)||StringUtil.isEmpty(password)){
            return null;
        }
        User checkedUser=userDao.findByName(userName);
        if (checkedUser.getPassword().equals(password)){

            return checkedUser;
        }
        return null;
    }


    public void signIn(User user) throws Exception {
        String userName=user.getName();
        String password=user.getPassword();
        if (StringUtil.isEmpty(userName)||StringUtil.isEmpty(password)){
            throw new Exception("注册失败，用户名或密码为空");
        }
        userDao.save(user);
    }

    public void addWordToWordList0(Word word,String username) {
        User user=userDao.findByName(username);
        user.getWordList0().add(word);
        userDao.save(user);
    }
}
