package com.example.absensiapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.absensiapp.entity.Absensi;
import com.example.absensiapp.service.AbsensiInterface;
import com.example.absensiapp.service.ApiClient;
import com.google.gson.Gson;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import in.mayanknagwanshi.imagepicker.ImageSelectActivity;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class checkIn extends AppCompatActivity {

    TextView textDate, textTime;
    Button btnCamera, btnPost;
    ImageView imageCam;
    private int requestCode = 1;
    String mediaPath;
    SharedPreferences sp;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String NAME = "name" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        textDate = findViewById(R.id.text_date);
        textTime = findViewById(R.id.text_time);
        btnCamera = findViewById(R.id.btn_camera);
        btnPost = findViewById(R.id.btn_postchecin);
        imageCam = findViewById(R.id.image_user);

        sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateToday = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat timeToday = new SimpleDateFormat("hh:mm");
        String date = dateToday.format(calendar.getTime());
        String time = timeToday.format(calendar.getTime());

        textDate.setText("Today is "+date);
        textTime.setText(time);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gambar = new Intent(getApplicationContext(), ImageSelectActivity.class);
                gambar.putExtra(ImageSelectActivity.FLAG_COMPRESS, true);
                gambar.putExtra(ImageSelectActivity.FLAG_CAMERA, true);
                gambar.putExtra(ImageSelectActivity.FLAG_GALLERY, true);
                startActivityForResult(gambar, 1);
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadProgress();
                finish();
            }
        });
    }

    private void uploadProgress() {

        Absensi absensi = new Absensi();

        String username = sp.getString(NAME, "");

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateToday = new SimpleDateFormat("dd-MM-yyyy");
        String date = dateToday.format(calendar.getTime());
        absensi.setCheckIn("8");
        absensi.setDate(date);
        absensi.setUsername(username);

        Gson gson = new Gson();
        String json = gson.toJson(absensi);

        AbsensiInterface absensiInterface = ApiClient.getRetrofit().create(AbsensiInterface.class);

        File file = new File(mediaPath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        RequestBody data = RequestBody.create(MediaType.parse("text/plain"), json);
        Call<Absensi> call = absensiInterface.addAbsensi(fileToUpload, data);
        call.enqueue(new Callback<Absensi>() {
            @Override
            public void onResponse(Call<Absensi> call, Response<Absensi> response) {
                System.out.println(response.body());
                finish();
            }

            @Override
            public void onFailure(Call<Absensi> call, Throwable t) {
                System.out.println(t);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.requestCode == requestCode && resultCode == RESULT_OK) {

            mediaPath = data.getStringExtra(ImageSelectActivity.RESULT_FILE_PATH);

            imageCam.setImageBitmap(BitmapFactory.decodeFile(mediaPath));
        }
    }


}