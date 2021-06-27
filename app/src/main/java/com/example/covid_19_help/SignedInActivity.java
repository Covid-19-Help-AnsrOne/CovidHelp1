package com.example.covid_19_help;

import android.content.Intent;
// import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SignedInActivity extends AppCompatActivity {

    TextView tvPhoneNumber,result1;
    Button btnSignOut;
    Button btnIsolationTips, btnBookAppointment, btnVaccination, btnQuickCheckup;


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