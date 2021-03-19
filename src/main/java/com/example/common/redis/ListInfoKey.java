package com.example.common.redis;

import com.example.common.redis.core.BasicKeyModel;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxc
 * @date 2021/3/18 17:48
 */
@Data
@Builder
public class ListInfoKey extends BasicKeyModel {

    private String name;

    @Override
    public List<String> sortKeyList() {
        List<String> keyList = new ArrayList<>();
        keyList.add(name);
        return keyList;
    }
}
