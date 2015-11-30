package com.appetite.appetite.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appetite.appetite.R;
import com.appetite.appetite.model.Menu;

import java.util.List;


/**
 * Created by Alex on 14/10/2015.
 */
public class MenuAdapter extends BaseAdapter {
    private Activity activity;
    private List<Menu> itemList;

    public MenuAdapter(Activity activity, List<Menu> menuList) {
        this.activity = activity;
        this.itemList = menuList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itemList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ImageView imageView;
        TextView comidaView;

        if (convertView == null) {
            LayoutInflater inflater
                    = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.image_test, null);
        }

        imageView = (ImageView) view.findViewById(R.id.image);
        comidaView = (TextView) view.findViewById(R.id.comida);
        imageView.setImageBitmap(itemList.get(position).getImage());
        comidaView.setText(itemList.get(position).getComida());

        return view;
    }
}
