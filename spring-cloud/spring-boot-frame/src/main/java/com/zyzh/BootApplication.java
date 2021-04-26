package com.zyzh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description com.zyzh.BootApplication
 * @Created by zhouxiaoyuan on 2021/4/23 15:10
 */
@SpringBootApplication
@MapperScan("com.zyzh.mapper")
public class BootApplication {


    //group1/M00/00/00/rBARNWCCg1CAVV2bAAAAECzrHMc6063323
    //http://172.16.17.53/group1/M00/00/00/wKiWC10xxc6AfHCKAAAib-i5DLU543_big.log

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}


