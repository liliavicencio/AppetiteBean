package com.appetite.appetite.serialize;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @autor Armando Alexis Sepulveda Cruz
 * @date 2015-11-27
 * @private Clase que serializa un objeto en formato JSON para poder guardar la información en
 * la seción de SharedPreference de la aplicacion
 */
public class JSONSerialize<T> {

    private static final String SHARED_REGISTRO = "Reservacion";
    private static final String TASK = "Task";
    private Class<T> entityClass;

    public JSONSerialize(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void setSerialization(Activity activity) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        SharedPreferences preferences = activity.getSharedPreferences(SHARED_REGISTRO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TASK, gson.toJson(this));
        editor.commit();
    }

    public T getSerialization(Activity activity) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        SharedPreferences preferences = activity.getSharedPreferences(SHARED_REGISTRO, Context.MODE_PRIVATE);
        return gson.fromJson(preferences.getString(TASK, ""), entityClass);
    }

}
