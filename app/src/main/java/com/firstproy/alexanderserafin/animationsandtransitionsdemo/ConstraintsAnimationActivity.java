package com.firstproy.alexanderserafin.animationsandtransitionsdemo;

import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

public class ConstraintsAnimationActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private ConstraintSet mediumConstraintSet = new ConstraintSet();
    private ConstraintSet baseConstraintSet = new ConstraintSet();
    private ConstraintSet endConstraintSet = new ConstraintSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraints_animation);

        constraintLayout = findViewById(R.id.cl1);
        baseConstraintSet.clone(constraintLayout);
        mediumConstraintSet.clone(this,R.layout.item_constraint_medium);
        endConstraintSet.clone(this,R.layout.item_constraint_end);

        findViewById(R.id.baseShape).setOnClickListener(onClickListenerBase);
        findViewById(R.id.mediumShape).setOnClickListener(onClickListenerMedium);
        findViewById(R.id.EndShape).setOnClickListener(onClickListenerEnd);
    }

    private View.OnClickListener onClickListenerBase = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(constraintLayout);
            }
            baseConstraintSet.applyTo(constraintLayout);
        }
    };

    private View.OnClickListener onClickListenerMedium = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(constraintLayout);
            }
            mediumConstraintSet.applyTo(constraintLayout);
        }
    };

    private View.OnClickListener onClickListenerEnd = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(constraintLayout);
            }
            endConstraintSet.applyTo(constraintLayout);
        }
    };
}
