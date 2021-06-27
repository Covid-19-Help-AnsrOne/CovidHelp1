package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Vector;
public class DietActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btnSignOut2;
    TextView dietcontent;
    String diettext;
    Vector<youTubeVideos> youtubeVideos = new Vector<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        youtubeVideos.add( new youTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www" +".youtube.com/embed/3tYjG_bN3Fc\" frameborder=\"0\" allowfullscreen></iframe>") );

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
        recyclerView.setAdapter(videoAdapter);

        btnSignOut2=findViewById(R.id.btn_sign_out2);
        btnSignOut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(DietActivity.this,MainActivity2.class));
                finish();
            }
        });

        dietcontent=findViewById(R.id.dietcontent);
        diettext="Eat a balanced and varied diet\n" +
                "Eating a well-balanced diet, with plenty of fruits and vegetables, whole grains, plant and animal proteins and healthy fats is the best way to get all the essential nutrients we need for good health and normal immune function.";

        dietcontent.setText(diettext);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(DietActivity.this,
                Isolationtips.class);


        startActivity(i);
    }
}