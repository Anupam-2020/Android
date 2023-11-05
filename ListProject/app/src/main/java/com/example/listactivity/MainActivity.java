package com.example.listactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Spinner spinner;
    AutoCompleteTextView autoCompleteView;
    ArrayList<String> arrName = new ArrayList<>(); // for listview
    ArrayList<String> arrIds = new ArrayList<>(); // for spinner
    ArrayList<String> arrLanguages = new ArrayList<>(); // for auto-complete

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

//        // ListView
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

//
//
//        // Spinner
//        arrIds.add("Aadhar Card");
//        arrIds.add("PAN Card");
//        arrIds.add("Voter ID Card");
//        arrIds.add("Driving License Card");
//        arrIds.add("Ration Card");
//        arrIds.add("Xth Score Card");
//        arrIds.add("XII Score Card");
//
//        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_spinner_dropdown_item,
//                arrIds
//        );
//        spinner.setAdapter(adapterSpinner);
    }
}