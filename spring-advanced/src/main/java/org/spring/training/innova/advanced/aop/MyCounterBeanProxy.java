package org.spring.training.innova.advanced.aop;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyCounterBeanProxy extends MyCounterBean {

    public  int counter() {
        //Trans code
        int counter = super.counter();
        // Commit
        return counter;
    }

}
