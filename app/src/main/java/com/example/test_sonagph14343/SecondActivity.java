package com.example.test_sonagph14343;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.test_sonagph14343.Adapter.PageTabAdapter;
import com.google.android.material.tabs.TabLayout;

public class SecondActivity extends AppCompatActivity {
    private TabLayout tbMain;
    private ViewPager vpMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tbMain = (TabLayout) findViewById(R.id.tbMain);
        vpMain = (ViewPager) findViewById(R.id.vpMain);

        PageTabAdapter pageTabAdapter = new PageTabAdapter(getSupportFragmentManager());
        vpMain.setAdapter(pageTabAdapter);
        tbMain.setupWithViewPager(vpMain);
        vpMain.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        vpMain.setAdapter(pageTabAdapter);
                        tbMain.setupWithViewPager(vpMain);
                }
            }
        });
    }
}