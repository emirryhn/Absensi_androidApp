package com.example.absensiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.absensiapp.entity.UserTbl;
import com.example.absensiapp.service.ApiClient;
import com.example.absensiapp.service.UserInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText editUsername, editPassword;
    Button btnLogin;
    UserInterface userInterface;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String NAME = "name" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername = findViewById(R.id.edit_username);
        editPassword = findViewById(R.id.edit_password);
        btnLogin = findViewById(R.id.btn_login);
        userInterface = ApiClient.getRetrofit().create(UserInterface.class);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();

                //validate form
                validateLogin(username, password);

                Call<UserTbl> call = userInterface.getNamePass(username, password);
                call.enqueue(new Callback<UserTbl>() {
                    @Override
                    public void onResponse(Call<UserTbl> call, Response<UserTbl> response) {
                        response.body();

                        //session shared preference
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(NAME, username);
                        editor.apply();

                        Intent intent = new Intent( getApplicationContext(), Welcome.class );
//                        intent.putExtra("name", username);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<UserTbl> call, Throwable t) {
                        System.out.println(t);
                    }
                });

            }
        });

    }

    private boolean validateLogin(String username, String password) {

        if(username == null){
            Toast.makeText(this, "username required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null){
            Toast.makeText(this, "password required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }

}