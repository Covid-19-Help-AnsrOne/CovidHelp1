package com.example.covid_19_help;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class
MainActivity2 extends AppCompatActivity {
   Button btnGenerateOTP, btnSignIn;

   EditText etPhoneNumber, etOTP;

   String phoneNumber, otp;

   FirebaseAuth auth;
    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;


   PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
   private String verificationCode;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main2);
      findViews();

      StartFirebaseLogin();
      //String phoneNumber2 = etPhoneNumber.getText().toString().trim();
       firebaseDatabase = FirebaseDatabase.getInstance();

       // below line is used to get reference for our database.
       databaseReference = firebaseDatabase.getReference();

      // Enable/disable the buttons.
      enableOTPButton(etPhoneNumber, btnGenerateOTP, 10);
      enableOTPButton(etOTP, btnSignIn, 6);

      //Send a request to generate OTP after entering a phone number.
      btnGenerateOTP.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            phoneNumber = etPhoneNumber.getText().toString();
            phoneNumber =
                    phoneNumber.contains("+91") ? phoneNumber : ("+91" + phoneNumber);

            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    phoneNumber,                     // Phone number to verify
                    60,                           // Timeout duration
                    TimeUnit.SECONDS,                // Unit of timeout
                    MainActivity2.this,        // Activity (for callback binding)
                    mCallback);                      // OnVerificationStateChangedCallbacks

            Toast.makeText(MainActivity2.this, "Please wait while your request is being process.", Toast.LENGTH_SHORT).show();
         }
      });

      btnSignIn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            otp = etOTP.getText().toString();

            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, otp);

            SigninWithPhone(credential);
         }
      });
   }



   private void SigninWithPhone(PhoneAuthCredential credential) {
      auth.signInWithCredential(credential)
              .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {


                        String username=etPhoneNumber.getText().toString();
                        username="+91"+username;
                        databaseReference.child(username).child("covidtest").setValue("NILL");
                        databaseReference.child(username).child("testresult").setValue("NILL");
                        databaseReference.child(username).child("travelled").setValue("NILL");
                        databaseReference.child(username).child("symptoms").setValue("NILL");


                       startActivity(new Intent(MainActivity2.this, FirstActivity.class));
                       finish();
                    } else {
                       Toast.makeText(MainActivity2.this, "Incorrect OTP", Toast.LENGTH_SHORT).show();
                    }
                 }
              });
   }

   private void findViews() {
      btnGenerateOTP = findViewById(R.id.btn_generate_otp);
      btnSignIn = findViewById(R.id.btn_sign_in);

      etPhoneNumber = findViewById(R.id.et_phone_number);
      etOTP = findViewById(R.id.et_otp);
   }



   private void StartFirebaseLogin() {

      auth = FirebaseAuth.getInstance();
      FirebaseUser user = auth.getCurrentUser();
      mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

         @Override
         public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            Toast.makeText(MainActivity2.this, "verification completed", Toast.LENGTH_SHORT).show();


         }

         @Override
         public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(MainActivity2.this, "verification failed", Toast.LENGTH_SHORT).show();
         }

         @Override
         public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationCode = s;
            Toast.makeText(MainActivity2.this, "Code sent", Toast.LENGTH_SHORT).show();
         }
      };
   }

   /**
     * Only enable the buttons if there are correct number of digits.
     */
    private void enableOTPButton(EditText toCheck, Button toEnable, int max) {
        toCheck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (toCheck.getText().toString().trim().length() < max) {
                    toEnable.setEnabled(false);
                    toEnable.setTextColor(ContextCompat.getColor(getApplicationContext(),
                            R.color.textColor));
                } else {
                    toEnable.setEnabled(true);
                    toEnable.setTextColor(ContextCompat.getColor(getApplicationContext(),
                            R.color.white));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}