package com.example.googleaad;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.example.googleaad.model.TopLearner;
import com.example.googleaad.tabs.Leader_frag;
import com.example.googleaad.tabs.SkillIQ_frag;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabs;
    TextView submit;
    Toolbar toolbar;

    SkillIQ_frag skillIQ_frag;
    Leader_frag leader_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.view_pager);
        tabs = findViewById(R.id.tabs);

        skillIQ_frag = new SkillIQ_frag();
        leader_frag = new Leader_frag();
        submit = findViewById(R.id.subtext);
        submit.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Submit.class)));

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabs.setupWithViewPager(viewPager);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        class SectionsPagerAdapter extends FragmentPagerAdapter{
            String[] fragNames = {" Learning Leader ","Skill IQ Leader"};


            public SectionsPagerAdapter(@NonNull FragmentManager fm, int behavior) {
                super(fm, behavior);
            }

            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return leader_frag;
                    case 1:
                        return skillIQ_frag;
                }
                return null;
            }

            @Override
            public int getCount() {
                return fragNames.length;
            }

            public CharSequence getPageTitle(int position){
                return fragNames[position];
            }
        }


    }


}