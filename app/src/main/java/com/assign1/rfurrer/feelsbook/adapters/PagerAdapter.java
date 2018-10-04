//package com.assign1.rfurrer.feelsbook.adapters;
//
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentStatePagerAdapter;
//
//import com.assign1.rfurrer.feelsbook.feeling.AddFeelings;
//import com.assign1.rfurrer.feelsbook.Stats;
//
//public class PagerAdapter extends FragmentStatePagerAdapter {
//    int mNumOfTabs;
//
//    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
//        super(fm);
//        this.mNumOfTabs = NumOfTabs;
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//
//        switch (position) {
//            case 0:
//                //AddFeelings tab1 = new AddFeelings();
//                return tab1;
//            case 1:
//                Stats tab2 = new Stats();
//                return tab2;
//            default:
//                return null;
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return mNumOfTabs;
//    }
//}
