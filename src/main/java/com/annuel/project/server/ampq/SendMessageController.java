package com.annuel.project.server.ampq;


import com.annuel.project.server.entites.Compteur;
import com.annuel.project.server.entites.PlayerStat;
import com.annuel.project.server.firebase.GameService;
import com.annuel.project.server.firebase.PlayerService;
import com.annuel.project.server.model.Matches;
import com.annuel.project.server.model.RequestClient;
import com.annuel.project.server.model.RequestMatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;


@RestController
@Slf4j
public class SendMessageController {

    private final RabbitTemplate rabbitTemplate;
    private final PlayerService playerService;
    private final GameService gameService;


    public SendMessageController(RabbitTemplate rabbitTemplate, PlayerService playerService,GameService gameService) {
        this.rabbitTemplate = rabbitTemplate;
        this.playerService = playerService;
        this.gameService = gameService;
    }



    @PostMapping("/requestClient")
    public ResponseEntity<?> sendrequest(@RequestBody RequestClient requestClient){

        if(!requestClient.getId().equals("")) {
            log.info("message send : {}", requestClient.toString() );
            rabbitTemplate.convertAndSend(AmqpConfig.REQUEST_CLIENT_QUEUE_, requestClient);
            return new ResponseEntity<>(requestClient.toString(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Team name is empty", HttpStatus.FORBIDDEN);
    }


    @PostMapping("/requestGames")
    public ResponseEntity<?> sendrequestIdGames(@RequestBody RequestMatch requestMatch){

        if(!requestMatch.equals("")) {
            log.info("message send : {}", requestMatch );
            rabbitTemplate.convertAndSend(AmqpConfig.RESPONSE_GAMES_QUEUE, requestMatch);
            return new ResponseEntity<>(requestMatch, HttpStatus.OK);
        }

        return new ResponseEntity<>("games_ID is empty", HttpStatus.FORBIDDEN);
    }



}

