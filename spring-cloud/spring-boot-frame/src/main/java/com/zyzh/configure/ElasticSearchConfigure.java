package com.zyzh.configure;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description com.zyzh.configure.ElasticSearchConfigure
 * @Created by zhouxiaoyuan on 2021/4/29 15:42
 */
@Configuration
public class ElasticSearchConfigure {

    @Bean
    public RestHighLevelClient esClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("172.16.17.53", 9200, "http")));
        return client;
    }

    public static void main(String[] args) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("172.16.17.53", 9200, "http")));
        System.out.println(client);
    }


}
