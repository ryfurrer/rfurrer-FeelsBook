package com.assign1.rfurrer.feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.assign1.rfurrer.feelsbook.adapters.FeelingListAdapter;
import com.assign1.rfurrer.feelsbook.feeling.Anger;
import com.assign1.rfurrer.feelsbook.feeling.Fear;
import com.assign1.rfurrer.feelsbook.feeling.FeelingsList;
import com.assign1.rfurrer.feelsbook.feeling.FeelingsPreferencesManager;
import com.assign1.rfurrer.feelsbook.feeling.Joy;
import com.assign1.rfurrer.feelsbook.feeling.Love;
import com.assign1.rfurrer.feelsbook.feeling.Mood;
import com.assign1.rfurrer.feelsbook.feeling.Sadness;
import com.assign1.rfurrer.feelsbook.feeling.Surprise;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FeelingsList feelings = new FeelingsList();
    private FeelingListAdapter feelingsAdapter;
    private ListView feelings_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        feelings_list = (ListView) findViewById(R.id.feelings_list);
        feelingsAdapter = new FeelingListAdapter(this, R.layout.list_item, feelings);
        feelings_list.setAdapter(feelingsAdapter);

        //feelings_list.setOnItemClickListener

        setupButtons();
    }

    private void setupButtons() {


        Button joyButton = findViewById(R.id.joyButton);
        Button sadButton = findViewById(R.id.sadButton);
        Button fearButton = findViewById(R.id.fearButton);
        Button angerButton = findViewById(R.id.angerButton);
        Button loveButton = findViewById(R.id.loveButton);
        Button supriseButton = findViewById(R.id.supriseButton);

        joyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Adapter", ""+feelingsAdapter.getCount());
                feelings.add(new Joy());
                FeelingsPreferencesManager.saveFeelings(getApplicationContext(), feelings);
                feelingsAdapter.notifyDataSetChanged();
                Log.d("Adapter", ""+feelingsAdapter.getCount());
            }
        });
        sadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feelings.add(new Sadness());
                feelingsAdapter.notifyDataSetChanged();
                FeelingsPreferencesManager.saveFeelings(getApplicationContext(), feelings);
            }
        });
        fearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feelings.add(new Fear());
                feelingsAdapter.notifyDataSetChanged();
                FeelingsPreferencesManager.saveFeelings(getApplicationContext(), feelings);
            }
        });
        angerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feelings.add(new Anger());
                feelingsAdapter.notifyDataSetChanged();
                FeelingsPreferencesManager.saveFeelings(getApplicationContext(), feelings);
            }
        });
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feelings.add(new Love());
                feelingsAdapter.notifyDataSetChanged();
                FeelingsPreferencesManager.saveFeelings(getApplicationContext(), feelings);
            }
        });
        supriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feelings.add(new Surprise());
                feelingsAdapter.notifyDataSetChanged();
                FeelingsPreferencesManager.saveFeelings(getApplicationContext(), feelings);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        feelingsAdapter = new FeelingListAdapter(this, R.layout.list_item, feelings);
        feelings_list.setAdapter(feelingsAdapter);
        feelings = FeelingsPreferencesManager.loadFeelings(getApplicationContext());
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
        feelings = new FeelingsList();
        feelingsAdapter.notifyDataSetChanged();
        FeelingsPreferencesManager.saveFeelings(getApplicationContext(), feelings);
    }
}
