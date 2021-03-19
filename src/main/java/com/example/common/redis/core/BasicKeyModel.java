package com.example.common.redis.core;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author zxc
 * @date 2021/3/18 17:40
 */
public abstract class BasicKeyModel {

    public abstract List<String> sortKeyList();
    private final static String PREFIX = "quick";
    private final static String VERSION = "1";

    public String generate(){
        List<String> keyList = sortKeyList();
        if (CollectionUtils.isEmpty(keyList)) {
            throw new RuntimeException("redis key 不能为null, 请继承KeyModel");
        }
        keyList.addAll(0, Arrays.asList(new String[]{PREFIX, VERSION}));
        return StringUtils.join(keyList, ':');
    }

}
