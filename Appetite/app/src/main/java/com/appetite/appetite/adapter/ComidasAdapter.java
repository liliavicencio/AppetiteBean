package com.appetite.appetite.adapter;

import android.app.Activity;
import android.content.Context;
import android.preference.CheckBoxPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.appetite.appetite.R;
import com.appetite.appetite.controller.ComidaOpcionesController;
import com.appetite.appetite.model.Image;
import com.appetite.appetite.model.Presentacion;
import org.w3c.dom.Text;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmoreno on 10/11/15.
 */

public class ComidasAdapter extends BaseAdapter {

    //Se utiliza Image ya que solo se usara para llenar el items y tener las posiciones de positions Items
    private Activity activity;
    private ArrayList<Image> items;
    private ArrayList<String> comida;
    private ArrayList<String> precio;

    private Context context;
    //Creada
    boolean selected=false;

    public ComidasAdapter(Activity activity, ArrayList<Image> items, ArrayList<String> comida, ArrayList<String> precio) {
        this.activity = activity;
        this.items = items;
        this.comida = comida;
        this.precio = precio;
    }

    public ComidasAdapter(){}

    //Para los selected de los listview chekboc
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public int getCount() {
        return items.size(); //aqui
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }
    //Contador de comidas que se motraran haciendo tambien que se cren los chekbox
    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }
    ///Fin
    TextView precioView;
    TextView TipoComidaView;
    CheckBox Chbx = null;
    CheckBox ComidaS;
    String ComidaPos;
    String Precio;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;


        //
        view = convertView;


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.single_listview_item, null);
            Chbx=(CheckBox)view.findViewById(R.id.chk_box);
            precioView=(TextView)view.findViewById(R.id.precio);

            Chbx.setOnCheckedChangeListener((Presentacion) activity);
        }
        //Varible type chekbox para saber cuantos chekbox se crearan segun las comidas


        Chbx.setChecked(isSelected());
        Chbx.setTag(items.get(position));

        ComidaPos = comida.get(position);
        Precio = precio.get(position);
        ComidaS = (CheckBox) view.findViewById(R.id.chk_box);
        precioView = (TextView) view.findViewById(R.id.precio);
        ComidaS.setText(ComidaPos);
        precioView.setText("Precio: $" + Precio);

        return view;
    }


}
