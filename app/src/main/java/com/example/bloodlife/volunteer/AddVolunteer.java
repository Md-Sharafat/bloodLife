package com.example.bloodlife.volunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bloodlife.MainActivity3;
import com.example.bloodlife.R;
import com.example.bloodlife.doctor.AddDoctor;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddVolunteer extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://bloodlife-41178-default-rtdb.firebaseio.com/");

    TextInputEditText name,phone,adress,nid,profession;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_volunteer);

        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone_number);
        adress=findViewById(R.id.adress);
        profession=findViewById(R.id.profession);
        nid=findViewById(R.id.nid_no);

        button=findViewById(R.id.submitbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nameText=name.getText().toString();
                final String phoneText=phone.getText().toString();
                final String adressText=adress.getText().toString();
                final String professionText=profession.getText().toString();
                final String nidText=nid.getText().toString();

                if(nameText.isEmpty()||phoneText.isEmpty()||adressText.isEmpty()||professionText.isEmpty()||nidText.isEmpty())
                {
                    Toast.makeText(AddVolunteer.this, "Fill up All the Field..", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("Patient").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {


                            if(snapshot.hasChild(nidText)){
                                Toast.makeText(AddVolunteer.this, "This Ambulance Already Exist", Toast.LENGTH_SHORT).show();
                            }

                            else {
                                databaseReference.child("Volunteer").child(nidText).child("Name").setValue(nameText);
                                databaseReference.child("Volunteer").child(nidText).child("Phone_Number").setValue(phoneText);
                                databaseReference.child("Volunteer").child(nidText).child("Adress").setValue(adressText);
                                databaseReference.child("Volunteer").child(nidText).child("NID_No").setValue(nidText);
                                databaseReference.child("Volunteer").child(nidText).child("Profession").setValue(professionText);


                                Toast.makeText(AddVolunteer.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(AddVolunteer.this, MainActivity3.class);
                                startActivity(intent);
                                finish();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }
        });


    }
}