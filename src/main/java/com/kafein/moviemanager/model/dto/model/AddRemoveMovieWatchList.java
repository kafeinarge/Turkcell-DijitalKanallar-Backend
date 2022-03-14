package com.kafein.moviemanager.model.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kafein.moviemanager.model.request.AccountAddRemoveMovieWatchListRequest;
import lombok.Data;

@Data
public class AddRemoveMovieWatchList {

    @JsonProperty("media_type")
    private String mediaType = "movie";
    @JsonProperty("media_id")
    private Integer mediaId;
    private boolean watchlist;

    public AddRemoveMovieWatchList(AccountAddRemoveMovieWatchListRequest request) {
        this.mediaId = request.getMediaId();
        this.watchlist = request.isWatchList();
    }

    public AddRemoveMovieWatchList() {
    }
}
