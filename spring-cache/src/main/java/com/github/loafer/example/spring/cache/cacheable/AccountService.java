package com.github.loafer.example.spring.cache.cacheable;

import com.github.loafer.example.spring.cache.entity.Account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

/**
 * @author zhaojh.
 */
public class AccountService {
  private static final String CACHE_NAME = "account";
  private Logger logger = LoggerFactory.getLogger(AccountService.class);
  @Resource
  private CacheManager cacheManager;

  private Map<String, Account> db = new HashMap<String, Account>(){
    {
      put("1", new Account("1", "Tom", "tom@163.com"));
    }
  };

  public Account saveAccount(Account account){
    return updateDB(account);
  }

  //如此注释会出现混乱
  @Caching(
      cacheable = {
        @Cacheable(value = CACHE_NAME, key = "#id")
      },
      put = {
        @CachePut(value = CACHE_NAME, key = "#result.name", condition = "#result != null")
      }
  )
  public Account getAccountById(String id){
    return getFromDB(id);
  }

  @Cacheable(value = CACHE_NAME, key = "#name")
  public Account getAccountByName(String name){
    logger.info("===> real querying db... by name");
    Set<String> keys = db.keySet();
    for (String key : keys){
      Account account = db.get(key);
      if(account.getName().equalsIgnoreCase(name)){
        return account;
      }
    }

    return null;
  }

  public void printCache(){
    Cache cache = cacheManager.getCache(CACHE_NAME);
    System.out.println("===> cache: " + cache.getNativeCache());
  }

  public void printDB(){
    System.out.println("===> db: " + db);
  }

  private Account getFromDB(String id){
    logger.info("===> real querying db... by id");
    return db.get(id);
  }

  private Account updateDB(Account account){
    logger.info("===> real updating db...　{}", account.getName());
    db.put(account.getId(), account);
    return account;
  }
}
