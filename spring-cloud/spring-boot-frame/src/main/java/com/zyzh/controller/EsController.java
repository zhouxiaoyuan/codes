package com.zyzh.controller;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description com.zyzh.controller.EsController
 * @Created by zhouxiaoyuan on 2021/4/29 17:11
 */
@Controller
@RequestMapping("/es")
public class EsController {

    @Autowired
    RestHighLevelClient esClient;

    @GetMapping("/add")
    @ResponseBody
    public String add(String index,String id, String pid ,String content){
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("pid", pid);
        jsonMap.put("postDate", new Date());
        jsonMap.put("content", content);
        IndexRequest indexRequest = new IndexRequest(index)
                .id(id).source(jsonMap);
        String result = "";
        try {
            IndexResponse indexResponse = esClient.index( indexRequest, RequestOptions.DEFAULT);
            System.out.println(indexResponse.getIndex());
            result = indexResponse.getId();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
