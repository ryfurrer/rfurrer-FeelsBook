package com.assign1.rfurrer.feelsbook.feeling;

public class Fear extends Mood {

    private static final String state = "Fear";

    public Fear() {
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
