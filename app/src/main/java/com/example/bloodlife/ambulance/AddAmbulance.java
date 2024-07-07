package com.example.bloodlife.ambulance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bloodlife.MainActivity;
import com.example.bloodlife.MainActivity2;
import com.example.bloodlife.R;
import com.example.bloodlife.patient.AddPatient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddAmbulance extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://bloodlife-41178-default-rtdb.firebaseio.com/");


    TextInputEditText org_name,phone,area,reg_no,seat_num;

    ImageView backbutton;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_ambulance);

        org_name=findViewById(R.id.organization_name);
        phone=findViewById(R.id.phone_number);
        area=findViewById(R.id.Area);
        reg_no=findViewById(R.id.registration_no);
        seat_num=findViewById(R.id.seat_no);
        button=findViewById(R.id.submitbutton);
        backbutton=findViewById(R.id.backbtn);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddAmbulance.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nameText=org_name.getText().toString();
                final String phoneText=phone.getText().toString();
                final String areaText=area.getText().toString();
                final String regText=reg_no.getText().toString();
                final String seatText=seat_num.getText().toString();

                if(nameText.isEmpty()||phoneText.isEmpty()||areaText.isEmpty()||regText.isEmpty()||seatText.isEmpty())
                {
                    Toast.makeText(AddAmbulance.this, "Fill up All the Field..", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("Patient").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {


                            if(snapshot.hasChild(regText)){
                                Toast.makeText(AddAmbulance.this, "This Ambulance Already Exist", Toast.LENGTH_SHORT).show();
                            }

                            else {
                                databaseReference.child("Ambulance").child(regText).child("Name").setValue(nameText);
                                databaseReference.child("Ambulance").child(regText).child("Phone_Number").setValue(phoneText);
                                databaseReference.child("Ambulance").child(regText).child("Area").setValue(areaText);
                                databaseReference.child("Ambulance").child(regText).child("Registration_No").setValue(regText);
                                databaseReference.child("Ambulance").child(regText).child("Seat_no").setValue(seatText);


                                Toast.makeText(AddAmbulance.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(AddAmbulance.this, MainActivity.class);
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