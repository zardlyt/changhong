package com.changhong.requestmanage.controller;

import com.changhong.exceptionhandle.RestResult;
import com.changhong.exceptionhandle.RestResultGenerator;
import com.changhong.requestmanage.entity.RequestModel;
import com.changhong.requestmanage.service.RequestService;
import com.changhong.semanticmanage.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/20.
 */
@RestController
@RequestMapping(value = "/request")
public class RequestController {

    @Autowired
    RequestService requestService;

    @RequestMapping(value = "/record/query")
    public RestResult<PageBean<RequestModel>> getRequestPage(@RequestBody RequestModel requestModel){
        PageBean<RequestModel> pageBean = requestService.getRequestPage(requestModel);
        return RestResultGenerator.genSuccessResult(pageBean);
    }

    @RequestMapping(value = "/collect/house")
    public RestResult updateCollect(@RequestBody RequestModel requestModel){
        requestService.updateCollect(requestModel);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/collect/query")
    public RestResult<PageBean<RequestModel>> getCollectPage(@RequestBody RequestModel requestModel){
        PageBean<RequestModel> pageBean = requestService.getCollectPage(requestModel);
        return RestResultGenerator.genSuccessResult(pageBean);
    }

    @RequestMapping(value = "/collect/cancel")
    public RestResult cancelCollect(@RequestBody RequestModel requestModel){
        requestService.cancelCollect(requestModel);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/most/query")
    public RestResult<PageBean<RequestModel>> getMostPage(@RequestBody RequestModel requestModel){
        PageBean<RequestModel> pageBean = requestService.getMostPage(requestModel);
        return RestResultGenerator.genSuccessResult(pageBean);
    }
}
