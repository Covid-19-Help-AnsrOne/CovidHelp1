package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ThirdActivity extends AppCompatActivity {


    Button yes3, no3;
    String phoneNumber2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        yes3 = (Button)findViewById(R.id.yes3);
        no3 = (Button)findViewById(R.id.no3);



        yes3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {


                Intent i1=new Intent(ThirdActivity.this,
                        FourthActivity.class);

                i1.putExtra("q3", "YES");
                startActivity(i1);


                finish();

            }
        });

        no3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {


                Intent i2=new Intent(ThirdActivity.this,
                        FourthActivity.class);


                i2.putExtra("q3", "NO");

                startActivity(i2);


                finish();

            }
        });


    }
}