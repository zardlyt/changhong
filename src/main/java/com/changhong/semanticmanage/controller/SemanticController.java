package com.changhong.semanticmanage.controller;

import com.changhong.semanticmanage.entity.PageBean;
import com.changhong.semanticmanage.entity.Semantic;
import com.changhong.semanticmanage.service.SemanticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
@Controller
@RequestMapping(value = "/semantic")
public class SemanticController {
    @Autowired
    SemanticService semanticService;
    @RequestMapping(value = "/query")
    public String getSemanticPage(){
        Semantic s = new Semantic();
        s.setPageNo(2);
        PageBean<Semantic> pageBean = semanticService.getSemanticPage(s);
        List<Semantic> list = pageBean.getList();
        Semantic semantic = list.get(0);
        System.out.print(semantic.getSquery());
        return "index";
    }

    @RequestMapping(value = "/annul")
    public String annul(){
        Semantic semantic = new Semantic();
        semanticService.update(semantic);
        return "";
    }

    @RequestMapping(value = "/examine")
    public String examine(){
        Semantic semantic = new Semantic();
        semanticService.update(semantic);
        return "";
    }

    @RequestMapping(value = "/ignore")
    public String ignore(){
        Semantic semantic = new Semantic();
        semanticService.update(semantic);
        return "";
    }

    @RequestMapping(value = "/add")
    public String add(){
        Semantic semantic = new Semantic();
        semanticService.update(semantic);
        return "";
    }


}
