package com.appetite.appetite.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.appetite.appetite.R;
import com.appetite.appetite.model.Image;

import java.util.ArrayList;

/**
 * Created by Alex on 14/10/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<Image> items;

    public ImageAdapter(Activity activity, ArrayList<Image> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Image image;
        View view;
        ImageView imageView;

        view = convertView;

        if(convertView == null) {
            LayoutInflater inflater
                    = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.image_test, null);
        }

        image = items.get(position);
        imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageBitmap(image.getImage());

        return view;
    }
}
