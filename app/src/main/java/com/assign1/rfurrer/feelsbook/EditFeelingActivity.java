/*
Each class must contain comments describing its purpose, design rationale, and any outstanding issues.
EditFeelingActivity is a screen of the app. It has a view and controllers to display functionality
for editing moods.

It's purpose is to be the gui for this.


Uses date time dialog code from
Android Date Time Picker Dialog,  ANUPAM CHUGH,
https://www.journaldev.com/9976/android-date-time-picker-dialog
 */


package com.assign1.rfurrer.feelsbook;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.assign1.rfurrer.feelsbook.exceptions.CommentTooLongException;
import com.assign1.rfurrer.feelsbook.feeling.Mood;

import java.util.Calendar;

public class EditFeelingActivity extends AppCompatActivity {
    public final static int id = 301;
    private Mood mood;
    private int position;
    private TextView txtDate;
    private TextView txtTime;
    private EditText editComment;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_feeling);

        // Get the Intent that started this activity and extract the mood
        Bundle data = getIntent().getExtras();
        mood = (Mood) data.getParcelable("mood");
        position = data.getInt("position");

        setupButtons();
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtTime = (TextView) findViewById(R.id.txtTime);
        editComment = (EditText) findViewById(R.id.editComment);
        txtDate.setText(mood.getDateAsString());
        txtTime.setText(mood.getTimeAsString());
        if (!mood.getComment().isEmpty())
            editComment.setText(mood.getComment());
    }


    private void setupButtons() {


        Button saveButton = findViewById(R.id.saveMood);
        Button deleteButton = findViewById(R.id.deleteMood);
        Button timeButton = findViewById(R.id.btnTime);
        Button dateButton = findViewById(R.id.btnDate);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Date", txtDate.getText().toString());
                Log.d("Date", txtTime.getText().toString());
                Log.d("Date", txtDate.toString()+'T'+txtTime.toString());
                mood.setDate(txtDate.getText().toString()+'T'+txtTime.getText().toString());
                try {
                    Log.d("Comment", editComment.getText().toString());
                    mood.setComment(editComment.getText().toString());
                } catch (CommentTooLongException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

                Intent resultIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDelete", false);
                bundle.putParcelable("mood", mood);
                bundle.putInt("position", position);
                resultIntent.putExtras(bundle);
                setResult(id, resultIntent);
                finish();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDelete", true);
                bundle.putParcelable("mood", mood);
                bundle.putInt("position", position);
                resultIntent.putExtras(bundle);
                setResult(id, resultIntent);
                finish();
            }
        });

        //code from https://www.journaldev.com/9976/android-date-time-picker-dialog
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mYear, mMonth, mDay, mHour, mMinute;
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(v.getContext(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                String time = "";
                                if (hourOfDay < 10) time = "0";
                                time = time + hourOfDay + ":";
                                if (minute < 10) time = time + "0";
                                time = time + minute + ":00";
                                txtTime.setText(time);
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();
            }
        });

        //code based from https://www.journaldev.com/9976/android-date-time-picker-dialog
        dateButton.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                int year = mood.getDate().getYear() + 1900;
                int month = mood.getDate().getMonth();
                int day = mood.getDate().getDate();

                datePickerDialog = new DatePickerDialog(v.getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                String text = year + "-";
                                if (monthOfYear < 9) text = text + "0";
                                text = text + (monthOfYear + 1) + "-";
                                if (dayOfMonth < 10) text = text + "0";
                                text = text + dayOfMonth;
                                txtDate.setText(text);

                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
