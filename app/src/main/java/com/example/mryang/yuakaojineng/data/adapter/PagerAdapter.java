package com.example.mryang.yuakaojineng.data.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mryang.yuakaojineng.R;
import com.example.mryang.yuakaojineng.ui.fragment.MainPagerFragment;
import com.example.mryang.yuakaojineng.ui.fragment.ShoppingCarFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private String[] list = new String[]{
      "购物车","我的"
    };

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new ShoppingCarFragment();

            case 1:
                return new MainPagerFragment();

                default:
                    return new Fragment();

        }

    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list[position];

    }
}
