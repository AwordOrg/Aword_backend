package aword.controller;

import aword.entity.Response;
import aword.entity.User;
import aword.entity.Word;
import aword.service.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 复习
 * Created by Lee on 2017/6/7 0007.
 */
@RestController
@RequestMapping(value = "/review")
public class ReviewController {
    @Autowired
    private WordListService wordListService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Response getReviewWord(@RequestParam(name = "uid")Long uid){
        Word word=wordListService.getWordForLearnning(uid);
        return new Response().success(word);
    }

    @RequestMapping(value = "/easy",method = RequestMethod.GET)
    public Response getEasy(@RequestParam(name = "wid")Long wid){
        Word word=wordListService.acceptEsay(wid);
        return new Response().success(word);
    }

    @RequestMapping(value = "/know",method = RequestMethod.GET)
    public Response getKnow(@RequestParam(name = "wid")Long wid){
        Word word=wordListService.acceptKnown(wid);
        return new Response().success(word);
    }

    @RequestMapping(value = "/unknow",method = RequestMethod.GET)
    public Response getUnknown(@RequestParam(name = "wid")Long wid){
        Word word=wordListService.acceptUnknown(wid);
        return new Response().success(word);
    }
}
