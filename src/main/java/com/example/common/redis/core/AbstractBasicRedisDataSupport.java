package com.example.common.redis.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zxc
 * @date 2021/3/18 17:32
 */
@Slf4j
public abstract class AbstractBasicRedisDataSupport<K extends BasicKeyModel,V> implements IBasicDataSupport<K, V, ValueOperations>, IBasicDataSupportService<K,V>{

    /**
     * 默认开启缓存
     * @return
     */
    public boolean enableCache() {
        return true;
    }

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public ValueOperations<String, V> getDataOperation() {
        return redisTemplate.opsForValue();
    }

    @Override
    public abstract V getData(K key);

    @Override
    public V getCacheData(K key)  {
        log.info("[{}] ===> getCacheData key: [{}]", this.getClass().getName(),  null == key ? "null" : key);
        if (!enableCache()) {
            return getData(key);
        }

        V v = getDataOperation().get(key.generate());
        if (null == v) {
            v = getData(key);
            setCacheData(key, v);
        }
        return v;
    }

    @Override
    public synchronized K setCacheData(K key, V value) {
        if (enableCache()) {
            getDataOperation().set(key.generate(), value);
        }
        return key;
    }

    @Override
    public Boolean deleteByKeyList(List<K> keyList) {
        log.info("[{}] ===> enableCache: [{}], deleteByKeyList key: [{}]", this.getClass().getName(), enableCache(), CollectionUtils.isEmpty(keyList) ? "null" : keyList);
        if (!enableCache()) {
            return false;
        }
        if (!CollectionUtils.isEmpty(keyList)) {
            keyList.forEach(key -> {
                        // 效率高 但无法记录删除的条目
                        // getDataOperation().getOperations().delete(Collection)
                        Boolean deleted = getDataOperation().getOperations().delete(key.generate());
                        log.info("key: [{}], deleted: [{}]", key, deleted);
                    }
            );
        }
        return true;
    }
}
