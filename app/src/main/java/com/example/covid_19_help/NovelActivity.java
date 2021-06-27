package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class NovelActivity extends AppCompatActivity {

    Button btnSignOut3;
    TextView novelcontent;
    String noveltext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);
        novelcontent=findViewById(R.id.novelcontent);
        noveltext="The Merchant of Venice\n" +
                "The scene starts on a street in Venice . Antonio , Salarino and salanio are presnt there . They were having a quite serious talking . Then there enter Lorenzo , Bassanio and Gratiano . Salarino and Salanio take a leve from there wishing Antonio goodbye.";

        novelcontent.setText(noveltext);

        btnSignOut3=findViewById(R.id.btn_sign_out3);
        btnSignOut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(NovelActivity.this,MainActivity2.class));
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(NovelActivity.this,
               Isolationtips.class);


        startActivity(i);
    }
}