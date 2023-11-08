package com.example.recyclerviewapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    ArrayList<ContactModel> arrContact;
    int lastPosition = -1;

    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContact) {
        this.context = context;
        this.arrContact = arrContact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgContact.setImageResource(arrContact.get(position).img);
        holder.txtName.setText(arrContact.get(position).name);
        holder.textNumber.setText(arrContact.get(position).number);


        int pos = holder.getAdapterPosition();

        if(lastPosition < pos) {
            setAnimation(holder.itemView, pos);
            lastPosition = pos;
        }

        holder.llProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_layout);

                Button updateBtn = dialog.findViewById(R.id.addUpdateBtn);
                EditText edtName = dialog.findViewById(R.id.nameEditTxt);
                EditText edtNumber = dialog.findViewById(R.id.contactEditTxt);
                TextView dialogHeading = dialog.findViewById(R.id.dialogHeading);

                updateBtn.setText(R.string.textView);
                dialogHeading.setText("Update Contacts".toUpperCase());

                edtName.setText(holder.txtName.getText());
                edtNumber.setText(holder.textNumber.getText());

                updateBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = edtName.getText().toString();
                        String number = edtNumber.getText().toString();
                        if(!name.isEmpty() && !number.isEmpty()) {

                            arrContact.set(pos, new ContactModel(R.drawable.man, name, number));
                            notifyItemChanged(pos);

                        } else {
                            Toast.makeText(context, "Fields can't be kept empty", Toast.LENGTH_LONG).show();
                        }
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        holder.llProfile.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("Delete Contact")
                        .setMessage("Are you sure want to delete it")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrContact.remove(pos);
                                notifyItemRemoved(pos);
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                alert.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    private void setAnimation(@NonNull View viewToAnimate, int position) {
//        Log.d("anim", String.valueOf(lastPosition));
            Animation animate = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.setAnimation(animate);
    }
}

