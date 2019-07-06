package com.isoft.demo.airplane;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    MainFragment1 mainFragment1;
    MainFragment2 mainFragment2;
    MainFragment3 mainFragment3;
    MainFragment4 mainFragment4;
    RadioGroup rg;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;

    public void init() {

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    if (mainFragment1 == null)
                        mainFragment1 = new MainFragment1();
                    return mainFragment1;
                }
                if (position == 1) {
                    if (mainFragment2 == null)
                        mainFragment2 = new MainFragment2();
                    return mainFragment2;
                }
                if (position == 2) {
                    if (mainFragment3 == null)
                        mainFragment3 = new MainFragment3();
                    return mainFragment3;
                }
                if (position == 3) {
                    if (mainFragment4 == null)
                        mainFragment4 = new MainFragment4();
                    return mainFragment4;
                }
                return null;
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0)
                    rb1.setChecked(true);
                if (position == 1)
                    rb2.setChecked(true);
                if (position == 2)
                    rb3.setChecked(true);
                if (position == 3)
                    rb4.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("航旅纵横");
        toolbar.setLogo(R.mipmap.logo);
        toolbar.setSubtitle("首页");
        toolbar.setBackground(getDrawable(R.mipmap.title_bg));
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.mainViewPager);
        rg = (RadioGroup) findViewById(R.id.bottomHav);
        rb1 = (RadioButton) findViewById(R.id.home);
        rb2 = (RadioButton) findViewById(R.id.flight);
        rb3 = (RadioButton) findViewById(R.id.info);
        rb4 = (RadioButton) findViewById(R.id.my);
        init();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.home) {
                    viewPager.setCurrentItem(0);
                    rb1.setTextColor(Color.RED);
                    rb2.setTextColor(Color.BLACK);
                    rb3.setTextColor(Color.BLACK);
                    rb4.setTextColor(Color.BLACK);
                }
                if (checkedId == R.id.flight) {
                    rb1.setTextColor(Color.BLACK);
                    rb2.setTextColor(Color.RED);
                    rb3.setTextColor(Color.BLACK);
                    rb4.setTextColor(Color.BLACK);
                    viewPager.setCurrentItem(1);
                }
                if (checkedId == R.id.info) {
                    rb1.setTextColor(Color.BLACK);
                    rb2.setTextColor(Color.BLACK);
                    rb3.setTextColor(Color.RED);
                    rb4.setTextColor(Color.BLACK);
                    viewPager.setCurrentItem(2);
                }
                if (checkedId == R.id.my) {
                    rb1.setTextColor(Color.BLACK);
                    rb2.setTextColor(Color.BLACK);
                    rb3.setTextColor(Color.BLACK);
                    rb4.setTextColor(Color.RED);
                    viewPager.setCurrentItem(3);
                }
             /* if( group.getCheckedRadioButtonId()==rb1.getId()){
                  viewPager.setCurrentItem(0);
              }
                if( group.getCheckedRadioButtonId()==rb2.getId()){
                    viewPager.setCurrentItem(1);
                }
                if( group.getCheckedRadioButtonId()==rb3.getId()){
                    viewPager.setCurrentItem(2);
                }
                if( group.getCheckedRadioButtonId()==rb4.getId()){
                    viewPager.setCurrentItem(3);
                }*/
            }
        });
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
