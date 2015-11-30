package serialize;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor Armando Alexis Sepulveda Cruz
 * @date 2015-11-27
 * @private Clase que serializa un objeto en formato JSON para poder guardar la información en
 * la seción de SharedPreference de la aplicacion
 */
public class JSONSerialize<T> {

    private static final String SHARED_REGISTRO = "Reservacion";
    private static final String EMPTY_JSON_LIST = "[]";
    private Class<T> entityClass;

    public JSONSerialize(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void setSerialization(Activity activity, T object, final String key) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        SharedPreferences preferences = activity.getSharedPreferences(SHARED_REGISTRO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, gson.toJson(this));
        editor.commit();
    }

    public T getSerialization(Activity activity, final String key) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        SharedPreferences preferences = activity.getSharedPreferences(SHARED_REGISTRO, Context.MODE_PRIVATE);
        String json = preferences.getString(key, "");

        if(json.equals("")) {
            return (T) new Object();
        }

        return gson.fromJson(json, entityClass);
    }

    public void setSerializationList(Activity activity, List<T> list, final String key) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        SharedPreferences preferences = activity.getSharedPreferences(SHARED_REGISTRO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if(list.isEmpty()) {
            list = new ArrayList<T>();
        }
        editor.putString(key, gson.toJson(list));
        editor.commit();
    }

    public <T> List<T> getSerializationList(Activity activity, final String key, Type t) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
        SharedPreferences preferences = activity.getSharedPreferences(SHARED_REGISTRO, Context.MODE_PRIVATE);
        String json = preferences.getString(key, "");

        if(json.equals(EMPTY_JSON_LIST)) {
            return new ArrayList<T>();
        } else {
            return gson.fromJson(json, t);
        }
    }

    public void clear(Activity activity, final String key) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        SharedPreferences preferences = activity.getSharedPreferences(SHARED_REGISTRO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, gson.toJson(""));
        editor.commit();
    }

}
