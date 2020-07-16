package com.annuel.project.server.controller;


import com.annuel.project.server.entites.Account;
import com.annuel.project.server.entites.Users;

import com.annuel.project.server.firebase.UserService;
/*
import com.annuel.project.server.security.TokenProvider;
*/
import com.google.firebase.auth.FirebaseAuthException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;


 */
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@RestController
public class UserRest {

       private final UserService userService;

    public UserRest(UserService userService) {
        this.userService= userService;

    }

         /*
       private final TokenProvider tokenProvider;

       private final AuthenticationManagerBuilder authenticationManager;

    public UserRest(UserService userService, TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManager) {
        this.userService= userService;
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }


    public UserRest(UserService userService, TokenProvider tokenProvider) {
        this.userService= userService;
        this.tokenProvider = tokenProvider;
    }

    */
    @PostMapping("/createAccount")
       public ResponseEntity<?> createAccount(@RequestBody Users user) throws ExecutionException, InterruptedException {
               String reponse = userService.saveUser(user);

            return new ResponseEntity<>("Time : " + reponse, HttpStatus.OK);
        }


        @GetMapping("/detailUser")
        public Users getUser(@RequestParam String login) throws ExecutionException, InterruptedException {
            return userService.getUserDetail(login);
        }

        @PutMapping("/updateUser")
        public ResponseEntity<?> updateUser(@RequestBody Users user) throws ExecutionException, InterruptedException {
            return userService.updateUserDetails(user);
        }


        @DeleteMapping("/deleteUser")
        public ResponseEntity<?> deleteUser(@RequestParam String login) throws FirebaseAuthException {
            return userService.deleteUser(login);
        }


        /*
        @PostMapping("/login")
        public ResponseEntity<?> loginUser(@RequestBody Users user) throws ExecutionException, InterruptedException {
            //return firebaseService.connectAccount(account);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword());

            Authentication authentication = authenticationManager.getObject().authenticate(authenticationToken);

            String token = tokenProvider.createToken(authentication);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(AUTHORIZATION, "Bearer " + token);

            return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
        }


         */





}

