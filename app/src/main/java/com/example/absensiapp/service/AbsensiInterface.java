package com.example.absensiapp.service;

import com.example.absensiapp.entity.Absensi;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface AbsensiInterface {

    @Multipart
    @POST("/absensi/add")
    Call<Absensi> addAbsensi(@Part MultipartBody.Part file, @Part("data")RequestBody data);

    @GET("/absensi/history/{username}")
    Call<ArrayList<Absensi>> getHistory(@Path("username") String username);

}
