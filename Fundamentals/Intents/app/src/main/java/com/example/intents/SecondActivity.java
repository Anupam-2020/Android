package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent fromActivity;

        fromActivity = getIntent();
        String title = fromActivity.getStringExtra("title");
        Integer regNo = fromActivity.getIntExtra("Reg No.", 0); // except string all other types of data-type requires a default value.
        String qualification = fromActivity.getStringExtra("qualification");

        txt = findViewById(R.id.text);
        btn = findViewById(R.id.home);

        txt.setText("name: " +title + " Reg No. "+regNo+" qualification: "+qualification);

        Intent moveToMain = new Intent(SecondActivity.this, MainActivity.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(moveToMain);
            }
        });
    }
}