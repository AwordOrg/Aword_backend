package aword.service;

import aword.entity.Word;

import java.util.List;

/**
 * 对应类图中的『待复习的消息队列』
 * Created by Lee on 2017/5/12 0012.
 */
public interface WordListService {

    /**
     * 从status为0，1，2的单词中随机取15，12，3个（如果少于，则能取多少取多少）
     * @return 返回一个供User复习的单词队列
     */
    List<Word> getWordListForLearnning();

    /**
     * 从getWordListForLearnning()返回的队列中取得一个给前端
     * @return
     */
    Word getWordForLearnning();

    /**
     * 接受到『太简单』时执行的业务
     * @return 返回下一个单词给前端
     */
    Word acceptEsay();

    /**
     * 接受到『认识』时执行的业务
     * @return 返回下一个单词给前端
     */
    Word acceptKnown();

    /**
     * 接受到『不认识』时执行的业务
     * @return 返回下一个单词给前端
     */
    Word acceptUnknown();
}
