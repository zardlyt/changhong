package com.changhong.semanticmanage.mapper;

import com.changhong.semanticmanage.entity.Synonym;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/10/27.
 */
@Repository
@Mapper
public interface SynonymMapper {
    public void update(Synonym synonym);
}
