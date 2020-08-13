package com.sxmd.util;

import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description: 页面工具类
 *
 * @author cy
 * @date 2020年02月20日 11:09
 * Version 1.0
 */
@Data
public class PageUtil<T> {
    /**
     * 实体类列表
     */
    private List<T> content;
    /**
     * 总记录数
     */
    private Integer count;
    /**
     * 总页数
     */
    private Integer totalPages;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 当前页
     */
    private Integer pageNum;


    public PageUtil(Integer pageNum, Integer pageSize, List<T> list) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageNum = 10;
        }
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        List<T> list1 = list.stream().skip((pageNum - 1L) * pageSize).limit(pageSize).collect(Collectors.toList());
        this.count = list.size();
        if (count % pageSize == 0) {
            this.totalPages = count / pageSize;
        } else {
            this.totalPages = count / pageSize + 1;
        }
        this.content = (list1);
    }

    public PageUtil(Integer pageNum, Integer pageSize, Set<T> set) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageNum = 10;
        }
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        List<T> list1 = set.stream().skip((pageNum - 1L) * pageSize).limit(pageSize).collect(Collectors.toList());
        this.count = set.size();
        if (count % pageSize == 0) {
            this.totalPages = count / pageSize;
        } else {
            this.totalPages = count / pageSize + 1;
        }
        this.content = (list1);
    }

}
