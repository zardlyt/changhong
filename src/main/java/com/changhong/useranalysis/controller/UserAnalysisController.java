package com.changhong.useranalysis.controller;

import com.changhong.exceptionhandle.RestResult;
import com.changhong.exceptionhandle.RestResultGenerator;
import com.changhong.useranalysis.entity.UserCount;
import com.changhong.useranalysis.service.UserAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
@RestController
@RequestMapping(value = "/userAnalysis")
public class UserAnalysisController {

    @Autowired
    UserAnalysisService userAnalysisService;

    @RequestMapping(value = "/month/query")
    public RestResult<List<UserCount>> getUserAnalysisMonth(){
        List<UserCount> list = userAnalysisService.getUserAnalysisMonth();
        return RestResultGenerator.genSuccessResult(list);
    }
}
