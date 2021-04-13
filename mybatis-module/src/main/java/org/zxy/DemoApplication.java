package org.zxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@MapperScan("org.zxy.mapper") //扫描的mapper
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {

        Map hashMap = new HashMap();


        SpringApplication.run(DemoApplication.class, args);
    }
}
