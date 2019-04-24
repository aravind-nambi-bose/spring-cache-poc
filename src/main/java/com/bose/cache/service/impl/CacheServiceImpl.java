package com.bose.cache.service.impl;

import com.bose.cache.dto.CacheDemo;
import com.bose.cache.service.CacheService;
import java.util.Random;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

  private Random random = new Random();

  @Override
  @Cacheable(value = "cacheDemo", key = "#id")
  public CacheDemo findById(int id) {
    throw new RuntimeException("Not found");
  }

  @Override
  @CachePut(value = "cacheDemo", key = "#result.id")
  public CacheDemo save(CacheDemo cacheDemo) {
    cacheDemo.setId(random.nextInt(50));
    return cacheDemo;
  }

  @Override
  @CacheEvict(value = "cacheDemo", allEntries = true)
  public void clearCache() {
    //No-op
  }
}
