package com.sxmd.base;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Description:  表的公共字段
 *
 * @author cy
 * @date 2019年08月05日 16:41
 * Version 1.0
 */
@Data
@ToString(callSuper = true)
public class BaseEntity extends BaseAbstractId{

    private LocalDateTime createTime;

}
