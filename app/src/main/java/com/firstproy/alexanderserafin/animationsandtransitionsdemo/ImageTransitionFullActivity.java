package com.firstproy.alexanderserafin.animationsandtransitionsdemo;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageTransitionFullActivity extends AppCompatActivity {

    public static final String imageDrawableSrc = "ARG_IMAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_transition_full);

        ImageView imageView = findViewById(R.id.imageView);

        try{
            imageView.setImageResource( getIntent().getExtras().getInt(imageDrawableSrc));
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }

    }
}
