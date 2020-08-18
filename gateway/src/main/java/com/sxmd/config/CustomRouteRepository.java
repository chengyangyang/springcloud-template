package com.sxmd.config;

import org.springframework.cloud.gateway.route.InMemoryRouteDefinitionRepository;
import org.springframework.stereotype.Component;

/**
 * Description:  自定义路由规则 使用内存存储
 *
 * @author cy
 * @date 2020年08月13日 18:18
 * Version 1.0
 */
@Component
public class CustomRouteRepository extends InMemoryRouteDefinitionRepository {


}