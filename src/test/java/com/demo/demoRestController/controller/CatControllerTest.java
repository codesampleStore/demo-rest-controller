package com.demo.demoRestController.controller;

import com.demo.demoRestController.entity.Cat;
import com.demo.demoRestController.service.CatService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CatController.class)

public class CatControllerTest {

  @MockBean
  CatService catService;

  @Autowired
  MockMvc mockMvc;

  @Test
  public void testGetById() throws Exception {
    Cat cat = new Cat().withId(1L).withName("Boots");

    when(catService.findById(1L)).thenReturn(cat);


    ResultActions result = mockMvc.perform(get("/api/cat/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("Boots"));


  }
}
