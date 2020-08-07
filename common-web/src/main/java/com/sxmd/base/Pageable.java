package com.sxmd.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description: 分页的数据显示
 *
 * @author cy
 * @date 2019年09月23日 15:22
 * Version 1.0
 */
@Data
@ApiModel(value = "分页数据")
public class Pageable {

    @ApiModelProperty(value = "总页码数")
    private int pages;
    @ApiModelProperty(value = "数据总条数")
    private long total;
    @ApiModelProperty(value = "页码")
    private int pageNum;
    @ApiModelProperty(value = "显示条数")
    private int pageSize;
}
