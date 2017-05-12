package aword.entity;

/**
 * Created by Lee on 2017/5/12 0012.
 */
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;//用于激活和找回密码的邮箱

    private WordHouse wordHouse;//单词库


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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