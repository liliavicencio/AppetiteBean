package com.appetite.appetite.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.appetite.appetite.R;
import com.appetite.appetite.model.Image;
import com.appetite.appetite.model.Presentacion;

import java.util.ArrayList;


/**
 * Created by Alex on 14/10/2015.
 */
public class ImageAdapter extends BaseAdapter{
    private Activity activity;
    private ArrayList<Image> items;
    private ArrayList<String> comida;


    public ImageAdapter(Activity activity, ArrayList<Image> items, ArrayList<String> comida) {
        this.activity = activity;
        this.items = items;
        this.comida = comida;
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

        String Comida;
        TextView comidaView;

        view = convertView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.image_test, null);
        }

        image = items.get(position);
        Comida = comida.get(position);
        imageView = (ImageView) view.findViewById(R.id.image);
        comidaView = (TextView) view.findViewById(R.id.comida);
        imageView.setImageBitmap(image.getImage());
        comidaView.setText(Comida);

        return view;
    }


}
