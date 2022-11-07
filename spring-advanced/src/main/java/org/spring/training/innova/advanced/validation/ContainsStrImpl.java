package org.spring.training.innova.advanced.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContainsStrImpl implements ConstraintValidator<ContainsStr,String> {

    private ContainsStr anno;

    @Override
    public void initialize(ContainsStr anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext context) {
        String[] values = anno.value();
        for (String str : values) {
            if (value.contains(str)){
                return false;
            }
        }
        return true;
    }
}
