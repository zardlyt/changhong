package com.changhong.cachemanage.controller;

import com.changhong.cachemanage.entity.Cache;
import com.changhong.cachemanage.entity.PageInfo;
import com.changhong.cachemanage.service.CacheService;
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
    public PageBean<Cache> getCachePage(@RequestParam(value="page",required=false,defaultValue = "1") Integer page){
        PageBean<Cache> pageBean = cacheService.getCachePage(page);
        return pageBean;
    }

    @RequestMapping(value = "/custom/edit")
    public Cache getOne(@RequestParam(value="id",required=false,defaultValue = "1") Integer id){
        Cache cache = cacheService.getOne(id);
        return cache;
    }

    @RequestMapping(value = "/custom/delete")
    public void delete(@RequestParam(value="id",required=false,defaultValue = "1") Integer id){
        cacheService.delete(id);
    }

    @RequestMapping(value = "/custom/update")
    public void update(@RequestParam(value="id",required=false,defaultValue = "1") Integer id,@RequestParam(value="quiz", required=false) String quiz,@RequestParam(value="answer", required=false) String answer){
        Cache cache = new Cache();
        cache.setQuiz(quiz);
        cache.setAnswer(answer);
        cache.setId(id);
        cacheService.update(cache);
    }

    @RequestMapping(value = "/custom/insert")
    public void insert(@RequestParam(value="quiz", required=false) String quiz,@RequestParam(value="answer", required=false) String answer){
        Cache cache = new Cache();
        cache.setQuiz(quiz);
        cache.setAnswer(answer);
        cacheService.insert(cache);
    }

    @RequestMapping(value = "/custom/upload")
    public void upload(@RequestParam(value = "upfile", required=false) MultipartFile file){
        //if(file==null) return null;
        String name = file.getOriginalFilename();
        long size = file.getSize();
        //if(name==null || ("").equals(name) && size==0) return null;
        cacheService.upload(file);
    }

    @RequestMapping(value = "/log/deleteAll")
    public void deleteAll(){
        cacheService.deleteAll();
    }

    @RequestMapping(value = "/log/delete")
    public void logDelete(@RequestParam(value = "key", required=false)String key){
        cacheService.logDelete(key);
    }

    @RequestMapping(value = "/log/query")
    public Cache logQurey(@RequestParam(value="key", required=false) String key){
        Cache cache = cacheService.logQuery(key);
        return cache;
    }

}
