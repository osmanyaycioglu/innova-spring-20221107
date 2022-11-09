package org.spring.training.innova.advanced.security.models;

import lombok.Getter;
import lombok.Setter;
import org.spring.training.innova.advanced.jpa.PasswordConverter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class MyUser {

    @Id
    @GeneratedValue
    private Long userId;
    @Column(unique = true)
    private String username;
    @Convert(converter = PasswordConverter.class)
    private String secretText;
    @Enumerated(EnumType.STRING)
    private EUserRole userRole;
}
