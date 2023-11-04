package com.cs407.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBoxHealthy, checkBoxEnergized, checkBoxReady;
    Button buttonGoToWork, buttonShowMyWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxHealthy = findViewById(R.id.checkBoxHealthy);
        checkBoxEnergized = findViewById(R.id.checkBoxEnergized);
        checkBoxReady = findViewById(R.id.checkBoxReady);
        buttonGoToWork = findViewById(R.id.buttonGoToWork);
        buttonShowMyWork = findViewById(R.id.buttonShowMyWork);

        CheckBox.OnCheckedChangeListener checkedChangeListener = (buttonView, isChecked) -> checkAllCheckboxes();

        checkBoxHealthy.setOnCheckedChangeListener(checkedChangeListener);
        checkBoxEnergized.setOnCheckedChangeListener(checkedChangeListener);
        checkBoxReady.setOnCheckedChangeListener(checkedChangeListener);

        buttonGoToWork.setOnClickListener(v -> goToWork());
        buttonShowMyWork.setOnClickListener(v -> showMyWork());
    }

    private void checkAllCheckboxes() {
        boolean allChecked = checkBoxHealthy.isChecked() && checkBoxEnergized.isChecked() && checkBoxReady.isChecked();
        buttonGoToWork.setEnabled(allChecked);
        buttonShowMyWork.setEnabled(allChecked);
    }

    private void goToWork() {
        if (buttonGoToWork.isEnabled()) {
            // Go to work logic
            Toast.makeText(this, "Going to work!", Toast.LENGTH_SHORT).show();
        } else {
            showCheckboxWarning();
        }
    }

    private void showMyWork() {
        if (buttonShowMyWork.isEnabled()) {
            // Show my work logic
            Toast.makeText(this, "Here is my work!", Toast.LENGTH_SHORT).show();
        } else {
            showCheckboxWarning();
        }
    }

    private void showCheckboxWarning() {
        Toast.makeText(this, "You need to check all boxes to continue", Toast.LENGTH_SHORT).show();
    }
}


