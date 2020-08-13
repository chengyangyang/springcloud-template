package com.sxmd.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Description:  跨域请求配置
 *
 * @author cy
 * @date 2020年06月10日 14:02
 * Version 1.0
 */
@Configuration
public class CorsConfig {

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许任何的head头部
        corsConfiguration.addAllowedHeader("*");
        // 允许任何域名使用
        corsConfiguration.addAllowedOrigin("*");
        // 允许任何的请求方法
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

    /**
     * 添加CorsFilter拦截器，对任意的请求使用
     *
     * @return
     */
    @ConditionalOnMissingBean
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

}
