package com.annuel.project.server.security;

/*
import com.annuel.project.server.entites.Users;

import com.annuel.project.server.firebase.UserService;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.util.ArrayList;




@Component
public class DomainUserDetailService implements UserDetailsService {

    private final UserService userService;

    public DomainUserDetailService(UserService userService) {
        this.userService=userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        try {

            Users appUser = userService.getUserDetail(login);


            UserDetails u = UserToken.builder().login(login)
                    .email(appUser.getEmail())
                    .firstName(appUser.getFirstName())
                    .lastName(appUser.getLastName())
                    .login(appUser.getLogin())
                    .phone(appUser.getPhone())
                    .password(appUser.getPassword())
                    .build();

            return u;

        }catch (Exception e){
            throw new AuthenticationServiceException("Login " + login + " not found");
        }


    }
}


 */
