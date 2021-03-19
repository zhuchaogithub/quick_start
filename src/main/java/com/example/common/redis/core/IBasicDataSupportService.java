package com.example.common.redis.core;

import java.util.List;

/**
 * @author zxc
 * @date 2021/3/18 17:39
 */
public interface IBasicDataSupportService<K,V> {

    V getData(K key);

    V getCacheData(K key);

    K setCacheData(K key, V value);

    Boolean deleteByKeyList(List<K> key);
}
