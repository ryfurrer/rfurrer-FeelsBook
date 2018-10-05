/*
FeelingsList provides additional functionality to a arraylist of moods.

It handles requirements for lists of moods, like stats.
 */

package com.assign1.rfurrer.feelsbook.feeling;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FeelingsList extends ArrayList<Mood> {

    //stores the number of each class present in the arraylist
    private HashMap<Class, Integer> feelingCounts = new HashMap<Class, Integer>() {{
        put(Anger.class, 0);
        put(Joy.class, 0);
        put(Sadness.class, 0);
        put(Surprise.class, 0);
        put(Fear.class, 0);
        put(Love.class, 0);
    }};

    //overrided add and remove to force sorted and keep track of counts
    @Override
    public Mood remove(int index) {
        Mood m = super.get(index);
        feelingCounts.put(m.getClass(), (Integer) feelingCounts.get(m.getClass()) - 1);
        Mood ret =  super.remove(index);
        this.sort(); // keep sorted

        return ret;
    }

    @Override
    public boolean remove(Object m) {
        feelingCounts.put(m.getClass(), (Integer) feelingCounts.get(m.getClass()) - 1);
        boolean ret =  super.remove(m);
        this.sort(); // keep sorted

        return ret;
    }

    @Override
    public boolean add(Mood mood) {
        feelingCounts.put(mood.getClass(), (Integer) feelingCounts.get(mood.getClass()) + 1);

        boolean ret = super.add(mood);
        this.sort(); // keep sorted

        return ret;
    }

    public int getCount() {
        return this.size();
    }

    public void sort(){
        Collections.sort(this);
    }

    public String printStats() {
        String stats = "";
        for (Map.Entry<Class, Integer> entry : feelingCounts.entrySet()) {
            Log.d(entry.getKey().getName(), "printStats: " + entry.getValue());
            stats = stats + (entry.getKey().getSimpleName() + ": " + entry.getValue() + "\n");
        }
        return stats;
    }
}
