package com.annuel.project.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class RequestMatch {
    private String id;

    public RequestMatch(@JsonProperty("id") String id) {

        this.id = id;
    }
}
