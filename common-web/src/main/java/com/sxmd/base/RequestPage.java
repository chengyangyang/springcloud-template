package com.sxmd.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 *
 * @author cy
 * @date 2020年04月23日 10:41
 * Version 1.0
 */
@Data
@ApiModel(value = "分页请求")
public class RequestPage {

    /**
     * 第几页
     */
    @ApiModelProperty(value = "页码")
    private Integer pageNum;
    /**
     * 每页大小
     */
    @ApiModelProperty(value = "显示条数")
    private Integer pageSize;

    public Integer getPageNum() {
        if(pageNum == null || pageNum <= 0){
            return 1;
        }
        return pageNum;
    }

    public Integer getPageSize() {
        if(pageSize == null || pageSize <= 0){
            return 10;
        }
        return pageSize;
    }

}
