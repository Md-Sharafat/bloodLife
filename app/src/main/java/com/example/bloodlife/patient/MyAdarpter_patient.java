package com.example.bloodlife.patient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodlife.R;

import java.util.ArrayList;

public class MyAdarpter_patient extends RecyclerView.Adapter <MyAdarpter_patient.MyViewHolder>{

    Context context;

    ArrayList<Patient> list;

    public MyAdarpter_patient(Context context, ArrayList<Patient> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.items_patient,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Patient patient =list.get(position);
        holder.name.setText(patient.getName());
        holder.thana.setText(patient.getThana());
        holder.number.setText(patient.getContact());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,number,thana;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            number=itemView.findViewById(R.id.number);
            thana=itemView.findViewById(R.id.thana);
        }
    }
}
