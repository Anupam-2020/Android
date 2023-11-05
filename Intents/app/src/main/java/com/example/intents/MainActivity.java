package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edt1, edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        btn = findViewById(R.id.intent);
        edt1 = findViewById(R.id.name);
        edt2 = findViewById(R.id.qualification);

        btn.setText("To to Second Screen");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edt1.getText().toString();
                String qualification = edt2.getText().toString();
                Log.d("Intents", title);
                intent.putExtra("title", title);
                intent.putExtra("qualification", qualification);
                intent.putExtra("Reg No.", 100221);
                startActivity(intent);
            }
        });
        Log.d("intent", "created");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("intent", "restarted");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("intent", "paused");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("intent", "started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("intent", "stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("intent", "destroyed");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("intent", "resume");
    }
}