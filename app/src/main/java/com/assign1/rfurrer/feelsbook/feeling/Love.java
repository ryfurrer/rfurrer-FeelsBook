package com.assign1.rfurrer.feelsbook.feeling;

public class Love extends Mood {

    private static final String state = "Love";

    public Love() {
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
