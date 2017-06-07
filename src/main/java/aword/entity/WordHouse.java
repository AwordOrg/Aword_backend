package aword.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 单词库(每个单词库对应一个user)
 * Created by Lee on 2017/5/12 0012.
 */
@Entity
public class WordHouse {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Word> wordListNo=new ArrayList<Word>();//不复习的单词List
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Word> wordList0=new ArrayList<Word>();//待复习的单词list（对应status为0的）
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Word> wordList1=new ArrayList<Word>();//（对应status为1的）
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Word> wordList2=new ArrayList<Word>();//（对应status为2的）

    @OneToOne(mappedBy = "word_house",fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
