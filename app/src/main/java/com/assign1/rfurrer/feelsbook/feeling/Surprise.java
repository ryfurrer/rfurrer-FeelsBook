package com.assign1.rfurrer.feelsbook.feeling;

import android.os.Parcel;

public class Surprise extends Mood {

    private static final String state = "Surprise";

    public Surprise() {
        super();
    }

    public Surprise(Parcel in) {
        super(in);
    }

    String format() {
        return state;
    }

    public static final Creator<Mood> CREATOR = new Creator<Mood>() {
        @Override
        public Mood createFromParcel(Parcel in) {
            return new Surprise(in);
        }

        @Override
        public Mood[] newArray(int size) {
            return new Mood[size];
        }
    };

    @Override
    public String toString(){
        return super.toString() + ": " + this.format();
    }
}
