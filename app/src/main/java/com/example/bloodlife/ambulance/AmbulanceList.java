package com.example.bloodlife.ambulance;

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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AmbulanceList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    ImageView backbutton;

    MyAdapter_ambulance myAdapterAmbulance;
    ArrayList<Ambulance> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ambulance_list);




        recyclerView = findViewById(R.id.ambulanceList);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Ambulance");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        backbutton=findViewById(R.id.backbtn);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AmbulanceList.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });


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