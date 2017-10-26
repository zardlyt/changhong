package com.changhong.semanticmanage.controller;

import com.changhong.exceptionhandle.RestResult;
import com.changhong.exceptionhandle.RestResultGenerator;
import com.changhong.semanticmanage.entity.PageBean;
import com.changhong.semanticmanage.entity.Semantic;
import com.changhong.semanticmanage.service.SemanticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
@RestController
@RequestMapping(value = "/semantic")
public class SemanticController {
    @Autowired
    SemanticService semanticService;
    @RequestMapping(value = "/query")
    public RestResult<PageBean<Semantic>> getSemanticPage(@RequestParam(value = "page",defaultValue = "1")Integer page, @RequestParam(value = "day", required=false)Integer day, @RequestParam(value = "state", required=false)Integer state, @RequestParam(value = "method", required=false)String method, @RequestParam(value = "type", required=false)String type){
        Semantic s = new Semantic();
        s.setState(state);
        s.setMethod(method);
        s.setStype(type);
        s.setPageNo(page);
        s.setDay(day);
        PageBean<Semantic> pageBean = semanticService.getSemanticPage(s);
        return RestResultGenerator.genSuccessResult(pageBean);
    }

    @RequestMapping(value = "/annul")
    public RestResult annul(@RequestParam(value = "state",required=false)Integer state,@RequestParam(value = "id",required=false,defaultValue = "1")Integer id){
        Semantic semantic = new Semantic();
        semantic.setState(state);
        semantic.setId(id);
        semanticService.update(semantic);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/examine")
    public RestResult examine(@RequestParam(value = "state",required=false)Integer state,@RequestParam(value = "id",required=false,defaultValue = "1")Integer id,@RequestParam(value = "spellCheck",required=false)String spellCheck,@RequestParam(value = "query",required=false)String query){
        Semantic semantic = new Semantic();
        semanticService.update(semantic);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/ignore")
    public RestResult ignore(@RequestParam(value = "state",required=false)Integer state,@RequestParam(value = "id",required=false,defaultValue = "1")Integer id){
        Semantic semantic = new Semantic();
        semantic.setState(state);
        semantic.setId(id);
        semanticService.update(semantic);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/add")
    public RestResult add(@RequestParam(value = "state",required=false)Integer state,@RequestParam(value = "id",required=false,defaultValue = "1")Integer id,@RequestParam(value = "spellCheck",required=false)String spellCheck,@RequestParam(value = "query",required=false)String query){
        Semantic semantic = new Semantic();
        semanticService.update(semantic);
        return RestResultGenerator.genSuccessResult();
    }

}
