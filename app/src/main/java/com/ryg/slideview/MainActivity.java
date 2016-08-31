package com.ryg.slideview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.ryg.slideview.entity.MessageItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	private SilderListView mListView;

	private List<MessageItem> mMessageItems = new ArrayList<MessageItem>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		mListView = (SilderListView) findViewById(R.id.list);

		for (int i = 0; i < 20; i++) {
			MessageItem item = new MessageItem();
			if (i % 3 == 0) {
				item.iconRes = R.drawable.default_qq_avatar;
				item.title = i + " >> this is first title";
				item.msg = "this is first message ";
				item.time = "2014-7-22";
			} else {
				item.iconRes = R.drawable.wechat_icon;
				item.title = i + " >> this is secend title";
				item.msg = "this is secend message ";
				item.time = "2014-8-22";
			}
			mMessageItems.add(item);
		}
		mListView.setAdapter(new SlideAdapter(MainActivity.this, mMessageItems));
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

			}
		});
	}
}
