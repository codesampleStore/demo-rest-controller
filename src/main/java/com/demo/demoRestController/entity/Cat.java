package com.demo.demoRestController.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cat {

  @Id
  private long id;

  private String name;
}
