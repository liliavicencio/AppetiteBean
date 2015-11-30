package com.appetite.appetite.service;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.appetite.appetite.R;
import com.appetite.appetite.adapter.MenuAdapter;
import com.appetite.appetite.connection.ServerConnection;
import com.appetite.appetite.model.Menu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmoreno on 18/10/15.
 */
public class MenuOpcionesService extends AsyncTask<String, String, String> {

    private Activity activity;
    private List<Menu> menuList = new ArrayList<>();
    private ListView listView;

    private final String URL_IMAGEN = "http://appetite.esy.es/File/ImageFromDirectory.php";
    private final String TAG_ARRAY_IMAGE = "imagenes";
    private final String TAG_IMAGE = "imagen";

    private final String URL_COMIDA = "http://appetite.esy.es/File/CategoriaController.php";
    private final String TAG_ARRAY_COMIDA = "menu_array";
    private final String TAG_COMIDA = "nombre";

    private ProgressDialog pDialog;
    private Bitmap image;

    private String comida_;

    public MenuOpcionesService(Activity activity) {
        this.activity = activity;
        listView = (ListView) activity.findViewById(R.id.list_menu_opciones);
    }

    /**
     * @private Before to start the background thread Show Progress Dialog
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(activity);
        pDialog.setMessage("Cargando menú. Por favor espere...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    /**
     * @private Get all products
     */
    protected String doInBackground(String... args) {
        ServerConnection serverConnection = new ServerConnection();
        Menu menu;
        JSONArray imageJSONArray;
        JSONObject jsonImage = serverConnection.makeHttpRequestGet(URL_IMAGEN);
        JSONObject instanceImage;

        JSONArray comidaJSONArray;
        JSONObject jsonComida = serverConnection.makeHttpRequestGet(URL_COMIDA);
        JSONObject instanceComida;

        try {
            imageJSONArray = jsonImage.getJSONArray(TAG_ARRAY_IMAGE);
            comidaJSONArray = jsonComida.getJSONArray(TAG_ARRAY_COMIDA);

            for (int i = 0; i < imageJSONArray.length(); i++) {
                instanceImage = imageJSONArray.getJSONObject(i);
                instanceComida = comidaJSONArray.getJSONObject(i);
                menu = new Menu();
                menu.setId(i + 1);
                menu.setImage(instanceImage.getString(TAG_IMAGE));
                menu.setComida(instanceComida.getString(TAG_COMIDA));
                menuList.add(menu);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param file_url
     * @private Updating UI from Background Thread and parsed JSON data into ListView
     */
    @Override
    protected void onPostExecute(String file_url) {
        pDialog.dismiss();
        if (!menuList.isEmpty()) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    listView.setAdapter(new MenuAdapter(activity, menuList));
                }
            });
        }
    }
}
