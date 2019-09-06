package com.example.cctvcolor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitle;
    private List<Bitmap> imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        mTitle = new ArrayList<>();
        mTitle.add("Tab0");
        mTitle.add("Tab1");
        mTitle.add("Tab2");
        mTitle.add("Tab3");

        Bitmap bitmap1 = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.img1);
        Bitmap bitmap2 = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.img2);
        Bitmap bitmap3 = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.img3);
        Bitmap bitmap4 = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.img4);

        imgs = new ArrayList<>();
        imgs.add(bitmap1);
        imgs.add(bitmap2);
        imgs.add(bitmap3);
        imgs.add(bitmap4);
    }

    private void initView() {
        mTabLayout = findViewById(R.id.mTabLayout);
        mViewPager = findViewById(R.id.mViewPager);
        //预加载
        mViewPager.setOffscreenPageLimit(imgs.size());
        //mViewPager滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        //设置适配器
        mViewPager.setAdapter(new MyViewPageAdapter(imgs,mTitle));
        //绑定
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
