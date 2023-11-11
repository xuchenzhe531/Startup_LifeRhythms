package com.cs407.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.Button;
import android.widget.DatePicker;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class ChoosePastScheduleTime extends AppCompatActivity {

    private int selectedYear;
    private int selectedMonth;
    private int selectedDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_past_schedule_time);

        // Initialize DatePicker and Buttons
        final DatePicker datePicker = findViewById(R.id.datePicker);
        Button backToStartButton = findViewById(R.id.buttonBackToStart);
        Button nextButton = findViewById(R.id.buttonNext);

        // Initialize the variables with the current date
        Calendar calendar = Calendar.getInstance();
        selectedYear = calendar.get(Calendar.YEAR);
        selectedMonth = calendar.get(Calendar.MONTH); // Note: Month is 0-based
        selectedDay = calendar.get(Calendar.DAY_OF_MONTH);

        // Set the current date as default in DatePicker
        datePicker.init(selectedYear, selectedMonth, selectedDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Update the variables when the user changes the date
                selectedYear = year;
                selectedMonth = monthOfYear; // Note: Month is 0-based
                selectedDay = dayOfMonth;
            }
        });

        backToStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Log the selected date or perform an action
                Log.i("DatePickerActivity", "Selected date: " + selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                // Perform action to "Back to Start"
                Intent intent = new Intent(ChoosePastScheduleTime.this, MainActivity.class);
                startActivity(intent);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Log the selected date or perform an action
                Log.i("DatePickerActivity", "Selected date: " + selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                // Perform action for "Next"
            }
        });
    }
}
