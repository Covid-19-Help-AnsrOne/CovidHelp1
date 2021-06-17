package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SecondActivity extends AppCompatActivity {


    Button yes2, no2;
    String phoneNumber2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        yes2 = (Button)findViewById(R.id.yes2);
        no2 = (Button)findViewById(R.id.no2);

        yes2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {


                Intent i1=new Intent(SecondActivity.this,
                        SignedInActivity.class);

                i1.putExtra("msg", "You tested covid 19 positive ,Take Rest");


                startActivity(i1);

                finish();

            }
        });

        no2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {




                Intent i2=new Intent(SecondActivity.this,
                        SignedInActivity.class);

                i2.putExtra("msg", "Stay Home Stay Safe");

                startActivity(i2);


                finish();

            }
        });


    }
}