package org.spring.training.innova.advanced.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.spring.training.innova.advanced.security.models.EUserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* org.spring.training.innova.advanced.aop.MyCounterBean.*(int)) && args(val)")
    public void beforeMethod(JoinPoint joinPoint,
                             int val) {
        System.out.println(joinPoint + " Method öncesi çalıştım : " + val);
    }

    @After("execution(* org.spring.training.innova.advanced.aop.MyCounterBean.*(int)) && args(val)")
    public void afterMethod(JoinPoint joinPoint,
                            int val) {
        System.out.println(joinPoint + "Method sonrası çalıştım " + val);
    }

    @AfterReturning(value = "execution(* org.spring.training.innova.advanced.aop.MyCounterBean.*(int)) && args(val)",
            returning = "retVal")
    public void afterReturningMethod(JoinPoint joinPoint,
                                     int retVal,
                                     int val) {
        System.out.println(joinPoint + " Method sonrası çalıştım " + val + " ve çıktı : " + retVal);
    }

    @AfterThrowing(value = "execution(* org.spring.training.innova.advanced.aop.MyCounterBean.*(int)) && args(val)",
            throwing = "retVal")
    public void afterReturningMethod(JoinPoint joinPoint,
                                     Exception retVal,
                                     int val) {
        System.out.println(joinPoint + " Method sonrası exception " + val + " ve exp : " + retVal.getMessage());
    }

    @Around("execution(String org.spring.training.innova.advanced.aop.MyCounterBean.*(String))")
    public Object aroundMethod(ProceedingJoinPoint pjp) {
        try {
            Object[] args = pjp.getArgs();
            String str = (String) args[0];
            if ("osman".equals(str)) {
                return "osman bu methoda giremez";
            }
            long delta = System.nanoTime();
            Object proceed = pjp.proceed();
            System.out.println("Method delta : " + (System.nanoTime() - delta));
            if (proceed instanceof String) {

                String myStr = (String) proceed;
                return myStr + " intercepted.";
            }
            return proceed;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Around("@annotation(deltaTime)")
    public Object aroundDelta(ProceedingJoinPoint pjp,
                              DeltaTime deltaTime) {
        try {
            long delta = System.nanoTime();
            Object proceed = pjp.proceed();
            System.out.println("Method delta : "
                                       + deltaTime.value()
                                                  .convert(System.nanoTime() - delta,
                                                           TimeUnit.NANOSECONDS)
                                       + " Method : " + pjp.toShortString());
            return proceed;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Around("@annotation(checkRole)")
    public Object aroundSecurity(ProceedingJoinPoint pjp,
                                 CheckRole checkRole) {
        try {
            boolean proc = false;
            Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext()
                                                                                      .getAuthentication()
                                                                                      .getAuthorities();
            for (GrantedAuthority grantedAuthority :
                    authorities) {
                EUserRole eUserRole = EUserRole.valueOf(grantedAuthority.getAuthority().substring(5));
                if (eUserRole != null && eUserRole == checkRole.value()) {
                    proc = true;
                }
            }
            if (proc) {
                Object proceed = pjp.proceed();
                return proceed;
            }
            throw new IllegalAccessException("Giremezsin");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
