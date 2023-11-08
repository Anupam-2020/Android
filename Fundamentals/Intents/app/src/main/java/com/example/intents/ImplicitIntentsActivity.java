package com.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ImplicitIntentsActivity extends AppCompatActivity {

    Button btnDial, btnMsg, btnEmail, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intents);

        btnDial = findViewById(R.id.btnDial);
        btnEmail = findViewById(R.id.btnEmail);
        btnMsg = findViewById(R.id.btnMsg);
        btnShare = findViewById(R.id.btnShare);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDial = new Intent(Intent.ACTION_DIAL);
                intentDial.setData(Uri.parse("tel: +918075319530"));
                startActivity(intentDial);
            }
        });

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMsg = new Intent(Intent.ACTION_SENDTO);
                intentMsg.setData(Uri.parse("smsto: "+Uri.encode("+918075319530")));
                intentMsg.putExtra("sms_body", "This message from Anupam");
                startActivity(intentMsg);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEmail = new Intent(Intent.ACTION_SEND);
                intentEmail.setType("message/rfc822");
                intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"abc@gmail.com", "anupam2029@gmail.com"});
                intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Queries");
                intentEmail.putExtra(Intent.EXTRA_TEXT, "Please send it immediately");
                startActivity(Intent.createChooser(intentEmail, "Email via"));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.setType("text/plain");
                intentShare.putExtra(Intent.EXTRA_TEXT, "Download this amazing app");
                startActivity(Intent.createChooser(intentShare, "Share via"));
            }
        });
    }
}