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

import com.example.bloodlife.ambulance.AmbulanceList;
import com.example.bloodlife.bloodbank.BloodStorage;
import com.example.bloodlife.doctor.DoctorList2;
import com.example.bloodlife.donor.DonorActivity;
import com.example.bloodlife.patient.AddPatient;
import com.example.bloodlife.patient.PatientList;
import com.example.bloodlife.plasmastore.PlasmaBank;
import com.example.bloodlife.volunteer.Volunteer;
import com.example.bloodlife.volunteer.VolunteerList;

public class MainActivity2 extends AppCompatActivity {

    String[] itemGroup={"A+","B+","O+","AB+","A-","B-","O-","AB-"};

    TextView logout;

    ImageView menu,addpatient,patientlist,donorPage,ambulancelist,doctorlist,
            bloodbankinfo,plasmabankinfo,helpline,volunteerlist,totaluser,totaldonor,contactinfo;


    AutoCompleteTextView groupText;


    ArrayAdapter<String> groupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        menu=findViewById(R.id.option);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity2.this, "Not implemented yet", Toast.LENGTH_SHORT).show();

            }
        });

        addpatient=findViewById(R.id.addPatient);
        addpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity2.this, AddPatient.class);
                startActivity(intent);
                finish();

            }
        });

        patientlist=findViewById(R.id.patientList);
        patientlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this, PatientList.class);
                startActivity(intent);
                finish();

            }
        });

        donorPage=findViewById(R.id.donorP);
        donorPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this, DonorActivity.class);
                startActivity(intent);
                finish();

            }
        });

        ambulancelist=findViewById(R.id.ambulanceList);
        ambulancelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this, AmbulanceList.class);
                startActivity(intent);
                finish();


            }
        });

        doctorlist=findViewById(R.id.doctorList);
        doctorlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this, DoctorList2.class);
                startActivity(intent);
                finish();

            }
        });

        bloodbankinfo=findViewById(R.id.bloodBankInfo);
        bloodbankinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this, BloodStorage.class);
                startActivity(intent);
                finish();

            }
        });

        plasmabankinfo=findViewById(R.id.plasmaBankInfo);
        plasmabankinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this, PlasmaBank.class);
                startActivity(intent);
                finish();
            }
        });

        helpline=findViewById(R.id.helpLine);
        helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this, NationalHelpLine.class);
                startActivity(intent);
                finish();

            }
        });

        volunteerlist=findViewById(R.id.volunteerList);
        volunteerlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this, VolunteerList.class);
                startActivity(intent);
                finish();

            }
        });

        totaluser=findViewById(R.id.totalUser);
        totaluser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Not implemented yet", Toast.LENGTH_SHORT).show();


            }
        });

        totaldonor=findViewById(R.id.totalDonor);


        contactinfo=findViewById(R.id.contactInfo);
        contactinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this, ContactUs.class);
                startActivity(intent);
                finish();

            }
        });

        logout=findViewById(R.id.sign_out);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        groupText=findViewById(R.id.blood_group);

        groupAdapter=new ArrayAdapter<String>(this,R.layout.list_item,itemGroup);

        groupText.setAdapter(groupAdapter);

        groupText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity2.this, "Group"+item, Toast.LENGTH_SHORT).show();
            }
        });

    }
}