package com.pm.heroofmylife.ToDo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by pierr on 2018-03-23.
 */

public  class PageAdapter extends FragmentStatePagerAdapter {
    int mNbTabs;

    public PageAdapter(FragmentManager fm, int NumberofTabs) {
        super(fm);
        this.mNbTabs = NumberofTabs;
    }

    @Override
    public int getCount() {
        return mNbTabs;
    }

    @Override
    public Fragment getItem(int position) {
       switch(position)
       {
           case 0 :
               Tab1 tab1 = new Tab1();
               return tab1;

           case 1:
               Tab2 tab2 = new Tab2();
               return tab2;

           case 2 :
               Tab3 tab3= new Tab3();
               return tab3;

           default:
                return null;

       }

    }
}