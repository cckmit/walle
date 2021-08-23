package com.panpan.walle.start;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class HelloTest extends BaseTest{

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test(){
        System.out.println(111);
    }


    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("a","1");
        redisTemplate.opsForValue().set("b","1");
        redisTemplate.opsForValue().set("c","1");
        redisTemplate.opsForValue().set("d","1");

        redisTemplate.opsForValue().get("a");
        redisTemplate.opsForValue().get("b");
        redisTemplate.opsForValue().get("c");
        redisTemplate.opsForValue().get("d");
    }
}
