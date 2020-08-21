package com.sxmd.content.baseroute.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Description: 路由规则所有数据列表实体
 *
 * @author sxmd
 * @date Version 1.0
 */
@Data
@ApiModel(value = "路由规则所有数据列表", description = "接收参数body")
@JsonIgnoreProperties({""})
public class BaseRouteListModel extends BaseRouteAddModel {

}