package com.snow.justjava;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;

/**
 * Created by snow on 2016/11/3.
 */

public class PayActivity extends Activity {

    private ImageView img;
    private RatingBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.imageView);
        bar = (RatingBar) findViewById(R.id.ratingBar);
    }
}
