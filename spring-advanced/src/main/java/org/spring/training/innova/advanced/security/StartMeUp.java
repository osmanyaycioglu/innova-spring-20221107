package org.spring.training.innova.advanced.security;

import org.spring.training.innova.advanced.security.models.EUserRole;
import org.spring.training.innova.advanced.security.models.IUserDao;
import org.spring.training.innova.advanced.security.models.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartMeUp implements CommandLineRunner {
    @Autowired
    private IUserDao userDao;
    @Override
    public void run(String... args) throws Exception {
        MyUser mahmut = userDao.findByUsername("mahmut");
        if (mahmut == null){
            MyUser myUser = new MyUser();
            myUser.setUserRole(EUserRole.ADMIN);
            myUser.setUsername("mahmut");
            myUser.setSecretText("123456");
            userDao.save(myUser);
            System.out.println("Mahmut yazıldı **********");
        }
    }
}
