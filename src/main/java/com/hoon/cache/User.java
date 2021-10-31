package com.hoon.cache;

import lombok.*;

@Getter
public class User {
  private final Long id;
  private final String email;
  private final String name;

  @Builder
  public User(Long id, String email, String name) {
    this.id = id;
    this.email = email;
    this.name = name;
  }
}
