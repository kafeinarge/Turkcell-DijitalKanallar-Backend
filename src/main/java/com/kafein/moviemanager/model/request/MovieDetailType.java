package com.kafein.moviemanager.model.request;

import lombok.Data;

@Data
public class MovieDetailType {

    private String releaseDate;
    private long voteAverage;
    private int voteCount;

}
