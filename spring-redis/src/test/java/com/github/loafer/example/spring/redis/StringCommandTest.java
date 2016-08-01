package com.github.loafer.example.spring.redis;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import redis.clients.jedis.Jedis;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-redis-jedis.xml"})
//@ContextConfiguration({"/spring-redis-lettuce.xml"})
public class StringCommandTest {
  private Logger logger = LoggerFactory.getLogger(StringCommandTest.class);
  @Resource
  private RedisTemplate redisTemplate;
  @Resource
  private StringRedisTemplate stringRedisTemplate;

  @Before
  public void flushdb(){
    redisTemplate.execute(new RedisCallback<Object>() {
      public Object doInRedis(RedisConnection connection) throws DataAccessException {
        connection.flushDb();
        return null;
      }
    });
  }

  @Test
  public void testSet(){
    redisTemplate.opsForValue().set("key", "value");
    String value = stringRedisTemplate.opsForValue().get("key");
    assertThat(value).isEqualToIgnoringCase("value");

    redisTemplate.opsForValue().set("key", "new value");
    String newValue = stringRedisTemplate.opsForValue().get("key");
    assertThat(newValue).isEqualToIgnoringCase("new value");
  }

  @Test
  public void testAppend() throws InterruptedException {
//    StringRedisSerializer serializer = new StringRedisSerializer();
//    template.setKeySerializer(serializer);
//    template.setValueSerializer(serializer);

    final String KEY = "hello";
    final String S1 = "Good";
    final String S2 = " Morning!";

    redisTemplate.opsForValue().set(KEY, S1);
    String value = (String) redisTemplate.opsForValue().get(KEY);
    assertThat(value).isEqualToIgnoringCase(S1);

    redisTemplate.opsForValue().append(KEY, S2);
    String newValue = (String) redisTemplate.opsForValue().get(KEY);
    logger.info("new value: {}", newValue);
  }

  @Test
  public void testAppend2(){
    final String KEY = "hello";
    final String S1 = "Good";
    final String S2 = " Morning!";

    stringRedisTemplate.opsForValue().set(KEY, S1);
    String value = stringRedisTemplate.opsForValue().get(KEY);
    assertThat(value).isEqualToIgnoringCase(S1);

    stringRedisTemplate.opsForValue().append(KEY, S2);
    String newValue = stringRedisTemplate.opsForValue().get(KEY);
    assertThat(newValue).isEqualToIgnoringCase(S1 + S2);
  }

  @Test
  public void testAppend3(){
    final String KEY = "hello";
    final String S1 = "Good";
    final String S2 = " Morning!";

    Jedis jedis = createJedis();
    jedis.set(KEY.getBytes(), S1.getBytes());
    byte[] bytes = jedis.get(KEY.getBytes());
    logger.info("value: {}", new String(bytes));
    assertThat(new String(bytes)).isEqualToIgnoringCase(S1);

    jedis.append(KEY.getBytes(), S2.getBytes());
    byte[] newbytes = jedis.get(KEY.getBytes());
    logger.info("new value: {}", new String(newbytes));
    assertThat(new String(newbytes)).isEqualToIgnoringCase(S1+S2);
  }

  @Test
  public void testGetAndSet(){
    final String KEY = "key";
    final String S1 = "value";
    final String S2 = "newValue";

    redisTemplate.opsForValue().set(KEY, S1);
    String value = (String) redisTemplate.opsForValue().getAndSet(KEY, S2);
    String newValue = (String) redisTemplate.opsForValue().get(KEY);
    assertThat(value).isEqualToIgnoringCase(S1);
    assertThat(newValue).isEqualToIgnoringCase(S2);
  }

  @Test
  public void testIncrement(){
    final String KEY = "count";
//    redisTemplate.opsForValue().set(KEY, "100");
//    Long value =  redisTemplate.opsForValue().increment(KEY, 50L);
//    assertThat(value).isEqualTo(150);

    stringRedisTemplate.opsForValue().set(KEY, "100");
    Long value = stringRedisTemplate.opsForValue().increment(KEY, 50);
    assertThat(value).isEqualTo(150);
  }

  @Test
  public void testIncrByFloat(){
    final String KEY = "mykey";
    stringRedisTemplate.opsForValue().set(KEY, "10.5");
    Double value = stringRedisTemplate.opsForValue().increment(KEY, 0.1d);
    assertThat(value).isEqualTo(10.6);
  }

  @Test
  public void testMultiSet(){
    Map<String, Object> map = new HashMap<String, Object>(){
      {
        put("redis", "redis.com");
        put("mongodb", "mongodb.org");
        put("website", 2);
        put("money", "1000");
      }
    };

    redisTemplate.opsForValue().multiSet(map);

    Set<String> keys = new HashSet<String>(Arrays.asList(new String[]{"redis", "mongodb", "website","money"}));
    List values = redisTemplate.opsForValue().multiGet(keys);
    logger.info("values: {}", values);
    assertThat(values).contains("redis.com", "mongodb.org", 2, "1000");
  }


  private Jedis createJedis(){
    Jedis j = new Jedis("localhost", 6379);
    j.connect();
    j.select(1);
//    j.flushAll();
    return j;
  }
}
