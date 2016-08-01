package com.github.loafer.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhaojh.
 */
public class UserDetailsServiceImpl implements UserDetailsService {
  private UserService userService;

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.getUserByUsername(username);
    if(user == null){
      String message = "用户 %s 未找到。";
      throw new UsernameNotFoundException(String.format(message, username));
    }

    Set<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
    user.setGrantedAuths(grantedAuths);
    return user;
  }

  private Set<GrantedAuthority> obtionGrantedAuthorities(User user){
    Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();

    List<Role> roles = userService.getRolesByUserid(user.getId());

    if(roles != null && !roles.isEmpty()){
      for (Role role:roles){
        authSet.add(new SimpleGrantedAuthority(role.getId()));
      }
    }

    return authSet;
  }
}
