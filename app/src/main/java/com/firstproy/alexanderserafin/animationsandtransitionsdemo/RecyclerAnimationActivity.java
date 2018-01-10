package com.firstproy.alexanderserafin.animationsandtransitionsdemo;

import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerAnimationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_animation);

        recyclerView = findViewById(R.id.rvList);
        recyclerView.setAdapter(adapter());

    }

    @Override
    public void onBackPressed() {
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(adapter());
        } else {
            super.onBackPressed();
        }
    }

    public RecyclerView.Adapter adapter(){
        return new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false)) {
                };
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

                holder.itemView.setOnClickListener(onClickListener);
                holder.getAdapterPosition();
            }

            private View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Rect viewRect = new Rect();
                    view.getGlobalVisibleRect(viewRect);

                    // create Explode transition with epicenter
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Transition explode = new Explode();
//                        explode = new Fade();   //FADE ANIMATION
//                        explode = new Slide();  //SLIDE ANIMATION

                        explode.setEpicenterCallback(new Transition.EpicenterCallback() {
                            @Override
                            public Rect onGetEpicenter(Transition transition) {
                                return viewRect;
                            }
                        });

                        explode.setDuration(800);

                        TransitionManager.beginDelayedTransition(recyclerView, explode);
                    }
                    // remove all views from Recycler View
                    recyclerView.setAdapter(null);
                }
            };

            @Override
            public int getItemCount() {
                return 100;
            }
        };
    }
}
