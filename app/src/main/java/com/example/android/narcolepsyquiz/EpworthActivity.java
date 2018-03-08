package com.example.android.narcolepsyquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class EpworthActivity extends AppCompatActivity {

    int scoreESS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epworth);

        // Submit button object
        Button submitButton = findViewById(R.id.submit_button);

        // Navigates to Epworth Results screen when submit button clicked
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent submitIntent = new Intent(EpworthActivity.this,EpworthResultsActivity.class);
                submitIntent.putExtra("ESS_SCORE",scoreESS);
                startActivity(submitIntent);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.s1_0:
                if (checked)
                    break;
            case R.id.s1_1:
                if (checked)
                    scoreESS += 1;
                    break;
            case R.id.s1_2:
                if (checked)
                    scoreESS += 2;
                break;
            case R.id.s1_3:
                if (checked)
                    scoreESS += 3;
                break;
            case R.id.s2_0:
                if (checked)
                    break;
            case R.id.s2_1:
                if (checked)
                    scoreESS += 1;
                break;
            case R.id.s2_2:
                if (checked)
                    scoreESS += 2;
                break;
            case R.id.s2_3:
                if (checked)
                    scoreESS += 3;
                break;
            case R.id.s3_0:
                if (checked)
                    break;
            case R.id.s3_1:
                if (checked)
                    scoreESS += 1;
                break;
            case R.id.s3_2:
                if (checked)
                    scoreESS += 2;
                break;
            case R.id.s3_3:
                if (checked)
                    scoreESS += 3;
                break;
            case R.id.s4_0:
                if (checked)
                    break;
            case R.id.s4_1:
                if (checked)
                    scoreESS += 1;
                break;
            case R.id.s4_2:
                if (checked)
                    scoreESS += 2;
                break;
            case R.id.s4_3:
                if (checked)
                    scoreESS += 3;
                break;
            case R.id.s5_0:
                if (checked)
                    break;
            case R.id.s5_1:
                if (checked)
                    scoreESS += 1;
                break;
            case R.id.s5_2:
                if (checked)
                    scoreESS += 2;
                break;
            case R.id.s5_3:
                if (checked)
                    scoreESS += 3;
                break;
            case R.id.s6_0:
                if (checked)
                    break;
            case R.id.s6_1:
                if (checked)
                    scoreESS += 1;
                break;
            case R.id.s6_2:
                if (checked)
                    scoreESS += 2;
                break;
            case R.id.s6_3:
                if (checked)
                    scoreESS += 3;
                break;
            case R.id.s7_0:
                if (checked)
                    break;
            case R.id.s7_1:
                if (checked)
                    scoreESS += 1;
                break;
            case R.id.s7_2:
                if (checked)
                    scoreESS += 2;
                break;
            case R.id.s7_3:
                if (checked)
                    scoreESS += 3;
                break;
            case R.id.s8_0:
                if (checked)
                    break;
            case R.id.s8_1:
                if (checked)
                    scoreESS += 1;
                break;
            case R.id.s8_2:
                if (checked)
                    scoreESS += 2;
                break;
            case R.id.s8_3:
                if (checked)
                    scoreESS += 3;
                break;
        }
    }
}
