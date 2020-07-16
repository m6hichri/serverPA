package com.annuel.project.server.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Prevision {
    private String id;
    private String homeTeamName;
    private String awayTeamName ;
    private String winProbHomePercent;
    private String winProbAwayPercent;


    public Prevision ( @JsonProperty("id") String id,
                       @JsonProperty("homeTeamName") String homeTeamName,
                       @JsonProperty("awayTeamName") String awayTeamName,
                       @JsonProperty("winProbHomePercent") String winProbHomePercent,
                       @JsonProperty("winProbAwayPercent") String winProbAwayPercent) {

        this.id= id;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.winProbAwayPercent = winProbAwayPercent;
        this.winProbHomePercent = winProbHomePercent;
    }


}
