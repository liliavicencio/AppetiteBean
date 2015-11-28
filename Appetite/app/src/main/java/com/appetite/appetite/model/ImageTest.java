package com.appetite.appetite.model;

import android.app.Activity;
import android.os.Bundle;

import com.appetite.appetite.R;
import com.appetite.appetite.controller.ImageController;

/**
 * Created by Alex on 14/10/2015.
 */
public class ImageTest extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_image_test);
        ImageController imageController
                = new ImageController(ImageTest.this);
        imageController.execute();
    }
}
