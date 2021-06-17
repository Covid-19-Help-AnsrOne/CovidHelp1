package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FourthActivity extends AppCompatActivity {


    Button yes4, no4;
    String phoneNumber2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        yes4 = (Button)findViewById(R.id.yes4);
        no4 = (Button)findViewById(R.id.no4);

        yes4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                Intent intent = getIntent();

                String str1 = intent.getStringExtra("q3");

                Intent i1=new Intent(FourthActivity.this,
                        SignedInActivity.class);

                if(str1=="YES")
                {
                    i1.putExtra("msg", "PLEASE GO FOR COVID TESTING ,YOU TRAVELLED AND HAVE SYMPTOMS");
                }
                else {
                    i1.putExtra("msg", "PLEASE GO FOR COVID TESTING ,YOU ARE NOT TRAVELLED BUT HAVE SYMPTOMS");
                }
                startActivity(i1);

                finish();

            }
        });

        no4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                Intent intent = getIntent();

                String str1 = intent.getStringExtra("q3");


                Intent i2=new Intent(FourthActivity.this,
                        SignedInActivity.class);

                if(str1=="YES")
                {
                    i2.putExtra("msg", "PLEASE BE HOME ISOLATED,YOU TRAVELLED");
                }
                else {
                    i2.putExtra("msg", "STAY HOME STAY SAFE");
                }
                startActivity(i2);


                finish();

            }
        });


    }
}