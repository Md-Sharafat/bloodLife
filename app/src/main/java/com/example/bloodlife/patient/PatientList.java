package com.example.bloodlife.patient;

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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PatientList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    ImageView backbutton;

    MyAdarpter_patient myAdarpterUser;
    ArrayList<Patient> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_patient_list);

        backbutton=findViewById(R.id.backbtn);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PatientList.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerView=findViewById(R.id.patientList);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Patient");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();

        myAdarpterUser =new MyAdarpter_patient(this,list);
        recyclerView.setAdapter(myAdarpterUser);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){

                    Patient patient =dataSnapshot.getValue(Patient.class);
                    list.add(patient);

                }

                myAdarpterUser.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}