package com.demo.demoRestController.exception;

import com.demo.demoRestController.entity.Cat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CatNotFoundException.class)
  public ResponseEntity<Cat> handleCatNotFound(CatNotFoundException exception, WebRequest webRequest) {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
