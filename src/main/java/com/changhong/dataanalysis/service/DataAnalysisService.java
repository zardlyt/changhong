package com.changhong.dataanalysis.service;

import com.changhong.dataanalysis.entity.DataCount;
import com.changhong.dataanalysis.mapper.DataAnalysisMapper;
import com.mysql.fabric.xmlrpc.base.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */
@Service
public class DataAnalysisService {

    @Autowired
    DataAnalysisMapper dataAnalysisMapper;

    public List<DataCount> getDataAnalysisMonth(DataCount dataCount){
        return dataAnalysisMapper.getDataAnalysisMonth(dataCount);
    }

    public List<DataCount> getDataAnalysisDay(DataCount dataCount){
        return dataAnalysisMapper.getDataAnalysisDay(dataCount);
    }

    public DataCount getDataAnalysisCount(){
        return dataAnalysisMapper.getDataAnalysisCount();
    }
}
