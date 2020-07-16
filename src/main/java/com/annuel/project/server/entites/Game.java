package com.annuel.project.server.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data@NoArgsConstructor@ToString
public class Game {

    private String id;
    private String homeTeamName;
    private String awayTeamName ;
    private String time;
    private String date;


    public Game ( @JsonProperty("id") String id,
                  @JsonProperty("homeTeamName") String homeTeamName,
                  @JsonProperty("awayTeamName") String awayTeamName,
                  @JsonProperty("time") String time,
                  @JsonProperty("date") String date) {

        this.id= id;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.time = time;
        this.date = date;
    }
}
