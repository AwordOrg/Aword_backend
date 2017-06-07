package aword.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * Created by Lee on 2017/5/12 0012.
 */
@Entity
public class User {
    private Long id;
    private String name;
    private String password;
    private String email;//用于激活和找回密码的邮箱

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private WordHouse wordHouse;//单词库


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public WordHouse getWordHouse() {
        return wordHouse;
    }

    public void setWordHouse(WordHouse wordHouse) {
        this.wordHouse = wordHouse;
    }
}
