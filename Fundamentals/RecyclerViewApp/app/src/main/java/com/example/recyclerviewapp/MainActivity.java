package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    ArrayList<ContactModel> arrContact = new ArrayList<>();
    FloatingActionButton floatingBtn;
    RecyclerContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingBtn = findViewById(R.id.btnOpenDialogue);

        floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_layout);

                EditText edtName = dialog.findViewById(R.id.nameEditTxt);
                EditText edtContact = dialog.findViewById(R.id.contactEditTxt);
                Button btnAction = dialog.findViewById(R.id.addUpdateBtn);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = edtName.getText().toString();
                        String number = edtContact.getText().toString();
                        if(!name.isEmpty() && !number.isEmpty()) {
                            arrContact.add(new ContactModel(R.drawable.avatar, name, number));
                            adapter.notifyItemInserted(arrContact.size()-1);
                            recycler.scrollToPosition(arrContact.size()-1); // this will scroll to the position where new entry has been made...
                            dialog.dismiss();
                        } else {
                            Toast.makeText(MainActivity.this, "Fields can't be kept empty", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                dialog.show();
            }
        });

        recycler = findViewById(R.id.recyclerContact); // step 1 -> Set recycler view in main_activity xml file and attach the id in this file...
        // step 5 -> create xml file for individual list item which will be used in View-holder class...

        recycler.setLayoutManager(new LinearLayoutManager(this)); // step 2 -> Set layout manager.

        // step 4 -> Create data-array to be displayed.
        arrContact.add(new ContactModel(R.drawable.avatar, "A", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.boy, "D", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.man, "E", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.woman, "V", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.avatar, "B", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.avatar, "W", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.woman, "N", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.man, "T", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.boy, "U", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.man, "I", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.boy, "P", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.woman, "Q", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.avatar, "Z", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.avatar, "X", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.avatar, "B", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.avatar, "Y", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.avatar, "R", "56788746323"));
        arrContact.add(new ContactModel(R.drawable.avatar, "C", "56788746323"));

        adapter = new RecyclerContactAdapter(this, arrContact); // step 6 -> create recycler-adapter and view-holder class...
        recycler.setAdapter(adapter); // step 7 -> set the adapter...
    }
}