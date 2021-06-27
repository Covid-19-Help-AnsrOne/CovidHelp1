package com.example.covid_19_help;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FourthActivity extends AppCompatActivity {


    Button yes4, no4;
    String phoneNumber2;
    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;
    String str1;
    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        yes4 = (Button)findViewById(R.id.yes4);
        no4 = (Button)findViewById(R.id.no4);
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

        //String phoneNumber2 = etPhoneNumber.getText().toString().trim();
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference();





        yes4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent i1=new Intent(FourthActivity.this,
                        SignedInActivity.class);

                    String username=user.getPhoneNumber();
                    databaseReference.child(username).child("symptoms").setValue("YES");

                startActivity(i1);

                finish();

            }
        });

        no4.setOnClickListener(new View.OnClickListener() {

            String str2;
            @Override
            public void onClick(View v)
            {

                Intent i2=new Intent(FourthActivity.this,
                        SignedInActivity.class);

                    String username=user.getPhoneNumber();
                    databaseReference.child(username).child("symptoms").setValue("NO");

                startActivity(i2);


                finish();

            }
        });


    }
}