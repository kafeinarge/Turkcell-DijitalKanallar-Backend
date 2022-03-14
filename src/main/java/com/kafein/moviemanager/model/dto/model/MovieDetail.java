package com.kafein.moviemanager.model.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieDetail extends Movie{

    private String overview;
    private long popularity;
    @JsonProperty("vote_average")
    private String voteAverage;
    @JsonProperty("vote_count")
    private String voteCount;

}
