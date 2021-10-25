package com.hoon.cache.common;

import lombok.Getter;

@Getter
public enum CacheType {
  ARTISTS("artists", 5 * 60, 10000),
  ARTIST_INFO("artistInfo", 24 * 60 * 60, 10000);

  CacheType(String cacheName, int expiredAfterWrite, int maximumSize) {
    this.cacheName = cacheName;
    this.expiredAfterWrite = expiredAfterWrite;
    this.maximumSize = maximumSize;
  }

  private String cacheName;
  private int expiredAfterWrite;
  private int maximumSize;

}
