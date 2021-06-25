package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class HomeIsolationtTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_isolationt_tips);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(HomeIsolationtTips.this,
                SignedInActivity.class);


        startActivity(i);
    }
}