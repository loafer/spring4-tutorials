package com.github.loafer.example.spring.redis;

import com.github.loafer.example.spring.redis.bean.Person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import redis.clients.jedis.Jedis;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-redis-jedis.xml"})
public class RedisTemplateTest {
  private Logger logger = LoggerFactory.getLogger(RedisTemplateTest.class);
  @Resource
  private RedisTemplate template;

  @Test
  public void testRandomKey(){
    logger.info("key: {}", template.randomKey());
    logger.info("key: {}", createJedis().randomKey());
  }

  @Test
  public void testValueOperations(){
    template.opsForValue().set("person:jane", new Person("Jane", "Smith"));
    Person person = (Person) template.opsForValue().get("person:jane");
    logger.info("Person: {}", person);
  }

  @Test
  public void testSerializer(){
    template.setValueSerializer(new Jackson2JsonRedisSerializer<Person>(Person.class));
    template.opsForValue().set("person:john", new Person("John", "Smith"));
    Person person = (Person) template.opsForValue().get("person:john");
    logger.info("Person: {}", person);
  }

  @Test
  public void testHashOperations(){
    BeanMap beanMap = BeanMap.create(new Person("Marry", "Smith"));
    logger.info("map: {}", beanMap);
    StringRedisSerializer serializer = new StringRedisSerializer();
    template.setHashKeySerializer(serializer);
    template.setHashValueSerializer(serializer);
    template.opsForHash().putAll("person:marry", beanMap);
  }

  private Jedis createJedis(){
    Jedis j = new Jedis("localhost", 6379);
    j.connect();
    j.flushAll();
    return j;
  }
}
