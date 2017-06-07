package aword.controller;

import aword.entity.Response;
import aword.entity.WordHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Created by Lee on 2017/6/7 0007.
 */
@RestController
@RequestMapping(value = "/wordHouse")
public class WordHouseController {

    @Autowired
    WordHouseService wordHouseService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Response addWordHouse(@RequestBody WordHouse wordHouse){
        wordHouseService.saveWordHouse(wordHouse);
        return new Response().success();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Response deleteWordHouse(@RequestParam(name = "id")Long id){
        wordHouseService.deleteWordHouse(id);
        return new Response().success();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response updateWordHouse(@RequestParam(name = "id")Long id,@RequestBody WordHouse wordHouse){
        wordHouseService.updateWordHouse(id,wordHouse);
        return new Response().success();
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Response getWordHouse(@RequestParam(name = "id")Long id){
        WordHouse wordHouse=wordHouseService.getWordHouseById(id);
        return new Response().success(wordHouse);
    }

}
