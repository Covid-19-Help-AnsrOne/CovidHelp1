package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirstActivity extends AppCompatActivity {

    Button yes1, no1;
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
        setContentView(R.layout.activity_first);
        yes1 = (Button)findViewById(R.id.yes1);
        no1 = (Button)findViewById(R.id.no1);

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

        //String phoneNumber2 = etPhoneNumber.getText().toString().trim();
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference();


        yes1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                String username=user.getPhoneNumber();
                databaseReference.child(username).child("covidtest").setValue("YES");

                Intent i1=new Intent(FirstActivity.this,
                        SecondActivity.class);
                startActivity(i1);

                finish();

            }
        });
        no1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                String username=user.getPhoneNumber();
                databaseReference.child(username).child("covidtest").setValue("NO");

                Intent i2=new Intent(FirstActivity.this,
                        ThirdActivity.class);

                startActivity(i2);

                finish();

            }
        });


    }


}