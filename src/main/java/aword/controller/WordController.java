package aword.controller;

import aword.entity.Response;
import aword.entity.Word;
import aword.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lee on 2017/6/7 0007.
 */
@RestController
@RequestMapping(value = "/word")
public class WordController {

    @Autowired
    private WordService wordService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Response addWord(@RequestBody Word word){
        Word wordres=wordService.saveWord(word);
        return new Response().success(wordres);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response updateWord(@RequestParam(name = "id")Long id,@RequestBody Word word){
        Word wordres=wordService.updateWord(id,word);
        return new Response().success(wordres);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Response deleteWord(@RequestParam(name = "id")Long id){
        wordService.deleteWord(id);
        return new Response().success();
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Response getWord(@RequestParam(name = "id")Long id){
        Word word=wordService.getWordById(id);
        return new Response().success(word);
    }
}
