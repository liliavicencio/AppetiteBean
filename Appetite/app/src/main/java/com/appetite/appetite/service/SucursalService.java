package com.appetite.appetite.service;

import android.os.AsyncTask;

import com.appetite.appetite.connection.ServerConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lily on 27/10/2015.
 */
public class SucursalService extends AsyncTask<String, String, String>
{
    private final String URL = "http://appetite.esy.es/File/SpinnerSucursal.php";
    private final String TAG_ARRAY_MENU = "sucursal_array";
    private final String TAG_NOMBRE = "nombre";

    @Override
    protected String doInBackground(String... params) {
        JSONArray instance = null;
        ServerConnection serverConnection = new ServerConnection();
        JSONObject json = serverConnection.makeHttpRequestGet(URL);
        JSONObject c;
        String nombre;

        try {
            instance = json.getJSONArray(TAG_ARRAY_MENU);
            for (int i = 0; i < instance.length(); i++) {
                c = instance.getJSONObject(i);
                nombre = c.getString(TAG_NOMBRE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
}
