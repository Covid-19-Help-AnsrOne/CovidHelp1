package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Isolationtips extends AppCompatActivity {

    Button diet,novel,remedies,nottodo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isolationtips);
        diet=findViewById(R.id.diet);
        novel=findViewById(R.id.novel);
        remedies=findViewById(R.id.remedies);
        nottodo=findViewById(R.id.nottodo);

        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Isolationtips.this,
                        DietActivity.class);
                startActivity(i1);

            }
        });

        novel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Isolationtips.this,
                        NovelActivity.class);
                startActivity(i2);

            }
        });


        remedies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(Isolationtips.this,
                        RemediesActivity.class);
                startActivity(i3);

            }
        });




        nottodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(Isolationtips.this,
                        NottodoActivity.class);
                startActivity(i5);

            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(Isolationtips.this,
                SignedInActivity.class);


        startActivity(i);
    }
}