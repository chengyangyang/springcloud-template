package com.sxmd.content.baseroute.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxmd.config.RouteInitConfig;
import com.sxmd.constant.ResponseCodeEnum;
import com.sxmd.content.baseroute.entity.BaseRouteEntity;
import com.sxmd.content.baseroute.mapper.BaseRouteMapper;
import com.sxmd.content.baseroute.model.BaseRouteEditModel;
import com.sxmd.exception.SxmdException;
import com.sxmd.util.IdWorkerUil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Description: 路由规则 实现类
 *
 * @author sxmd
 * @date Version 1.0
 */
@Service
public class BaseRouteServiceImpl extends ServiceImpl<BaseRouteMapper, BaseRouteEntity> implements BaseRouteService {

    @Autowired
    private RouteInitConfig routeInitConfig;

    /**
     * Description:   新增
     *
     * @param route:
     * @author sxmd
     * @date
     */
    @Override
    @Transactional
    public Long insertBaseRoute(RouteDefinition route) {
        routeInitConfig.add(route);
        BaseRouteEntity entity = new BaseRouteEntity();
        entity.setId(IdWorkerUil.generateId());
        entity.setCreateTime(LocalDateTime.now());
        entity.setDel(false);
        entity.setUri(route.getUri().getPath());
        baseMapper.insert(entity);
        return entity.getId();
    }

    /**
     * Description: 更新
     *
     * @param model:
     * @author sxmd
     * @date
     */
    @Override
    public void updateBaseRoute(BaseRouteEditModel model) {
        // 查询当前数据
        BaseRouteEntity entity = baseMapper.selectById(model.getId());
        if (Objects.isNull(entity)) {
            throw new SxmdException(ResponseCodeEnum.CODE_9991);
        }
        BeanUtils.copyProperties(model, entity);
        baseMapper.updateById(entity);
    }

    /**
     * Description: 删除
     *
     * @param id: 主键
     * @author sxmd
     * @date
     */
    @Override
    public void deleteBaseRoute(Long id) {
        BaseRouteEntity entity = baseMapper.selectById(id);
        if (Objects.isNull(entity)) {
            throw new SxmdException(ResponseCodeEnum.CODE_9991);
        }
        baseMapper.deleteById(id);
    }

    @Override
    public List<BaseRouteEntity> findAll() {
        return baseMapper.selectList(new QueryWrapper<BaseRouteEntity>().eq("del", false));
    }
}
