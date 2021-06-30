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
    TextView dietcontent1,dietcontent2;
    String diettext1,diettext2;
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


        dietcontent1=findViewById(R.id.dietcontent1);
        dietcontent2=findViewById(R.id.dietcontent2);
        diettext1="Diet During Home Isolation\n";

        diettext2= "If you are experiencing Covid-19 and are in home isolation, you must follow a balanced eating regimen apart from burning through recommended meds to recuperate soon. Weakness is one of the major results of battling the deadly infection and the deficiency of taste and smell frequently powers patients to refrain from eating on schedule.\n\n" +
                "Great nourishment is significant for wellbeing, especially on occasions when the insusceptible framework may have to retaliate. Restricted admittance to new food sources may bargain freedoms to keep eating a sound and changed eating regimen. It can likewise conceivably prompt an expanded utilization of profoundly prepared food varieties, which will, in general, be high in fats, sugars, and salt. Regardless, even with not many and restricted fixings, one can keep eating an eating regimen that upholds great wellbeing.\n\n" +
                "The accessibility of new food sources may diminish and it might in this way become important to depend more on canned, frozen, or handled food varieties. A significant number of these food varieties contain undeniable degrees of salt. You may likewise consider flushing canned food sources like vegetables and beans, to eliminate a portion of the overabundance of sodium. Know that cured food sources regularly contain significant degrees of sodium as well. In numerous nations, 50–75% of the salt admission comes from the food varieties we eat, instead of what we add ourselves. Given that you may be devouring sufficient salt as of now, abstain from adding additional salt when preparing and to your dinners at the table.\n\n" +
                "Fiber adds to a solid stomach-related framework and offers a delayed sensation of completion, which forestalls indulging. To guarantee a sufficient fiber consumption, intend to incorporate vegetables, organic product, beats and wholegrain food sources in all suppers. Wholegrains food sources incorporate oats, earthy colored pasta and rice, quinoa, and entire wheat bread and wraps, instead of refined grain food sources like white pasta and rice, and white bread.\n\n" +
                "Great hydration is essential for ideal wellbeing. At whatever point accessible and alright for utilization, the faucet water is the best and least expensive beverage. It is additionally the most practical, as it delivers no waste, contrasted with filtered water. Drinking water rather than sugar-improved refreshments is a straightforward method to restrict your admission of sugar and abundance calories. To improve its taste, new or frozen organic products like berries or cuts of citrus natural products might be added, just as cucumber or spices like mint, lavender, or rosemary. \n\n" +
                "Try not to drink a lot of solid espresso, solid tea, and particularly energized sodas and caffeinated drinks. These may prompt parchedness and can adversely affect your dozing designs.\n\n" +
                "The social removing related to the COVID-19 episode has implied that numerous families are investing more energy at home, which gives new freedoms to share suppers. Family dinners are a significant chance for guardians to be good examples for smart dieting, and for reinforcing family connections.\n\n";


        dietcontent1.setText(diettext1);
        dietcontent2.setText(diettext2);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(DietActivity.this,
                Isolationtips.class);


        startActivity(i);
    }
}