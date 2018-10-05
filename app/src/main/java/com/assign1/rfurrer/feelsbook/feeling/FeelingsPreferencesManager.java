/*
Each class must contain comments describing its purpose, design rationale, and any outstanding issues.
This class uses the shared preferences manager to store/load feelingsLists

Adapted from https://github.com/nklapste/lonelyTwitter/blob/9f8f86354105bc7719a90ffa2ab0325e9d369c84/app/src/main/java/ca/ualberta/cs/lonelytwitter/LonelyTwitterPreferencesManager.java
(Nathan klapstein - lonelyTwitter)
 */

package com.assign1.rfurrer.feelsbook.feeling;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class FeelingsPreferencesManager {
    private static final String NAME = "feelingsList";
    private static final String GSON_KEY = "feelingsListGson";

    public static void saveFeelings(Context context, ArrayList<Mood> feelings){
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Mood.class, new FeelingSerializer());


        editor.putString(GSON_KEY, gsonBuilder.create().toJson(feelings));
        editor.apply();
    }

    public static FeelingsList loadFeelings(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Mood.class, new FeelingSerializer());
        Gson gson = gsonBuilder.create();

        String jsonText = sharedPreferences.getString(GSON_KEY, "");

        if(jsonText.isEmpty()) {return new FeelingsList();}
        return gson.fromJson(jsonText, FeelingsList.class);
    }
}
