package com.example.zero.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {

    /**
     * 性能分析拦截器，不建议生产使用 用来观察 SQL 执行情况及执行时长, 默认dev,staging 环境开启
     */
    @Bean
    // @Profile({"dev", "staging"})
    public PerformanceInterceptor performanceInterceptor(){

        //启用性能分析插件, SQL是否格式化 默认false,此处开启
        return new PerformanceInterceptor().setFormat(true);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        //设置方言类型
        page.setDialectType("mysql");
        return page;
    }



}
