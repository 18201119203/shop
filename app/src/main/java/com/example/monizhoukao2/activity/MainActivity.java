package com.example.monizhoukao2.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.example.monizhoukao2.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.image)
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        getSupportActionBar().hide();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int heightPixels = displayMetrics.heightPixels;

        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(image,"scaleX",2,1);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(image,"alpha",1,0);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(image,"rotation",0,360);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(image,"translationY",0,heightPixels/2-image.getHeight());

        AnimatorSet aset = new AnimatorSet();
        aset.play(objectAnimator1).with(objectAnimator2).with(objectAnimator3).with(objectAnimator4);
        aset.setDuration(3000);
        aset.start();

        aset.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(MainActivity.this,BottomActivity.class));
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


    }
}
