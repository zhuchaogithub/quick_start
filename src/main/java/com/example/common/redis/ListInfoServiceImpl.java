package com.example.common.redis;

import com.example.common.redis.core.AbstractBasicRedisDataSupport;

/**
 * @author zxc
 * @date 2021/3/18 17:52
 */
public class ListInfoServiceImpl extends AbstractBasicRedisDataSupport<ListInfoKey,ListInfoData> implements ListInfoService {

    @Override
    public ListInfoData getData(ListInfoKey key) {
        return null;
    }
}
