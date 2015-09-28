package com.ronnie.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * ListView的基础适配器，继承于BaseAdapter
 *
 * @author Ronnie
 */
public abstract class BaseListAdapter extends BaseAdapter {
    protected List mList;// 列表List
    protected LayoutInflater mInflater;// 布局管理
    protected Activity mContext;

    /**
     * 基类构造器
     *
     * @param context
     * @param list
     */
    protected BaseListAdapter(Activity context, List list) {
        super();
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mList = list;
    }

    @Override
    public int getCount() {
        return (mList == null) ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return (mList == null) ? null : mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
