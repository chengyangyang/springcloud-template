package com.sxmd.content.baseroute.model;

import com.sxmd.base.RequestPage;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Description: 路由规则 列表参数
 *
 * @author sxmd
 * @date Version 1.0
 */
@Data
@ApiModel(value = "路由规则列表参数", description = "接收参数 query")
public class BaseRouteListRequestModel extends RequestPage {

}