package com.market.book_market.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableCaching
public class CommonConfig {

    @Bean
    public String serverUrl(@Value("${swagger.url}") String url, @Value("${server.servlet.context-path}") String contextPath) {
        return url + contextPath;
    }
}
