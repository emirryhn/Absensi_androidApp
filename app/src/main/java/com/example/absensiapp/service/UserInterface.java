package com.example.absensiapp.service;

import com.example.absensiapp.entity.UserTbl;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserInterface {

    @GET("/user/login/{username}&{password}")
    Call<UserTbl> getNamePass (@Path("username") String username, @Path("password") String password);
}
