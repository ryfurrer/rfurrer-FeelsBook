package com.assign1.rfurrer.feelsbook.feeling;

public class Surprise extends Mood {

    private static final String state = "Surprise";

    public Surprise() {
        super();
    }

    String format() {
        return state;
    }

    @Override
    public String toString(){
        return super.toString() + this.format();
    }
}
