package aword.service;

import aword.entity.Word;
import aword.repository.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lee on 2017/6/10 0010.
 */
@Service
public class WordService {
    @Autowired
    private WordDao wordDao;


    public Word saveWord(Word word) {
        return wordDao.save(word);
    }


    public Word updateWord(Long id, Word word) {
        Word word1=wordDao.findOne(id);
        word1.setName(word.getName());
        word1.setSymbol(word.getSymbol());
        word1.setMean(word.getMean());
        word1.setCount(word.getCount());
        word1.setStatus(word.getStatus());
        return wordDao.save(word1);
    }


    public void deleteWord(Long id) {
        wordDao.delete(id);
    }

    public Word getWordById(Long id) {
        return wordDao.findOne(id);
    }
}
