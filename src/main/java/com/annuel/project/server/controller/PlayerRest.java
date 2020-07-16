package com.annuel.project.server.controller;


import com.annuel.project.server.firebase.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class PlayerRest {

    private PlayerService playerService;

    public PlayerRest(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/playerStat")
    public ResponseEntity<?> getPlayerStat(@RequestParam String playerStatId) throws ExecutionException, InterruptedException {
        return playerService.getPlayerStat(playerStatId);
    }

    @GetMapping("/player")
    public ResponseEntity<?> getPlayer() throws ExecutionException, InterruptedException {
        return playerService.getPlayer();
    }

}
