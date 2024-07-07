package com.example.bloodlife.doctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodlife.R;

import java.util.ArrayList;

public class MyAdapter_doctor extends RecyclerView.Adapter<MyAdapter_doctor.MyViewHolder> {

    Context context;

    ArrayList<Doctor>list;


    public MyAdapter_doctor(Context context, ArrayList<Doctor> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.items_doctor,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Doctor doctor =list.get(position);
        holder.name.setText(doctor.getName());
        holder.area.setText(doctor.getArea());
        holder.number.setText(doctor.getPhone_Number());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,number,area;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            number=itemView.findViewById(R.id.number);
            area=itemView.findViewById(R.id.area);

        }
    }
    
}
