package com.sxmd.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description:   使用springmvc 如果是WebFlux 就是要它自身的
 *
 * @author cy
 * @date 2020年08月18日 13:49
 * Version 1.0
 */
@Configuration
@ConditionalOnExpression("${sxmd.common-web.web-mvc.enabled:true}")
public class SwaggerUiWebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.
                addResourceHandler( "/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(  "/swagger-ui/")
                .setViewName("forward:" + "/swagger-ui/index.html");
    }

}
