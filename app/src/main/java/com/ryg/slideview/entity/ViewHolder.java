package com.ryg.slideview.entity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ryg.slideview.R;
import com.ryg.slideview.SliderView;

/**
 * Created by sam on 2016/8/30.
 */
public class ViewHolder {
    public ImageView icon;
    public TextView title;
    public TextView msg;
    public TextView time;
    public ViewGroup deleteHolder;
    public int position;
    public SliderView scrollView;

    public ViewHolder(View view) {
        icon = (ImageView) view.findViewById(R.id.icon);
        title = (TextView) view.findViewById(R.id.title);
        msg = (TextView) view.findViewById(R.id.msg);
        time = (TextView) view.findViewById(R.id.time);
        deleteHolder = (ViewGroup) view.findViewById(R.id.holder);
    }
}
