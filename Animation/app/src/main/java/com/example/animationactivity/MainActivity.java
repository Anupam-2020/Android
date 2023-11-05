package com.example.animationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtAnm;
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAnm = findViewById(R.id.txtAnm);
        btn1 = findViewById(R.id.btnTranslate);
        btn2 = findViewById(R.id.btnAlpha);
        btn3 = findViewById(R.id.btnRotate);
        btn4 = findViewById(R.id.btnScale);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation move = AnimationUtils.loadAnimation(MainActivity.this,R.anim.move);
                txtAnm.startAnimation(move);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation alpha = AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha);
                txtAnm.startAnimation(alpha);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation rotate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                txtAnm.startAnimation(rotate);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation scale = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
                txtAnm.startAnimation(scale);
            }
        });
    }
}