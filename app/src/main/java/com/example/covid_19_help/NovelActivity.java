package com.example.covid_19_help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class NovelActivity extends AppCompatActivity {


    TextView novelcontent1,novelcontent2;
    String noveltext1,noveltext2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);
        novelcontent1=findViewById(R.id.novelcontent1);
        novelcontent2=findViewById(R.id.novelcontent2);
        noveltext1="Best Novels to Read\n" ;

        noveltext2="Companions, it's actual: the decade's end approaches. It's anything but a troublesome, anxiety-inciting, morally undermined decade, yet at least it's been populated by some damn fine literature. We'll take our silver linings where we can. \n\n" +
                "Thus, as is our hallowed obligation as a literary and culture site—however with full awareness of the potentially unproductive and interminably contestable nature of the task—in the coming weeks, we'll be taking a glance at the best and generally important (these being not always the same) books of the decade that was. We will do this, obviously, through a variety of records.\n\n" +
                "The Kite Runner by Khaled Hosseini Kite Runner is a moving story of a far-fetched kinship between a wealthy kid and the child of his father's servant. Set in Afghanistan during a period of tragedy and obliteration, this unforgettable novel will have you snared from start to wrap up\n\n" +
                " \n\n" +
                "1.\tPride and Prejudice by Jane Austen: \n\n" +
                "The initial line of this exemplary novel, \"It's anything but a reality generally recognized that a solitary man possessing a favorable luck should need a spouse\" is quite possibly the most unmistakable first line of fiction. Pride and Prejudice stay perhaps the most suffering works of English Literature not because we discover such compensating joy in watching flashes fly between Elizabeth Bennet and Mr. Darcy. Perusers embrace the novel since Austen candidly catches the human person with the entirety of its wonders and its flaws. Pride and Prejudice is a novel about conquering contrasts of caste and class, about figuring out how to snicker at life in any event, when it's terribly out of line, and about perceiving that caring for somebody frequently implies tolerating them despite instead of in light of what their identity is.\n" +
                " \n" +
                "2.\tLittle Women by Louisa May Alcott:\n\n" +
                "This is a tale of four sisters with their own totally different and exceptionally unmistakable personalities. The tale draws the reader profound into their lives as we become more acquainted with each of their flaws, delights, battles, and fears.\n" +
                " \n" +
                "3.\tTo Kill a Mockingbird by Harper Lee\n\n" +
                "The epic examines racism in the American South through the blameless wide eyes of a sharp young lady named Jean Louise (\"Scout\") Finch. Its famous characters, most notably the sympathetic and just lawyer and father Atticus Finch, filled in as good examples and changed viewpoints in the United States when pressures regarding race were intense. To Kill a Mockingbird earned the Pulitzer Prize for fiction in 1961 and was made into an Academy Award-winning film in 1962, giving the story and its characters further life and impact over the American social circle.\n" +
                " \n" +
                "At the point when we read a book, we venture into another person's perspective, see the world through another person's eyes, and visit places. Books teach us about adoration, heartbreak, companionship, war, social unfairness, and the versatility of the human soul\n\n";


        novelcontent1.setText(noveltext1);
        novelcontent2.setText(noveltext2);



    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(NovelActivity.this,
               Isolationtips.class);


        startActivity(i);
    }
}