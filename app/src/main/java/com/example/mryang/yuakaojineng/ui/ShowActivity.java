package com.example.mryang.yuakaojineng.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.mryang.yuakaojineng.R;
import com.example.mryang.yuakaojineng.data.adapter.PagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity {

    @BindView(R.id.viewPager_show)
    ViewPager viewPagerShow;
    @BindView(R.id.tabLayout_show)
    TabLayout tabLayoutShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        viewPagerShow.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tabLayoutShow.setupWithViewPager(viewPagerShow);

    }
}
