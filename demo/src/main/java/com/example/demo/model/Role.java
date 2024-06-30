package com.example.demo.model;

import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
  ADMIN(Set.of(ADMIN_READ, ADMIN_UPDATE, ADMIN_DELETE, ADMIN_CREATE)),
  USER(Set.of(USER_READ, USER_UPDATE, USER_DELETE, USER_CREATE));

  @Getter private final Set<Permission> permissions;
}
