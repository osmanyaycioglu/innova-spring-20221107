package org.spring.training.innova.advanced.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,
         ElementType.FIELD,
         ElementType.TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(MyPropConditionImpl.class)
public @interface MyPropCondition {
    String conf();
    String confValue();
}
