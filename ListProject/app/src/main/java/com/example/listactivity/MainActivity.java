package com.example.listactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrName = new ArrayList<>(); // list of names

    Button autoCompleteActivityBtn, spinnerActivityBtn, listActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteActivityBtn = findViewById(R.id.autoCompleteActivityBtn);
        spinnerActivityBtn = findViewById(R.id.spinnerActivityBtn);
        listActivityBtn = findViewById(R.id.listActivityBtn);

        autoCompleteActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AutoCompleteActivity.class);
                intent.putExtra("nameList", arrName);
                startActivity(intent);
            }
        });

        spinnerActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                intent.putExtra("nameList", arrName);
                startActivity(intent);
            }
        });

        listActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("nameList", arrName);
                startActivity(intent);
            }
        });

        arrName.add("Anupam");
        arrName.add("Anurag");
        arrName.add("Rahul");
        arrName.add("Ram");
        arrName.add("Sidd");
        arrName.add("Virat");
        arrName.add("Rohit");
        arrName.add("Siraj");
        arrName.add("Bumrah");
        arrName.add("DeCock");
        arrName.add("Rabada");
        arrName.add("Ponting");
        arrName.add("Steve Smith");
        arrName.add("Maxwell");
        arrName.add("Gayle");
        arrName.add("Tendulkar");
        arrName.add("Dhoni");
        arrName.add("Gautam");
        arrName.add("Leander");
        arrName.add("Ussain Bolt");
    }
}