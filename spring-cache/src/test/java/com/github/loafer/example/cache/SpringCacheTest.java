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
  public void testFindNull(){
    Account jack = accountService.findAccountById("2");
    System.out.println(jack);
    accountService.printDB();
    accountService.pringCache();
  }

  @Test
  public void testFind(){
    Account account = accountService.findAccountById("1");
    System.out.println(account);

    Account account2 = accountService.findAccountById("1");
    System.out.println(account2);
    accountService.pringCache();
  }

  @Test
  public void test2(){
    Account jack = accountService.findAccountById("2");
    accountService.pringCache();
    if(jack == null){
      jack = new Account("2", "jack", "jack@163.com");
      accountService.saveAccount(jack);
    }

    accountService.printDB();
    Account jack2 = accountService.findAccountById("2");
    System.out.println(jack2);
    accountService.pringCache();
  }

  @Test
  public void test3(){
    Account jone = accountService.findAccountById("3");
    if(jone == null){
      jone = new Account("3", "jone", "jone@163.com");
      accountService.saveAccount(jone);
    }

    accountService.printDB();
    Account jone2 = accountService.findAccountById("3");
    System.out.println(jone2);

    accountService.delete(jone.getId());
    Account jone3 = accountService.findAccountById("3");
    System.out.println(jone3);
    accountService.printDB();
  }
}
