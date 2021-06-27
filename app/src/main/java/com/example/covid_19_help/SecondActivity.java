package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity {


    Button yes2, no2;
    String phoneNumber2;
    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        yes2 = (Button)findViewById(R.id.yes2);
        no2 = (Button)findViewById(R.id.no2);

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        //String phoneNumber2 = etPhoneNumber.getText().toString().trim();
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference();


        yes2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                String username=user.getPhoneNumber();
                databaseReference.child(username).child("testresult").setValue("YES");

                Intent i1=new Intent(SecondActivity.this,
                        SignedInActivity.class);

                startActivity(i1);

                finish();
            }
        });

        no2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                String username=user.getPhoneNumber();
                databaseReference.child(username).child("testresult").setValue("NO");

                Intent i2=new Intent(SecondActivity.this,
                        SignedInActivity.class);

                startActivity(i2);
                finish();

            }
        });


    }
}