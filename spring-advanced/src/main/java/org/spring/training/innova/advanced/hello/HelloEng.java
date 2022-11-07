package org.spring.training.innova.advanced.hello;

import org.spring.training.innova.advanced.conditional.MyPropCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
// @Primary
@Profile("eng")
@MyPropCondition(conf = "app.language",confValue = "en")
@ConditionalOnProperty(value = "app.language",havingValue = "en")
public class HelloEng implements IHello {

    @Override
    public String hello(String name,
                        String surname) {
        return "Hello " + name + " " + surname;
    }

}
