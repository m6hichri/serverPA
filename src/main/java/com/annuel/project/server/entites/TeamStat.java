package com.annuel.project.server.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class TeamStat {

    private Long TEAM_ID;
    private String TEAM_CITY;
    private String TEAM_NAME;
    private String YEAR;
    private double GP;
    private double WINS;
    private double LOSSES;
    private double CONF_RANK;
    private double DIV_RANK;
    private double DIV_COUNT;
    private String NBA_FINALS_APPEARANCE;
    private double FGM;
    private double FGA;
    private double FG3M;
    private double FG3A;
    private double OREB;
    private double DREB;
    private double REB;
    private double PTS;


    //TEAM_ID": 1610612737, "TEAM_CITY": "Atlanta", "TEAM_NAME": "Atlanta Hawks", "YEAR": "2019-20", "GP": 67, "WINS": 20, "LOSSES": 47, "CONF_RANK": 14, "DIV_RANK": 5, "DIV_COUNT": 5, "NBA_FINALS_APPEARANCE": "N/A", "FGM": 2723, "FGA": 6067, "FG3M": 805, "FG3A": 2416, "OREB": 661, "DREB": 2237, "REB": 2898, "PTS": 7488


    public TeamStat(@JsonProperty("TEAM_ID") long TEAM_ID,
                @JsonProperty("TEAM_CITY") String TEAM_CITY,
                @JsonProperty("TEAM_NAME") String TEAM_NAME,
                @JsonProperty("YEAR") String YEAR,
                @JsonProperty("GP") double GP,
                @JsonProperty("WINS") double WINS,
                @JsonProperty("LOSSES") double LOSSES,
                @JsonProperty("CONF_RANK") double CONF_RANK,
                @JsonProperty("DIV_RANK") double DIV_RANK,
                @JsonProperty("DIV_COUNT") double DIV_COUNT,
                @JsonProperty("NBA_FINALS_APPEARANCE") String NBA_FINALS_APPEARANCE,
                @JsonProperty("FGM") double FGM,
                @JsonProperty("FGA") double FGA,
                @JsonProperty("FG3M") double FG3M,
                @JsonProperty("FG3A") double FG3A,
                @JsonProperty("OREB") double OREB,
                @JsonProperty("DREB") double DREB,
                @JsonProperty("REB") double REB,
                @JsonProperty("PTS") double PTS)
    {
        this.TEAM_ID = TEAM_ID;
        this.TEAM_CITY = TEAM_CITY;
        this.TEAM_NAME = TEAM_NAME;
        this.YEAR = YEAR;
        this.GP = GP;
        this.WINS = WINS;
        this.LOSSES = LOSSES;
        this.CONF_RANK = CONF_RANK;
        this.DIV_RANK = DIV_RANK;
        this.DIV_COUNT = DIV_COUNT;
        this.NBA_FINALS_APPEARANCE = NBA_FINALS_APPEARANCE;
        this.FGM = FGM;
        this.FGA = FGA;
        this.FG3M = FG3M;
        this.FG3A = FG3A;
        this.OREB = OREB;
        this.DREB = DREB;
        this.REB = REB;
        this.PTS = PTS;
    }



}
