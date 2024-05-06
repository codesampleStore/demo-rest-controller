package com.demo.demoRestController.service;

import com.demo.demoRestController.entity.Cat;
import com.demo.demoRestController.exception.CatNotFoundException;
import com.demo.demoRestController.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatServiceTest {

  @Mock
  CatRepository catRepository;

  @Test
  void getCatById() throws Exception {
    CatService service = new CatService(catRepository);

    Optional<Cat> cat = Optional.of(new Cat().withId(1).withName("Boots"));

    when(catRepository.findById(1L)).thenReturn(cat);

    Cat foundCat = service.findById(1L);

    assertThat(foundCat).isEqualTo(cat.get());
    verify(catRepository).findById(1L);
  }

  @Test
  void getCatByIdNotFound() {
    CatService catService = new CatService(catRepository);
    Optional<Cat> emptyCat = Optional.empty();

    when(catRepository.findById(1L)).thenReturn(emptyCat);

    assertThrows(CatNotFoundException.class, () -> {
      Cat foundCat = catService.findById(1L);
    });

    verify(catRepository).findById(1L);

  }
}
