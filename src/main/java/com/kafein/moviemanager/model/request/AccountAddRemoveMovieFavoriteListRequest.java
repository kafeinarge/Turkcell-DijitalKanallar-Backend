package com.kafein.moviemanager.model.request;

import com.kafein.moviemanager.model.base.BaseRequest;
import lombok.Data;

@Data
public class AccountAddRemoveMovieFavoriteListRequest implements BaseRequest {
    private Integer mediaId;
    private boolean favorite;
}
