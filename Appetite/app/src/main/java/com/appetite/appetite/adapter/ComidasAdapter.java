package com.appetite.appetite.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.appetite.appetite.R;
import com.appetite.appetite.model.Comida;
import com.appetite.appetite.serialize.JSONSerialize;

import java.util.List;

/**
 * Created by Dmoreno on 10/11/15.
 */

public class ComidasAdapter extends BaseAdapter {

    private Activity activity;
    private List<Comida> itemList;
    JSONSerialize<Comida> serialize = new JSONSerialize<>(Comida.class);
    TextView precioView;
    CheckBox ComidaS;
    String CATEGORIA;

    public ComidasAdapter(Activity activity, List<Comida> itemList, String CATEGORIA) {
        this.activity = activity;
        this.itemList = itemList;
        this.CATEGORIA = CATEGORIA;
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
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.single_listview_item, null);
        precioView = (TextView) view.findViewById(R.id.precio);
        ComidaS = (CheckBox) view.findViewById(R.id.chk_box);
        ComidaS.setText(itemList.get(position).getDescripcion());
        precioView.setText("Precio: $" + itemList.get(position).getPrecio());
        return view;
    }

}
