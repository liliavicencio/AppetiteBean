package com.appetite.appetite.service;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ListView;

import com.appetite.appetite.R;
import com.appetite.appetite.adapter.ComidasAdapter;
import com.appetite.appetite.connection.ServerConnection;
import com.appetite.appetite.model.Comida;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmoreno on 10/11/15.
 */

public class ComidaOpcionesService extends AsyncTask<String, String, String> {   //aqui

    private Activity activity;
    private List<Comida> comidaList = new ArrayList<>();
    private ListView listView;

    private final String URL = "http://appetite.esy.es/File/MenuComida.php";
    private final String TAG_ARRAY_MENUCOMIDA = "platillo_array";
    private final String TAG_COMIDA = "nombre";
    private final String TAG_PRECIO = "precio";
    private final String RecibeComida;
    private final String CATEGORIA;
    private ProgressDialog pDialog;


    public ComidaOpcionesService(final Activity activity, String Recibecomida, String categoria) {
        this.activity = activity;
        listView = (ListView) activity.findViewById(R.id.listView);
        this.RecibeComida = Recibecomida;
        this.CATEGORIA = categoria;
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
        StringBuilder params = new StringBuilder();
        Comida comida;
        JSONArray JSONArray;
        ServerConnection serverConnection = new ServerConnection();
        JSONObject json = serverConnection.makeHttpRequestPost(URL, params.toString());
        JSONObject c;

        params.append("Comida").append("=").append(RecibeComida);

        try {
            JSONArray = json.getJSONArray(TAG_ARRAY_MENUCOMIDA);

            for (int i = 0; i < JSONArray.length(); i++) {
                comida = new Comida();
                c = JSONArray.getJSONObject(i);
                comida.setId(i + 1);
                comida.setImage(c.getString(TAG_COMIDA));
                comida.setDescripcion(c.getString(TAG_COMIDA));
                comida.setPrecio(c.getString(TAG_PRECIO));
                comida.setCategoria(CATEGORIA);
                comida.setSeleccionado(false);
                comidaList.add(comida);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String file_url) {
        pDialog.dismiss();
        if (!comidaList.isEmpty()) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    listView.setAdapter(new ComidasAdapter(activity, comidaList, CATEGORIA));
                }
            });
        }
    }
}
