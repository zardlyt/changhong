package com.changhong.useranalysis.mapper;

import com.changhong.useranalysis.entity.UserCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
@Mapper
@Repository
public interface UserAnalysisMapper {
    public List<UserCount> getUserAnalysisMonth();

    public void insert(UserCount userCount);
}
