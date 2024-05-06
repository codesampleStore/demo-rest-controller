package com.demo.demoRestController.controller;

import com.demo.demoRestController.entity.Cat;
import com.demo.demoRestController.service.CatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

  private CatService catService;

  public CatController(CatService catService) {
    this.catService = catService;
  }

  @GetMapping("/api/cat/{id}")
  public Cat getCatByID(@PathVariable Long id) {
    return catService.findById(id);
  }
}
