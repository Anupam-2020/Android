package com.example.listactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class AutoCompleteActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteView;
    ArrayList<String> list;
    Intent intent;
    public ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complate);

        intent = getIntent();
        autoCompleteView = findViewById(R.id.autoCompleteView);
        list = intent.getStringArrayListExtra("nameList");

        ArrayAdapter<String> adapterAutoComplete = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, list);
        autoCompleteView.setAdapter(adapterAutoComplete);
        autoCompleteView.setThreshold(3); // After `3` key-input suggestions will pop up.
    }
}