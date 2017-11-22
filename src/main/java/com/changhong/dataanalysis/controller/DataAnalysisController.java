package com.changhong.dataanalysis.controller;

import com.changhong.dataanalysis.entity.DataCount;
import com.changhong.dataanalysis.service.DataAnalysisService;
import com.changhong.exceptionhandle.RestResult;
import com.changhong.exceptionhandle.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */
@RestController
@RequestMapping(value = "/dataAnalysis")
public class DataAnalysisController {

    @Autowired
    DataAnalysisService dataAnalysisService;

    @RequestMapping(value = "/month/query")
    public RestResult<List<DataCount>> getDataAnalysisMonth(@RequestBody DataCount dataCount){
        List<DataCount> list = dataAnalysisService.getDataAnalysisMonth(dataCount);
        return RestResultGenerator.genSuccessResult(list);
    }

    @RequestMapping(value = "/day/query")
    public RestResult<List<DataCount>> getDataAnalysisDay(@RequestBody DataCount dataCount){
        List<DataCount> list = dataAnalysisService.getDataAnalysisDay(dataCount);
        return RestResultGenerator.genSuccessResult(list);
    }

    @RequestMapping(value = "/count/query")
    public RestResult<DataCount> getDataAnalysisCount(){
        DataCount dataCount = dataAnalysisService.getDataAnalysisCount();
        return RestResultGenerator.genSuccessResult(dataCount);
    }
}
