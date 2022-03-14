package com.kafein.moviemanager.model.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Movie {

    @JsonProperty("poster_path")
    private String posterPath;
    private int id;
    @JsonProperty("release_date")
    private String releaseDate;
    private String title;

}
