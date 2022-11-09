package org.spring.training.innova.advanced;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
@EnableEncryptableProperties
@ServletComponentScan
public class SpringAdvancedApplication {
    private int counter = 0;

    @Scheduled(initialDelay = 1_000, fixedDelay = 10_000)
    public void mySchedule() {
        System.out.println("schedule : " + (counter++));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedApplication.class,
                              args);
    }

}
