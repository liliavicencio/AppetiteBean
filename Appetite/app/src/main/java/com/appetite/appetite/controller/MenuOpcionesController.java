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
    private ArrayList<String> comidaList = new ArrayList<>();
    private ListView listView;

    // url to get all products list
    private final String URL = "http://appetite.esy.es/File/ImageFromDirectory.php";
    private final String TAG_ARRAY_IMAGE = "imagenes";
    private final String TAG_IMAGE = "imagen";

    //18 / 10/ 2015
    //URL para traer el tipo de comida  http://appetite.esy.es/File/CategoriaController.php
    private final String URL_ = "http://appetite.esy.es/File/CategoriaController.php";
    private final String TAG_ARRAY_COMIDA_ = "menu_array"; //Nombre de array
    private final String TAG_COMIDA_ = "nombre";//Obtener nombre
    //Fin url archivo php

    private ProgressDialog pDialog;                         // Progress Dialog
    private Bitmap image;

    //Variable de comidas  18/10/2015
    private String comida_;

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

        //serializas 18 /10 /2015
        JSONArray comida_ = null;
        ServerConnection serverConnection2 = new ServerConnection();
        JSONObject jsonComida_ = serverConnection2.makeHttpRequestGet(URL_);
        JSONObject Ccomida_;


        try {
            images = json.getJSONArray(TAG_ARRAY_IMAGE);
            // llenamos el array con lista de comidas 18/10/2015
            comida_=jsonComida_.getJSONArray(TAG_ARRAY_COMIDA_);


            for (int i = 0; i < images.length(); i++) {
                c = images.getJSONObject(i);
                //imageList.add(new Image((i + 1), c.getString(TAG_IMAGE) + "comida"));

                imageList.add(new Image((i + 1), c.getString(TAG_IMAGE)));
            }
            // for para entradas array de comidas
            for (int cont=0; cont < comida_.length(); cont++){
                Ccomida_=comida_.getJSONObject(cont);
                comidaList.add(new String((Ccomida_.getString(TAG_COMIDA_))));
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
                    listView.setAdapter(new ImageAdapter(activity, imageList, comidaList));
                }
            });
        }
    }
}
