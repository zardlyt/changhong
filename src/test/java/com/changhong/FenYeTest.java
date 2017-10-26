package com.changhong;

import com.changhong.redis.RedisUtil;
import com.changhong.semanticmanage.entity.Semantic;
import com.changhong.semanticmanage.mapper.SemanticMapper;
import com.changhong.utils.HttpUtil;
import com.changhong.utils.JsonUtils;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

/**
 * Created by Administrator on 2017/10/17.
 */
@Component
public class FenYeTest {

    /*@Autowired
    DemoService demoService;
    @Test
    public void testFindByPage() {
        Page<UserEntity> userEntities = demoService.findByPage(1, 2);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<UserEntity> pageInfo = new PageInfo<>(userEntities);
        Assert.assertNotNull(userEntities);
    }*/
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    SemanticMapper semanticMapper;

    @Test
    public void test() {
        for(int i=0;i<20;i++){
            redisUtil.set("semantic:提问"+i,"回答");
        }
    }

    public static void main(String[] args){
        for(int i=0;i<20;i++){

        }
    }

}
