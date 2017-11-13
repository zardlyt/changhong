package com.changhong.dataconversion.controller;

import com.changhong.dataconversion.entity.DataConvert;
import com.changhong.dataconversion.service.DataConvertService;
import com.changhong.exceptionhandle.RestResult;
import com.changhong.exceptionhandle.RestResultGenerator;
import com.changhong.semanticmanage.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Administrator on 2017/11/9.
 */
@RestController
@RequestMapping(value = "/dataConvert")
public class DataConvertController {

    @Autowired
    DataConvertService dataConvertService;

    @RequestMapping(value = "/query")
    public RestResult<PageBean<DataConvert>> getDataConvertPage(@RequestBody DataConvert dataConvert){
        PageBean<DataConvert> pageBean = dataConvertService.getDataConvertPage(dataConvert);
        return RestResultGenerator.genSuccessResult(pageBean);
    }

    @RequestMapping(value = "/delete")
    public RestResult delete(@RequestBody DataConvert dataConvert){
        dataConvertService.delete(dataConvert.getId());
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/update")
    public RestResult update(@RequestBody DataConvert dataConvert){
        dataConvertService.update(dataConvert);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/insert")
    public RestResult insert(@RequestBody DataConvert dataConvert){
        dataConvertService.insert(dataConvert);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public RestResult upload(@RequestParam(value = "upfile") MultipartFile file) throws IOException {
        if(file==null) return RestResultGenerator.genErrorResult("请上传文件");
        String name = file.getOriginalFilename();
        long size = file.getSize();
        if(name==null || ("").equals(name) && size==0) return RestResultGenerator.genErrorResult("请上传文件");
        return dataConvertService.upload(file);
    }
}
