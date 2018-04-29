package com.mars.fjdqrliandong;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.vp_head)
    ViewPager vpHead;
    @BindView(R.id.vp_foot)
    ViewPager vpFoot;
    private PagerAdapter vPHeadPagerAdapter;
    private PagerAdapter vPFootPagerAdapter;


    private View view1, view2, view3;
    private ArrayList<View> viewList;//view数组

    private View v1, v2, v3;
    private ArrayList<View> vList;//view数组


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        initData();
        init();
    }

    private void initData() {
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.vp_header, null);
        view2 = inflater.inflate(R.layout.vp_header1, null);
        view3 = inflater.inflate(R.layout.vp_header2, null);

        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        LayoutInflater inflater1 = getLayoutInflater();
        v1 = inflater1.inflate(R.layout.vp_footer1, null);
        v2 = inflater1.inflate(R.layout.vp_footer, null);
        v3 = inflater1.inflate(R.layout.vp_footer2, null);

        vList = new ArrayList<View>();// 将要分页显示的View装入数组中
        vList.add(v1);
        vList.add(v2);
        vList.add(v3);
    }

    private void init() {
        vPHeadPagerAdapter = new VPHeadPagerAdapter(viewList);
        vpHead.setAdapter(vPHeadPagerAdapter);

        vPFootPagerAdapter = new VPFootPagerAdapter(vList);
        vpFoot.setAdapter(vPFootPagerAdapter);

        vpHead.addOnPageChangeListener(headOnPageChangeListener);
        vpFoot.addOnPageChangeListener(footOnPageChangeListener);
    }

    private ViewPager.OnPageChangeListener headOnPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            vpFoot.setCurrentItem(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    private ViewPager.OnPageChangeListener footOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            vpHead.setCurrentItem(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
