package com.annuel.project.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class RequestClient {

    private String category ;
    private Long id ;

    public RequestClient ( @JsonProperty("category") String category,
                           @JsonProperty("id") Long id) {

        this.category = category;
        this.id = id;
    }

}
