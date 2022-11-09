package org.spring.training.innova.advanced.security;

import org.spring.training.innova.advanced.security.models.IUserDao;
import org.spring.training.innova.advanced.security.models.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser byUsername = userDao.findByUsername(username);
        if (byUsername == null) {
            throw new UsernameNotFoundException("böyle user yok");
        }
        return User.builder()
                   .username(username)
                   .password(encoder.encode(byUsername.getSecretText()))
                   .roles(byUsername.getUserRole()
                                    .toString())
                   .build();
    }

}
