package com.changhong.semanticmanage.service;

import com.changhong.semanticmanage.entity.Synonym;
import com.changhong.semanticmanage.mapper.SynonymMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/27.
 */
@Service
public class SynonymService {
    @Autowired
    SynonymMapper synonymMapper;
    public void update(Synonym synonym){
        synonymMapper.update(synonym);
    }
}
