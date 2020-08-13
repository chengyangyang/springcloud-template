package com.sxmd.util;


import com.sxmd.entity.TreeEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description:  树工具类
 *
 * @author cy
 * @date 2020年07月22日 14:23
 * Version 1.0
 */
public class TreeUtil {


    static String ROOT_ID = "0";


    /**
     * Description:   树形结构返回
     *
     * @param entityList:
     * @return java.util.List<E>
     * @author cy
     * @date 2020/7/22 14:55
     */
    public static <E extends TreeEntity<E, String>> List<E> getTreeList(List<E> entityList) {
        List<E> rootNode = new ArrayList<>();
        // 构造一个map
        HashMap<String, E> map = new HashMap<>(40);
        entityList.stream().forEach(x -> {
            map.put(x.getId() + "", x);
        });

        entityList.stream().forEach(x -> {
            if (ROOT_ID.equals(x.getParentId() + "")) {
                rootNode.add(x);
            } else {
                map.get(x.getParentId() + "").getChildList().add(x);
            }
        });
        return rootNode;
    }

    /**
     * Description:   根据父类id 查询数据
     *
     * @param parentId:
     * @param entityList:
     * @return
     * @author cy
     * @date 2020/7/22 14:58
     */
    public static <E extends TreeEntity<E, String>> List<E> getTreeListByParentId(String parentId, List<E> entityList) {
        List<E> rootNode = new ArrayList<>();
        // 构造一个map
        HashMap<String, E> map = new HashMap<>(40);
        entityList.stream().forEach(x -> {
            map.put(x.getId() + "", x);
        });

        entityList.stream().forEach(x -> {
            if (ROOT_ID.equals(x.getParentId() + "")) {
                rootNode.add(x);
            } else {
                map.get(x.getParentId() + "").getChildList().add(x);
            }
        });
        if (ROOT_ID.equals(parentId)) {
            return rootNode;
        }
        return map.get(parentId).getChildList();
    }

}
