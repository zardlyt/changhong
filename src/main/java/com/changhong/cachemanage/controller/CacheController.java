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
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
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

    @RequestMapping(value = "/custom/upload", method = RequestMethod.POST)
    public RestResult upload(@RequestParam(value = "upfile") MultipartFile file) throws IOException {
        if(file==null) return RestResultGenerator.genErrorResult("请上传文件");
        String name = file.getOriginalFilename();
        long size = file.getSize();
        if(name==null || ("").equals(name) && size==0) return RestResultGenerator.genErrorResult("请上传文件");
        return cacheService.upload(file);
    }

    @RequestMapping(value = "/custom/download")
    public RestResult download(HttpServletResponse response) throws IOException {
        Workbook wb = cacheService.download();
        String fileName = URLEncoder.encode("自定义缓存.xls", "utf-8");
        response.setHeader("Content-disposition", "attachment;filename="+fileName);
        OutputStream os = response.getOutputStream();
        wb.write(os);
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
