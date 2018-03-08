package com.example.android.narcolepsyquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.ViewFlipper;

public class QuestionActivity extends AppCompatActivity {

    int currentQuestion = 1;
    int quizScore = 0;

    boolean q1, q2, q3, q4, q5, q6, q7, q8, q9, q10;

    CheckBox q2_answer1, q2_answer2, q2_answer3, q2_answer4, q2_answer5, q5_answer1, q5_answer2,
            q5_answer3, q5_answer4;

    EditText q9_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Get all checkboxes
        q2_answer1 = findViewById(R.id.q2_answer1);
        q2_answer2 = findViewById(R.id.q2_answer2);
        q2_answer3 = findViewById(R.id.q2_answer3);
        q2_answer4 = findViewById(R.id.q2_answer4);
        q2_answer5 = findViewById(R.id.q2_answer5);
        q5_answer1 = findViewById(R.id.q5_answer1);
        q5_answer2 = findViewById(R.id.q5_answer2);
        q5_answer3 = findViewById(R.id.q5_answer3);
        q5_answer4 = findViewById(R.id.q5_answer4);

        // ProgressBar object
        final ProgressBar quizProgressBar = findViewById(R.id.determinateBar);

        // Button object for check button
        Button checkQuestionButton = findViewById(R.id.check_button);

        // Get user input for 9th question
        q9_field = findViewById(R.id.q9_field);

        // Sets a TextWatcher for Question 9
        q9_field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String q9_answer = q9_field.getText().toString();
                if (q9_answer.equals("Hypocretins")) {
                    q9 = true;
                    return;
                }
            }
        }
        );

        // When next button is pressed
        checkQuestionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (currentQuestion < 10) {
                    // Flips to next view
                    ViewFlipper questionFlipper = (ViewFlipper) findViewById( R.id.question_flipper);
                    questionFlipper.showNext();
                    // Changes the number of the current question
                    currentQuestion += 1;
                    // Increases amount of progress in progress bar
                    quizProgressBar.incrementProgressBy(10);
                }

                else if (currentQuestion == 10) {
                    // Navigates to quiz results screen
                    int score = keepScore();
                    Intent quizResultsIntent = new Intent(QuestionActivity.this, QuizResultsActivity.class);
                    quizResultsIntent.putExtra("TOTAL_SCORE", score);
                    startActivity(quizResultsIntent);
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.q1_answer1:
                q1 = checked;
                break;
            case R.id.q3_answer2:
                q3 = checked;
                break;
            case R.id.q4_answer1:
                q4 = checked;
                break;
            case R.id.q6_answer2:
                q6 = checked;
                break;
            case R.id.q7_answer1:
                q7 = checked;
                break;
            case R.id.q8_answer3:
                q8 = checked;
                break;
            case R.id.q10_answer3:
                q10 = checked;
                break;
            default:
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkboxes were clicked
        switch(view.getId()) {
            case R.id.q2_answer1:
            case R.id.q2_answer2:
            case R.id.q2_answer3:
            case R.id.q2_answer4:
            case R.id.q2_answer5:
                q2 = q2_answer1.isChecked() && q2_answer2.isChecked() && q2_answer3.isChecked() &&
                        q2_answer4.isChecked() && !q2_answer5.isChecked();
            case R.id.q5_answer1:
            case R.id.q5_answer2:
            case R.id.q5_answer3:
            case R.id.q5_answer4:
                q5 = q5_answer2.isChecked() && q5_answer3.isChecked() && q5_answer4.isChecked() &&
                        !q5_answer1.isChecked();
            default:
                break;
        }
    }

    /*
    * This method keeps the quiz score based on booleans
     */
    private int keepScore(){
        if (q1) {
            quizScore++;
        }
        if (q2) {
            quizScore++;
        }
        if (q3) {
            quizScore++;
        }
        if (q4) {
            quizScore++;
        }
        if (q5) {
            quizScore++;
        }
        if (q6) {
            quizScore++;
        }
        if (q7) {
            quizScore++;
        }
        if (q8) {
            quizScore++;
        }
        if (q9) {
            quizScore++;
        }
        if (q10) {
            quizScore++;
        }

        return quizScore;
    }
}
