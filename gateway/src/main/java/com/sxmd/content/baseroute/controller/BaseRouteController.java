package com.sxmd.content.baseroute.controller;


import com.sxmd.base.AjaxResult;
import com.sxmd.base.BaseController;
import com.sxmd.config.CustomRouteRepository;
import com.sxmd.constant.ConstantWeb;
import com.sxmd.content.baseroute.model.BaseRouteEditModel;
import com.sxmd.content.baseroute.service.BaseRouteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.validation.Valid;

/**
 * Description: 路由规则 控制器
 *
 * @author sxmd
 * @date Version 1.0
 */
@RestController
@Api(value = "路由规则 controller", tags = "路由规则")
@RequestMapping("base-route")
public class BaseRouteController extends BaseController {

    @Autowired
    private BaseRouteService service;
    @Autowired
    private CustomRouteRepository customRouteRepository;

    /**
     * Description:   路由规则-所有数据
     *
     * @param :
     * @author sxmd
     * @date
     */
    @ApiOperation(value = "所有数据", notes = "获得所有路由规则数据")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public AjaxResult<Flux<RouteDefinition>> all() {
        return success(customRouteRepository.getRouteDefinitions());
    }


    /**
     * Description:   路由规则-新增
     *
     * @param model:
     * @author sxmd
     * @date
     */
    @ApiOperation(value = "新增", notes = "新增路由规则")
    @RequestMapping(method = RequestMethod.POST)
    public AjaxResult insert(@RequestBody @Valid RouteDefinition model) {
        service.insertBaseRoute(model);
        return success(ConstantWeb.SAVE_MSEEAGE);
    }

    /**
     * Description:   路由规则-修改
     *
     * @param model:
     * @author sxmd
     * @date
     */
    @ApiOperation(value = "修改", notes = "根据id更新路由规则")
    @RequestMapping(method = RequestMethod.PUT)
    public AjaxResult update(@RequestBody @Valid BaseRouteEditModel model) {
        service.updateBaseRoute(model);
        return success(ConstantWeb.UPDATE_MSEEAGE);
    }


    /**
     * Description:   路由规则-删除
     *
     * @param id:
     * @author sxmd
     * @date
     */
    @ApiOperation(value = "删除", notes = "根据Id删除路由规则")
    @ApiImplicitParam(name = "id", value = "主键 id", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id) {
        service.deleteBaseRoute(id);
        return success(ConstantWeb.DELETE_MSEEAGE);
    }

}
