package com.assign1.rfurrer.feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.assign1.rfurrer.feelsbook.feeling.Anger;
import com.assign1.rfurrer.feelsbook.feeling.Fear;
import com.assign1.rfurrer.feelsbook.feeling.FeelingsPreferencesManager;
import com.assign1.rfurrer.feelsbook.feeling.Joy;
import com.assign1.rfurrer.feelsbook.feeling.Love;
import com.assign1.rfurrer.feelsbook.feeling.Mood;
import com.assign1.rfurrer.feelsbook.feeling.Sadness;
import com.assign1.rfurrer.feelsbook.feeling.Surprise;

public class EditFeelingActivity extends AppCompatActivity {
    public final static int id = 301;
    private Mood mood;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_feeling);

        // Get the Intent that started this activity and extract the mood
        Bundle data = getIntent().getExtras();
        mood = (Mood) data.getParcelable("mood");
        position = data.getInt("position");
        setupButtons();
    }


    private void setupButtons() {


        Button saveButton = findViewById(R.id.saveMood);
        Button deleteButton = findViewById(R.id.deleteMood);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Test", "onClick: Save");
                Intent resultIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDelete", false);
                bundle.putInt("position", position);
                resultIntent.putExtra("mood", mood);
                setResult(id, resultIntent);
                finish();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Test", "onClick: Delete");
                Intent resultIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDelete", true);
                bundle.putInt("position", position);
                resultIntent.putExtra("mood", mood);
                setResult(id, resultIntent);
                finish();
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
    }
}
