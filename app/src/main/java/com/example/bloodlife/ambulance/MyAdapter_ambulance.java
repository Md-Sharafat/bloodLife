package com.example.bloodlife.ambulance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodlife.R;
import com.example.bloodlife.ambulance.MyAdapter_ambulance;
import com.example.bloodlife.ambulance.Ambulance;

import java.util.ArrayList;

public class MyAdapter_ambulance extends RecyclerView.Adapter<MyAdapter_ambulance.MyViewHolder> {

    Context context;

    ArrayList<Ambulance>list;



    public MyAdapter_ambulance(Context context,ArrayList<Ambulance> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.items_ambulance,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Ambulance ambulance =list.get(position);
        holder.name.setText(ambulance.getName());
        holder.area.setText(ambulance.getArea());
        holder.number.setText(ambulance.getPhone_Number());

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
