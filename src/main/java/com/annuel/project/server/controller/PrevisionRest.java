package com.annuel.project.server.controller;

import com.annuel.project.server.firebase.PrevisionService;
import com.annuel.project.server.firebase.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class PrevisionRest {
    private PrevisionService previsionService;

    public PrevisionRest(PrevisionService previsionService) {
        this.previsionService= previsionService;
    }


    @GetMapping("/prevision")
    public ResponseEntity<?> getPrevision(@RequestParam String prevision_ID) throws ExecutionException, InterruptedException {
        return previsionService.getPrevion(prevision_ID);
    }

}
