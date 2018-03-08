package com.example.android.narcolepsyquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        int score = 0;
        Bundle extras = getIntent().getExtras();

        if (extras != null){
            score = extras.getInt("TOTAL_SCORE");
        }

        // Makes a toast message with quiz score
        Toast.makeText(this, "Your total score is " + score + " out of 10.",
                Toast.LENGTH_SHORT).show();

        // button objects for main menu and learn more buttons
        Button selectMainButton = findViewById(R.id.main_menu_button);
        Button selectLearnButton = findViewById(R.id.learn_more_button);

        // User returns to main menu if main menu button clicked
        selectMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(QuizResultsActivity.this,MainActivity.class);
                startActivity(mainIntent);
            }
        });

        // User navigates to Learn page if Learn More is clicked
        selectLearnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent learnMoreIntent = new Intent(QuizResultsActivity.this,LearnActivity.class);
                startActivity(learnMoreIntent);
            }
        });
    }
}
