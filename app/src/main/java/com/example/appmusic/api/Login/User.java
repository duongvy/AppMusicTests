package com.example.appmusic.api.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface User {

    @POST("/api/auth/login")
    Call<UserResponse> userLogin(@Body UserRequest userRequest);

    @GET("/api/auth/getMe")
    Call<UserResponse>  userDetail();
}
