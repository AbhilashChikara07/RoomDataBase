package com.example.chikara.wizarddemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by chikara on 11/14/17.
 */

public class PagerAdaptor extends FragmentPagerAdapter {
    ArrayList<Fragment> mFragmentList;
    FragmentManager fm;

    public PagerAdaptor(ArrayList<Fragment> mFragmentList, FragmentManager fm) {
        super(fm);
        this.mFragmentList = mFragmentList;
        this.fm = fm;
    }

    public PagerAdaptor(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
