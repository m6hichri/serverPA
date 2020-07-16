package com.annuel.project.server.controller;

import com.annuel.project.server.ampq.SendMessageController;
import com.annuel.project.server.entites.Users;
import com.annuel.project.server.firebase.MatchService;
import com.annuel.project.server.model.Matches;
import com.annuel.project.server.model.RequestClient;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;


 */
import org.springframework.web.bind.annotation.*;


import java.util.concurrent.ExecutionException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
public class MatchesRest {

    private MatchService matchService;

    public MatchesRest(MatchService matchService) {
        this.matchService=matchService;
    }

    @GetMapping("/recentMatches")
    public ResponseEntity<?> getMatches() throws ExecutionException, InterruptedException {
        return matchService.getMatches();
    }




}
