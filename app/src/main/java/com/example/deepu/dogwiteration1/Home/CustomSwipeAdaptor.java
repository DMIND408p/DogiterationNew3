package com.example.deepu.dogwiteration1.Home;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.deepu.dogwiteration1.R;

/**
 * Created by deepu on 20/09/2017.
 */

public class CustomSwipeAdaptor extends PagerAdapter {
    private int [] img_resources = {R.drawable.mollynewone, R.drawable.mollynewtwo};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdaptor(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return img_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view==(RelativeLayout)o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.img_view);
        imageView.setImageResource(img_resources[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((RelativeLayout)object);
    }


}
