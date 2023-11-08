package com.example.bmi_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt;
        EditText edt_height_ft, edt_height_in, edt_weight;
        Button btnSubmit;

        edt_weight = findViewById(R.id.edit_weight);
        edt_height_ft  = findViewById(R.id.edit_height_ft);
        edt_height_in = findViewById(R.id.edit_height_in);
        btnSubmit = findViewById(R.id.btn_click);
        txt = findViewById(R.id.txtResult);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weight = Double.parseDouble(edt_weight.getText().toString());
                double height_inch = Double.parseDouble(edt_height_in.getText().toString());
                double height_ft = Double.parseDouble(edt_height_ft.getText().toString());

                double height_in_feet = (height_inch / 12) + height_ft;
                double height_in_meter = height_in_feet * 0.304;
                double calculatedBMI = weight / (height_in_meter * height_in_meter);
                int BMI = (int) (Math.round(calculatedBMI));
//                Log.i("BMI", Double.toString(calculatedBMI));
                txt.setText(String.valueOf(BMI));
;            }
        });
    }
}