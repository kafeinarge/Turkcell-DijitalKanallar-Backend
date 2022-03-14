package com.kafein.moviemanager.model.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kafein.moviemanager.model.request.AccountAddRemoveMovieFavoriteListRequest;
import lombok.Data;

@Data
public class AddRemoveMovieFavoriteList {

    @JsonProperty("media_type")
    private String mediaType = "movie";
    @JsonProperty("media_id")
    private Integer mediaId;
    private boolean favorite;

    public AddRemoveMovieFavoriteList(AccountAddRemoveMovieFavoriteListRequest request) {
        this.mediaId = request.getMediaId();
        this.favorite = request.isFavorite();
    }

    public AddRemoveMovieFavoriteList() {
    }

}
