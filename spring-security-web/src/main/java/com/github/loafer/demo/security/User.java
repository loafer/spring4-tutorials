package com.github.loafer.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author zhaojh.
 */
public class User implements UserDetails {
  private String id;
  private String username;
  private String password;
  private boolean enabled = false;
  private boolean accountNonExpired = false;
  private boolean accountNonLocked = false;
  private boolean credentialsNonExpired = false;
  private Collection<GrantedAuthority> grantedAuths;

  public User(String id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.enabled = true;
  }

  public User(String id, String username, String password, boolean enabled) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.enabled = enabled;
  }

  public User(String id, String username, String password, boolean enabled,
              boolean accountNonExpired,
              boolean accountNonLocked, boolean credentialsNonExpired,
              Collection<GrantedAuthority> grantedAuths) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.accountNonExpired = accountNonExpired;
    this.accountNonLocked = accountNonLocked;
    this.credentialsNonExpired = credentialsNonExpired;
    this.grantedAuths = grantedAuths;
  }

  public Collection<? extends GrantedAuthority> getAuthorities() {
    return grantedAuths;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setGrantedAuths(Collection<GrantedAuthority> grantedAuths) {
    this.grantedAuths = grantedAuths;
  }

  public String getId() {
    return id;
  }
}
