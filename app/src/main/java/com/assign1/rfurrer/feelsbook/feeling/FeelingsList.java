package com.assign1.rfurrer.feelsbook.feeling;

import android.content.Context;
import android.content.SharedPreferences;

import com.assign1.rfurrer.feelsbook.feeling.Anger;
import com.assign1.rfurrer.feelsbook.feeling.Joy;
import com.assign1.rfurrer.feelsbook.feeling.Love;
import com.assign1.rfurrer.feelsbook.feeling.Mood;
import com.assign1.rfurrer.feelsbook.feeling.Sadness;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class FeelingsList<T extends Mood> {

    private static final String NAME = "feelingsList";
    private static final String GSON_KEY = "feelingsListGson";

    public static void save(Context context, ArrayList<Mood> feelings){
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        editor.putString(GSON_KEY, gson.toJson(feelings));
        editor.apply();
    }

    public static ArrayList<Mood> load(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        String jsonText = sharedPreferences.getString(GSON_KEY, "");

        if(jsonText.isEmpty()) {return new ArrayList<Mood>();}
        return gson.fromJson(jsonText, (new TypeToken<ArrayList<Mood>>(){}).getType());
    }


    public static Mood convertMood(Mood m){
        return m;
    }

    public static int getTally(Class c, ArrayList<Mood> feelings) {
        int count = 0;
        for (Mood m: feelings) {
            if (c.isInstance(m)) {
                count++;
            }
        }
        return count;
    }

    public static int getSadTally(ArrayList<Mood> feelings) {
        int count = 0;
        for (Mood m: feelings) {
            if (Sadness.class.isInstance(m)) {
                count++;
            }
        }
        return count;
    }

    public static int getJoyTally(ArrayList<Mood> feelings) {
        int count = 0;
        for (Mood m: feelings) {
            if (Joy.class.isInstance(m)) {
                count++;
            }
        }
        return count;
    }

    public static int getAngerTally(ArrayList<Mood> feelings) {
        int count = 0;
        for (Mood m: feelings) {
            if (Anger.class.isInstance(m)) {
                count++;
            }
        }
        return count;
    }

    public static int getFearTally(ArrayList<Mood> feelings) {
        int count = 0;
        for (Mood m: feelings) {
            if (Fear.class.isInstance(m)) {
                count++;
            }
        }
        return count;
    }

    public static int getLoveTally(ArrayList<Mood> feelings) {
        int count = 0;
        for (Mood m: feelings) {
            if (Love.class.isInstance(m)) {
                count++;
            }
        }
        return count;
    }

    public static int getSupriseTally(ArrayList<Mood> feelings) {
        int count = 0;
        for (Mood m: feelings) {
            if (Surprise.class.isInstance(m)) {
                count++;
            }
        }
        return count;
    }
}
