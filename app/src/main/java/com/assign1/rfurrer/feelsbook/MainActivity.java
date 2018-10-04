package com.assign1.rfurrer.feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.assign1.rfurrer.feelsbook.feeling.Anger;
import com.assign1.rfurrer.feelsbook.feeling.Fear;
import com.assign1.rfurrer.feelsbook.feeling.FeelingsList;
import com.assign1.rfurrer.feelsbook.feeling.Joy;
import com.assign1.rfurrer.feelsbook.feeling.Love;
import com.assign1.rfurrer.feelsbook.feeling.Mood;
import com.assign1.rfurrer.feelsbook.feeling.Sadness;
import com.assign1.rfurrer.feelsbook.feeling.Surprise;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText bodyText;
    private ListView feelings_list;
    private ArrayList<Mood> feelings = new ArrayList<Mood>();
    private ArrayAdapter<Mood> feelingsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feelings_list = (ListView) findViewById(R.id.feelings_list);

        //feelings_list.setOnItemClickListener

        setup();
    }

    private void setup() {
        feelingsAdapter = new ArrayAdapter<Mood>(this,
                R.layout.list_item, feelings);
        feelings_list.setAdapter(feelingsAdapter);

        Button joyButton = findViewById(R.id.joyButton);
        Button sadButton = findViewById(R.id.sadButton);
        Button fearButton = findViewById(R.id.fearButton);
        Button angerButton = findViewById(R.id.angerButton);
        Button loveButton = findViewById(R.id.loveButton);
        Button supriseButton = findViewById(R.id.supriseButton);

        joyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feelings.add(new Joy());
                feelingsAdapter.notifyDataSetChanged();
                FeelingsList.save(getApplicationContext(), feelings);
            }
        });
        sadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feelings.add(new Sadness());
                feelingsAdapter.notifyDataSetChanged();
                FeelingsList.save(getApplicationContext(), feelings);
            }
        });
        fearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feelings.add(new Fear());
                feelingsAdapter.notifyDataSetChanged();
                FeelingsList.save(getApplicationContext(), feelings);
            }
        });
        angerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("AngerClicked", feelings.toString());
                feelings.add(new Anger());
                feelingsAdapter.notifyDataSetChanged();
                FeelingsList.save(getApplicationContext(), feelings);
            }
        });
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feelings.add(new Love());
                feelingsAdapter.notifyDataSetChanged();
                FeelingsList.save(getApplicationContext(), feelings);
            }
        });
        supriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feelings.add(new Surprise());
                feelingsAdapter.notifyDataSetChanged();
                FeelingsList.save(getApplicationContext(), feelings);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        feelings_list.setAdapter(feelingsAdapter);
        feelings = FeelingsList.load(getApplicationContext());
        for (int i = 0; i < feelings.size(); i++) {
            Log.d("Mood:", feelings.get(i).getClass().getName());
        }
        feelingsAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void clearFeelings() {
        feelings = new ArrayList<Mood>();
        feelingsAdapter.notifyDataSetChanged();
        FeelingsList.save(getApplicationContext(), feelings);
    }
}
