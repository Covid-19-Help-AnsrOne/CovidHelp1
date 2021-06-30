package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class NottodoActivity extends AppCompatActivity {


    TextView nottodocontent1,nottodocontent2;
    String nottodotext1,nottodotext2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nottodo);
        nottodocontent1=findViewById(R.id.nottodocontent1);
        nottodocontent2=findViewById(R.id.nottodocontent2);
        nottodotext1="Do’s & Don’t When You are Home Isolated. \n" ;

        nottodotext2= "If you presume you have COVID-19:\n\n" +
                "DOs \n\n" +
                "•\tDisconnect yourself promptly to a different room with a connected washroom and loo.\n\n" +
                "•\tComplete an RT-PCR test.\n\n" +
                "•\tIn the meantime, stay at home. The vast majority with COVID-19 have a gentle disease and can recuperate at home without hospitalization. Keep in contact with your PCP\n\n" +
                "•\tMonitor your manifestations. On the off chance that you have a crisis cautioning sign (counting inconvenience breathing) call your PCP or go to a medical clinic right away.\n\n" +
                "•\tWear a decent quality veil - surgical+cloth in a cozy fit, covering your nose, mouth, and jawline. N-95 is superior to most different covers.\n\n" +
                "•\tCover your hacks and sniffles.\n\n" +
                "•\tWash hands with cleanser and water or disinfect, frequently.\n\n" +
                "•\tStay hydrated, get rest, and eat basic non-hot, simple to-process food.\n\n" +
                "•\tScreen your SPO2 levels with a heartbeat oximeter and keep in contact with a specialist for exhortation if the Oxygen level starts dipping under 95%.\n\n" +
                "•\tRests in a prone position. Breathing is simpler and lungs work all the more productively when you rest on your stomach. at the point when you.\n\n" +
                "\nDON'Ts\n\n" +
                "•\tDo not share any toiletries, food, utensils with others\n\n" +
                "•\tAvoid public transportation, ride-sharing, or taxis\n\n" +
                "•\tDo not leave your home, except to get medical care. \n\n" +
                "•\tDo not visit public areas.\n\n" +
                "•\tDo not self-prescribe steroids, redeliver, etc.\n\n" +
                "\n" +
                "If you have tested positive for COVID-19:\n\n" +
                "DOs:\n\n" +
                "•\tGet an RT-PCR test done, take your doctor's appointment and advice.\n\n" +
                "•\tStay at home.\n\n" +
                "•\tMonitor your symptoms carefully. If you feel symptoms are worsening, call your doctor.\n\n" +
                "•\tInform all those who have been in contact with you, immediately.\n\n" +
                "•\tIsolate yourself to a separate room with an attached bath and loo.\n\n" +
                "•\tGet rest, eat nutritious food, stay hydrated.\n\n" +
                "•\tPractice regular COVID-appropriate behavior: Mask + Sanitise + Wash hands + Social distancing + No closed and/or crowded places.\n\n" +
                "•\tClean all surfaces that are touched often, with sanitizing or prescribed cleaning liquid by following all safety instructions.\n\n" +
                "•\tMonitor your SPO2 levels with a pulse oximeter and stay in touch with a doctor for advice if Oxygen level begins dropping below 95 percent.\n\n" +
                "•\tLie down in a prone position. Breathing is easier and lungs work more efficiently when you lie down on your stomach.\n\n" +
                "•\tCover your mouth and nose with a tissue when you cough or sneeze.\n\n" +
                "•\tThrow away used tissues in a lined trash can.\n\n" +
                "•\tImmediately wash your hands with soap and water for at least 20 seconds.\n\n" +
                "•\tIf soap and water are not available, clean your hands with a standard quality alcohol-based hand sanitizer.\n\n" +
                "DON'TS:\n\n" +
                "•\tAvoid sharing personal items with other people in the household.\n\n" +
                "•\tDo not self-prescribe steroids, Remdesivir, etc.\n\n" +
                "•\tDo not go to public places.\n\n" +
                "•\tAvoid public transportation. \n\n" +
                "•\tDo not leave your home, except to get medical care. \n\n" +
                "\n" +
                "Follow these tips to stay protected and healthy. Always consult your doctor or a dietician before starting any fitness program or making any changes to your diet.\n" +
                "\n";



        nottodocontent1.setText(nottodotext1);
        nottodocontent2.setText(nottodotext2);



    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(NottodoActivity.this,
                Isolationtips.class);


        startActivity(i);
    }
}