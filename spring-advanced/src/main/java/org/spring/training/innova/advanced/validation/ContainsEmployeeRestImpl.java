package org.spring.training.innova.advanced.validation;

import org.spring.training.innova.advanced.employee.rest.EmployeeRest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ContainsEmployeeRestImpl implements ConstraintValidator<ContainsStr, EmployeeRest> {

    private ContainsStr anno;

    @Override
    public void initialize(ContainsStr anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(EmployeeRest value,
                           ConstraintValidatorContext context) {
        LocalDate birthday = value.getBirthday();
        Integer height = value.getHeight();
        return true;
    }
}
