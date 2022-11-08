package org.spring.training.innova.advanced.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class ContainsStrAllImpl implements ConstraintValidator<ContainsStr, Object> {

    private ContainsStr anno;

    @Override
    public void initialize(ContainsStr anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(Object value,
                           ConstraintValidatorContext context) {
        Class<?> aClass = value.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f : declaredFields) {
            if (f.getType()
                 .getName()
                 .equals("java.lang.String")) {
                String s = null;
                try {
                    f.setAccessible(true);
                    s = (String) f.get(value);
                    String[] values = anno.value();
                    for (String str : values) {
                        if (s.contains(str)) {
                            context.disableDefaultConstraintViolation();
                            ConstraintValidatorContext.ConstraintViolationBuilder violationBuilder = context.buildConstraintViolationWithTemplate(
                                    "Field : "
                                            + f.getName()
                                            + " contains : "
                                            + str + " not allowed!.");
                            violationBuilder.addConstraintViolation();
                            return false;
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        return true;
    }
}
