package aword.entity;


/**
 * Created by Lee on 2017/5/12 0012.
 */
public class Word {
    private Integer id;
    private String name;//单词
    private String symbol;//音标
    private String mean;//释义

    private int count;
    private int status;//-1代表不复习;0代表待复习;1代表已复习;2代表熟识

    public Word() {
    }

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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
