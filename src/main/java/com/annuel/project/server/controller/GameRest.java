package com.annuel.project.server.controller;

import com.annuel.project.server.firebase.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class GameRest {

    private GameService gameService;

    public GameRest(GameService  gameService){
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public ResponseEntity<?> getGames() throws ExecutionException, InterruptedException {
        return gameService.getGames();
    }
}
