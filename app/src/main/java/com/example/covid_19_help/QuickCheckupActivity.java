package com.example.covid_19_help;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//Quick checkup activity with a chat bot.
public class QuickCheckupActivity extends AppCompatActivity implements View.OnClickListener {

   TextView tvVaccine, tvHowMany, tvAgePrompt, btnNo, btnYes, tvOne, tvTwo,
           btnYesTested, btnNoTested, btnPos, btnNeg,
           btnTravelledYes, btnTravelledNo, btnSymptomsYes, btnSymptomsNo, tvRecentlyTested,
           tvTravelledRecently, tvHaveSymptoms, tvLastFinalMessage;
   EditText etAge;
   Button btnConfirm;
   TextView tvDoseResult, tvCovidPositiveOrNot, tvCovidPositiveMessage;
   View btnContainTakenVaccine, btnContainNumberOfDoses,
           btnContainTestedForCovid, btnContainCovPosOrNot, btnContainTravelledOrNot,
           btnContainHaveSymptomsOrNot;
   boolean haveTravelled;

   //Find all the views.
   private void findViews() {
      btnContainHaveSymptomsOrNot = findViewById(R.id.btnContainHaveSymptomsOrNot);
      btnContainTravelledOrNot = findViewById(R.id.btnContainTravelledOrNot);
      tvTravelledRecently = findViewById(R.id.tvTravelledRecently);
      tvHaveSymptoms = findViewById(R.id.tvHaveSymptoms);
      tvLastFinalMessage = findViewById(R.id.tvLastFinalMessage);
      btnTravelledNo = findViewById(R.id.btnTravelledNo);
      btnTravelledYes = findViewById(R.id.btnTravelledYes);
      btnSymptomsNo = findViewById(R.id.btnSymptomsNo);
      btnSymptomsYes = findViewById(R.id.btnSymptomsYes);
      etAge = findViewById(R.id.etAge);
      tvHowMany = findViewById(R.id.tvHowMany);
      tvAgePrompt = findViewById(R.id.tvAgePrompt);
      tvVaccine = findViewById(R.id.tvVaccine);
      btnConfirm = findViewById(R.id.btnConfirmAge);
      btnNo = findViewById(R.id.btnNo);
      btnYes = findViewById(R.id.btnYes);
      btnYesTested = findViewById(R.id.btnYesTested);
      btnNoTested = findViewById(R.id.btnNoTested);
      tvOne = findViewById(R.id.tvOne);
      tvTwo = findViewById(R.id.tvTwo);
      tvDoseResult = findViewById(R.id.tvDoseResult);
      btnContainTakenVaccine = findViewById(R.id.btnContainTakenVaccine);
      btnContainNumberOfDoses = findViewById(R.id.containNumberOfDoses);
      btnContainTestedForCovid = findViewById(R.id.btnContainTestedForCovid);
      btnPos = findViewById(R.id.btnPos);
      btnNeg = findViewById(R.id.btnNeg);
      tvCovidPositiveOrNot = findViewById(R.id.tvCovidPositiveOrNot);
      tvCovidPositiveMessage = findViewById(R.id.tvCovidPositiveMessage);
      btnContainCovPosOrNot = findViewById(R.id.btnContainCovPosOrNot);
      tvRecentlyTested = findViewById(R.id.tvRecentlyTested);

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

      btnYesTested.setOnClickListener(this);
      btnNoTested.setOnClickListener(this);

      btnPos.setOnClickListener(this);
      btnNeg.setOnClickListener(this);

      btnTravelledNo.setOnClickListener(this);
      btnTravelledYes.setOnClickListener(this);

      btnSymptomsNo.setOnClickListener(this);
      btnSymptomsYes.setOnClickListener(this);
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
               btnContainTakenVaccine.setVisibility(View.VISIBLE);
            }
            break;
         case R.id.btnNo:
            btnYes.setVisibility(View.GONE);
            tvRecentlyTested.setVisibility(View.VISIBLE);
            tvRecentlyTested.setText(getResources().getString(R.string.recently_tested));
            btnContainTestedForCovid.setVisibility(View.VISIBLE);
            break;

         case R.id.btnYes:
            btnNo.setVisibility(View.GONE);
            tvHowMany.setVisibility(View.VISIBLE);
            btnContainNumberOfDoses.setVisibility(View.VISIBLE);
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

         case R.id.btnYesTested:
            btnNoTested.setVisibility(View.GONE);
            tvCovidPositiveOrNot.setVisibility(View.VISIBLE);
            btnContainCovPosOrNot.setVisibility(View.VISIBLE);
            tvCovidPositiveOrNot.setText(getResources().getString(R.string.positive_or_not));
            break;
         case R.id.btnNoTested:
            btnYesTested.setVisibility(View.GONE);
            tvTravelledRecently.setVisibility(View.VISIBLE);
            btnContainTravelledOrNot.setVisibility(View.VISIBLE);
            tvTravelledRecently.setText(getResources().getString(R.string.travelled));
            break;

         case R.id.btnNeg:
               btnPos.setVisibility(View.GONE);
               tvCovidPositiveMessage.setVisibility(View.VISIBLE);
               tvCovidPositiveMessage.setText(getResources().getString(R.string.covid_negative));
            break;
         case R.id.btnPos:
               tvCovidPositiveMessage.setVisibility(View.VISIBLE);
               btnNeg.setVisibility(View.GONE);
               tvCovidPositiveMessage.setText(getResources().getString(R.string.covid_positive));
            break;

         case R.id.btnTravelledYes:
            haveTravelled = true;
            btnTravelledNo.setVisibility(View.GONE);
            tvHaveSymptoms.setVisibility(View.VISIBLE);
            btnContainHaveSymptomsOrNot.setVisibility(View.VISIBLE);
            tvHaveSymptoms.setText(getResources().getString(R.string.symptoms));
            break;
         case R.id.btnTravelledNo:
            haveTravelled = false;
            btnTravelledYes.setVisibility(View.GONE);
            tvHaveSymptoms.setVisibility(View.VISIBLE);
            btnContainHaveSymptomsOrNot.setVisibility(View.VISIBLE);
            tvHaveSymptoms.setText(getResources().getString(R.string.symptoms));
            break;
         case R.id.btnSymptomsYes:
            btnSymptomsNo.setVisibility(View.GONE);
            tvLastFinalMessage.setVisibility(View.VISIBLE);

            if (haveTravelled) {
               tvLastFinalMessage.setText(getResources().getString(R.string.travel_and_symptoms));
            } else {

               tvLastFinalMessage.setText(getResources().getString(R.string.no_travel_but_yes_symptom));
            }

            break;
         case R.id.btnSymptomsNo:
            btnSymptomsYes.setVisibility(View.GONE);
            tvLastFinalMessage.setVisibility(View.VISIBLE);

            if (haveTravelled) {
               tvLastFinalMessage.setText(getResources().getString(R.string.travel_but_no_symptom));

            } else {
               tvLastFinalMessage.setText(getResources().getString(R.string.no_travel_no_symptom));

            }
            break;
      }
   }
}