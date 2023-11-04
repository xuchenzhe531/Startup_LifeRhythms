package com.cs407.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import androidx.appcompat.app.AppCompatActivity;

public class DateSelectionActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Button buttonBackToStart, buttonNext;
    private String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);

        datePicker = findViewById(R.id.datePicker);
        buttonBackToStart = findViewById(R.id.buttonBackToStart);
        buttonNext = findViewById(R.id.buttonNext);

        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Save the selected date in a variable
                selectedDate = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
            }
        });

        buttonBackToStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the "Back to Start" button click, e.g., navigate back to the previous activity
                finish();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the "Next" button click, e.g., navigate to the next activity or perform other actions
                // You can use the selectedDate variable here to access the chosen date
            }
        });
    }
}
