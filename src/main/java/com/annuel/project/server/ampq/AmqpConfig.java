package com.annuel.project.server.ampq;



import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {


    public static final String QUEUE_MATHES = "matches_queue";
    public static final String REQUEST_CLIENT_QUEUE_ = "request_client_queue";
    public static final String TEAMS_QUEUE = "teams_queue";
    public static final String TEAMS_STAT_QUEUE = "team_stat_queue";
    public static final String PLAYERS_QUEUE = "players_queue";
    public static final String PLAYER_STAT_QUEUE = "player_stat_queue";
    public static final String NEXT_GAMES_QUEUE = "next_games_queue";
    public static final String RESPONSE_GAMES_QUEUE = "id_next_game_queue";
    public static final String PREVISION_QUEUE = "prevision_queue";


    @Bean(name = "connexion")
    public ConnectionFactory createConnectionFactory() {

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("chinook.rmq.cloudamqp.com");
        connectionFactory.setUsername("tcdhcjrf");
        connectionFactory.setPassword("e_-7EazoBPwTdj-zHwsAeU4bHwZTpzoY");
        connectionFactory.setVirtualHost("tcdhcjrf");
        return connectionFactory;
    }

    @Bean
    public RabbitAdmin createAdmin() {
        ConnectionFactory ConnectionFactory = createConnectionFactory();
        RabbitAdmin admin = new RabbitAdmin(ConnectionFactory);

        return admin;
    }


    @Bean
    Queue createQueueMatches() {
        RabbitAdmin admin = createAdmin();
        Queue queue = new Queue(QUEUE_MATHES, true, false, false);
        admin.declareQueue(queue);
        return queue;
    }

    @Bean
    Queue createQueueRequestClient() {
        RabbitAdmin admin = createAdmin();
        Queue queue = new Queue(REQUEST_CLIENT_QUEUE_, true, false, false);
        admin.declareQueue(queue);
        return queue;
    }

    @Bean
    Queue createQueueTeams() {
        RabbitAdmin admin = createAdmin();
        Queue queue = new Queue(TEAMS_QUEUE, true, false, false);
        admin.declareQueue(queue);
        return queue;
    }

    @Bean
    Queue createQueueTeamStat() {
        RabbitAdmin admin = createAdmin();
        Queue queue = new Queue(TEAMS_STAT_QUEUE, true, false, false);
        admin.declareQueue(queue);
        return queue;
    }

    @Bean
    Queue createQueuePlayers() {
        RabbitAdmin admin = createAdmin();
        Queue queue = new Queue(PLAYERS_QUEUE, true, false, false);
        admin.declareQueue(queue);
        return queue;
    }

    @Bean
    Queue createQueuePlayerStat() {
        RabbitAdmin admin = createAdmin();
        Queue queue = new Queue(PLAYER_STAT_QUEUE, true, false, false);
        admin.declareQueue(queue);
        return queue;
    }

    @Bean
    Queue createQueueGames() {
        RabbitAdmin admin = createAdmin();
        Queue queue = new Queue(RESPONSE_GAMES_QUEUE, true, false, false);
        admin.declareQueue(queue);
        return queue;
    }

    @Bean
    Queue createQueuePrevision() {
        RabbitAdmin admin = createAdmin();
        Queue queue = new Queue(PREVISION_QUEUE, true, false, false);
        admin.declareQueue(queue);
        return queue;
    }


    @Bean
    public Jackson2JsonMessageConverter producerMessage()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(@Qualifier("connexion") final ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerMessage());
        return rabbitTemplate;
    }




}