package org.spring.training.innova.advanced.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyException extends Exception {
    private String extraMessage;

}
