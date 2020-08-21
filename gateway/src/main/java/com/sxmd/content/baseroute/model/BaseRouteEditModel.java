package com.sxmd.content.baseroute.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Description: 编辑路由规则实体
 * 非修改字段需要移至 AddModel中
 *
 * @author sxmd
 * @date Version 1.0
 */
@Data
@ApiModel(value = "编辑路由规则实体", description = "接收参数body")
public class BaseRouteEditModel {

    @ApiModelProperty(name = "主键,新增不需要要，更新必填")
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

    @ApiModelProperty(value = "删除标识（0 false  1  true）")
    private Integer delete;


}