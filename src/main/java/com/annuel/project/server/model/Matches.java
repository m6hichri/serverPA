package com.annuel.project.server.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Matches {

    private String matchDate;
    private String homeName ;
    private int homePoints;
    private String visitorName;
    private int visitorPoints;

    public Matches( @JsonProperty("matchDate") String matchDate,
                    @JsonProperty("homeName") String homeName,
                    @JsonProperty("homePoints") int homePoints,
                    @JsonProperty("visitorName") String visitorName,
                    @JsonProperty("visitorPoints") int visitorPoints) {

        this.matchDate = matchDate;
        this.homeName = homeName;
        this.homePoints = homePoints;
        this.visitorName = visitorName;
        this.visitorPoints = visitorPoints;
    }

}


