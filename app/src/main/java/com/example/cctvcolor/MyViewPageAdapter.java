package com.example.cctvcolor;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyViewPageAdapter extends PagerAdapter {
    List<Bitmap> data;
    List<String> mTitle;

    MyViewPageAdapter(List<Bitmap> data, List<String> mTitle) {
        this.data = data;
        this.mTitle = mTitle;
    }

    @Override
    public int getCount() {
        return data.size();
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.page_item, null);

        ImageView viewById = view.findViewById(R.id.img);
        TextView tv = view.findViewById(R.id.tv);
        viewById.setImageBitmap(data.get(position));
        container.addView(view);
        return view;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
        super.destroyItem(container, position, object);
    }

    //设置标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
