package com.example.bloodlife.donor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodlife.MainActivity2;
import com.example.bloodlife.R;
import com.example.bloodlife.ambulance.AddAmbulance;
import com.example.bloodlife.patient.MyAdarpter_patient;
import com.example.bloodlife.patient.Patient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DonorActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    ImageView backbutton;

    MyAdapter_donor myAdapterDonor;
    ArrayList<Donor> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_donor);

        backbutton=findViewById(R.id.backbtn);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DonorActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerView=findViewById(R.id.donorList);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Donors");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();

        myAdapterDonor =new MyAdapter_donor(this,list);
        recyclerView.setAdapter(myAdapterDonor);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){

                    Donor donor =dataSnapshot.getValue(Donor.class);
                    list.add(donor);

                }

                myAdapterDonor.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}