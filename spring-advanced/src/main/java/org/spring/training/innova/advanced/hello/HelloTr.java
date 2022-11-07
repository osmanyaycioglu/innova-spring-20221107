package org.spring.training.innova.advanced.hello;

import org.spring.training.innova.advanced.conditional.MyPropCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("tr")
@MyPropCondition(conf = "app.language",confValue = "tr")
@ConditionalOnProperty(value = "app.language",havingValue = "tr")
public class HelloTr implements IHello {

    @Override
    public String hello(String name,
                        String surname) {
        return "Selam " + name + " " + surname;
    }

}
