package com.assign1.rfurrer.feelsbook.feeling;

import android.os.Parcel;

public class Sadness extends Mood {

    private static final String state = "Sadness";

    public Sadness() {
        super();
    }

    public Sadness(Parcel in) {
        super(in);
    }

    public static final Creator<Mood> CREATOR = new Creator<Mood>() {
        @Override
        public Mood createFromParcel(Parcel in) {
            return new Sadness(in);
        }

        @Override
        public Mood[] newArray(int size) {
            return new Mood[size];
        }
    };

    String format() {
        return state;
    }

    @Override
    public String toString(){
        return super.toString() + ": " +  this.format();
    }
}
