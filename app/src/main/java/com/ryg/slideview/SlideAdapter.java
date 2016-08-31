package com.ryg.slideview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ryg.slideview.entity.MessageItem;
import com.ryg.slideview.entity.ViewHolder;

import java.util.List;

public class SlideAdapter extends ArrayAdapter<MessageItem> implements View.OnClickListener{
    private List<MessageItem> mMessageItems;
    private Context context;
    private LayoutInflater layoutInflater;
    SlideAdapter(Context context, List<MessageItem> mMessageItems) {
        super(context, 0, mMessageItems);
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.mMessageItems = mMessageItems;
    }

    @Override
    public int getCount() {
        return mMessageItems.size();
    }

    @Override
    public MessageItem getItem(int position) {
        return mMessageItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        SliderView slideView = (SliderView) convertView;
        if (slideView == null) {
//            slideView = (SliderView) layoutInflater.inflate(R.layout.list_item, null);
            View itemView = View.inflate(context, R.layout.list_item, null);
            slideView = new SliderView(context);
            slideView.setContentView(itemView);
            holder = new ViewHolder(slideView);
            holder.scrollView = slideView;
            slideView.setTag(holder);
        } else {
            holder = (ViewHolder) slideView.getTag();
        }
        MessageItem item = mMessageItems.get(position);
        slideView.shrink();
        holder.icon.setImageResource(item.iconRes);
        holder.title.setText(item.title);
        holder.msg.setText(item.msg);
        holder.time.setText(item.time);
        holder.position = position;
        holder.deleteHolder.setOnClickListener(this);
        holder.deleteHolder.setTag(holder);
        return slideView;
    }

    @Override
    public void onClick(View view) {
        final ViewHolder holder = (ViewHolder) view.getTag();
        Toast.makeText(context, holder.title.getText()+ "deleted", Toast.LENGTH_SHORT).show();
        Animation animation = AnimationUtils.loadAnimation(context,
                R.anim.anim_item_delete);
        holder.scrollView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //此处可改为具体数据库删除
                remove(getItem(holder.position));
            }
        });
    }
}
