package com.example.appmusic.api.Account;

import com.example.appmusic.api.Login.UserRequest;
import com.example.appmusic.api.Login.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Account {

    @GET("/api/auth/getMe")
    Call<UserResponse>  userDetail();
}
