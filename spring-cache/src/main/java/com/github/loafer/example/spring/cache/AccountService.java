package com.github.loafer.example.spring.cache;

import com.github.loafer.example.spring.cache.entity.Account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

/**
 * @author zhaojh.
 */

public class AccountService {
  private final Logger logger = LoggerFactory.getLogger(AccountService.class);

  @Resource
  private CacheManager cacheManager;

  private Map<String, Account> db = new HashMap<String, Account>(){
    {
      put("tom", new Account("1", "tom", "tom@163.com"));
    }
  };

  @Cacheable(value = "account", key = "#id", condition = "#result != null")
  public Account findAccountById(String id){
    return getFromDB(id);
  }

  @CachePut(value = "account", key = "#account.id")
  public Account saveAccount(Account account){
    return updateDB(account);
  }

  @CacheEvict(value = "account", key = "#id")
  public void delete(String id){
    if(db.containsKey(id)){
      db.remove(id);
    }
  }

  @CacheEvict(value = "account", allEntries = true)
  public void deleteAll(){
    db.clear();
  }

  public void printDB(){
    System.out.println("DB: " + db);
  }

  public void pringCache(){
    Cache cache = cacheManager.getCache("account");
    System.out.println("cache: " + cache.getNativeCache());
  }

  private Account getFromDB(String username){
    logger.info("===>  real querying db... {}");
    return db.get(username);
  }

  private Account updateDB(Account account){
    logger.info("===>  real updating db...　{}", account.getName());
    if(!db.containsKey(account.getId())){
      db.put(account.getId(), account);
    }
    return account;
  }
}
