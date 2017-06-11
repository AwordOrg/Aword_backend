package aword.repository;

import aword.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Lee on 2017/6/7 0007.
 */
public interface UserDao extends JpaRepository<User,Long>{

    User findByName(String username);

    @Query("select u from User u left join fetch u.wordList0 where u.name=?1")
    User findByNameFetchWordList0(String username);

    @Query("select u from User u left join fetch u.wordList1 where u.name=?1")
    User findByNameFetchWordList1(String username);

    @Query("select u from User u left join fetch u.wordList2 where u.name=?1")
    User findByNameFetchWordList2(String username);

    @Query("select u from User u left join fetch u.wordListNo where u.name=?1")
    User findByNameFetchWordListNo(String username);


    @Query("select u from User u left join fetch u.wordList0 where u.id=?1")
    User findByIdFetchWordList0(Long uid);

    @Query("select u from User u left join fetch u.wordList1 where u.id=?1")
    User findByIdFetchWordList1(Long uid);

    @Query("select u from User u left join fetch u.wordList2 where u.id=?1")
    User findByIdFetchWordList2(Long uid);

    @Query("select u from User u left join fetch u.wordListNo where u.id=?1")
    User findByIdFetchWordListNo(Long uid);
}
