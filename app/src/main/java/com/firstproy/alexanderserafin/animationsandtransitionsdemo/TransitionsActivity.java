package com.firstproy.alexanderserafin.animationsandtransitionsdemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by alexanderserafin on 1/5/18
 */

public class TransitionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transitions);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(new Intent(TransitionsActivity.this, TransitionOneActivity.class),ActivityOptions.makeSceneTransitionAnimation(TransitionsActivity.this).toBundle());
                } else {
                    startActivity(new Intent(TransitionsActivity.this, TransitionOneActivity.class));
                }
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(new Intent(TransitionsActivity.this, CircleRevealActivity.class),ActivityOptions.makeSceneTransitionAnimation(TransitionsActivity.this).toBundle());
                } else {
                    startActivity(new Intent(TransitionsActivity.this, CircleRevealActivity.class));
                }
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(new Intent(TransitionsActivity.this, RecyclerAnimationActivity.class),ActivityOptions.makeSceneTransitionAnimation(TransitionsActivity.this).toBundle());
                } else {
                    startActivity(new Intent(TransitionsActivity.this, RecyclerAnimationActivity.class));
                }
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(new Intent(TransitionsActivity.this, ConstraintsAnimationActivity.class),ActivityOptions.makeSceneTransitionAnimation(TransitionsActivity.this).toBundle());
                } else {
                    startActivity(new Intent(TransitionsActivity.this, ConstraintsAnimationActivity.class));
                }
            }
        });

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(new Intent(TransitionsActivity.this, SpringAnimationActivity.class),ActivityOptions.makeSceneTransitionAnimation(TransitionsActivity.this).toBundle());
                } else {
                    startActivity(new Intent(TransitionsActivity.this, SpringAnimationActivity.class));
                }
            }
        });

    }

}
