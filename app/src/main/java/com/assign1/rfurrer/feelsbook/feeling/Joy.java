package com.assign1.rfurrer.feelsbook.feeling;


import android.os.Parcel;

/**
 * Created by rfurrer on 9/20/18.
 */

public class Joy extends Mood{

    private static final String state = "Joy";

    public Joy() {
        super();
    }

    public Joy(Parcel in) {
        super(in);
    }

    public static final Creator<Mood> CREATOR = new Creator<Mood>() {
        @Override
        public Mood createFromParcel(Parcel in) {
            return new Joy(in);
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
        return super.toString() + ": " + this.format();
    }


}

