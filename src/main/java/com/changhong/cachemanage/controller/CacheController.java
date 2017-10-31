package com.changhong.cachemanage.controller;

import com.changhong.cachemanage.entity.Cache;
import com.changhong.cachemanage.entity.PageInfo;
import com.changhong.cachemanage.service.CacheService;
import com.changhong.exceptionhandle.RestResult;
import com.changhong.exceptionhandle.RestResultGenerator;
import com.changhong.semanticmanage.entity.PageBean;
import com.changhong.semanticmanage.entity.Semantic;
import com.changhong.utils.JsonUtils;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/18.
 */
@RestController
@RequestMapping(value = "/cache")
public class CacheController {
    @Autowired
    CacheService cacheService;
    @RequestMapping(value = "/custom/query")
    public RestResult<PageBean<Cache>> getCachePage(@RequestBody Cache cache){
        PageBean<Cache> pageBean = cacheService.getCachePage(cache);
        return RestResultGenerator.genSuccessResult(pageBean);
    }

    @RequestMapping(value = "/custom/delete")
    public RestResult delete(@RequestBody Cache cache){
        cacheService.delete(cache.getId());
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/custom/update")
    public RestResult update(@RequestBody Cache cache){
        cacheService.update(cache);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/custom/insert")
    public RestResult insert(@RequestBody Cache cache){
        cacheService.insert(cache);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/custom/upload")
    public RestResult upload(@RequestParam(value = "upfile", required=false) MultipartFile file){
        if(file==null) return null;
        String name = file.getOriginalFilename();
        long size = file.getSize();
        if(name==null || ("").equals(name) && size==0) return null;
        cacheService.upload(file);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/log/deleteAll")
    public RestResult deleteAll(){
        cacheService.deleteAll();
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/log/delete")
    public RestResult logDelete(@RequestBody Map map){
        cacheService.logDelete((String) map.get("key"));
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/log/query")
    public RestResult<Cache> logQurey(@RequestBody Map map){
        Cache cache = cacheService.logQuery((String) map.get("key"));
        return RestResultGenerator.genSuccessResult(cache);
    }
}
