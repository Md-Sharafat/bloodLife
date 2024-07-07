package com.example.bloodlife.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bloodlife.MainActivity2;
import com.example.bloodlife.MainActivity3;
import com.example.bloodlife.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddPatient extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://bloodlife-41178-default-rtdb.firebaseio.com/");

    String[] itemGroup={"A+","B+","O+","AB+","A-","B-","O-","AB-"};

//    private String selectDis, selectSubdist,selctGroup,selectType;

    AutoCompleteTextView distText,thanaText,groupText;

    TextInputEditText name,number,age;

    ImageView backbtn;

    Button submitBtn;

    ArrayAdapter<String> disAdapter,subDisAdapter,groupAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_patient);


        distText= findViewById(R.id.dropDownDist);
        thanaText=findViewById(R.id.dropDownThana);
        groupText=findViewById(R.id.bloodGroup);
        submitBtn=findViewById(R.id.submitbtn);

        name=findViewById(R.id.people_name);
        number=findViewById(R.id.phone_number);
        age=findViewById(R.id.people_age);

        backbtn=findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddPatient.this, MainActivity3.class);
                startActivity(intent);
                finish();
            }
        });

        groupAdapter=new ArrayAdapter<String>(this,R.layout.list_item,itemGroup);

        groupText.setAdapter(groupAdapter);

        groupText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(AddPatient.this, "Group"+item, Toast.LENGTH_SHORT).show();
            }
        });


        String [] district=getResources().getStringArray(R.array.array_bd_distric) ;

        String[] barguna =getResources().getStringArray(R.array.Barguna) ;
        String[] barishal =getResources().getStringArray(R.array.Barishal) ;
        String[] bhola =getResources().getStringArray(R.array.Bhola) ;
        String[] bBaria =getResources().getStringArray(R.array.BBaria) ;
        String[] bandarban =getResources().getStringArray(R.array.Bandarban) ;
        String[] bagethat =getResources().getStringArray(R.array.Bagerhat) ;
        String[] bogura =getResources().getStringArray(R.array.Bogura) ;

        String[] cnawabganj =getResources().getStringArray(R.array.Cnawabganj) ;
        String[] chuadanga =getResources().getStringArray(R.array.Chuadanga) ;
        String[] chandpur =getResources().getStringArray(R.array.Chandpur) ;
        String[] chattogram =getResources().getStringArray(R.array.Chattogram) ;
        String[] coxsbazar =getResources().getStringArray(R.array.COXSBAZAR) ;
        String[] cumilla =getResources().getStringArray(R.array.Cumilla) ;

        String[] dhaka =getResources().getStringArray(R.array.Dhaka) ;
        String[] dinajpur =getResources().getStringArray(R.array.Dinajpur) ;

        String[] feni =getResources().getStringArray(R.array.Feni) ;
        String[] faridpur =getResources().getStringArray(R.array.Faridpur) ;

        String[] gazipur =getResources().getStringArray(R.array.Gazipur) ;
        String[] gopalganj =getResources().getStringArray(R.array.Gopalganj) ;
        String[] gaibandha =getResources().getStringArray(R.array.Gaibandha) ;

        String[] habiganj =getResources().getStringArray(R.array.Habiganj) ;

        String[] jhalokathi =getResources().getStringArray(R.array.Jhalokathi) ;
        String[] jashore =getResources().getStringArray(R.array.Jashore) ;
        String[] jhenaidah =getResources().getStringArray(R.array.Jhenaidah) ;
        String[] jamalpur =getResources().getStringArray(R.array.Jamalpur) ;
        String[] joypurhat =getResources().getStringArray(R.array.Joypurhat) ;

        String[] kishoreganj =getResources().getStringArray(R.array.Kishoreganj) ;
        String[] khagrachari =getResources().getStringArray(R.array.Khagrachari) ;
        String[] kurigram =getResources().getStringArray(R.array.Kurigram) ;
        String[] khulna =getResources().getStringArray(R.array.Khulna) ;
        String[] kushtia =getResources().getStringArray(R.array.Kushtia) ;

        String[] lalmonirhat =getResources().getStringArray(R.array.Lalmonirhat) ;
        String[] laxmipur =getResources().getStringArray(R.array.Laxmipur) ;

        String[] madaripur =getResources().getStringArray(R.array.Madaripur) ;
        String[] manikganj =getResources().getStringArray(R.array.Manikganj) ;
        String[] munshiganj =getResources().getStringArray(R.array.Munshiganj) ;
        String[] magura =getResources().getStringArray(R.array.Magura) ;
        String[] meherpur =getResources().getStringArray(R.array.Meherpur) ;
        String[] mymensingh =getResources().getStringArray(R.array.Mymensingh) ;
        String[] moulvibazar =getResources().getStringArray(R.array.Moulvibazar) ;

        String[] netrokona =getResources().getStringArray(R.array.Netrokona) ;
        String[] narail =getResources().getStringArray(R.array.Narail) ;
        String[] noakhali =getResources().getStringArray(R.array.Noakhali) ;
        String[] narayanganj =getResources().getStringArray(R.array.Narayanganj) ;
        String[] narshinghi =getResources().getStringArray(R.array.Narshingdi) ;
        String[] naogaon =getResources().getStringArray(R.array.Naogaon) ;
        String[] natore =getResources().getStringArray(R.array.Natore) ;
        String[] nilphamari =getResources().getStringArray(R.array.Nilphamari) ;

        String[] panchagarh =getResources().getStringArray(R.array.Panchagarh) ;
        String[] patuakhali =getResources().getStringArray(R.array.Patuakhali) ;
        String[] pirojpur =getResources().getStringArray(R.array.Pirojpur) ;
        String[] pabna =getResources().getStringArray(R.array.Pabna) ;

        String[] rajbari =getResources().getStringArray(R.array.Rajbari) ;
        String[] rangamati =getResources().getStringArray(R.array.Rangamati) ;
        String[] rajshahi =getResources().getStringArray(R.array.Rajshahi) ;
        String[] rangpur =getResources().getStringArray(R.array.Rangpur) ;

        String[] shariatpur =getResources().getStringArray(R.array.Shariatpur) ;
        String[] satkhira =getResources().getStringArray(R.array.Satkhira) ;
        String[] sherpur =getResources().getStringArray(R.array.Sherpur) ;
        String[] sirajganj =getResources().getStringArray(R.array.Sirajganj) ;
        String[] sunamganj =getResources().getStringArray(R.array.Sunamganj) ;
        String[] sylhet =getResources().getStringArray(R.array.Sylhet) ;

        String[] tangail =getResources().getStringArray(R.array.Tangail) ;
        String[] thakurgaan =getResources().getStringArray(R.array.Thakurgaon) ;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,district);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, barguna);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, barishal);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, bhola);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, jhalokathi);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, patuakhali);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, pirojpur);
        ArrayAdapter<String> adapter7 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, bBaria);

        ArrayAdapter<String> adapter8 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, bandarban);
        ArrayAdapter<String> adapter9 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, chandpur);
        ArrayAdapter<String> adapter10 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, chattogram);
        ArrayAdapter<String> adapter11 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, coxsbazar);
        ArrayAdapter<String> adapter12 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, cumilla);
        ArrayAdapter<String> adapter13 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, feni);

        ArrayAdapter<String> adapter14 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, khagrachari);
        ArrayAdapter<String> adapter15 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, laxmipur);

        ArrayAdapter<String> adapter16 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, noakhali);
        ArrayAdapter<String> adapter17 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, rangamati);

        ArrayAdapter<String> adapter18 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, dhaka);
        ArrayAdapter<String> adapter19 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, faridpur);
        ArrayAdapter<String> adapter20 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, gazipur);

        ArrayAdapter<String> adapter21 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, gopalganj);

        ArrayAdapter<String> adapter22 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, kishoreganj);
        ArrayAdapter<String> adapter23 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, madaripur);
        ArrayAdapter<String> adapter24 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, manikganj);
        ArrayAdapter<String> adapter25 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, munshiganj);
        ArrayAdapter<String> adapter26 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, narayanganj);

        ArrayAdapter<String> adapter27 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, narshinghi);
        ArrayAdapter<String> adapter28 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, rajbari);
        ArrayAdapter<String> adapter29 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, shariatpur);
        ArrayAdapter<String> adapter30 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, tangail);
        ArrayAdapter<String> adapter31 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, bagethat);

        ArrayAdapter<String> adapter32 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, chuadanga);
        ArrayAdapter<String> adapter33 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, jashore);

        ArrayAdapter<String> adapter34 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, jhenaidah);
        ArrayAdapter<String> adapter35 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, khulna);
        ArrayAdapter<String> adapter36 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, kushtia);
        ArrayAdapter<String> adapter37 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, magura);
        ArrayAdapter<String> adapter38 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, meherpur);
        ArrayAdapter<String> adapter39 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,narail);
        ArrayAdapter<String> adapter40 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, satkhira);

        ArrayAdapter<String> adapter41 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, jamalpur);
        ArrayAdapter<String> adapter42 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, mymensingh);
        ArrayAdapter<String> adapter43 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, netrokona);
        ArrayAdapter<String> adapter44 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, sherpur);
        ArrayAdapter<String> adapter45 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, bogura);
        ArrayAdapter<String> adapter46 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, cnawabganj);
        ArrayAdapter<String> adapter47 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,natore);
        ArrayAdapter<String> adapter48 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, pabna);

        ArrayAdapter<String> adapter49 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, rajshahi);
        ArrayAdapter<String> adapter50 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, sirajganj);
        ArrayAdapter<String> adapter51 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, dinajpur);
        ArrayAdapter<String> adapter52 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, gaibandha);

        ArrayAdapter<String> adapter53 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, kurigram);
        ArrayAdapter<String> adapter54 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, lalmonirhat);
        ArrayAdapter<String> adapter55 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, nilphamari);
        ArrayAdapter<String> adapter56 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, panchagarh);

        ArrayAdapter<String> adapter57 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, rangpur);
        ArrayAdapter<String> adapter58 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, thakurgaan);
        ArrayAdapter<String> adapter59 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, habiganj);
        ArrayAdapter<String> adapter60 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, moulvibazar);
        ArrayAdapter<String> adapter61 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, sunamganj);
        ArrayAdapter<String> adapter62 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, sylhet);
        ArrayAdapter<String> adapter63 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, tangail);
        ArrayAdapter<String> adapter64 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, thakurgaan);


        distText.setAdapter(adapter);
        distText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distText.showDropDown();
            }
        });
        distText.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        thanaText.setAdapter(adapter1);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 2:
                        thanaText.setAdapter(adapter2);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 3:
                        thanaText.setAdapter(adapter3);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 4:
                        thanaText.setAdapter(adapter4);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 5:
                        thanaText.setAdapter(adapter5);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 6:
                        thanaText.setAdapter(adapter6);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 7:
                        thanaText.setAdapter(adapter7);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 8:
                        thanaText.setAdapter(adapter8);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 9:
                        thanaText.setAdapter(adapter9);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 10:
                        thanaText.setAdapter(adapter10);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 11:
                        thanaText.setAdapter(adapter12);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 12:
                        thanaText.setAdapter(adapter12);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 13:
                        thanaText.setAdapter(adapter13);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 14:
                        thanaText.setAdapter(adapter14);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 15:
                        thanaText.setAdapter(adapter15);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 16:
                        thanaText.setAdapter(adapter16);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 17:
                        thanaText.setAdapter(adapter17);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 18:
                        thanaText.setAdapter(adapter18);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 19:
                        thanaText.setAdapter(adapter19);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 20:
                        thanaText.setAdapter(adapter20);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 21:
                        thanaText.setAdapter(adapter21);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 22:
                        thanaText.setAdapter(adapter22);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 23:
                        thanaText.setAdapter(adapter23);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 24:
                        thanaText.setAdapter(adapter24);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 25:
                        thanaText.setAdapter(adapter25);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 26:
                        thanaText.setAdapter(adapter26);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 27:
                        thanaText.setAdapter(adapter27);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 28:
                        thanaText.setAdapter(adapter28);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 29:
                        thanaText.setAdapter(adapter29);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 30:
                        thanaText.setAdapter(adapter30);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 31:
                        thanaText.setAdapter(adapter31);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 32:
                        thanaText.setAdapter(adapter32);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 33:
                        thanaText.setAdapter(adapter33);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 34:
                        thanaText.setAdapter(adapter34);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 35:
                        thanaText.setAdapter(adapter35);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 36:
                        thanaText.setAdapter(adapter36);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 37:
                        thanaText.setAdapter(adapter37);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 38:
                        thanaText.setAdapter(adapter38);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 39:
                        thanaText.setAdapter(adapter39);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 40:
                        thanaText.setAdapter(adapter40);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 41:
                        thanaText.setAdapter(adapter41);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 42:
                        thanaText.setAdapter(adapter42);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 43:
                        thanaText.setAdapter(adapter43);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 44:
                        thanaText.setAdapter(adapter44);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 45:
                        thanaText.setAdapter(adapter45);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 46:
                        thanaText.setAdapter(adapter46);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 47:
                        thanaText.setAdapter(adapter47);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 48:
                        thanaText.setAdapter(adapter48);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 49:
                        thanaText.setAdapter(adapter49);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 50:
                        thanaText.setAdapter(adapter50);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 51:
                        thanaText.setAdapter(adapter51);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 52:
                        thanaText.setAdapter(adapter52);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 53:
                        thanaText.setAdapter(adapter53);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 54:
                        thanaText.setAdapter(adapter54);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 55:
                        thanaText.setAdapter(adapter55);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 56:
                        thanaText.setAdapter(adapter56);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 57:
                        thanaText.setAdapter(adapter57);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 58:
                        thanaText.setAdapter(adapter58);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 59:
                        thanaText.setAdapter(adapter59);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 60:
                        thanaText.setAdapter(adapter60);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 61:
                        thanaText.setAdapter(adapter61);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 62:
                        thanaText.setAdapter(adapter62);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 63:
                        thanaText.setAdapter(adapter63);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });
                        break;
                    case 64:
                        thanaText.setAdapter(adapter64);
                        thanaText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                thanaText.showDropDown();
                            }
                        });

                }
            }
        });


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nameText=name.getText().toString();
                final String numberText=number.getText().toString();
                final String ageText=age.getText().toString();
                final String districtText=distText.getText().toString();
                final String upozilaText=thanaText.getText().toString();
                final String bloodGroupText=groupText.getText().toString();

                if(nameText.isEmpty()||numberText.isEmpty()||ageText.isEmpty())
                {
                    Toast.makeText(AddPatient.this, "Fill up All the Field..", Toast.LENGTH_SHORT).show();
                }
                else {

                    databaseReference.child("Patient").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.hasChild(numberText)){
                                Toast.makeText(AddPatient.this, "This Patient Already Exist", Toast.LENGTH_SHORT).show();
                            }

                            else {

                                databaseReference.child("Patient").child(numberText).child("Name").setValue(nameText);
                                databaseReference.child("Patient").child(numberText).child("Age").setValue(ageText);
                                databaseReference.child("Patient").child(numberText).child("District").setValue(districtText);
                                databaseReference.child("Patient").child(numberText).child("Thana").setValue(upozilaText);
                                databaseReference.child("Patient").child(numberText).child("Blood Group").setValue(bloodGroupText);
                                databaseReference.child("Patient").child(numberText).child("Contact").setValue(numberText);


                                Toast.makeText(AddPatient.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(AddPatient.this, MainActivity2.class);
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