package com.kafein.moviemanager.model.request;

import com.kafein.moviemanager.model.base.BaseRequest;
import lombok.Data;

@Data
public class AccountAddRemoveMovieWatchListRequest implements BaseRequest {
    private Integer mediaId;
    private boolean watchList;
}
