package aword.service.impl;

import aword.entity.User;
import aword.entity.Word;
import aword.entity.WordHouse;
import aword.repository.UserDao;
import aword.repository.WordDao;
import aword.repository.WordHouseDao;
import aword.service.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 复用这个service有疑点。下面有解决方案
 * Created by Lee on 2017/6/7 0007.
 */
@Service
public class WordListServiceImpl implements WordListService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private WordHouseDao wordHouseDao;

    @Autowired
    private WordDao wordDao;

    private List<Word> reviewWordList;

    /**
     * 从status为0，1，2的单词中随机取12，15，3个（如果少于，则能取多少取多少）
     * @return 返回一个供User复习的单词队列
     */
    @Override
    public void setWordListForLearning(Long uid) {
        User user=userDao.findOne(uid);
        WordHouse wordHouse=wordHouseDao.findByUser(user);

        List<Word> list0=wordHouse.getWordList0();
        List<Word> list1=wordHouse.getWordList1();
        List<Word> list2=wordHouse.getWordList2();
        for (Word word:list0){
            reviewWordList.add(word);
        }
        for (Word word:list1){
            reviewWordList.add(word);
        }
        for (Word word:list2){
            reviewWordList.add(word);
        }
    }

    /**
     * 从getWordListForLearnning()返回的队列中取得一个给前端
     * @return
     */
    @Override
    public Word getWordForLearnning(Long uid) {
        init(uid);

        Word word=reviewWordList.get(0);
        reviewWordList.remove(0);
        finish(word);
        return word;
    }

    private void finish(Word word) {//todo 当word为null时，就是用户不再拿单词的时候，这时候将队列置null，以便可以给之后的用户复用这个 service
        if (word==null){
            reviewWordList=null;
        }
    }

    private void init(Long uid) {
        //todo 设初值,当用户a使用这个service时，可以保证若干次请求都是使用同一个队列，直到用户a不需要再使用这个service时，会调用finish使其恢复初始状态，以便其他用户使用
        if (reviewWordList==null){
            reviewWordList=new ArrayList<>();
            setWordListForLearning(uid);
        }

    }

    /**
     * 接受到『太简单』时执行的业务
     * @return 返回下一个单词给前端
     */
    @Override
    public Word acceptEsay(Long wid) {//将该单词的status设为-1，并且返回下一个单词
        Word ww=wordDao.findOne(wid);
        ww.setStatus(-1);
        wordDao.save(ww);
        Word word=reviewWordList.get(0);
        reviewWordList.remove(0);
        finish(word);
        return word;
    }

    /**
     * 接受到『认识』时执行的业务
     * @return 返回下一个单词给前端
     */
    @Override
    public Word acceptKnown(Long wid) {//设置该单词状态，返回下一个单词
        Word ww=wordDao.findOne(wid);
        ww.setCount(ww.getCount()+1);
        if (ww.getCount()>=5){
            ww.setStatus(2);
        }else {
            ww.setStatus(1);
        }
        wordDao.save(ww);

        Word word=reviewWordList.get(0);
        reviewWordList.remove(0);
        finish(word);
        return word;
    }

    /**
     * 接受到『不认识』时执行的业务
     * @return 返回下一个单词给前端
     */
    @Override
    public Word acceptUnknown(Long wid) {//设置该单词状态，将单词再一次插入队列中,返回下一个单词
        Word ww=wordDao.findOne(wid);
        ww.setCount(0);
        ww.setStatus(0);
        wordDao.save(ww);
        reviewWordList.add(ww);

        Word word=reviewWordList.get(0);
        reviewWordList.remove(0);
        finish(word);
        return word;
    }
}
