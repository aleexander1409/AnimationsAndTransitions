package com.firstproy.alexanderserafin.animationsandtransitionsdemo;

import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SpringAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring_animation);

        View ivCircle = findViewById(R.id.ivCircle);
        ConstraintLayout clMain = findViewById(R.id.clMain);

        SpringAnimation springAnimation = new SpringAnimation(ivCircle, DynamicAnimation.TRANSLATION_X,clMain.getLeft());
        springAnimation.start();
    }
}
