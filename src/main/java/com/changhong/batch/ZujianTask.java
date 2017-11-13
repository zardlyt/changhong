package com.changhong.batch;

import com.changhong.semanticmanage.entity.Semantic;
import com.changhong.semanticmanage.mapper.SemanticMapper;
import com.changhong.utils.HttpUtil;
import com.changhong.utils.JsonUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.tomcat.jni.Time;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/17.
 */
@Component
public class ZujianTask {
    @Autowired
    SemanticMapper semanticMapper;


    //@Scheduled(fixedRate = 1000*60*5)
    public void httpTask() throws Exception {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sDate = formatter.format(date);//当前时间
        String sYeDate = addDateOneMinute(sDate, -5);//五分钟之前
        String sdate = dateToStamp(sDate);
        String syedate = dateToStamp(sYeDate);
        String start_time = syedate.substring(0,10);
        String end_time = sdate.substring(0,10);

        JSONObject json = new JSONObject();
        json.put("start_time",start_time);
        json.put("end_time",end_time);
        json.put("type",1);
        json.put("filter","{}");
        json.put("page",1);
        json.put("limit",1);
        String result = HttpUtil.doPost("http://emotibot12.changhong.com/controller.php/record",json.toString());
        Map<String,Object> map = JsonUtils.toMap(result);
        String total_size = (String) map.get("total_size");
        json.put("limit",Integer.parseInt(total_size));
        String fresult = HttpUtil.doPost("http://emotibot12.changhong.com/controller.php/record",json.toString());
        Map<String,Object> fmap = JsonUtils.toMap(fresult);
        String data = (String) fmap.get("data");
        List<Map> list = JsonUtils.toList(data,Map.class);
        for(Map ma:list){
            Object object = ma.get("answer");
            String answer = object.toString();
            if(answer.contains("semantic")){
                String created_time = (String) ma.get("created_time");
                String user_q = (String) ma.get("user_q");
                String user_a = user_q.trim();
                String result1 = HttpUtil.doGet("http://emotibot14.changhong.com/api/ApiKey/spellcheck/spellcheck.php?sentence="+user_a);
                List<Map> list1 = JsonUtils.toList(result1,Map.class);
                Map map1 = list1.get(0);
                String query = (String) map1.get("query");
                String spellCheck1 = (String) map1.get("spellCheck");
                String spellCheck = spellCheck1.equals("")?null:spellCheck1;
                Boolean madeChange = (Boolean) map1.get("madeChange");
                Integer stateCode = (Integer) map1.get("stateCode");
                List list2 = (List) map1.get("type");
                if(query!=null&&!query.equals("")&&list2!=null&&list2.size()>0) {
                    String type = (String) list2.get(0);
                    Semantic semantic = new Semantic();
                    semantic.setSentence(user_q);
                    semantic.setSquery(query);
                    semantic.setSpellCheck(spellCheck);
                    semantic.setMadeChange(madeChange);
                    semantic.setStateCode(stateCode);
                    semantic.setStype(type);
                    semantic.setState(0);
                    semantic.setMethod("离线");
                    semantic.setStime(Timestamp.valueOf(created_time));
                    semanticMapper.insert(semantic);
                }
            }
        }
    }

    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    public String addDateOneDay(String sdate, int day) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, day);
        date = c.getTime();
        String strDate = sdf.format(date);
        return strDate;
    }

    public String addDateOneMinute(String sdate, int minute) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE,minute);
        date = c.getTime();
        String strDate = sdf.format(date);
        return strDate;
    }
}

