package com.cs407.myapplication;

import android.content.Intent;
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

        buttonGoToWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allCheckBoxesChecked()) {
                    // Launch an activity for GoToWork
                    Intent intent = new Intent(MainActivity.this, DateSelectionActivity.class);
                    startActivity(intent);
                } else {
                    showCheckboxWarning();
                }
            }
        });

        buttonShowMyWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allCheckBoxesChecked()) {
                    // Launch an activity for ShowMyWork
                    //Intent intent = new Intent(MainActivity.this, ShowMyWorkActivity.class);
                    //startActivity(intent);
                } else {
                    showCheckboxWarning();
                }
            }
        });

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allCheckBoxesChecked()) {
                    // Launch an activity for Start
                    //Intent intent = new Intent(MainActivity.this, StartActivity.class);
                    //startActivity(intent);
                } else {
                    showCheckboxWarning();
                }
            }
        });
    }

    private boolean allCheckBoxesChecked() {
        return checkBoxHealthy.isChecked() && checkBoxEnergized.isChecked() && checkBoxReady.isChecked();
    }

    private void showCheckboxWarning() {
        Toast.makeText(MainActivity.this, "You need to check all boxes to continue!", Toast.LENGTH_SHORT).show();
    }
}




