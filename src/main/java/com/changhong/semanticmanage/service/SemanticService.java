package com.changhong.semanticmanage.service;
import com.changhong.semanticmanage.entity.PageBean;
import com.changhong.semanticmanage.entity.Semantic;
import com.changhong.semanticmanage.mapper.SemanticMapper;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
@Service
public class SemanticService {
    @Autowired
    SemanticMapper semanticMapper;

    public PageBean<Semantic> getSemanticPage(Semantic semantic){
        PageBean<Semantic> pageBean = new PageBean<Semantic>();
        int page = semantic.getPageNo();
        pageBean.setPage(page);
        int limit = 30;
        pageBean.setLimit(limit);
        int totalCount = 0;
        totalCount = semanticMapper.getSemanticCount(semantic);
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if(totalCount % limit ==0){
            totalPage=totalCount/limit;

        }else {
            totalPage= totalCount/limit +1;
        }
        pageBean.setTotalPage(totalPage);
        int begin = (page-1)*limit;
        semantic.setBegin(begin);
        semantic.setLimit(limit);
        List<Semantic> list = semanticMapper.getSemanticPage(semantic);
        pageBean.setList(list);
        return pageBean;
    }

    public void update(Semantic semantic){
        semanticMapper.update(semantic);
    }
}
