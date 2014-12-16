package com.github.loafer.spring;

import com.github.loafer.spring.hello.AppConfig;
import com.github.loafer.spring.hello.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 测试 @Resource 行为
 * 结果：
 * 1、@Resource 默认按照接口实现来注入依赖关系
 * 2、如果存在实现了同一接口的多个实现类，需要通过name属性指定所要注入的bean,
 * 否则在创建bean时产生NoUniqueBeanDefinitionException异常
 *
 *
 * @author zhaojh
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ResourceAnnotationTest {

//    @Resource
    @Resource(name = "english")
    private HelloService helloService;

    @Test
    public void test1(){
        System.out.println(helloService.say());
    }
}
