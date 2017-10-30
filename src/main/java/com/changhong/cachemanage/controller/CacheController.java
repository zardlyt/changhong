package com.changhong.cachemanage.controller;

import com.changhong.cachemanage.entity.Cache;
import com.changhong.cachemanage.entity.PageInfo;
import com.changhong.cachemanage.service.CacheService;
import com.changhong.exceptionhandle.RestResult;
import com.changhong.exceptionhandle.RestResultGenerator;
import com.changhong.semanticmanage.entity.PageBean;
import com.changhong.semanticmanage.entity.Semantic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
@RestController
@RequestMapping(value = "/cache")
public class CacheController {
    @Autowired
    CacheService cacheService;
    @RequestMapping(value = "/custom/query")
    public RestResult<PageBean<Cache>> getCachePage(@RequestParam(value="page",required=false,defaultValue = "1") Integer page,@RequestParam(value="quiz", required=false) String quiz){
        Cache cache = new Cache();
        cache.setPageNo(page);
        cache.setQuiz(quiz);
        PageBean<Cache> pageBean = cacheService.getCachePage(cache);
        return RestResultGenerator.genSuccessResult(pageBean);
    }

    @RequestMapping(value = "/custom/edit")
    public RestResult<Cache> getOne(@RequestParam(value="id",required=false,defaultValue = "1") Integer id){
        Cache cache = cacheService.getOne(id);
        return RestResultGenerator.genSuccessResult(cache);
    }

    @RequestMapping(value = "/custom/delete")
    public RestResult delete(@RequestParam(value="id",required=false,defaultValue = "1") Integer id){
        cacheService.delete(id);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/custom/update")
    public RestResult update(@RequestParam(value="id",required=false,defaultValue = "1") Integer id,@RequestParam(value="quiz", required=false) String quiz,@RequestParam(value="answer", required=false) String answer){
        Cache cache = new Cache();
        cache.setQuiz(quiz);
        cache.setAnswer(answer);
        cache.setId(id);
        cacheService.update(cache);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/custom/insert")
    public RestResult insert(@RequestParam(value="quiz", required=false) String quiz,@RequestParam(value="answer", required=false) String answer){
        Cache cache = new Cache();
        cache.setQuiz(quiz);
        cache.setAnswer(answer);
        cacheService.insert(cache);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/custom/upload")
    public RestResult upload(@RequestParam(value = "upfile", required=false) MultipartFile file){
        //if(file==null) return null;
        String name = file.getOriginalFilename();
        long size = file.getSize();
        //if(name==null || ("").equals(name) && size==0) return null;
        cacheService.upload(file);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/log/deleteAll")
    public RestResult deleteAll(){
        cacheService.deleteAll();
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/log/delete")
    public RestResult logDelete(@RequestParam(value = "key", required=false)String key){
        cacheService.logDelete(key);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/log/query")
    public RestResult<Cache> logQurey(@RequestParam(value="key", required=false) String key){
        Cache cache = cacheService.logQuery(key);
        return RestResultGenerator.genSuccessResult(cache);
    }
}
