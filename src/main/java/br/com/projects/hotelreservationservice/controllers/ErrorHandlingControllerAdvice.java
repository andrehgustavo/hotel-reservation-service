package br.com.projects.hotelreservationservice.controllers;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import br.com.projects.hotelreservationservice.entity.ValidationErrorResponse;
import br.com.projects.hotelreservationservice.entity.Violation;
import br.com.projects.hotelreservationservice.exception.ErrorRegisterNotFoundInDataBase;

/** Controller to intercept exceptions */
@ControllerAdvice
public class ErrorHandlingControllerAdvice {
    
    /**
     * Handle with ConstraintViolationException exceptions.
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onConstraintValidationException(
        ConstraintViolationException e) {
      ValidationErrorResponse error = new ValidationErrorResponse();
      for (ConstraintViolation violation : e.getConstraintViolations()) {
        error.getViolations().add(
          new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
      }
      return error;
    }
  
    /**
     * Handle with MethodArgumentNotValidException exceptions.
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onMethodArgumentNotValidException(
        MethodArgumentNotValidException e) {
      ValidationErrorResponse error = new ValidationErrorResponse();
      for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
        error.getViolations().add(
          new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
      }
      return error;
    }

    /**
     * Handle with ErrorRegisterNotFoundInDataBase exceptions.
     * @param e
     * @return
     */
    @ExceptionHandler(ErrorRegisterNotFoundInDataBase.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    ValidationErrorResponse onErrorRegisterNotFoundInDataBase(
        ErrorRegisterNotFoundInDataBase e) {
      ValidationErrorResponse error = new ValidationErrorResponse();
      error.getViolations().add(
          new Violation("id", e.getMessage()));
      return error;
    } 

    /**
     * Handle with generic exceptions.
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse handleException(Exception e) {
      ValidationErrorResponse error = new ValidationErrorResponse();
      error.getViolations().add(
          new Violation("Generic", e.getMessage()));
      return error;
    } 
}
