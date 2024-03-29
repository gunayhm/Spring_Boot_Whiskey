package com.example.spring_boot_whiskey.exception;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(MyException.class)
  public ErrorResponse handleInternalException(MyException e) {
    var response = ErrorResponse.build(
            HttpStatus.NOT_FOUND, e.getMessage());
    log.error("Internal Server Error: {}", response);
    if (log.isTraceEnabled()) {
      log.error(Arrays.toString(e.getStackTrace()));
    }
    return response;
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorResponse handleInternalException(MethodArgumentNotValidException e) {
    var response = ErrorResponse.build(
            HttpStatus.BAD_REQUEST, e.getMessage());
    log.error("Invalid request");
    if (log.isTraceEnabled()) {
      log.error(Arrays.toString(e.getStackTrace()));
    }
    return response;
  }

}