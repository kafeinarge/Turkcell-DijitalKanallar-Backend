package com.kafein.moviemanager.model.response;

import com.kafein.moviemanager.model.base.BaseResponse;
import lombok.Data;

@Data
public class AccountDetailResponse extends BaseResponse {
    private String userName;
    private String name;
    private int accountId;
}
