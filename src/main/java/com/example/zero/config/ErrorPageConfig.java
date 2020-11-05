package com.example.zero.config;

import cn.hutool.core.lang.tree.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ErrorPageConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        //1、按错误的类型显示错误的网页
        //错误类型为404，找不到网页的，默认显示404.html网页
        ErrorPage e400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400");
        ErrorPage e401 = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401");
        ErrorPage e403 = new ErrorPage(HttpStatus.FORBIDDEN, "/error/403");
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");

        //错误类型为500，表示服务器响应错误，默认显示500.html网页
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
        ErrorPage e503 = new ErrorPage(HttpStatus.SERVICE_UNAVAILABLE, "/error/503");
        registry.addErrorPages(e400, e401, e403, e404, e500, e503);
    }
}
