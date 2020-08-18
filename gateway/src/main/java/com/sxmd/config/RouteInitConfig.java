package com.sxmd.config;

import com.sxmd.content.baseroute.entity.BaseRouteEntity;
import com.sxmd.content.baseroute.service.BaseRouteService;
import com.sxmd.util.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: 动态路由服务初始话
 *
 * @author cy
 * @date 2020年08月13日 18:37
 * Version 1.0
 */
@Configuration
@Slf4j
public class RouteInitConfig implements ApplicationEventPublisherAware {

    @Autowired
    private CustomRouteRepository customRouteRepository;
    @Autowired
    private BaseRouteService routeService;

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    @PostConstruct
    public void init() {
        log.info("初始化路由数据...");
        List<BaseRouteEntity> routeList = routeService.findAll();
        if (CollectionUtil.isNotBlank(routeList)) {
            List<RouteDefinition> list = routeList.stream().map(BaseRouteEntity::parseToRoute).collect(Collectors.toList());
            list.stream().forEach(x->{
                customRouteRepository.save(Mono.just(x)).subscribe();
            });
            // 完成之后，刷新路由
            refreshRoute();
        }
    }

    /**
     * Description:   增加路由
     *
     * @param definition:
     * @return
     * @author cy
     * @date  2020/8/17 16:28
     */
    public void add(RouteDefinition definition){
        customRouteRepository.save(Mono.just(definition)).subscribe();
        refreshRoute();
    }

    /**
     * 更新路由
     */
    public void update(RouteDefinition definition) {
        customRouteRepository.delete(Mono.just(definition.getId()));
        customRouteRepository.save(Mono.just(definition)).subscribe();
        refreshRoute();
    }

    /**
     * 删除路由
     *
     */
    public void delete(String id) {
        customRouteRepository.delete(Mono.just(id)).subscribe();
        refreshRoute();
    }

    /**
     * Description:   沙逊路由
     *
     * @param :
     * @return void
     * @author cy
     * @date  2020/8/17 16:27
     */
    public void refreshRoute(){
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }


}
