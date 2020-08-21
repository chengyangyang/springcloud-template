package com.sxmd.content.baseroute.entity;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sxmd.base.BaseEntity;
import com.sxmd.util.StringUtil;
import lombok.Data;
import lombok.ToString;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;

import java.net.URI;
import java.util.LinkedHashMap;


/**
 * Description: 路由规则实体
 *
 * @author sxmd
 * @date Version 1.0
 */
@Data
@ToString(callSuper = true)
@TableName("base_route")
public class BaseRouteEntity extends BaseEntity {

    /**
     * 路由id
     */
    @TableField(value = "route_id")
    private String routeId;

    /**
     * 转发地址
     */
    @TableField(value = "uri")
    private String uri;

    /**
     * 判断条件
     */
    @TableField(value = "predicates")
    private String predicates;

    /**
     * 过滤
     */
    @TableField(value = "filters")
    private String filters;

    /**
     * 线路顺序
     */
    @TableField(value = "`order`")
    private Integer order;

    /**
     * 元数据区
     */
    @TableField(value = "metadata")
    private String metadata;

    /**
     * 删除标识（0 false  1  true）
     */
    @TableField(value = "del")
    private boolean del;


    /**
     * Description:   转换成 RouteDefinition
     *
     * @param baseRouteEntity:
     * @return org.springframework.cloud.gateway.route.RouteDefinition
     * @author cy
     * @date 2020/8/13 19:02
     */
    public static RouteDefinition parseToRoute(BaseRouteEntity baseRouteEntity) {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(baseRouteEntity.getRouteId());
        routeDefinition.setOrder(baseRouteEntity.getOrder());
        routeDefinition.setUri(URI.create(baseRouteEntity.getUri()));
        if (StringUtil.isNotBlank(baseRouteEntity.getMetadata())) {
            routeDefinition.setMetadata(JSON.parseObject(baseRouteEntity.getMetadata(), LinkedHashMap.class));
        }
        if (StringUtil.isNotBlank(baseRouteEntity.getFilters())) {
            routeDefinition.setFilters(JSON.parseArray(baseRouteEntity.getFilters(), FilterDefinition.class));
        }
        if (StringUtil.isNotBlank(baseRouteEntity.getPredicates())) {
            routeDefinition.setPredicates(JSON.parseArray(baseRouteEntity.getPredicates(), PredicateDefinition.class));
        }
        return routeDefinition;
    }
}
