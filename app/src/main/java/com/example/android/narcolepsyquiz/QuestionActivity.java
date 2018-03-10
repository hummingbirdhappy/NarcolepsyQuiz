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
import android.widget.RadioGroup;
import android.widget.ViewFlipper;

public class QuestionActivity extends AppCompatActivity {

    int currentQuestion = 1;
    int quizScore = 0;

    boolean q1, q2, q3, q4, q5, q6, q7, q8, q9, q10;

    ViewFlipper questionFlipper;

    CheckBox q2_answer1, q2_answer2, q2_answer3, q2_answer4, q2_answer5, q5_answer1, q5_answer2,
            q5_answer3, q5_answer4;

    RadioGroup q1_rg1, q1_rg2, q3_rg1, q3_rg2, q8_rg1, q8_rg2, q10_rg1, q10_rg2;

    EditText q9_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // If not null, retrieve quiz score
        if ((savedInstanceState != null)){
            quizScore = savedInstanceState.getInt("quizScore");
            q1 = savedInstanceState.getBoolean("q1");
            q2 = savedInstanceState.getBoolean("q2");
            q3 = savedInstanceState.getBoolean("q3");
            q4 = savedInstanceState.getBoolean("q4");
            q5 = savedInstanceState.getBoolean("q5");
            q6 = savedInstanceState.getBoolean("q6");
            q7 = savedInstanceState.getBoolean("q7");
            q8 = savedInstanceState.getBoolean("q8");
            q9 = savedInstanceState.getBoolean("q9");
            q10 = savedInstanceState.getBoolean("q10");
        }
        setContentView(R.layout.activity_question);

        // Get the ViewFlipper for all questions
        questionFlipper = findViewById( R.id.question_flipper);

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

        // Get all RadioGroups
        q1_rg1 = findViewById(R.id.q1_rg1);
        q1_rg2 = findViewById(R.id.q1_rg2);
        q3_rg1 = findViewById(R.id.q3_rg1);
        q3_rg2 = findViewById(R.id.q3_rg2);
        q8_rg1 = findViewById(R.id.q8_rg1);
        q8_rg2 = findViewById(R.id.q8_rg2);
        q10_rg1 = findViewById(R.id.q10_rg1);
        q10_rg2 = findViewById(R.id.q10_rg2);

        // Start fresh, with no selection on either RadioGroup of a question
        q1_rg1.clearCheck();
        q1_rg2.clearCheck();
        q3_rg1.clearCheck();
        q3_rg2.clearCheck();
        q8_rg1.clearCheck();
        q8_rg2.clearCheck();
        q10_rg1.clearCheck();
        q10_rg2.clearCheck();

        // Makes the two RadioGroups of a question work as one
        q1_rg1.setOnCheckedChangeListener(q1Listener1);
        q1_rg2.setOnCheckedChangeListener(q1Listener2);
        q3_rg1.setOnCheckedChangeListener(q3Listener1);
        q3_rg2.setOnCheckedChangeListener(q3Listener2);
        q8_rg1.setOnCheckedChangeListener(q8Listener1);
        q8_rg2.setOnCheckedChangeListener(q8Listener2);
        q10_rg1.setOnCheckedChangeListener(q10Listener1);
        q10_rg2.setOnCheckedChangeListener(q10Listener2);

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
                }
            }
        }
        );

        // When next button is pressed
        checkQuestionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (currentQuestion < 10) {
                    // Flips to next view
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

    /*
    *Save UI state changes to the savedInstanceState.
    *This bundle will be passed to onCreate if the process is
    * killed and restarted.
    */
    @Override
    protected void onSaveInstanceState(Bundle vars){
        super.onSaveInstanceState(vars);
        vars.putInt("quizScore",quizScore);
        vars.putBoolean("q1",q1);
        vars.putBoolean("q2",q2);
        vars.putBoolean("q3",q3);
        vars.putBoolean("q4",q4);
        vars.putBoolean("q5",q5);
        vars.putBoolean("q6",q6);
        vars.putBoolean("q7",q7);
        vars.putBoolean("q8",q8);
        vars.putBoolean("q9",q9);
        vars.putBoolean("q10",q10);
    }

    private RadioGroup.OnCheckedChangeListener q1Listener1 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                q1_rg2.setOnCheckedChangeListener(null); // remove the listener before clearing so we don't throw that stackoverflow exception(like Vladimir Volodin pointed out)
                q1_rg2.clearCheck(); // clear the second RadioGroup!
                q1_rg2.setOnCheckedChangeListener(q1Listener2); //reset the listener
            }
        }
    };


    private RadioGroup.OnCheckedChangeListener q1Listener2 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                q1_rg1.setOnCheckedChangeListener(null);
                q1_rg1.clearCheck();
                q1_rg1.setOnCheckedChangeListener(q1Listener1);
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener q3Listener1 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                q3_rg2.setOnCheckedChangeListener(null); // remove the listener before clearing so we don't throw that stackoverflow exception(like Vladimir Volodin pointed out)
                q3_rg2.clearCheck(); // clear the second RadioGroup!
                q3_rg2.setOnCheckedChangeListener(q3Listener2); //reset the listener
            }
        }
    };


    private RadioGroup.OnCheckedChangeListener q3Listener2 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                q3_rg1.setOnCheckedChangeListener(null);
                q3_rg1.clearCheck();
                q3_rg1.setOnCheckedChangeListener(q3Listener1);
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener q8Listener1 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                q8_rg2.setOnCheckedChangeListener(null); // remove the listener before clearing so we don't throw that stackoverflow exception(like Vladimir Volodin pointed out)
                q8_rg2.clearCheck(); // clear the second RadioGroup!
                q8_rg2.setOnCheckedChangeListener(q8Listener2); //reset the listener
            }
        }
    };


    private RadioGroup.OnCheckedChangeListener q8Listener2 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                q8_rg1.setOnCheckedChangeListener(null);
                q8_rg1.clearCheck();
                q8_rg1.setOnCheckedChangeListener(q8Listener1);
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener q10Listener1 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                q10_rg2.setOnCheckedChangeListener(null); // remove the listener before clearing so we don't throw that stackoverflow exception(like Vladimir Volodin pointed out)
                q10_rg2.clearCheck(); // clear the second RadioGroup!
                q10_rg2.setOnCheckedChangeListener(q10Listener2); //reset the listener
            }
        }
    };


    private RadioGroup.OnCheckedChangeListener q10Listener2 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                q10_rg1.setOnCheckedChangeListener(null);
                q10_rg1.clearCheck();
                q10_rg1.setOnCheckedChangeListener(q10Listener1);
            }
        }
    };

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
