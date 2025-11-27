package com.example.abtest.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageSourceConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages"); // messages.properties 파일 이름
        messageSource.setDefaultEncoding("UTF-8"); // UTF-8 인코딩 설정
        messageSource.setCacheSeconds(3600); // 캐시 시간 설정 (1시간)
        return messageSource;
    }
}
