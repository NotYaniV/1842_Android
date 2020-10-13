package com.example.materialapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {
    Pojo set = new Pojo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(false);

        ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        TabLayout tab = findViewById(R.id.tabLayout);
        tab.setupWithViewPager(viewPager);
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
            int count = 2;
            return count;
        }

        @Override
        public CharSequence getPageTitle(int titlePosition) {
            String getTitle = getItem(titlePosition).getClass().getName();
            return getTitle.subSequence(getTitle.lastIndexOf(".") + 1,getTitle.length());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menuCreate) {
        getMenuInflater().inflate(R.menu.menu,menuCreate);
        return super.onCreateOptionsMenu(menuCreate);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem getItems) {

        switch(getItems.getItemId()){
            case R.id.ok:
                TextInputEditText test = findViewById(R.id.name_input);
                test.setText(set.name);

                MaterialTextView newTest = findViewById(R.id.name);
                newTest.setText(test.getText().toString());

                TextInputEditText email = findViewById(R.id.email);
                email.setText(set.email);

                TextInputEditText phone = findViewById(R.id.phone);
                phone.setText(set.phone);

                TextInputEditText password = findViewById(R.id.password);
                password.setText(set.password);

                TextInputEditText rePassword = findViewById(R.id.rePassword);
                rePassword.setText(set.password);
        }
        return super.onOptionsItemSelected(getItems);
    }


}


