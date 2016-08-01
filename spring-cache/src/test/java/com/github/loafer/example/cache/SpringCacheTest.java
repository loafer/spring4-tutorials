package com.github.loafer.example.cache;

import com.github.loafer.example.spring.cache.AccountService;
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
@ContextConfiguration({"/spring-cache.xml"})
public class SpringCacheTest {
  @Resource
  private AccountService accountService;

  @Test
  public void testCacheable(){
    Account account = accountService.findAccountByName("tom");
    System.out.println(account);

    Account account2 = accountService.findAccountByName("tom");
    System.out.println(account2);
  }


}
