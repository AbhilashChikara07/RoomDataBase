package com.example.chikara.wizarddemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> mFragmentList = new ArrayList<>();
    ViewPager mViewPager;
    LinearLayout nextLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentList.add(new AddFragment());
        mFragmentList.add(new AddFragment());
        mFragmentList.add(new AddFragment());
        mFragmentList.add(new AddFragment());
        mFragmentList.add(new AddFragment());

        mViewPager = findViewById(R.id.viewPager);
        mViewPager.setAdapter(new PagerAdaptor(mFragmentList, getSupportFragmentManager()));
        nextLL = (LinearLayout) findViewById(R.id.nextLL);
        nextLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            }
        });
    }
}
