package com.sxmd.content.baseroute.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxmd.content.baseroute.entity.BaseRouteEntity;
import com.sxmd.content.baseroute.model.BaseRouteListModel;
import com.sxmd.content.baseroute.model.BaseRouteListRequestModel;
import com.sxmd.content.baseroute.model.BaseRouteListResponseModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description: 路由规则 dao接口
 *
 * @author sxmd
 * @date Version 1.0
 */
@Mapper
public interface BaseRouteMapper extends BaseMapper<BaseRouteEntity> {

    /**
     * Description: 列表查询
     *
     * @param listRequestModel:
     * @return java.util.List
     * @author sxmd
     * @date
     */
    List<BaseRouteListResponseModel> findBaseRouteList(BaseRouteListRequestModel listRequestModel);

    /**
     * Description: 获得所有数据
     *
     * @param :
     * @return java.util.List
     * @author sxmd
     * @date
     */
    List<BaseRouteListModel> findAllList();

    /**
     * Description: 批量新增
     *
     * @param entityList:
     * @return long
     * @author sxmd
     * @date
     */
    long batchInsert(List<BaseRouteEntity> entityList);


    /**
     * Description: 批量新增
     *
     * @param ids:
     * @return long
     * @author sxmd
     * @date
     */
    long batchDeleteByIds(Long[] ids);

}