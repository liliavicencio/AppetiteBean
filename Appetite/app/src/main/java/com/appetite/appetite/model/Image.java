package com.appetite.appetite.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

/**
 * Created by Alex on 14/10/2015.
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
