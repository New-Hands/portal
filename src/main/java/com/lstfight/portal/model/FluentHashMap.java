package com.lstfight.portal.model;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>简化map操作,封装了HashMap的操作</p>
 *
 * @author 李尚庭
 * @date 2018/8/22 0022 16:04
 */
public class FluentHashMap {

    private FluentHashMap() {

    }

    /**
     * <p>简化put，put后直接返回map对象。但是map的泛型会被固定</p>
     *
     * @param key   键对象
     * @param value 值对象
     * @param <K>   键泛型
     * @param <V>   值泛型
     * @return 添加数据后的map
     */
    public static <K, V> Map<K, V> put(K key, V value) {
        Map<K, V> map = new HashMap<>(16);
        map.put(key, value);
        return map;
    }
}
