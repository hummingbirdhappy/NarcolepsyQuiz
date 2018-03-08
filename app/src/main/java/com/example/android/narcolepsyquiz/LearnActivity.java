package com.example.android.narcolepsyquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LearnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        // Button object for main menu button
        Button selectMainButton = findViewById(R.id.main_menu_button);

        // User returns to main menu if main menu button clicked
        selectMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(LearnActivity.this,MainActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}
