package com.pm.heroofmylife;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pierr on 2018-03-24.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentListTitles = new ArrayList<>();
    private final List<Integer> fragmentListIcon = new ArrayList<Integer>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentListTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTitles.get(position);
    }


    public int getPageIcon(int position) {
        return fragmentListIcon.get(position);
    }



    public void AddFragment(Fragment fragment, String Title, Integer Icon) {
        fragmentList.add(fragment);
        fragmentListTitles.add(Title);
        fragmentListIcon.add(Icon);


    }

}
