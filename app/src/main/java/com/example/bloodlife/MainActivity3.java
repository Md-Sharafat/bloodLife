package com.example.bloodlife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.example.bloodlife.ambulance.AmbulanceList3;
import com.example.bloodlife.doctor.DoctorList;
import com.example.bloodlife.donor.DonorActivity;
import com.example.bloodlife.patient.AddPatient;
import com.example.bloodlife.patient.PatientList;

public class MainActivity3 extends AppCompatActivity {

    String[] itemGroup={"A+","B+","O+","AB+","A-","B-","O-","AB-"};

    TextView login;

    ImageView menu,addpatient,patientlist,donorlist,ambulancelist,doctorlist,
            bloodbankinfo,plasmabankinfo,helpline,volunteerlist,totaluser,totaldonor,contactinfo;


    AutoCompleteTextView groupText;

    ArrayAdapter<String> groupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        menu=findViewById(R.id.option);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity3.this, "To access sign in first", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity3.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        addpatient=findViewById(R.id.addPatient);
        addpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity3.this, AddPatient.class);
                startActivity(intent);
                finish();

            }
        });

        patientlist=findViewById(R.id.patientList);
        patientlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this, PatientList.class);
                startActivity(intent);
                finish();

            }
        });

        donorlist=findViewById(R.id.donorList);
        donorlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this, DonorActivity.class);
                startActivity(intent);
                finish();

            }
        });

        ambulancelist=findViewById(R.id.ambulanceList);
        ambulancelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this, AmbulanceList3.class);
                startActivity(intent);
                finish();

            }
        });

        doctorlist=findViewById(R.id.doctorList);
        doctorlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this, DoctorList.class);
                startActivity(intent);
                finish();

            }
        });

        bloodbankinfo=findViewById(R.id.bloodBankInfo);
        bloodbankinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "To access sign in first", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity3.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        plasmabankinfo=findViewById(R.id.plasmaBankInfo);
        plasmabankinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "To access sign in first", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity3.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        helpline=findViewById(R.id.helpLine);
        helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "To access sign in first", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity3.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        volunteerlist=findViewById(R.id.volunteerList);
        volunteerlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "To access sign in first", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity3.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        totaluser=findViewById(R.id.totalUser);
        totaluser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "To access sign in first", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity3.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        totaldonor=findViewById(R.id.totalDonor);
        totaldonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "To access sign in first", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity3.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        contactinfo=findViewById(R.id.contactInfo);
        contactinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "To access sign in first", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity3.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });


        login=findViewById(R.id.signin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        groupText=findViewById(R.id.blood_group);

        groupAdapter=new ArrayAdapter<String>(this,R.layout.list_item,itemGroup);

        groupText.setAdapter(groupAdapter);

        groupText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity3.this, "Group"+item, Toast.LENGTH_SHORT).show();
            }
        });

    }
}