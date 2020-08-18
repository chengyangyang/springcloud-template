package com.sxmd.content.baseroute.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxmd.content.baseroute.entity.BaseRouteEntity;
import com.sxmd.content.baseroute.model.*;
import org.springframework.cloud.gateway.route.RouteDefinition;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * Description: 路由规则接口
 *
 * @author summit
 * @date Version 1.0
 */
public interface BaseRouteService extends IService<BaseRouteEntity> {

    /**
     * Description:  路由规则-新增
     *
     * @param route:
     * @return
     * @author summit
     * @date
     */
    Long insertBaseRoute(RouteDefinition route);

    /**
     * Description:  路由规则-更新
     *
     * @param model:
     * @author summit
     * @date
     */
    void updateBaseRoute(BaseRouteEditModel model);

    /**
     * Description:   路由规则-删除
     *
     * @param id: 主键
     * @author summit
     * @date
     */
    void deleteBaseRoute(Long id);

    /**
     * Description:   查找所有的路由
     *
     * @param :
     * @return java.util.List<com.sxmd.content.baseroute.entity.BaseRouteEntity>
     * @author cy
     * @date 2020/8/13 18:52
     */
    List<BaseRouteEntity> findAll();
}
