package org.spring.training.innova.advanced.rest;

import org.spring.training.innova.advanced.hello.IHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloRest {

    @Autowired
    //@Qualifier("helloTr")
    private IHello hello;

    // /hello/hello1/osman?soy=yaycioglu
    @GetMapping("/hello1/{isim}")
    public String hello1(@PathVariable("isim") String name,
                         @RequestParam("soy") String surname) {
        return hello.hello(name,
                           surname);
    }

}
