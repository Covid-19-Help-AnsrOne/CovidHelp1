package com.example.covid_19_help;




import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class RemediesActivity extends AppCompatActivity {

    TextView remediescontent1,remediescontent2;
    String remediestext1,remediestext2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedies);
        remediescontent1=findViewById(R.id.remediescontent1);
        remediescontent2=findViewById(R.id.remediescontent2);
        remediestext1="Home Remedies To Contour COVID-19\n";

        remediestext2= "The previous year has been amazingly hard for individuals. While the pandemic welcomed a genuinely necessary spotlight on wellbeing and cleanliness, it's anything but a great deal of disarray among individuals about what is useful for wellbeing and what isn't.\n" +
                "Here are a few cures that were embraced intensely however accomplished more mischief than anything:\n" +
                "\n" +
                "Drinking kadha's:\n\n" +
                "Normal fixings used to make kadha incorporate dark Pepper, Cinnamon, Turmeric, Giloy, Ashwagandha, Cardamom, and Ginger. While these are acceptable energizers during winters, these things make tremendous warmth in the body. Unreasonable utilization of these can be hurtful and cause issues like nose drain, persevering corrosiveness, lead to mouth ulcers and dark stools. While making kadhas, one must be incredibly cautious about the number of spices and flavors that are being utilized to make it, these can long haul impacts as well.\n" +
                "\n" +
                "Overconsumption of Ayurvedic health supplements: \n\n" +
                "While these are incredible homegrown cures used to reinforce invulnerability and improve the life span of an individual; these can't be the solitary safeguard against COVID19. Likewise, they can't be devoured excessively. These dependable enhancements ought to be taken as recommended; abuse may cause tenacious stomach-related problems and unpredictable defecation.\n" +
                "\n" +
                "Steam inward breath:\n\n" +
                "While steam inward breath is supposed to be a deep-rooted home solution for the normal cold, it can't help in battling an infection like COVID 19. Additionally, steam can cause expanding of the eyes, redness of the eye, dry eye, nonstop watering of the eye, and so on It can likewise influence the skin, and may even consume it when overexposed to steam. It likewise makes the skin on the face and neck dry, prompting parasitic or bacterial skin contaminations.\n" +
                "\n" +
                "Exorbitant admission of Zinc and Vitamin D and C enhancements:\n\n" +
                "Zinc was normally burned-through in the previous year. There is some proof that Zinc can assist with controlling the infection, yet once more, we need more proof to check the amount of supplement utilization. Undeniable degrees of Zinc can prompt a discouragement, as opposed to a fortified safe framework. FDA has additionally cautioned purchasers that Zinc nasal showers can prompt loss of smell! Nutrient D harmfulness is created when there is abundance admission. A high measure of Calcium in your blood (Hypercalcemia) can cause sickness, regurgitating, shortcoming, and incessant pee.\n" +
                "\n" +
                "Washing with sanitizers: \n\n" +
                "As soon as the pandemic hit us, individuals started to wash food with fade, applied family cleaning or sanitizer items to exposed skin, and purposefully breathed in or ingested the cleaners. Some even begun washing with sanitizers. There is sufficient proof that expresses that improper utilization of sanitizers can cause harm!\n" +
                "\n" +
                "You can increase your immunity by avoiding processed foods, eats ample fruits and vegetables, drink a minimum of eight glasses of water, exercise regularly, wash your hands, stay hygiene. The most important thing is to get vaccinated.\n" +
                " \n";

        remediescontent1.setText(remediestext1);
        remediescontent2.setText(remediestext2);



    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(RemediesActivity.this,
                Isolationtips.class);


        startActivity(i);
    }
}