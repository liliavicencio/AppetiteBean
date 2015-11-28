package com.appetite.appetite.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.preference.CheckBoxPreference;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import com.appetite.appetite.R;
import com.appetite.appetite.adapter.ComidasAdapter;
import com.appetite.appetite.connection.ServerConnection;
import com.appetite.appetite.model.Image;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Dmoreno on 10/11/15.
 */

public class ComidaOpcionesController extends AsyncTask<String, String, String> {   //aqui

    private Activity activity;
    //Se declaro como imagen  el array solamente para llenar los items de la clase Comida Adapter
    private ArrayList<Image> imageList = new ArrayList<>();
    private ArrayList<String> MenuComida = new ArrayList<>();
    private ArrayList<String> Precio = new ArrayList<>();
    private ListView lvs;
    // url to get all products list
    private final String URL = "http://appetite.esy.es/File/MenuComida.php";
    private final String TAG_ARRAY_MENUCOMIDA = "platillo_array";
    private final String TAG_COMIDA = "nombre";
    private final String TAG_PRECIO = "precio";
    private final String RecibeComida;

    private ProgressDialog pDialog;                         // Progress Dialog

    //Variable imagese utiliza para capturar la cantidad de comidas
    private String comida_;
    private Image image;
    private String precio_;


    public ComidaOpcionesController(final Activity activity,String Recibecomida) {
        this.activity = activity;
     //   CheckComida = (CheckBox) activity.findViewById(R.id.checkBox);
        lvs = (ListView) activity.findViewById(R.id.listView);

        this.RecibeComida=Recibecomida;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(activity);
        pDialog.setMessage("Cargando menú. Por favor espere...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    protected String doInBackground(String... args) {
        //Solo para el parseo  o serializacion
        StringBuilder params = new StringBuilder();
        params.append("Comida").append("=").append(RecibeComida);

        JSONArray images = null;
        ServerConnection serverConnection2 = new ServerConnection();
        JSONObject json = serverConnection2.makeHttpRequestPost(URL, params.toString());
        JSONObject c;

        JSONArray comida = null;
        ServerConnection serverConnection = new ServerConnection();
        JSONObject jsonComida = serverConnection.makeHttpRequestPost(URL,params.toString());
        JSONObject Ccomida;

        JSONArray precio = null;
        ServerConnection serverConnection3 = new ServerConnection();
        JSONObject jsonPrecio = serverConnection3.makeHttpRequestPost(URL, params.toString());
        JSONObject Pprecio;

       // devolver en caso de no funcionar//JSONObject c; pero si funciono
        try {
            //Llenamos con el mismo array de comidas ya que solo es para obtener la cantidad de items que se crearan
            images = json.getJSONArray(TAG_ARRAY_MENUCOMIDA);
            comida = jsonComida.getJSONArray(TAG_ARRAY_MENUCOMIDA);
            precio = jsonPrecio.getJSONArray(TAG_ARRAY_MENUCOMIDA);


            for (int i = 0; i < images.length(); i++) {
                c = images.getJSONObject(i);
                //imageList.add(new Image((i + 1), c.getString(TAG_IMAGE) + "comida"));

                imageList.add(new Image((i + 1), c.getString(TAG_COMIDA)));
            }

            for (int cont=0; cont < comida.length(); cont++){
                Ccomida = comida.getJSONObject(cont);
                MenuComida.add(new String((Ccomida.getString(TAG_COMIDA))));
            }

            for (int j=0; j < precio.length(); j++){
                Pprecio = precio.getJSONObject(j);
                Precio.add(new String((Pprecio.getString(TAG_PRECIO))));
            }

         } catch (JSONException e) {
            e.printStackTrace();
        }
          return null;
    }
     @Override
    protected void onPostExecute(String file_url) {
        pDialog.dismiss();
        if (!MenuComida.isEmpty()) {
            activity.runOnUiThread(new Runnable() {   //aqui
                @Override
                public void run() {  // se llena la grilla Lvs y mandamos a llamar a ComidasAdapter
                    //Enviamos dos ARRAYS uno de numero de comidas en la lista y el otro con las comidas para que reciba
                    //el metodo Comidas Adapter   Examplea item 1  , MenuComida  carne
                    lvs.setAdapter(new ComidasAdapter(activity, imageList, MenuComida, Precio));
                }
            });
        }
    }
}
