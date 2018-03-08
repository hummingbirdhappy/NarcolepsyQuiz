package com.example.android.narcolepsyquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // button objects
        Button selectQuizButton = findViewById(R.id.quiz_button);
        Button selectLearnButton = findViewById(R.id.learn_button);
        Button selectEpworthButton = findViewById(R.id.epworth_button);

        // Navigates to Epworth Sleepiness Scale screen when epworth button clicked
        selectEpworthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent epworthIntent = new Intent(MainActivity.this,EpworthActivity.class);
                startActivity(epworthIntent);
            }
        });

        // Navigates to quiz start screen when quiz button clicked
        selectQuizButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent quizIntent = new Intent(MainActivity.this,QuizActivity.class);
                startActivity(quizIntent);
            }
        }
        );

        // Navigates to learn screen when learn button clicked
        selectLearnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent learnIntent = new Intent(MainActivity.this,LearnActivity.class);
                startActivity(learnIntent);
            }
        });
    }
}
