package com.changhong.semanticmanage.mapper;

import com.changhong.semanticmanage.entity.Semantic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
@Repository
@Mapper
public interface SemanticMapper {
    public List<Semantic> getSemanticPage(Semantic semantic);

    public int getSemanticCount(Semantic semantic);

    public void insertAll(Semantic semantic);

    public void update(Semantic semantic);
}
