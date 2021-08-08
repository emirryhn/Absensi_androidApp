package com.example.absensiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView textWelcome;
    SharedPreferences sp;
    Button btnLogout, btnCheckIn, btnHistory, btnCheckOut;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String NAME = "name" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textWelcome = findViewById(R.id.text_welcome);
        btnLogout = findViewById(R.id.btn_logout);
        btnCheckIn = findViewById(R.id.btn_checkin);
        btnCheckOut = findViewById(R.id.btn_checkout);
        btnHistory = findViewById(R.id.btn_history);

        sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String username = sp.getString(NAME, "");

//        Intent i = getIntent();
//        String username = i.getExtras().getString("name");

        textWelcome.setText("Welcome " + username);

        btnCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), checkIn.class);
            startActivity(i);
            }
        });

        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.commit();
                finish();
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewHistory.class);
                startActivity(i);
            }
        });

    }
}