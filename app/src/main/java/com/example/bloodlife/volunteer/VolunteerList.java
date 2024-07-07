package com.example.bloodlife.volunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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

import com.example.bloodlife.ambulance.AddAmbulance;
import com.example.bloodlife.volunteer.Volunteer;
import com.example.bloodlife.volunteer.MyAdapter_volunteer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VolunteerList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    ImageView backbutton;

    MyAdapter_volunteer myAdapterVolunteer;
    ArrayList<Volunteer> list;

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_volunteer_list);

        backbutton=findViewById(R.id.backbtn);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VolunteerList.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerView = findViewById(R.id.volunteerList);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Volunteer");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapterVolunteer = new MyAdapter_volunteer(this, list);
        recyclerView.setAdapter(myAdapterVolunteer);


        button=findViewById(R.id.add_Volunteer);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VolunteerList.this,AddVolunteer.class);
                startActivity(intent);
                finish();
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    Volunteer volunteer = dataSnapshot.getValue(Volunteer.class);
                    list.add(volunteer);

                }

                myAdapterVolunteer.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }
}