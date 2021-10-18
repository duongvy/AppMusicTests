package com.example.appmusic.api;

import androidx.annotation.NonNull;

import com.example.appmusic.api.Login.User;
import com.example.appmusic.api.Register.Register;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYxNjdkZmQxNGUzNGI0NTgyYmVhMGQwOCIsInVzZXJuYW1lIjoibmd1eWVudnUzIiwiaWF0IjoxNjM0MzUxMDg3fQ.uRHldZuxPw9P7MYGeFAD0coxpX__mXudOxxr5J1kBoc";
                        Request request = chain.request().newBuilder().addHeader("authorization", token).build();
                        return chain.proceed(request);
                    }
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-musics.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static Register getRegister(){
        Register register = getRetrofit().create(Register.class);

        return register;
    }

    public static User getUser(){
        User user = getRetrofit().create(User.class);

        return user;
    }

}
