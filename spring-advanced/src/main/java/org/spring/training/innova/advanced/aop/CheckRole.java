package org.spring.training.innova.advanced.aop;

import org.spring.training.innova.advanced.security.models.EUserRole;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckRole {

    EUserRole value() default EUserRole.SUPER_ADMIN;

}
