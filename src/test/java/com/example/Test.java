package com.example;

import com.example.common.redis.RedisService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @program: RuoYi
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-07-10 09:46
 **/
@SpringBootTest(classes = QuickStartApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {

    @Autowired
    RedisService redisService;

    @Autowired
    RedisTemplate redisTemplate;


    @org.junit.Test
    public void redisTest() {
        redisService.setValue("key", "hello");
        redisTemplate.opsForValue().set("key1", "hello");
        Object o = redisTemplate.opsForValue().get("key1");
        System.out.println(o);

    }


    @org.junit.Test
    public void redisTest2() {
        System.out.println("get key value:" + redisService.getValue("key"));
    }
}
