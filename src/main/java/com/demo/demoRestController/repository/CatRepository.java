package com.demo.demoRestController.repository;

import com.demo.demoRestController.entity.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {

}
