package com.feicui.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/12.
 */
public class MypagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mList;

    public MypagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }
}
