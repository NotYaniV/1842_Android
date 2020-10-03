package com.example.materialapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.view.Menu;

import com.example.materialapp.MainActivity2;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(false);

        ViewPager v_pager = findViewById(R.id.pager);
        v_pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        TabLayout tab= findViewById(R.id.tabLayout);
        tab.setupWithViewPager(v_pager);
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0) {
                return new MainActivity2();
            }
            else if(position == 1){
                return new MainActivity3();
            }
            else return null; //if not happen
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String get_title = getItem(position).getClass().getName();
            return get_title.subSequence(get_title.lastIndexOf(".") + 1, get_title.length());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


}