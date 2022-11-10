package org.spring.training.innova.advanced.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/counter")
public class MyCounterController {

    @Autowired
    private MyCounterBean myCounterBean;

    @GetMapping("/get")
    public Integer getCounter(){
        return myCounterBean.counter();
    }

    @GetMapping("/get2")
    public Integer getCounter2(){
        return myCounterBean.addCounter(2);
    }

    @DeltaTime
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return myCounterBean.hello(name);
    }

}
