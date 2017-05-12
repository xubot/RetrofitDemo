package com.example.administrator.retrofitdemo.Adater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.retrofitdemo.Activity.MainActivity;
import com.example.administrator.retrofitdemo.Bean.DataBean;
import com.example.administrator.retrofitdemo.R;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */

class LVAdater extends BaseAdapter {
    private final MainActivity mainActivity;
    private final List<DataBean.TngouBean> tngou;

    public LVAdater(MainActivity mainActivity, List<DataBean.TngouBean> tngou) {
        this.mainActivity = mainActivity;
        this.tngou = tngou;
    }

    @Override
    public int getCount() {
        return tngou.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=View.inflate(mainActivity, R.layout.lv_item,null);
        TextView title= (TextView) convertView.findViewById(R.id.title);
        ImageView img= (ImageView) convertView.findViewById(R.id.img);
        title.setText(tngou.get(position).getTitle());
        return convertView;
    }
}
