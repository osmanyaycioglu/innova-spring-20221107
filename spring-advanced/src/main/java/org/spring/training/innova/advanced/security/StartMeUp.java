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
        MyUser user1 = userDao.findByUsername("user1");
        if (user1 == null){
            MyUser myUser = new MyUser();
            myUser.setUserRole(EUserRole.USER);
            myUser.setUsername("user1");
            myUser.setSecretText("123456");
            userDao.save(myUser);
            System.out.println("user1 yazıldı **********");
        }
        MyUser super1 = userDao.findByUsername("super1");
        if (super1 == null){
            MyUser myUser = new MyUser();
            myUser.setUserRole(EUserRole.SUPER_ADMIN);
            myUser.setUsername("super1");
            myUser.setSecretText("123456");
            userDao.save(myUser);
            System.out.println("super1 yazıldı **********");
        }

    }
}
