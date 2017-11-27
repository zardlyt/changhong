package com.changhong.useranalysis.service;

import com.changhong.useranalysis.entity.UserCount;
import com.changhong.useranalysis.mapper.UserAnalysisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
@Service
public class UserAnalysisService {
    @Autowired
    UserAnalysisMapper userAnalysisMapper;
    public List<UserCount> getUserAnalysisMonth(){
        return userAnalysisMapper.getUserAnalysisMonth();
    }
}
