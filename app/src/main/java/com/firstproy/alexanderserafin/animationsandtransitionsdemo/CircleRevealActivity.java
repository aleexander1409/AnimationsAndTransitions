package com.firstproy.alexanderserafin.animationsandtransitionsdemo;

import android.animation.Animator;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;

public class CircleRevealActivity extends AppCompatActivity {

    private boolean isOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_reveal);

        final ConstraintLayout constraintLayout = findViewById(R.id.clForm);
        final ConstraintLayout layoutMain = findViewById(R.id.layoutMain);
        final View button = findViewById(R.id.button);

        isOpen = false;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                int x = constraintLayout.getRight() / 2;
                int y = (int) v.getY() + (int) v.getPivotY();

                int startRadius = 0;
                int endRadius = (int) Math.hypot(layoutMain.getWidth(), layoutMain.getHeight());

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    if (!isOpen) {
                        isOpen = true;
                        v.setBackground(ContextCompat.getDrawable(CircleRevealActivity.this, R.drawable.bg_circle_white));
                        constraintLayout.setVisibility(View.VISIBLE);
                        final Animator anim = ViewAnimationUtils.createCircularReveal(constraintLayout, x, y, startRadius, endRadius);
                        anim.start();
                    } else {
                        isOpen = false;
                        v.setBackground(ContextCompat.getDrawable(CircleRevealActivity.this, R.drawable.bg_circle_green));
                        Animator anim = ViewAnimationUtils.createCircularReveal(constraintLayout, x, y, endRadius, startRadius);
                        anim.start();
                        anim.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                constraintLayout.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });
                    }
                } else {
                    constraintLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
