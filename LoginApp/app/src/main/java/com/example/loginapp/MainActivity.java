package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = getSharedPreferences("sf_login", MODE_PRIVATE);
                boolean isLoggedIn = pref.getBoolean("flag", false);
                intent = new Intent(MainActivity.this, isLoggedIn ? HomeScreen.class : LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}