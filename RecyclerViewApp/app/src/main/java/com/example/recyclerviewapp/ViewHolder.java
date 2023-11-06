package com.example.recyclerviewapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView txtName, textNumber;
    ImageView imgContact;

    LinearLayout llProfile;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        llProfile = itemView.findViewById(R.id.llRow);
        txtName = itemView.findViewById(R.id.contactName);
        textNumber = itemView.findViewById(R.id.contactNumber);
        imgContact = itemView.findViewById(R.id.contactImg);
    }
}
