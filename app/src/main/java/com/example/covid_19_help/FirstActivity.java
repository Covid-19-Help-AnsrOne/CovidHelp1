package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirstActivity extends AppCompatActivity {

    Button yes1, no1;
    String phoneNumber2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //Welcome message to the user.
        Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show();

        yes1 = (Button)findViewById(R.id.yes1);
        no1 = (Button)findViewById(R.id.no1);

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();



        yes1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {


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

                Intent i2=new Intent(FirstActivity.this,
                        ThirdActivity.class);

                startActivity(i2);

                finish();

            }
        });


    }


}