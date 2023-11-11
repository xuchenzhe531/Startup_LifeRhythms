package com.cs407.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.Locale;
import android.widget.AdapterView;


public class InsertActivity extends AppCompatActivity {

    private LinearLayout timeSlotsContainer;
    private Button backButton;
    private String[] activityTypes = new String[] {"Meeting", "Lunch", "Gym", "Study", "Break"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        timeSlotsContainer = findViewById(R.id.timeSlotsContainer);
        backButton = findViewById(R.id.backButton);

        addNewTimeSlot(); // Add the first time slot when the activity is created

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewTimeSlot();
            }
        });

        backButton.setOnClickListener(v -> {
            // Intent to go back to MainActivity
            Intent intent = new Intent(InsertActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
/*
    private void addNewTimeSlot() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View timeSlotView = inflater.inflate(R.layout.time_slot, timeSlotsContainer, false);

        setupSpinner((Spinner) timeSlotView.findViewById(R.id.startTimeSpinner), "Start Time");
        setupSpinner((Spinner) timeSlotView.findViewById(R.id.endTimeSpinner), "End Time");

        timeSlotsContainer.addView(timeSlotView);
    }

    private void setupSpinner(Spinner spinner, String title) {
        List<String> times = new ArrayList<>();
        times.add(title); // This is the default item that will show as the title

        // Populate the times list with actual times or generate programmatically
        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute += 30) { // As an example, increments of 30 minutes
                times.add(String.format("%02d:%02d", hour, minute));
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, times);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }*/
private void addNewTimeSlot() {
    final View timeSlotView = LayoutInflater.from(this).inflate(R.layout.time_slot, timeSlotsContainer, false);
    Button startTimeButton = timeSlotView.findViewById(R.id.startTimeButton);
    Button endTimeButton = timeSlotView.findViewById(R.id.endTimeButton);
    Spinner activityTypeSpinner = timeSlotView.findViewById(R.id.activityTypeSpinner);

    startTimeButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showTimePickerDialog((Button) v, null, false);
        }
    });

    endTimeButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showTimePickerDialog((Button) v, startTimeButton, true);
        }
    });

    // Set up the Activity Type spinner
    ArrayAdapter<String> activityTypeAdapter = new ArrayAdapter<>(
            this, android.R.layout.simple_spinner_item, activityTypes);
    activityTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    activityTypeSpinner.setAdapter(activityTypeAdapter);

    // Listener for spinner selection
    activityTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            // Prevent "Activity" from being selected after an actual activity has been chosen
            if (position == 0) {
                activityTypeSpinner.setSelection(parent.getSelectedItemPosition());
            } else {
                // Your code here for when an actual activity is selected
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // Required method, you might not need to implement anything here
        }
    });


    timeSlotsContainer.addView(timeSlotView);
}

    private void showTimePickerDialog(final Button timeButton, final Button startTimeButton, final boolean isEndTime) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view, selectedHour, selectedMinute) -> {
            // Format the chosen time and set it as the button text
            if (isEndTime) {
                // Parse start time from the startTimeButton
                String startTime = startTimeButton.getText().toString();
                String[] parts = startTime.split(":");
                int startHour = Integer.parseInt(parts[0]);
                int startMinute = Integer.parseInt(parts[1]);

                // Check if the end time is after the start time
                if (selectedHour < startHour || (selectedHour == startHour && selectedMinute <= startMinute)) {
                    // Show an error message
                    Toast.makeText(this, "End time must be later than start time.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
            String formattedTime = String.format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute);
            timeButton.setText(formattedTime);
        }, hour, minute, true); // true for 24-hour time format

        timePickerDialog.show();
    }
}