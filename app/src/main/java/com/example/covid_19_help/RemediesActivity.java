package com.example.covid_19_help;




import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class RemediesActivity extends AppCompatActivity {

    Button btnSignOut4;
    TextView remediescontent;
    String remediestext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedies);
        remediescontent=findViewById(R.id.remediescontent);
        remediestext="Isolate yourself in a well ventilated room.\n\n" +
                "Use a triple layer medical mask, discard mask after 8 hours of use or earlier if they become wet or visibly soiled. In the event of a caregiver entering the room, both caregiver and patient may consider using N 95 mask.";

        remediescontent.setText(remediestext);

        btnSignOut4=findViewById(R.id.btn_sign_out4);
        btnSignOut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(RemediesActivity.this,MainActivity2.class));
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(RemediesActivity.this,
                Isolationtips.class);


        startActivity(i);
    }
}