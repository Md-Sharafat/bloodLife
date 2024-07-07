package com.example.bloodlife;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://bloodlife-41178-default-rtdb.firebaseio.com/");

    TextInputEditText editTextphoneNumber,editTextpassword;
    Button loginButton;

    TextView regNow;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        editTextphoneNumber=findViewById(R.id.phone);
        editTextpassword=findViewById(R.id.password);
        loginButton=findViewById(R.id.btn_lonin);
        regNow=findViewById(R.id.register_now);


        regNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String phoneText=editTextphoneNumber.getText().toString();
               final String passwordText=editTextpassword.getText().toString();

                if(phoneText.isEmpty()||passwordText.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Fill up all the fields", Toast.LENGTH_SHORT).show();
                }

                else {

                    databaseReference.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {


                            if(snapshot.hasChild(phoneText))
                            {
                                final String getPassword=snapshot.child(phoneText).child("Password").getValue(String.class);
                                final String getPhoneNumber=snapshot.child(phoneText).child("Contact").getValue(String.class);
                                final String number="01995799846";

                                if(getPassword.equals(passwordText) && getPhoneNumber.equals(number))
                                {
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(LoginActivity.this,MainActivity3.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else if(getPassword.equals(passwordText) )
                                {
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(LoginActivity.this,MainActivity2.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    Toast.makeText(LoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(LoginActivity.this, "Patient Never Registered", Toast.LENGTH_SHORT).show();
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