package com.example.covid_19_help;

import android.content.Intent;
// import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignedInActivity extends AppCompatActivity {

    TextView tvPhoneNumber,result1;
    Button btnSignOut;
    Button btnIsolationTips, btnBookAppointment, btnVaccination, btnQuickCheckup;

    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;
    String Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in);

        findViews();

        Intent intent = getIntent();
        String message= intent.getStringExtra("msg");
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

        //String phoneNumber2 = etPhoneNumber.getText().toString().trim();
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String username=user.getPhoneNumber();

                String q1 = snapshot.child(username).child("covidtest").getValue(String.class);
                String q2 = snapshot.child(username).child("testresult").getValue(String.class);
                String q3 = snapshot.child(username).child("travelled").getValue(String.class);
                String q4 = snapshot.child(username).child("symptoms").getValue(String.class);


                if(q1=="YES")
                {
                    if(q2=="YES")
                    {
                        result1.setText("BE HOME ISOLATED,YOU TESTED POSITIVE");
                    }
                    else
                    {
                        result1.setText("STAY HOME STAY SAFE,YOU TESTED NEGATIVE");
                    }

                }
                else {

                    if (q3 == "YES") {
                        if (q4 == "YES") {
                            result1.setText("PLEASE GO FOR COVID TESTING ,YOU TRAVELLED AND HAVE SYMPTOMS");
                        }
                        else  {
                            result1.setText("PLEASE BE HOME ISOLATED,YOU TRAVELLED  ");
                        }
                    }
                    else {
                        if (q4 == "YES") {
                            result1.setText("PLEASE GO FOR COVID TESTING ,YOU ARE NOT TRAVELLED BUT HAVE SYMPTOMS");
                        }
                        else {
                            result1.setText("STAY HOME STAY SAFE,YOU ARE NOT TRAVELLED AND DO NOT HAVE SYMPTOMS");
                        }
                    }
                }

                //result1.setText(q1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        result1.setText(Result);

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SignedInActivity.this,MainActivity2.class));
                finish();
            }
        });

        btnVaccination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(SignedInActivity.this,
                        Vaccination.class);
                startActivity(i1);

            }
        });

        btnIsolationTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(SignedInActivity.this,
                        Isolationtips.class);
                startActivity(i2);


            }
        });

        //Open quick checkup activity by clicking on the button.
        btnQuickCheckup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityQuickCheckup();
            }
        });
    }

  //  private void gotoUrl(String s) {
    //    Uri uri = Uri.parse(s);
      //  startActivity(new Intent(Intent.ACTION_VIEW,uri));
    //}

    private void findViews() {
        //tvPhoneNumber=findViewById(R.id.tv_2);
        btnSignOut=findViewById(R.id.btn_sign_out);
        result1=findViewById(R.id.result);
        btnIsolationTips =findViewById(R.id.btnIsolationTips);
        btnBookAppointment =findViewById(R.id.btnBookAppointment);
        btnVaccination =findViewById(R.id.btnVaccination);
        btnQuickCheckup =findViewById(R.id.btnQuickCheckup);
    }

    //Method to open quick checkup activity.
    private void openActivityQuickCheckup() {
        startActivity(new Intent(this, QuickCheckupActivity.class));
    }

}