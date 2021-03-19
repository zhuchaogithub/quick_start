package com.example.common.redis.core;

/**
 * @author zxc
 * @date 2021/3/18 18:07
 */
public interface IBasicDataSupport<K extends BasicKeyModel, V, DATA_OPERATION> {
    DATA_OPERATION getDataOperation();
//
//    V getMetadata(K param);
}
