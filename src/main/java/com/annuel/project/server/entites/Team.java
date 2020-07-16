package com.annuel.project.server.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Team {

    private Long teamId;
    private String name;

    public Team(@JsonProperty("teamId") Long teamId,
                @JsonProperty("name") String name) {
        this.teamId = teamId;
        this.name = name;
    }
}
