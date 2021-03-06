package com.gz.android_utils.ui.listview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * created by Zhao Yue, at 22/9/16 - 6:36 PM
 * for further issue, please contact: zhaoy.samuel@gmail.com
 */
public class GZListView extends ListView{

    public GZListView(Context context) {
        super(context);
    }

    public GZListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GZListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public GZListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setAdapter(final ListAdapter adapter) {
        super.setAdapter(adapter);
        if (adapter.getClass().isAssignableFrom(GZListViewAdapter.class)) {
            this.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    GZListViewBaseItem item = (GZListViewBaseItem) adapter.getItem(position);
                    item.onItemClicked();
                }
            });
        }
    }
}
