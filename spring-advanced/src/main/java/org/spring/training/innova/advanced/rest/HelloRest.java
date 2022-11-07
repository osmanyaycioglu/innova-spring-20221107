package org.spring.training.innova.advanced.rest;

import org.spring.training.innova.advanced.hello.IHello;
import org.spring.training.innova.advanced.properties.AnotherAppProperties;
import org.spring.training.innova.advanced.properties.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloRest {

    @Autowired
    //@Qualifier("helloTr")
    private IHello hello;

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private AnotherAppProperties anotherAppProperties;

    @Value("${my.app.prop.prop1}")
    private String propXyz;

    @Value("#{appProperties.prop2}")
    private String propXyz2;

    @Value("#{appProperties.consolidate()}")
    private String propXyz3;

    // /hello/hello1/osman?soy=yaycioglu
    @GetMapping("/hello1/{isim}")
    public String hello1(@PathVariable("isim") String name,
                         @RequestParam("soy") String surname) {
        return hello.hello(name,
                           surname);
    }

    @GetMapping("/props")
    public AppProperties getProps(){
        return appProperties;
    }

    @GetMapping("/aprops")
    public AnotherAppProperties getProps2(){
        return anotherAppProperties;
    }

    @GetMapping("/prop1")
    public String getProps3(){
        return propXyz;
    }

    @GetMapping("/prop2")
    public String getProps4(){
        return propXyz2;
    }

    @GetMapping("/propc")
    public String getProps5(){
        return propXyz3;
    }

}
