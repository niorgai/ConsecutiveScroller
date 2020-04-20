package com.donkingliang.consecutivescrollerdemo;

import android.os.Bundle;
import android.widget.TextView;

import com.donkingliang.consecutivescrollerdemo.adapter.TabPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        TextView text = findViewById(R.id.text);
        text.setText("子view实现IConsecutiveScroller接口，并通过实现接口方法告诉ConsecutiveScrollerLayout需要滑动的下级view,\n" +
                " * ConsecutiveScrollerLayout就能正确地处理它的滑动事件。");
        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        viewPager.setAdapter(new TabPagerAdapter(getSupportFragmentManager(), getTabs(), getFragments()));
        tabLayout.setupWithViewPager(viewPager);
    }

    private List<String> getTabs() {
        List<String> tabs = new ArrayList<>();
        tabs.add("Tab1");
        tabs.add("Tab2");
        tabs.add("Tab3");
        tabs.add("Tab4");
        tabs.add("Tab5");
        return tabs;
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MyFragment());
        fragmentList.add(new MyFragment());
        fragmentList.add(new MyFragment());
        fragmentList.add(new MyFragment());
        fragmentList.add(new MyFragment());
        return fragmentList;
    }
}