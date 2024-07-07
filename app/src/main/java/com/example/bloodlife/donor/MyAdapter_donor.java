package com.example.bloodlife.donor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodlife.R;
import com.example.bloodlife.donor.MyAdapter_donor;
import com.example.bloodlife.donor.Donor;
import com.example.bloodlife.patient.MyAdarpter_patient;
import com.example.bloodlife.patient.Patient;

import java.util.ArrayList;

public class MyAdapter_donor extends RecyclerView.Adapter<MyAdapter_donor.MyViewHolder> {
    Context context;

    ArrayList<Donor> list;

    public MyAdapter_donor(Context context,ArrayList<Donor>list) {
        this.context=context;
        this.list=list;
    }



    @NonNull
    @Override
    public MyAdapter_donor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.items_donor,parent,false);

        return new MyAdapter_donor.MyViewHolder(v);
    }




    public void onBindViewHolder(@NonNull MyAdapter_donor.MyViewHolder holder, int position) {

        Donor donor =list.get(position);
        holder.name.setText(donor.getName());
        holder.thana.setText(donor.getThana());
        holder.number.setText(donor.getContact());

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

