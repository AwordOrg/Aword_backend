package aword.controller;

import aword.entity.Response;
import aword.entity.User;
import aword.entity.Word;
import aword.service.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 复习
 * Created by Lee on 2017/6/7 0007.
 */
@RestController
@RequestMapping(value = "/review")
public class ReviewController {
    @Autowired
    WordListService wordListService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Response getReviewWord(){
        Word word=wordListService.getWordForLearnning();
        return new Response().success(word);
    }

    @RequestMapping(value = "/easy",method = RequestMethod.GET)
    public Response getEasy(){
        Word word=wordListService.acceptEsay();
        return new Response().success(word);
    }

    @RequestMapping(value = "/know",method = RequestMethod.GET)
    public Response getKnow(){
        Word word=wordListService.acceptKnown();
        return new Response().success(word);
    }

    @RequestMapping(value = "/unknow",method = RequestMethod.GET)
    public Response getUnknown(){
        Word word=wordListService.acceptUnknown();
        return new Response().success(word);
    }
}
