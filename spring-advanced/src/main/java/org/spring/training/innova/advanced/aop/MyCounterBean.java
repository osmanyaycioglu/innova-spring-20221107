package org.spring.training.innova.advanced.aop;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyCounterBean {
    // private List<String> stringList = Collections.synchronizedList(new ArrayList<>());

    // private int           counter = 0;
    private AtomicInteger acounter = new AtomicInteger();

    public  int counter() {
        // return counter++;
        return acounter.incrementAndGet();
    }

    public  int addCounter(int amount) {
        // return counter++;
        return acounter.addAndGet(amount);
    }

    @DeltaTime
    public String hello(String name){
        return "Hello "  + name;
    }

    public static class CounterThread extends Thread {
        private MyCounterBean myCounterBean;

        public CounterThread(MyCounterBean myCounterBean) {
            this.myCounterBean = myCounterBean;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                myCounterBean.counter();
            }
            System.out.println("Bitti : " + this.getName());
        }
    }

    public static void main(String[] args) {
        MyCounterBean myCounterBean = new MyCounterBean();
        for (int i = 0; i < 5; i++) {
            CounterThread counterThread = new CounterThread(myCounterBean);
            counterThread.setName("Counter-" + i);
            counterThread.start();
        }
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {

        }
        System.out.println("counter : " + myCounterBean.counter());

    }
}
