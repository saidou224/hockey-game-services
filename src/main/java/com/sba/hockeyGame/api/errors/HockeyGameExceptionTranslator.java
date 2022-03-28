package com.sba.hockeyGame.api.errors;


import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import javax.management.InstanceAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HockeyGameExceptionTranslator extends ResponseEntityExceptionHandler {

  @ExceptionHandler(InstanceAlreadyExistsException.class)
  public ResponseEntity<Error> handleException(InstanceAlreadyExistsException e) {
    Error error = new Error(CONFLICT, e.getLocalizedMessage());
    return new ResponseEntity<>(error, error.getHttpStatus());
  }

  @ExceptionHandler(InternalServerError.class)
  public ResponseEntity<Error> handleException(InternalServerError e) {
    Error error = new Error(INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
    return new ResponseEntity<>(error, error.getHttpStatus());
  }

}
