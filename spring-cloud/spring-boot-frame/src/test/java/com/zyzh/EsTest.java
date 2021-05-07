package com.zyzh;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description com.zyzh.EsTest
 * @Created by zhouxiaoyuan on 2021/4/29 15:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

    @Autowired
    RestHighLevelClient esClient;

    @Test
    public void test(){
//        IndexRequest request = new IndexRequest("posts");
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "kimchy");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out Elasticsearch");
        IndexRequest indexRequest = new IndexRequest("posts")
                .id("1").source(jsonMap);
        try {
            IndexResponse indexResponse = esClient.index( indexRequest, RequestOptions.DEFAULT);
            System.out.println(indexResponse.getIndex());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
