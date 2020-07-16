package com.annuel.project.server.ampq;




import com.annuel.project.server.entites.*;

import com.annuel.project.server.firebase.*;
import com.annuel.project.server.model.Matches;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;





@Service
@Slf4j
public class ReceiveMessage{

    private MatchService matchService;
    private PlayerService playerService;
    private TeamService teamService;
    private GameService gameService;
    private PrevisionService previsionService;

    public ReceiveMessage(MatchService matchService,
                          PlayerService playerService,
                          TeamService teamService,
                          GameService gameService,
                          PrevisionService previsionService) {
        this.matchService = matchService;
        this.playerService = playerService;
        this.teamService = teamService;
        this.gameService = gameService;
        this.previsionService = previsionService;
    }

    @RabbitListener(queues = AmqpConfig.QUEUE_MATHES)
    public void consumeMessageMatchs(final Matches matches) throws ExecutionException, InterruptedException {

        log.info("matchs receive: {}", matches.toString() );
        matchService.saveMatches(matches);

    }


    @RabbitListener(queues = AmqpConfig.TEAMS_QUEUE)
    public void consumeMessageTeams(final Team team) throws ExecutionException, InterruptedException {

        log.info("Teams receive: {}", team.toString() );
        teamService.saveTeams(team);

    }


    @RabbitListener(queues = AmqpConfig.TEAMS_STAT_QUEUE)
    public void consumeMessageTeamStat(final TeamStat teamStat) throws ExecutionException, InterruptedException {

        log.info("Team static receive: {}", teamStat.toString() );
        teamService.saveTeamStat(teamStat);

    }


    @RabbitListener(queues = AmqpConfig.PLAYERS_QUEUE)
    public void consumeMessagePlayer(final Player player) throws ExecutionException, InterruptedException {

        log.info("Player receive: {}", player.toString() );
        playerService.savePlayer(player);

    }


    @RabbitListener(queues = AmqpConfig.PLAYER_STAT_QUEUE)
    public void consumeMessagePlayerStat(final PlayerStat playerStat) throws ExecutionException, InterruptedException {

        log.info("Player stat receive: {}", playerStat.toString() );
        playerService.savePlayerStat(playerStat);

    }

    @RabbitListener(queues = AmqpConfig.NEXT_GAMES_QUEUE)
    public void consumeMessageGames(final Game game) throws ExecutionException, InterruptedException {

        log.info("Games receive: {}", game.toString() );
        gameService.saveGame(game);
    }

    @RabbitListener(queues = AmqpConfig.PREVISION_QUEUE)
    public void consumeMessagePrevision(final Prevision prevision) throws ExecutionException, InterruptedException {

        log.info("Prevision receive: {}", prevision.toString() );
        previsionService.savePrevision(prevision);
    }


}







