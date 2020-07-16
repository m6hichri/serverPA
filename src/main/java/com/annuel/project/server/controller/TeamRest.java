package com.annuel.project.server.controller;


import com.annuel.project.server.firebase.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class TeamRest {

    private TeamService teamService;

    public TeamRest(TeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping("/teams")
    public ResponseEntity<?> getTeams() throws ExecutionException, InterruptedException {
        return teamService.getTeams();
    }

    @GetMapping("/teamStat")
    public ResponseEntity<?> getTeamStat(@RequestParam String teamStatId) throws ExecutionException, InterruptedException {
        return teamService.getTeamStat(teamStatId);
    }

}
