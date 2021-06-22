package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Quick checkup activity with a chat bot.
public class QuickCheckupActivity extends AppCompatActivity {

   private TextView tvVaccine, tvSymptoms, tvAgePrompt, btnNo, btnYes;
   private EditText etAge;
   private Button btnConfirm;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_quick_checkup2);
      findViews();

      //Prompt to ask the age of the use.
      askForAge();

      // After entering age, press confirm.
      btnConfirm.setOnClickListener(v -> {
         if (etAge.getText().toString().isEmpty()) etAge.setError("Age required!");
         else {
            etAge.setEnabled(false);
            btnConfirm.setVisibility(View.GONE);
            tvVaccine.setVisibility(View.VISIBLE);
            btnNo.setVisibility(View.VISIBLE);
            btnYes.setVisibility(View.VISIBLE);
         }
      });

      //Code when no button is pressed.
      btnNo.setOnClickListener(v -> {
         btnYes.setVisibility(View.GONE);
         showSymptomsPrompt();
      });

      //Code When yes button is pressed.
      btnYes.setOnClickListener(v -> {
         btnNo.setVisibility(View.GONE);
         showSymptomsPrompt();
      });
   }

   //Method to ask the age of the user.
   private void askForAge() {
      new Handler().postDelayed(() -> {
         etAge.setVisibility(View.VISIBLE);
         btnConfirm.setVisibility(View.VISIBLE);
         tvAgePrompt.setVisibility(View.VISIBLE);
      }, 1200);
   }

   //Make symptoms prompt visible.
   private void showSymptomsPrompt() {
      tvSymptoms.setVisibility(View.VISIBLE);
   }

   //Find all the views.
   private void findViews() {
      etAge = findViewById(R.id.etAge);
      tvSymptoms = findViewById(R.id.tvSymptoms);
      tvAgePrompt = findViewById(R.id.tvAgePrompt);
      tvVaccine = findViewById(R.id.tvVaccine);
      btnConfirm = findViewById(R.id.btnConfirmAge);
      btnNo = findViewById(R.id.btnNo);
      btnYes = findViewById(R.id.btnYes);
   }
}