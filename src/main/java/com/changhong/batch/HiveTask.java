package com.changhong.batch;

import com.changhong.dataanalysis.entity.DataCount;
import com.changhong.dataanalysis.mapper.DataAnalysisMapper;
import com.changhong.requestmanage.mapper.RequestMapper;
import com.changhong.useranalysis.entity.UserCount;
import com.changhong.useranalysis.mapper.UserAnalysisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/16.
 */
@Component
public class HiveTask {
    @Autowired
    RequestMapper requestMapper;

    @Autowired
    DataAnalysisMapper dataAnalysisMapper;

    @Autowired
    UserAnalysisMapper userAnalysisMapper;

    //@Scheduled(fixedRate = 1000000000)
    public void hiveTask(){
        userTask();
        dataTask();
    }

    public void userTask(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        long count = requestMapper.getUserCount();
        long yescount = requestMapper.getYesUserCount(formatter.format(date));
        long toacount = requestMapper.getToaUserCount(formatter.format(date));
        UserCount userCount = new UserCount();
        userCount.setAll_user(count);
        userCount.setNewly_user(count-yescount);
        userCount.setActive_user(toacount);
        userCount.setP_log_date(date);
        userAnalysisMapper.insert(userCount);
    }

    public void dataTask(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<Map> list = requestMapper.getTypeCount(formatter.format(date));
        DataCount dataCount = new DataCount();
        dataCount.setP_log_date(date);
        long app = 0;
        long baike = 0;
        long music = 0;
        long tv = 0;
        long video = 0;
        long talk = 0;
        for(Map li:list){
            if(li.get("return_domain").equals("APP")) {
                app = (Long) li.get("counts");
            }
            if(li.get("return_domain").equals("BAIKE")) {
                baike = (Long) li.get("counts");
            }
            if(li.get("return_domain").equals("MUSIC")) {
                music = (Long) li.get("counts");
            }
            if(li.get("return_domain").equals("TV")) {
                tv = (Long) li.get("counts");
            }
            if(li.get("return_domain").equals("VIDEO")) {
                video = (Long) li.get("counts");
            }
            if(li.get("return_domain").equals("TALK")) {
                talk = (Long) li.get("counts");
            }
        }
        dataCount.setApp(app);
        dataCount.setBaike(baike);
        dataCount.setMusic(music);
        dataCount.setTv(tv);
        dataCount.setVideo(video);
        dataCount.setTalk(talk);
        long all = app+baike+music+tv+video+talk;
        dataCount.setAll_domain(all);
        dataAnalysisMapper.insert(dataCount);
    }
}
