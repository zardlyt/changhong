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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

/**
 * Created by Administrator on 2017/10/17.
 */
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
    public void test() throws JSONException {

        JSONObject json = new JSONObject();
        json.put("start_time",1120752000);
        json.put("end_time",1508224667);
        json.put("type",1);
        json.put("filter","{}");
        json.put("page",1);
        json.put("limit",20);

        String result = HttpUtil.doPost("http://emotibot12.changhong.com/controller.php/record",json.toString());
        System.out.print(result);
        Map<String,Object> map = JsonUtils.toMap(result);
        String data = (String) map.get("data");
        List<Map> list = JsonUtils.toListBean(data,Map.class);
        for(Map ma:list){
            Object object = ma.get("answer");
            String answer = object.toString();
            if(answer.contains("semantic")){
                String user_q = (String) ma.get("user_q");
                String result1 = HttpUtil.doPost("http://emotibot14.changhong.com/api/ApiKey/spellcheck/spellcheck.php?sentence="+user_q);
                List<Map> list1 = JsonUtils.toListBean(result1,Map.class);
                Map map1 = list1.get(0);
                String query = (String) map1.get("query");
                String spellCheck = (String) map1.get("spellCheck");
                Boolean madeChange = (Boolean) map1.get("madeChange");
                Integer stateCode = (Integer) map1.get("stateCode");
                List list2 = (List) map1.get("type");
                String type = (String) list2.get(0);
            }
        }
    }
    @Test
    public void test1() throws JSONException {
        String result1 = HttpUtil.doGet("http://emotibot14.changhong.com/api/ApiKey/spellcheck/spellcheck.php?sentence=CCTV5 ");
        System.out.print(result1);
        /*String name = HttpUtil.doPost("http://emotibot14.changhong.com/api/ApiKey/spellcheck/spellcheck.php?sentence=我要看半月传");
        List<Map> list = JsonUtils.toListBean(name,Map.class);
        Map map = list.get(0);
        String query = (String) map.get("query");
        String spellCheck = (String) map.get("spellCheck");
        Boolean madeChange = (Boolean) map.get("madeChange");
        Integer stateCode = (Integer) map.get("stateCode");
        List list1 = (List) map.get("type");
        String type = (String) list1.get(0);
        System.out.println(query);
        System.out.println(spellCheck);
        System.out.println(madeChange);
        System.out.println(stateCode);
        System.out.println(type);*/
        /*JSONObject json = new JSONObject();
        json.put("start_time",1120752000);
        json.put("end_time",1508224667);
        json.put("type",1);
        json.put("filter","{}");
        json.put("page",1);
        json.put("limit",20);

        String result = HttpUtil.doPost("http://emotibot12.changhong.com/controller.php/record",json.toString());*/
    }
    @Test
    public void test2(){
        List<Semantic> list = semanticMapper.getAll();
        for(int i=0;i<list.size();i++){
            Semantic semantic = list.get(i);
            String str = JsonUtils.toJsonString(semantic);
            String sentence = semantic.getSentence();
            Map<String,String> map = new HashMap<String,String>();

            map.put(sentence,"");
            redisUtil.hmset("semantic"+i,map);
        }
    }
}
