package com.demo.demoRestController.service;

import com.demo.demoRestController.entity.Cat;
import com.demo.demoRestController.exception.CatNotFoundException;
import com.demo.demoRestController.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatService {

  private CatRepository catRepository;

  public CatService(CatRepository catRepository) {
    this.catRepository = catRepository;
  }
  public Cat findById(Long id) throws CatNotFoundException {
    Optional<Cat> cat =  catRepository.findById(id);

    if(cat.isEmpty()) {
      throw new CatNotFoundException();
    }
    return cat.get();
  }
}
