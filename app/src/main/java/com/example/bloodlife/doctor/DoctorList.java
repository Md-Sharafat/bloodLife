package com.example.bloodlife.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodlife.MainActivity2;
import com.example.bloodlife.R;
import com.example.bloodlife.doctor.Doctor;
import com.example.bloodlife.doctor.MyAdapter_doctor;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DoctorList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    MyAdapter_doctor myAdapterDoctor;
    ArrayList<Doctor> list;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_list);

        recyclerView = findViewById(R.id.doctorList);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Doctor");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapterDoctor = new MyAdapter_doctor(this, list);
        recyclerView.setAdapter(myAdapterDoctor);

        btn=findViewById(R.id.add_Doctor);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DoctorList.this,AddDoctor.class);
                startActivity(intent);
                finish();
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    Doctor doctor = dataSnapshot.getValue(Doctor.class);
                    list.add(doctor);

                }

                myAdapterDoctor.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }
}