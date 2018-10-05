package com.assign1.rfurrer.feelsbook.feeling;

import java.util.ArrayList;

public class FeelingsList extends ArrayList<Mood>{


//    private ArrayList<Class> feelingClasses = new ArrayList<Class>(){{
//        add(Anger.class);
//        add(Joy.class);
//        add(Sadness.class);
//        add(Surprise.class);
//        add(Fear.class);
//        add(Love.class);
//    }};
//    private ArrayList<ArrayList<T>> feelingLists = new ArrayList<ArrayList<T>>();
//
//
//    public ArrayList<Class> getFeelingClasses() {
//        return feelingClasses;
//    }
//
//    public void addFeelingClass(T mood) {
//        feelingClasses.add(mood.getClass());
//    }


    public static int getTally(Class c, ArrayList<Mood> feelings) {
        int count = 0;
        for (Mood m: feelings) {
            if (c.isInstance(m)) {
                count++;
            }
        }
        return count;
    }

    public int getCount() {
        return this.size();
    }
}
