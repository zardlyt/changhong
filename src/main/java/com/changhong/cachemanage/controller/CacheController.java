package com.changhong.cachemanage.controller;

import com.changhong.cachemanage.entity.Cache;
import com.changhong.cachemanage.service.CacheService;
import com.changhong.semanticmanage.entity.PageBean;
import com.changhong.semanticmanage.entity.Semantic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
@Controller
@RequestMapping(value = "/cache")
public class CacheController {
    @Autowired
    CacheService cacheService;
    @RequestMapping(value = "/query")
    public String getAll(){
        int c = 3;
        PageBean<Cache> pageBean = cacheService.getAll(c);
        List<Cache> list = pageBean.getList();
        Cache cache = list.get(0);
        System.out.print(cache.getQuiz());
        return "";
    }

    @RequestMapping(value = "/edit")
    public String getOne(){
        int i = 11;
        Cache cache = cacheService.getOne(i);
        System.out.print(cache.getQuiz());
        return "";
    }

    @RequestMapping(value = "/delete")
    public String delete(){
        int i = 14;
        cacheService.delete(i);
        return "";
    }

    @RequestMapping(value = "/update")
    public String update(){
        Cache cache = new Cache();
        cache.setQuiz("泉水");
        cache.setId(11);
        cacheService.update(cache);
        return "";
    }

    @RequestMapping(value = "/insert")
    public String insert(){
        Cache cache = new Cache();
        cache.setQuiz("大话");
        cache.setAnswer("西游");
        cacheService.insert(cache);
        return "";
    }

    @RequestMapping(value = "/deleteAll")
    public String deleteAll(){
        return "";
    }

}
