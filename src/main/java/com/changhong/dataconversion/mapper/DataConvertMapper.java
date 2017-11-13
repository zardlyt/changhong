package com.changhong.dataconversion.mapper;

import com.changhong.cachemanage.entity.Cache;
import com.changhong.dataconversion.entity.DataConvert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/9.
 */
@Repository
@Mapper
public interface DataConvertMapper {

    public List<DataConvert> getDataConvertPage(DataConvert dataConvert);

    public int getDataConvertCount(DataConvert dataConvert);

    public void insert(DataConvert dataConvert);

    public void update(DataConvert dataConvert);

    public void delete(int i);
}
