package com.example.bloodlife.volunteer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodlife.R;
import com.example.bloodlife.doctor.Doctor;
import com.example.bloodlife.doctor.MyAdapter_doctor;
import com.example.bloodlife.volunteer.Volunteer;
import com.example.bloodlife.volunteer.MyAdapter_volunteer;

import java.util.ArrayList;

public class MyAdapter_volunteer extends RecyclerView.Adapter<MyAdapter_volunteer.MyViewHolder>{

    Context context;

    ArrayList<Volunteer> list;



    public MyAdapter_volunteer(Context context,ArrayList<Volunteer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.items_doctor,parent,false);

        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull MyAdapter_volunteer.MyViewHolder holder, int position) {

        Volunteer volunteer =list.get(position);
        holder.name.setText(volunteer.getName());
        holder.area.setText(volunteer.getAdress());
        holder.number.setText(volunteer.getPhone_Number());

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
