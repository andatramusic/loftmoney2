package com.andatra.loftmoney;
import com.andatra.loftmoney.Status;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AuthApi {

    @GET("./auth")
    Single<Status> makeLogin(@Query("social_user_id") String socialUserId);
}