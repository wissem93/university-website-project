package com.example.imen.facebookfalseprofile.adapter;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.matthewtamlin.sliding_intro_screen_library.indicators.DotIndicator;
import com.microsoft.projectoxford.face.samples.R;

import java.util.ArrayList;


public class AndroidImageAdapter extends PagerAdapter {
    Context mContext;
    private ArrayList<Integer> items;

    public AndroidImageAdapter(Context context, ArrayList<Integer> listOfItems) {
        this.items = listOfItems;

        this.mContext = context;
    }


    @Override
    public int getCount() {
        return sliderImagesId.length;
    }

    private int[] sliderImagesId = new int[]{
            R.drawable.image1, R.drawable.image2, R.drawable.image3,

    };

    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v == ((ImageView) obj);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int i) {
        ImageView mImageView = new ImageView(mContext);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mImageView.setImageResource(sliderImagesId[i]);
        ((ViewPager) container).addView(mImageView, 0);

        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        ((ViewPager) container).removeView((ImageView) obj);
    }
}