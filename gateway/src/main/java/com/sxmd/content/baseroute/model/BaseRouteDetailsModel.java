package com.sxmd.content.baseroute.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description: 路由规则详情实体
 *
 * @author sxmd
 * @date Version 1.0
 */
@Data
@ApiModel(value = "路由规则详情实体")
public class BaseRouteDetailsModel {

    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "路由id")
    private String routeId;
    @ApiModelProperty(value = "转发地址")
    private String uri;
    @ApiModelProperty(value = "判断条件")
    private String predicates;
    @ApiModelProperty(value = "过滤")
    private String filters;
    @ApiModelProperty(value = "线路顺序")
    private Integer order;
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
    @ApiModelProperty(value = "删除标识（0 false  1  true）")
    private Integer delete;

}