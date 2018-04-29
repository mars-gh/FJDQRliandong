package com.mars.fjdqrliandong;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class VPFootPagerAdapter extends PagerAdapter {

    private ArrayList<View> vList;

    public VPFootPagerAdapter(ArrayList<View> vList) {
        this.vList = vList;
    }

    @Override
    public int getCount() {
        return vList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(vList.get(position));
        return vList.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(vList.get(position));
    }
}
