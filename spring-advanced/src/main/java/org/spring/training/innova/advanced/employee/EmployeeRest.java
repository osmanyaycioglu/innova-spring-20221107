package org.spring.training.innova.advanced.employee;

import lombok.Getter;
import lombok.Setter;
import org.spring.training.innova.advanced.validation.ContainsStr;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeRest {

    @NotEmpty(message = "name null olamaz")
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    @ContainsStr({"ali","veli"})
    private String    name;
    @NotEmpty
    @Size(min = 3,max = 25)
    private String    surname;
    @NotEmpty
    @Size(min = 6,max = 25)
    private String    username;
    @ContainsStr({"1234","123456","abc"})
    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String    password;
    @Min(80)
    @Max(300)
    private Integer   height;
    @Min(10)
    @Max(300)
    private Integer   weight;
    @Past
    private LocalDate birthday;

}
