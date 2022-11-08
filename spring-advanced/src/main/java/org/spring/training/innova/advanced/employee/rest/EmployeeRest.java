package org.spring.training.innova.advanced.employee.rest;

import org.spring.training.innova.advanced.validation.ContainsStr;

import javax.validation.constraints.*;
import java.time.LocalDate;

@ContainsStr({"1234","123","12345"})
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
    @ContainsStr({"asd","qwerty","abc"})
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

    public @NotEmpty(message = "name null olamaz") @NotNull @NotBlank @Size(min = 2, max = 20) @ContainsStr({"ali",
                                                                                                             "veli"
    }) String getName() {
        return this.name;
    }

    public @NotEmpty @Size(min = 3, max = 25) String getSurname() {
        return this.surname;
    }

    public @NotEmpty @Size(min = 6, max = 25) String getUsername() {
        return this.username;
    }

    public @ContainsStr({"asd",
                         "qwerty",
                         "abc"
    }) @NotEmpty @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$") String getPassword() {
        return this.password;
    }

    public @Min(80) @Max(300) Integer getHeight() {
        return this.height;
    }

    public @Min(10) @Max(300) Integer getWeight() {
        return this.weight;
    }

    public @Past LocalDate getBirthday() {
        return this.birthday;
    }

    public void setName(@NotEmpty(message = "name null olamaz") @NotNull @NotBlank @Size(min = 2, max = 20) @ContainsStr({"ali",
                                                                                                                          "veli"
    }) String name) {
        this.name = name;
    }

    public void setSurname(@NotEmpty @Size(min = 3, max = 25) String surname) {
        this.surname = surname;
    }

    public void setUsername(@NotEmpty @Size(min = 6, max = 25) String username) {
        this.username = username;
    }

    public void setPassword(@ContainsStr({"asd",
                                          "qwerty",
                                          "abc"
    }) @NotEmpty @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$") String password) {
        this.password = password;
    }

    public void setHeight(@Min(80) @Max(300) Integer height) {
        this.height = height;
    }

    public void setWeight(@Min(10) @Max(300) Integer weight) {
        this.weight = weight;
    }

    public void setBirthday(@Past LocalDate birthday) {
        this.birthday = birthday;
    }
}
