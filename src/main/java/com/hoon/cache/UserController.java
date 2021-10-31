package com.hoon.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
public class UserController {

  Map<Long, User> userMap = new ConcurrentHashMap<>();

  @PostConstruct
  public void init() {
    User user1 = User.builder()
        .id(1L)
        .name("test1")
        .email("test1@test.com")
        .build();

    User user2 = User.builder()
        .id(2L)
        .name("test2")
        .email("test2@test.com")
        .build();

    User user3 = User.builder()
        .id(3L)
        .name("test3")
        .email("test3@test.com")
        .build();

    userMap.put(user1.getId(), user1);
    userMap.put(user2.getId(), user2);
    userMap.put(user3.getId(), user3);

  }

  @Cacheable(cacheNames = "users")
  @GetMapping("/users")
  public List<User> getUser() throws InterruptedException {
    Thread.sleep(10000);
    Set<Long> userIds = userMap.keySet();

    return userIds.stream()
        .map(userId -> userMap.get(userId))
        .collect(Collectors.toList());

  }

}
