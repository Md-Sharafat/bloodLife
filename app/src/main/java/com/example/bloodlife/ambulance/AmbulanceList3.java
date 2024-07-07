package com.example.bloodlife.ambulance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodlife.R;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AmbulanceList3 extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    MyAdapter_ambulance myAdapterAmbulance;
    ArrayList<Ambulance> list;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ambulance_list2);

        button = findViewById(R.id.addAmbulance);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AmbulanceList3.this, AddAmbulance.class);
                startActivity(intent);
                finish();
            }
        });


        recyclerView = findViewById(R.id.ambulanceList);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Ambulance");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();


        myAdapterAmbulance = new MyAdapter_ambulance(this, list);
        recyclerView.setAdapter(myAdapterAmbulance);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    Ambulance ambulance = dataSnapshot.getValue(Ambulance.class);
                    list.add(ambulance);

                }

                myAdapterAmbulance.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }
}