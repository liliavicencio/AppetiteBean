package com.appetite.appetite.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

/**
 * @autor Armando Alexis Sepulveda Cruz
 * @date 2015-10-14
 * @private modelo para codificar una imagen obtenidas por una peticion al servidor.
 */
public class Image {
    private Bitmap image;

    public Image() {

    }

    public Image(String imagen) {
        setImage(imagen);
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(String imageCode) {
        try {
            byte[] byteData = Base64.decode(imageCode, Base64.DEFAULT);
            this.image = BitmapFactory.decodeByteArray(byteData, 0, byteData.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
