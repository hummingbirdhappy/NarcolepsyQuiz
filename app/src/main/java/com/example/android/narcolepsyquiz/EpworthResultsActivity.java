package com.example.android.narcolepsyquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EpworthResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epworth_results);

        // Get extras ESS Score
        int scoreESS = 0;
        Bundle extras = getIntent().getExtras();

        if (extras != null){
            scoreESS = extras.getInt("ESS_SCORE");
        }

        // Display user's ESS Score
        TextView scoreView = (TextView) findViewById(R.id.epworth_score);
        scoreView.setText(String.format(String.valueOf(scoreESS)));

        // Display score range explanation based on user's ESS score
        if (scoreESS<=10){
            TextView explanationText = (TextView) findViewById(R.id.epworth_score_range);
            explanationText.setText(R.string.epworth_results_normal);
        }
        else if (scoreESS<=12){
            TextView explanationText = (TextView) findViewById(R.id.epworth_score_range);
            explanationText.setText(R.string.epworth_results_mild);
        }
        else if (scoreESS<=15){
            TextView explanationText = (TextView) findViewById(R.id.epworth_score_range);
            explanationText.setText(R.string.epworth_results_moderate);
        }
        else if (scoreESS<=24){
            TextView explanationText = (TextView) findViewById(R.id.epworth_score_range);
            explanationText.setText(R.string.epworth_results_severe);
        }

        // Button object for main menu button
        Button selectMainButton = findViewById(R.id.main_menu_button);

        // User returns to main menu if main menu button clicked
        selectMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(EpworthResultsActivity.this,MainActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}
