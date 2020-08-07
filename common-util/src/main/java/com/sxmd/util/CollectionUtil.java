package com.sxmd.util;

import java.util.Collection;

/**
 * Description:  集合工具类
 *
 * @author cy
 * @date 2020年06月19日 11:21
 * Version 1.0
 */
public class CollectionUtil {

    /**
     * Description:    集合 非空判断
     *
     * @param collection:
     * @return boolean
     * @author cy
     * @date  2020/6/19 11:25
     */
    public static boolean isNotBlank(Collection collection){
        if(collection != null && !collection.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * Description:   集合 空判断
     *
     * @param collection:
     * @return boolean
     * @author cy
     * @date  2020/6/19 11:25
     */
    public static boolean isBlank(Collection collection){
        return !isNotBlank(collection);
    }



}
