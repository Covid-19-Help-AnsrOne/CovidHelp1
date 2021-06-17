package com.example.covid_19_help;

import android.content.Intent;
// import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class SignedInActivity extends AppCompatActivity {

    TextView tvPhoneNumber,result1;
    Button btnSignOut;
    RadioButton rb1,rb2,rb3,rb4;


    String Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in);



        findViews();

        Intent intent = getIntent();
        String message= intent.getStringExtra("msg");

/*
        q1 = intent.getStringExtra("q1");
        q2 = intent.getStringExtra("q2");
        q3 = intent.getStringExtra("q3");
        q4 = intent.getStringExtra("q4");

        if(q1=="YES")
        {
            if(q2=="YES")
            {
                Result="BE HOME ISOLATED,YOU TESTED POSITIVE";
            }
            if(q2=="NO")
            {
                Result="STAY HOME STAY SAFE,YOU TESTED NEGATIVE";
            }

        }

        if(q3=="YES")
        {
            if(q4=="YES")
                {
                    Result="PLEASE GO FOR COVID TESTING ,YOU TRAVELLED AND HAVE SYMPTOMS";
                }
            if(q4=="NO")
                {
                    Result="PLEASE BE HOME ISOLATED,YOU TRAVELLED ";
                }
        }
        if(q3=="NO")
            {
                if(q4=="YES")
                {
                    Result="PLEASE GO FOR COVID TESTING ,YOU ARE NOT TRAVELLED BUT HAVE SYMPTOMS";
                }
                if(q4=="NO")
                {
                    Result="STAY HOME STAY SAFE";
                }
            }
*/
        Result=message;
        result1.setText(Result);

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SignedInActivity.this,MainActivity2.class));
                finish();
            }
        });

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(SignedInActivity.this,
                        Homeisolation.class);
                startActivity(i1);

                finish();
            }
        });


    }

    private void findViews() {
        tvPhoneNumber=findViewById(R.id.tv_2);
        btnSignOut=findViewById(R.id.btn_sign_out);
        result1=findViewById(R.id.result);
        rb1=findViewById(R.id.radio_id1);
        rb2=findViewById(R.id.radio_id2);
        rb3=findViewById(R.id.radio_id3);
        rb4=findViewById(R.id.radio_id4);

    }


}