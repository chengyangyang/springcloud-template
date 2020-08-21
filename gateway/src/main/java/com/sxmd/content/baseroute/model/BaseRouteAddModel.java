package com.sxmd.content.baseroute.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;


/**
 * Description: 添加路由规则实体
 * 字段需要修改，需移至EditModel中
 *
 * @author sxmd
 * @date Version 1.0
 */
@Data
@ApiModel(value = "新增路由规则实体", description = "接收参数body")
@JsonIgnoreProperties({"id"})
public class BaseRouteAddModel extends BaseRouteEditModel {


}