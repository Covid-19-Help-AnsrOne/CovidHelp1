package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Quick checkup activity with a chat bot.
public class QuickCheckupActivity extends AppCompatActivity implements View.OnClickListener{

   private TextView tvVaccine, tvHowMany, tvAgePrompt, btnNo, btnYes, tvOne, tvTwo,
           btnNoDoseZero, btnYesDoseZero, btnPos, btnNeg;
   private EditText etAge;
   private Button btnConfirm;
   private TextView tvDoseResult, tvCovidPositiveOrNot, tvCovidPositiveMessage;
   View btnContain, doses, btnDoseContainZero, btnCovPosOrNot;
   boolean flag = false;

   //Find all the views.
   private void findViews() {
      etAge = findViewById(R.id.etAge);
      tvHowMany = findViewById(R.id.tvHowMany);
      tvAgePrompt = findViewById(R.id.tvAgePrompt);
      tvVaccine = findViewById(R.id.tvVaccine);
      btnConfirm = findViewById(R.id.btnConfirmAge);
      btnNo = findViewById(R.id.btnNo);
      btnYes = findViewById(R.id.btnYes);
      btnNoDoseZero = findViewById(R.id.btnNoDoseZero);
      btnYesDoseZero = findViewById(R.id.btnYesDoseZero);
      tvOne = findViewById(R.id.tvOne);
      tvTwo = findViewById(R.id.tvTwo);
      tvDoseResult = findViewById(R.id.tvDoseResult);
      btnContain = findViewById(R.id.btnContain);
      doses = findViewById(R.id.doses);
      btnDoseContainZero = findViewById(R.id.btnContainDoseZero);
      btnPos = findViewById(R.id.btnPos);
      btnNeg = findViewById(R.id.btnNeg);
      tvCovidPositiveOrNot = findViewById(R.id.tvCovidPositiveOrNot);
      tvCovidPositiveMessage = findViewById(R.id.tvCovidPositiveMessage);
      btnCovPosOrNot = findViewById(R.id.btnCovPosOrNot);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_quick_checkup);
      findViews();

      //Prompt to ask the age of the use.
      askForAge();

      // After entering age, press confirm.
      btnConfirm.setOnClickListener(this);

      //Code when no button is pressed.
      btnNo.setOnClickListener(this);

      //Code When yes button is pressed.
      btnYes.setOnClickListener(this);

      tvTwo.setOnClickListener(this);
      tvOne.setOnClickListener(this);

      btnNoDoseZero.setOnClickListener(this);

      btnYesDoseZero.setOnClickListener(this);

      btnPos.setOnClickListener(this);
      btnNeg.setOnClickListener(this);
   }

   //Method to ask the age of the user.
   private void askForAge() {
      new Handler().postDelayed(() -> {
         etAge.setVisibility(View.VISIBLE);
         btnConfirm.setVisibility(View.VISIBLE);
         tvAgePrompt.setVisibility(View.VISIBLE);
      }, 1200);
   }



   @SuppressLint("NonConstantResourceId")
   @Override
   public void onClick(View view) {
      switch (view.getId()) {
         case R.id.btnConfirmAge:
             if (etAge.getText().toString().isEmpty()) etAge.setError("Age required!");
         else {
            etAge.setEnabled(false);
            btnConfirm.setVisibility(View.GONE);
            tvVaccine.setVisibility(View.VISIBLE);
            btnContain.setVisibility(View.VISIBLE);
         }
         break;
         case R.id.btnNo:
            btnYes.setVisibility(View.GONE);
            tvHowMany.setVisibility(View.VISIBLE);
            tvHowMany.setText(getResources().getString(R.string.dose_zero));
            btnDoseContainZero.setVisibility(View.VISIBLE);
            break;
         case R.id.btnYes:
            btnNo.setVisibility(View.GONE);
            tvHowMany.setVisibility(View.VISIBLE);
            doses.setVisibility(View.VISIBLE);
            break;
         case R.id.tvOne:
            tvTwo.setVisibility(View.GONE);
            tvDoseResult.setText(getResources().getString(R.string.dose_one));
            tvDoseResult.setVisibility(View.VISIBLE);
            break;
         case R.id.tvTwo:
            tvOne.setVisibility(View.GONE);
            tvDoseResult.setText(getResources().getString(R.string.dose_two));
            tvDoseResult.setVisibility(View.VISIBLE);
            break;
         case R.id.btnYesDoseZero:
            flag = true;
            btnNoDoseZero.setVisibility(View.GONE);
            tvCovidPositiveOrNot.setVisibility(View.VISIBLE);
            btnCovPosOrNot.setVisibility(View.VISIBLE);
            tvCovidPositiveOrNot.setText(getResources().getString(R.string.positive_or_not));
            break;
         case R.id.btnNoDoseZero:
            flag = false;
            btnYesDoseZero.setVisibility(View.GONE);
            tvCovidPositiveMessage.setVisibility(View.VISIBLE);
            tvCovidPositiveMessage.setText(getResources().getString(R.string.symptoms));
            btnCovPosOrNot.setVisibility(View.VISIBLE);
            //TODO:
            break;

         case R.id.btnNeg:
            if (flag) {
               tvCovidPositiveMessage.setVisibility(View.VISIBLE);
               btnPos.setVisibility(View.GONE);
               tvCovidPositiveMessage.setText(getResources().getString(R.string.covid_negative));
            } else {
               tvCovidPositiveMessage.setVisibility(View.VISIBLE);
               btnPos.setVisibility(View.GONE);
               tvCovidPositiveMessage.setText(getResources().getString(R.string.covid_negative));
            }
            break;
         case R.id.btnPos:
            if (flag) {
               tvCovidPositiveMessage.setVisibility(View.VISIBLE);
               btnNeg.setVisibility(View.GONE);
               tvCovidPositiveMessage.setText(getResources().getString(R.string.you_have_symptoms));
            } else {
               tvCovidPositiveMessage.setVisibility(View.VISIBLE);
               btnNeg.setVisibility(View.GONE);
               tvCovidPositiveMessage.setText(getResources().getString(R.string.isolation));
            }
            break;
      }
   }
}