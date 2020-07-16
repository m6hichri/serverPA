package com.annuel.project.server.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class PlayerStat {

    private Long PLAYER_ID;
    private String PLAYER_NAME;
    private int PLAYER_AGE;
    private double MIN;
    private double FGM;
    private double FG3M;
    private double OREB;
    private double DREB;
    private double REB;
    private double AST;
    private double PTS;

    public PlayerStat(@JsonProperty("PLAYER_ID") Long PLAYER_ID,
                      @JsonProperty("PLAYER_NAME") String PLAYER_NAME,
                      @JsonProperty("PLAYER_AGE") int PLAYER_AGE,
                      @JsonProperty("MIN") double MIN,
                      @JsonProperty("FGM") double FGM,
                      @JsonProperty("FG3M") double FG3M,
                      @JsonProperty("OREB") double OREB,
                      @JsonProperty("DREB") double DREB,
                      @JsonProperty("REB") double REB,
                      @JsonProperty("AST") double AST,
                      @JsonProperty("PTS") double PTS)
    {
        this.PLAYER_ID = PLAYER_ID;
        this.PLAYER_NAME = PLAYER_NAME;
        this.PLAYER_AGE = PLAYER_AGE;
        this.MIN = MIN;
        this.FGM = FGM;
        this.FG3M = FG3M;
        this.OREB = OREB;
        this.DREB = DREB;
        this.REB = REB;
        this.AST = AST;
        this.PTS = PTS;
    }
}
