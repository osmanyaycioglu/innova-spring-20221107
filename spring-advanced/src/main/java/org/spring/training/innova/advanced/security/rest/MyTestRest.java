package org.spring.training.innova.advanced.security.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@RequestMapping("/int/test")
@RequestScope
public class MyTestRest {
    int counter = 0;

    @GetMapping
    public Integer counter(){
        return counter++;
    }
}
