package org.spring.training.innova.advanced.security.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<MyUser,Long> {

    MyUser findByUsername(String username);

}
