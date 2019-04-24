package com.bose.cache.service;

import com.bose.cache.dto.CacheDemo;

public interface CacheService {

  CacheDemo findById(int id);

  CacheDemo save(CacheDemo cacheDemo);

  void clearCache();

}
