package com.bose.cache.controller;

import com.bose.cache.dto.CacheDemo;
import com.bose.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

  private CacheService cacheService;

  @Autowired
  public CacheController(CacheService cacheService) {
    this.cacheService = cacheService;
  }

  @GetMapping(value = "/data/{id}", produces = "application/json")
  public CacheDemo get(@PathVariable("id") int id) {
    return this.cacheService.findById(id);
  }

  @PostMapping(value = "/data", consumes = "application/json", produces = "application/json")
  public CacheDemo save(@RequestBody CacheDemo cacheDemo) {
    return this.cacheService.save(cacheDemo);
  }

  @GetMapping(value = "/evict")
  public void evict() {
    this.cacheService.clearCache();
  }

}
