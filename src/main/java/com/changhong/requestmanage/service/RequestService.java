package com.changhong.requestmanage.service;

import com.changhong.requestmanage.entity.RequestModel;
import com.changhong.requestmanage.mapper.RequestMapper;
import com.changhong.semanticmanage.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/20.
 */
@Service
public class RequestService {

    @Autowired
    RequestMapper requestMapper;

    public PageBean<RequestModel> getRequestPage(RequestModel requestModel){
        PageBean<RequestModel> pageBean = new PageBean<RequestModel>();
        int page = requestModel.getPageNo();
        pageBean.setPage(page);
        int limit = 30;
        pageBean.setLimit(limit);
        int totalCount = 0;
        totalCount = requestMapper.getRequestCount(requestModel);
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if(totalCount % limit ==0){
            totalPage=totalCount/limit;
        }else {
            totalPage= totalCount/limit +1;
        }
        pageBean.setTotalPage(totalPage);
        int begin = (page-1)*limit;
        requestModel.setBegin(begin);
        requestModel.setLimit(limit);
        List<RequestModel> list = requestMapper.getRequestPage(requestModel);
        pageBean.setList(list);
        return pageBean;
    }

    public void updateCollect(RequestModel requestModel){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sDate = formatter.format(date);
        requestModel.setCollect_time(Timestamp.valueOf(sDate));
        requestMapper.updateCollect(requestModel);
    }

    public PageBean<RequestModel> getCollectPage(RequestModel requestModel){
        PageBean<RequestModel> pageBean = new PageBean<RequestModel>();
        int page = requestModel.getPageNo();
        pageBean.setPage(page);
        int limit = 30;
        pageBean.setLimit(limit);
        int totalCount = 0;
        totalCount = requestMapper.getCollectCount(requestModel);
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if(totalCount % limit ==0){
            totalPage=totalCount/limit;
        }else {
            totalPage= totalCount/limit +1;
        }
        pageBean.setTotalPage(totalPage);
        int begin = (page-1)*limit;
        requestModel.setBegin(begin);
        requestModel.setLimit(limit);
        List<RequestModel> list = requestMapper.getCollectPage(requestModel);
        pageBean.setList(list);
        return pageBean;
    }

    public void cancelCollect(RequestModel requestModel){
        requestMapper.updateCollect(requestModel);
    }

    public PageBean<RequestModel> getMostPage(RequestModel requestModel){
        PageBean<RequestModel> pageBean = new PageBean<RequestModel>();
        int page = requestModel.getPageNo();
        pageBean.setPage(page);
        int limit = 30;
        pageBean.setLimit(limit);
        int totalCount = 0;
        totalCount = requestMapper.getMostCount(requestModel);
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if(totalCount % limit ==0){
            totalPage=totalCount/limit;
        }else {
            totalPage= totalCount/limit +1;
        }
        pageBean.setTotalPage(totalPage);
        int begin = (page-1)*limit;
        requestModel.setBegin(begin);
        requestModel.setLimit(limit);
        List<RequestModel> list = requestMapper.getMostPage(requestModel);
        pageBean.setList(list);
        return pageBean;
    }
}
