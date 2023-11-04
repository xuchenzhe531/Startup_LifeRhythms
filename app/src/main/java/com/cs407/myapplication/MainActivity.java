package com.cs407.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxHealthy, checkBoxEnergized, checkBoxReady;
    private Button buttonGoToWork, buttonShowMyWork, buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxHealthy = findViewById(R.id.checkBoxHealthy);
        checkBoxEnergized = findViewById(R.id.checkBoxEnergized);
        checkBoxReady = findViewById(R.id.checkBoxReady);

        buttonGoToWork = findViewById(R.id.buttonGoToWork);
        buttonShowMyWork = findViewById(R.id.buttonShowMyWork);
        buttonStart = findViewById(R.id.buttonStart);

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxHealthy.isChecked() && checkBoxEnergized.isChecked() && checkBoxReady.isChecked()) {
                    // Here you can add your intent to go to another activity or any other logic you want.
                    Toast.makeText(MainActivity.this, "Proceeding...", Toast.LENGTH_SHORT).show();
                } else {
                    // Show a message if all checkboxes are not checked
                    Toast.makeText(MainActivity.this, "You need to check all boxes to continue!", Toast.LENGTH_SHORT).show();
                }
            }
        };

        // Set the same click listener for all buttons
        buttonGoToWork.setOnClickListener(buttonClickListener);
        buttonShowMyWork.setOnClickListener(buttonClickListener);
        buttonStart.setOnClickListener(buttonClickListener);
    }
}


