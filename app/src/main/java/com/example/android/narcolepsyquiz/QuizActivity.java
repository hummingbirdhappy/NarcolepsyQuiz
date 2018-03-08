package com.example.android.narcolepsyquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by huang on 3/2/2018.
 */

public class QuizActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);

        // Button object for start button
        Button startQuizButton = findViewById(R.id.quiz_start_button);

        // Navigates to questions when user clicks start button
        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent questionIntent = new Intent(QuizActivity.this,
                        QuestionActivity.class);
                startActivity(questionIntent);
            }
        }
        );
    }
}
