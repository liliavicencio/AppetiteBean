package com.appetite.appetite.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ListView;

import com.appetite.appetite.R;
import com.appetite.appetite.adapter.ImageAdapter;
import com.appetite.appetite.connection.ServerConnection;
import com.appetite.appetite.model.Image;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Dmoreno on 18/10/15.
 */
public class MenuOpcionesController  extends AsyncTask<String, String, String> {

    private Activity activity;
    private ArrayList<Image> imageList = new ArrayList<>();
    private ListView listView;

    // url to get all products list
    private final String URL = "http://appetite.esy.es/File/ImageFromDirectory.php";
    private final String TAG_ARRAY_IMAGE = "imagenes";
    private final String TAG_IMAGE = "imagen";

    private ProgressDialog pDialog;                         // Progress Dialog
    private Bitmap image;

    public MenuOpcionesController(Activity activity) {
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
        JSONArray images = null;
        ServerConnection serverConnection = new ServerConnection();
        JSONObject json = serverConnection.makeHttpRequestGet(URL);
        JSONObject c;

        try {
            images = json.getJSONArray(TAG_ARRAY_IMAGE);

            for (int i = 0; i < images.length(); i++) {
                c = images.getJSONObject(i);
                imageList.add(new Image((i + 1), c.getString(TAG_IMAGE)));
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
        if (!imageList.isEmpty()) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    listView.setAdapter(new ImageAdapter(activity, imageList));
                }
            });
        }
    }
}
