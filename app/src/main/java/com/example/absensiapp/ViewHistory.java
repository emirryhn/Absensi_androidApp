package com.example.absensiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.absensiapp.adapter.AbsensiAdapter;
import com.example.absensiapp.entity.Absensi;
import com.example.absensiapp.service.AbsensiInterface;
import com.example.absensiapp.service.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewHistory extends AppCompatActivity {

    RecyclerView rcvhistory;
    SharedPreferences sp;
    AbsensiAdapter absensiAdapter;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String NAME = "name" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);

        rcvhistory = findViewById(R.id.rcv_history);

        sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String username = sp.getString(NAME, "");


        AbsensiInterface absensiInterface = ApiClient.getRetrofit().create(AbsensiInterface.class);
        Call<ArrayList<Absensi>> call = absensiInterface.getHistory(username);
        call.enqueue(new Callback<ArrayList<Absensi>>() {
            @Override
            public void onResponse(Call<ArrayList<Absensi>> call, Response<ArrayList<Absensi>> response) {
                absensiAdapter = new AbsensiAdapter(response.body(), ViewHistory.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewHistory.this,LinearLayoutManager.VERTICAL,false);
                rcvhistory.setLayoutManager(layoutManager);
                rcvhistory.setAdapter(absensiAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Absensi>> call, Throwable t) {

            }
        });

    }
}