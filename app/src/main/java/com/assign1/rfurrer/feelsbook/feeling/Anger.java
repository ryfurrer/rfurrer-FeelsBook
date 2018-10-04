package com.assign1.rfurrer.feelsbook.feeling;

public class Anger extends Mood {

    private static final String state = "Anger";

    public Anger() {
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
