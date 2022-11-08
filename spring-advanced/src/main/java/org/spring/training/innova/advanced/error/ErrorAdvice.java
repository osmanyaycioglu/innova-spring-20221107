package org.spring.training.innova.advanced.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(IllegalArgumentException exception) {
        return ErrorObj.builder()
                       .withMicroservice("xyz")
                       .withErrorDesc(exception.getMessage())
                       .withErrorCode(1023)
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(MethodArgumentNotValidException exception) {
        return ErrorObj.builder()
                       .withMicroservice("xyz")
                       .withErrorDesc("Validasyon problemi")
                       .withErrorCode(1027)
                       .build()
                       .addSubErrors(exception.getAllErrors()
                                              .stream()
                                              .map(e -> ErrorObj.builder()
                                                                .withMicroservice("xyz")
                                                                .withErrorDesc(e.toString())
                                                                .withErrorCode(1028)
                                                                .build())
                                              .collect(Collectors.toList()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ErrorObj handle(ConstraintViolationException exception) {
        return ErrorObj.builder()
                       .withMicroservice("xyz")
                       .withErrorDesc("Validasyon problemi")
                       .withErrorCode(1027)
                       .build()
                       .addSubErrors(exception.getConstraintViolations()
                                              .stream()
                                              .map(e -> ErrorObj.builder()
                                                                .withMicroservice("xyz")
                                                                .withErrorDesc(e.toString())
                                                                .withErrorCode(1028)
                                                                .build())
                                              .collect(Collectors.toList()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handle(Exception exception) {
        if (exception instanceof NullPointerException){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body(ErrorObj.builder()
                                               .withMicroservice("xyz")
                                               .withErrorDesc("Data corr")
                                               .withErrorCode(5001)
                                               .build());

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .header("Error",
                                     exception.getMessage())
                             .body(ErrorObj.builder()
                                           .withMicroservice("xyz")
                                           .withErrorDesc(exception.getMessage())
                                           .withErrorCode(5000)
                                           .build());
    }

}
