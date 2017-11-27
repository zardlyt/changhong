package com.changhong.requestmanage.mapper;

import com.changhong.requestmanage.entity.RequestModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/17.
 */
@Repository
@Mapper
public interface RequestMapper {
    public List<RequestModel> getRequestPage(RequestModel requestModel);

    public int getRequestCount(RequestModel requestModel);

    public List<RequestModel> getCollectPage(RequestModel requestModel);

    public int getCollectCount(RequestModel requestModel);

    public void updateCollect(RequestModel requestModel);

    public List<RequestModel> getMostPage(RequestModel requestModel);

    public int getMostCount(RequestModel requestModel);

    public List<Map> getTypeCount(String str);

    public long getUserCount();

    public long getYesUserCount(String str);

    public long getToaUserCount(String str);

}
