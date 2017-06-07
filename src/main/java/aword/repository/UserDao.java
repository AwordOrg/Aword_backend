package aword.repository;

import aword.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lee on 2017/6/7 0007.
 */
public interface UserDao extends JpaRepository<User,Long>{

}
