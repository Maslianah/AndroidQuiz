package com.maslianah.my.androidquiz;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
     SectionsPageAdapter mSectionsPageAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() starting");

        mSectionsPageAdapter= new SectionsPageAdapter(getSupportFragmentManager());

        //set up viewPager with the sections adapter
        mViewPager = (ViewPager) findViewById(R.id.container);
        setUpViewPager(mViewPager);

        mViewPager.setCurrentItem(0);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public void setUpViewPager (ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new logInTab(), "Log In");
        adapter.addFragment(new signUpTab(), "Sign Up");

        viewPager.setAdapter(adapter);

    }
}
