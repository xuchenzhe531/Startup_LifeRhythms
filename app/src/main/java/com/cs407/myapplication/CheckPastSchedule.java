package com.cs407.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;

public class CheckPastSchedule extends AppCompatActivity {

    private CheckBox checkBox;
    private Button backButton;
    private Button nextButton;
    private boolean isCheckBoxChecked;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_past_schedule); // make sure you have a corresponding layout XML file.

        checkBox = findViewById(R.id.checkbox_import_schedule);
        backButton = findViewById(R.id.button_back_to_start);
        nextButton = findViewById(R.id.button_next);

        // Set a listener for the checkbox
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Store the checkbox status in a variable
            isCheckBoxChecked = isChecked;
        });

        // Set a listener for the back button
        backButton.setOnClickListener(v -> {
            // Intent to go back to MainActivity
            Intent intent = new Intent(CheckPastSchedule.this, MainActivity.class);
            startActivity(intent);
        });

        // Set a listener for the next button
        nextButton.setOnClickListener(v -> {
            // Proceed to the next activity or whatever needs to be done next
            // You can also pass the state of 'isCheckBoxChecked' if needed
        });
    }
}

