package com.assign1.rfurrer.feelsbook.feeling;

public class Sadness extends Mood {

    private static final String state = "Sadness";

    public Sadness() {
        super();
    }

    String format() {
        return state;
    }

    @Override
    public String toString(){
        return super.toString() + " " +  this.format();
    }
}
