package com.github.loafer.demo.security;

import java.util.List;

/**
 * @author zhaojh.
 */
public interface UserService {
  User getUserByUsername(String username);

  List<Role> getRolesByUserid(String id);
}
