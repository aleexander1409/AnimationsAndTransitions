package com.firstproy.alexanderserafin.animationsandtransitionsdemo;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

public class TransitionOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_one);

        findViewById(R.id.imageView).setOnClickListener(onClickListener);
        findViewById(R.id.imageView2).setOnClickListener(onClickListener);
        findViewById(R.id.imageView3).setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String id = (String) v.getTag();
            Intent intent = new Intent(TransitionOneActivity.this, ImageTransitionFullActivity.class);
            switch (Integer.valueOf(id)) {
                case 0:
                    intent.putExtra(ImageTransitionFullActivity.imageDrawableSrc,android.R.drawable.btn_star_big_on);
                    break;
                case 1:
                    intent.putExtra(ImageTransitionFullActivity.imageDrawableSrc,android.R.drawable.ic_delete);
                    break;
                default:
                    intent.putExtra(ImageTransitionFullActivity.imageDrawableSrc,android.R.drawable.ic_lock_lock);
                    break;
            }

            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(TransitionOneActivity.this, v, "imageTransition");
            startActivity(intent, options.toBundle());
        }
    };
}
