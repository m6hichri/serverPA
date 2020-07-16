package com.annuel.project.server.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Player {

   private Long PLAYER_ID;
   private String name;

   public Player(@JsonProperty("PLAYER_ID") Long playerId,
                 @JsonProperty("name") String name) {
      this.PLAYER_ID = playerId;
      this.name = name;
   }
}
