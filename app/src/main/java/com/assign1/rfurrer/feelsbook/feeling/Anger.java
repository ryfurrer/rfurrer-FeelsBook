/**
 * love, joy, surprise, anger, sadness, and fear are things and as such they were made into
 * classes.
 * they have a superclass since they all fall under feelings
 *
 */
package com.assign1.rfurrer.feelsbook.feeling;

import android.os.Parcel;

public class Anger extends Mood {

    private static final String state = "Anger";

    public Anger() {
        super();
    }

    public Anger(Parcel in) {
        super(in);
    }

    public static final Creator<Mood> CREATOR = new Creator<Mood>() {
        @Override
        public Mood createFromParcel(Parcel in) {
            return new Anger(in);
        }

        @Override
        public Mood[] newArray(int size) {
            return new Mood[size];
        }
    };

    String format() {
        return state + '\n' + super.getComment();
    }

    @Override
    public String toString(){
        return super.toString() + ": " +  this.format();
    }
}
