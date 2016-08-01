package com.github.loafer.example.cache;

import com.github.loafer.example.spring.cache.cacheable.AccountService;
import com.github.loafer.example.spring.cache.entity.Account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-cache.xml","/spring-cacheable.xml"})
public class CacheableTest {
  @Resource
  private AccountService accountService;

  @Test
  public void test1(){
    accountService.printDB();
    Account first = accountService.getAccountById("1");
    Account second = accountService.getAccountByName("Tom");
    accountService.printCache();
    System.out.println("first == second ? :" + (first == second));
  }

  @Test
  public void test2(){
    for (int i =0; i<3; i++){
      accountService.getAccountById("1");
      accountService.getAccountByName("Tom");
      accountService.printCache();
    }
  }
}
