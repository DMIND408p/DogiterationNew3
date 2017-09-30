package com.example.deepu.dogwiteration1.maps;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.deepu.dogwiteration1.R;

/**
 * Created by deepu on 15/09/2017.
 */

public class ViewPageAdapter extends PagerAdapter {

private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.dogcare, R.drawable.dogpark};

    public ViewPageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {



        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.id.custom_layout,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView5);
        imageView.setImageResource(images[position]);

        ViewPager vp =  (ViewPager) container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);



    }
}
