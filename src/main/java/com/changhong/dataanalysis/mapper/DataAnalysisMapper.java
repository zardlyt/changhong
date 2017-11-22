package com.changhong.dataanalysis.mapper;

import com.changhong.dataanalysis.entity.DataCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */
@Mapper
@Repository
public interface DataAnalysisMapper {
    public List<DataCount> getDataAnalysisMonth(DataCount dataCount);

    public List<DataCount> getDataAnalysisDay(DataCount dataCount);

    public DataCount getDataAnalysisCount();
}
