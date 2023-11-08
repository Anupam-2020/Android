package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    Button btn;
    Intent intent;
    SharedPreferences sf;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        btn = findViewById(R.id.logout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sf = getSharedPreferences("sf_login", MODE_PRIVATE);
                editor = sf.edit();
                editor.putBoolean("flag", false);
                editor.apply();

                intent = new Intent(HomeScreen.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}