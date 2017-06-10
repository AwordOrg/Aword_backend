package aword.service;

import aword.entity.WordHouse;
import aword.repository.WordHouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lee on 2017/6/10 0010.
 */
@Service
public class WordHouseService {

    @Autowired
    private WordHouseDao wordHouseDao;


    public void saveWordHouse(WordHouse wordHouse) {

    }
}
