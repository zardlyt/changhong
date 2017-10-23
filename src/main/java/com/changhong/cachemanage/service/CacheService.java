package com.changhong.cachemanage.service;

import com.changhong.cachemanage.entity.Cache;
import com.changhong.cachemanage.entity.PageInfo;
import com.changhong.cachemanage.mapper.CacheMapper;
import com.changhong.redis.RedisUtil;
import com.changhong.semanticmanage.entity.PageBean;
import com.changhong.semanticmanage.entity.Semantic;
import com.changhong.semanticmanage.mapper.SemanticMapper;
import com.changhong.utils.JsonUtils;
import net.sf.json.util.JSONUtils;
import org.apache.commons.collections.map.HashedMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PageBean<Cache> getAll(int i){
        PageBean<Cache> pageBean = new PageBean<Cache>();
        Cache cache = new Cache();
        int page = i;
        pageBean.setPage(page);
        int limit = 5;
        pageBean.setLimit(limit);
        int totalCount = 0;
        totalCount = cacheMapper.getCacheCount();
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

    public void deleteAll(){
        List<Cache> list = cacheMapper.getAll();
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
    }
}
