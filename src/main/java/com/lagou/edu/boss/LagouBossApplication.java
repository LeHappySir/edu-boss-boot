package com.lagou.edu.boss;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * LagouBossApplication
 *
 * @author xianhongle
 * @data 2022/1/9 7:48 下午
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableMethodCache(basePackages = "com.lagou.edu")
@EnableCreateCacheAnnotation
@EnableFeignClients("com.lagou.edu")
@ComponentScan({"com.lagou.edu"})
public class LagouBossApplication {

    public static void main(String[] args) {
        SpringApplication.run(LagouBossApplication.class, args);
    }
}
