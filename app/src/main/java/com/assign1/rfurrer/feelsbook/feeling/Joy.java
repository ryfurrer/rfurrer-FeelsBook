package com.assign1.rfurrer.feelsbook.feeling;


/**
 * Created by rfurrer on 9/20/18.
 */

public class Joy extends Mood{

    private static final String state = "Joy";

    public Joy() {
        super();
    }

    String format() {
        return state;
    }

    @Override
    public String toString(){
        return super.toString() +" " + this.format();
    }


}

