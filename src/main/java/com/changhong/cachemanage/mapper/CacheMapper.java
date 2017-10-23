package com.changhong.cachemanage.mapper;

import com.changhong.cachemanage.entity.Cache;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */
@Repository
@Mapper
public interface CacheMapper {

    public List<Cache> getCachePage(Cache cache);

    public int getCacheCount();

    public List<Cache> getAll();

    public Cache getOne(int i);

    public void insert(Cache cache);

    public void update(Cache cache);

    public void delete(int i);
}
