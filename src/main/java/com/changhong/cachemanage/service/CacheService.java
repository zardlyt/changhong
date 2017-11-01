package com.changhong.cachemanage.service;

import com.changhong.cachemanage.entity.Cache;
import com.changhong.cachemanage.entity.PageInfo;
import com.changhong.cachemanage.mapper.CacheMapper;
import com.changhong.exceptionhandle.RestResult;
import com.changhong.exceptionhandle.RestResultGenerator;
import com.changhong.redis.RedisUtil;
import com.changhong.semanticmanage.entity.PageBean;
import com.changhong.semanticmanage.entity.Semantic;
import com.changhong.semanticmanage.mapper.SemanticMapper;
import com.changhong.utils.JsonUtils;
import net.sf.json.util.JSONUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.jni.File;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by Administrator on 2017/10/18.
 */
@Service
public class CacheService {
    @Autowired
    CacheMapper cacheMapper;
    @Autowired
    RedisUtil redisUtil;
    public PageBean<Cache> getCachePage(Cache cache){
        PageBean<Cache> pageBean = new PageBean<Cache>();
        int page = cache.getPageNo();
        pageBean.setPage(page);
        int limit = 30;
        pageBean.setLimit(limit);
        int totalCount = 0;
        totalCount = cacheMapper.getCacheCount(cache);
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if(totalCount % limit ==0){
            totalPage=totalCount/limit;
        }else {
            totalPage= totalCount/limit +1;
        }
        pageBean.setTotalPage(totalPage);
        int begin = (page-1)*limit;
        cache.setBegin(begin);
        cache.setLimit(limit);
        List<Cache> list = cacheMapper.getCachePage(cache);
        pageBean.setList(list);
        return pageBean;
    }

    public Cache getOne(int i){
        return cacheMapper.getOne(i);
    }

    public void delete(int i){
        cacheMapper.delete(i);
    }

    public void insert(Cache cache){
        cacheMapper.insert(cache);
    }

    public void update(Cache cache){
        cacheMapper.update(cache);
    }

    public RestResult upload(MultipartFile file) throws IOException {
        boolean b = false;
        InputStream in = null;
        XSSFWorkbook workbook = null;
        in = file.getInputStream();
        workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = null;
        XSSFCell cell = null;
        int rowNum = sheet.getLastRowNum();
        List<Cache> list = new ArrayList<Cache>();
        for(int i = 1;i<=rowNum;i++) {
            row = sheet.getRow(i);
            if(row!=null){
                Cell quiz = row.getCell(0);
                Cell answer = row.getCell(1);
                if(quiz!=null&&answer!=null) {
                    String nquiz = quiz.getStringCellValue();
                    String nanswer = answer.getStringCellValue();
                    Cache cache = new Cache();
                    cache.setQuiz(nquiz);
                    cache.setAnswer(nanswer);
                    list.add(cache);
                }else{
                    b = true;
                    break;
                }
            }else {
                b = true;
                break;
            }
        }
        if(b==false){
            for(Cache li:list){
                cacheMapper.insert(li);
            }
            return RestResultGenerator.genSuccessResult();
        }else{
            return RestResultGenerator.genErrorResult("问法和回答不能为空");
        }
    }

    public Workbook download(){
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("自定义缓存");
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("问法");
        row.createCell(1).setCellValue("回答");
        return  wb;
    }

    public void deleteAll(){
        Set<String> set = redisUtil.keys("semantic"+"*");
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String keyStr = it.next();
            redisUtil.del(keyStr);
        }
        List<Cache> list = cacheMapper.getAll();
        for (Cache ca:list){
            String quiz = ca.getQuiz();
            String answer = ca.getAnswer();
            String key = "semantic:"+quiz+"5a200ce8e6ec3a6506030e54ac3b970e";
            redisUtil.set(key,answer);
        }
    }

    public void logDelete(String str){
        String key = "semantic:"+str+"5a200ce8e6ec3a6506030e54ac3b970e";
        redisUtil.del(key);
    }

    public Cache logQuery(String key){
        String quiz = "semantic:"+key+"5a200ce8e6ec3a6506030e54ac3b970e";
        String answer = redisUtil.get(quiz);
        if(answer!=null){
            Cache cache = new Cache();
            cache.setQuiz(key);
            cache.setAnswer(answer);
            return cache;
        }
        return null;
    }
}
/*Long count = redisUtil.llen("semantic");
        int totalCount = count.intValue();
        int limit = 5;
        int begin = (i-1)*limit;
        List<String> idlist = redisUtil.lrange("semantic",begin,limit);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setLimit(limit);
        pageInfo.setPage(i);
        pageInfo.setLimit(totalCount);
        int totalPage=0;
        if(totalCount % limit ==0){
            totalPage=totalCount/limit;

        }else {
            totalPage= totalCount/limit +1;
        }
        pageInfo.setTotalPage(totalPage);
        List<Map> list = new ArrayList<Map>();
        for(String id: idlist){
            Map<String,String> map = redisUtil.hgetall("semantic"+id);
            list.add(map);
        }
        pageInfo.setList(list);*/

/*  Set<String> set = redisUtil.keys("semantic"+"*");
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String keyStr = it.next();
            System.out.println(keyStr);
            redisUtil.del(keyStr);
        }
        List<Semantic> list = semanticMapper.getAll();
        for(int i=0;i<list.size();i++){
            Semantic semantic = list.get(i);
            Map<String,Object> map1 = new HashMap<String,Object>();
            map1.put("query",semantic.getSquery());
            map1.put("spellCheck",semantic.getSpellCheck());
            map1.put("madeChange",semantic.getMadeChange());
            map1.put("stateCode",semantic.getStateCode());
            List<String> list1 = new ArrayList<String>();
            list1.add(semantic.getStype());
            map1.put("type",list1);
            List<Map> list3 = new ArrayList<Map>();
            list3.add(map1);
            String str = JsonUtils.toJsonString(list3);
            String sentence = semantic.getSentence();
            Map<String,String> map = new HashMap<String,String>();
            map.put(sentence,str);
            redisUtil.rpush("semantic",String.valueOf(i));
            redisUtil.hmset("semantic"+":"+i,map);
        }*/
