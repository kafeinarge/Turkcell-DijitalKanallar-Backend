package com.kafein.moviemanager.model.response;

import com.kafein.moviemanager.model.base.BaseResponse;
import com.kafein.moviemanager.model.dto.model.MovieDetail;
import lombok.Data;

@Data
public class MovieDetailResponse extends BaseResponse {

    private MovieDetailType movieDetailType;

    public MovieDetailResponse(MovieDetailType movieDetailType) {
        this.movieDetailType = movieDetailType;
    }

    public MovieDetailResponse(MovieDetail movieDetail) {
        MovieDetailType movieDetailType = new MovieDetailType(movieDetail);
        this.movieDetailType = movieDetailType;
    }

    public MovieDetailResponse() {
    }
}
