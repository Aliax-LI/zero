package com.example.zero.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/error/400").setViewName("error/400");
        registry.addViewController("/error/401").setViewName("error/401");
        registry.addViewController("/error/403").setViewName("error/403");
        registry.addViewController("/error/404").setViewName("error/404");
        registry.addViewController("/error/500").setViewName("error/500");
        registry.addViewController("/error/503").setViewName("error/503");
        registry.addViewController("/sse").setViewName("sse-emitter");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new LocaleResolverConfig();
    }
}
