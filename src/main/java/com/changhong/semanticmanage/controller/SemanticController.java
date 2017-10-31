package com.changhong.semanticmanage.controller;

import com.changhong.exceptionhandle.RestResult;
import com.changhong.exceptionhandle.RestResultGenerator;
import com.changhong.semanticmanage.entity.PageBean;
import com.changhong.semanticmanage.entity.Semantic;
import com.changhong.semanticmanage.entity.Synonym;
import com.changhong.semanticmanage.service.SemanticService;
import com.changhong.semanticmanage.service.SynonymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/18.
 */
@RestController
@RequestMapping(value = "/semantic")
public class SemanticController {
    @Autowired
    SemanticService semanticService;
    @Autowired
    SynonymService synonymService;

    @RequestMapping(value = "/query")
    public RestResult<PageBean<Semantic>> getSemanticPage(@RequestBody Semantic semantic){
        PageBean<Semantic> pageBean = semanticService.getSemanticPage(semantic);
        return RestResultGenerator.genSuccessResult(pageBean);
    }

    @RequestMapping(value = "/annul")
    public RestResult annul(@RequestBody Semantic semantic){
        semanticService.update(semantic);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/examine")
    public RestResult examine(@RequestBody Map map){
        Semantic semantic = new Semantic();
        semantic.setId((Integer) map.get("id"));
        semantic.setState((Integer) map.get("state"));
        Synonym synonym = new Synonym();
        synonym.setEntity_name((String) map.get("query"));
        synonym.setSimilar_words((String) map.get("spellCheck"));
        synonymService.update(synonym);
        semanticService.update(semantic);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/ignore")
    public RestResult ignore(@RequestBody Semantic semantic){
        semanticService.update(semantic);
        return RestResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/add")
    public RestResult add(@RequestBody Map map){
        Semantic semantic = new Semantic();
        semantic.setId((Integer) map.get("id"));
        semantic.setState((Integer) map.get("state"));
        Synonym synonym = new Synonym();
        synonym.setEntity_name((String) map.get("query"));
        synonym.setSimilar_words((String) map.get("spellCheck"));
        semanticService.update(semantic);
        synonymService.update(synonym);
        return RestResultGenerator.genSuccessResult();
    }
}
