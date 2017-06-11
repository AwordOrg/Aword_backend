package aword.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2017/5/12 0012.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String password;
    private String email;//用于激活和找回密码的邮箱

    //原先单词库
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    private List<Word> wordListNo=new ArrayList<Word>();//不复习的单词List
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    private List<Word> wordList0=new ArrayList<Word>();//待复习的单词list（对应status为0的）
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    private List<Word> wordList1=new ArrayList<Word>();//（对应status为1的）
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    private List<Word> wordList2=new ArrayList<Word>();//（对应status为2的）


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

    public List<Word> getWordListNo() {
        return wordListNo;
    }

    public void setWordListNo(List<Word> wordListNo) {
        this.wordListNo = wordListNo;
    }

    public List<Word> getWordList0() {
        return wordList0;
    }

    public void setWordList0(List<Word> wordList0) {
        this.wordList0 = wordList0;
    }

    public List<Word> getWordList1() {
        return wordList1;
    }

    public void setWordList1(List<Word> wordList1) {
        this.wordList1 = wordList1;
    }

    public List<Word> getWordList2() {
        return wordList2;
    }

    public void setWordList2(List<Word> wordList2) {
        this.wordList2 = wordList2;
    }
}
