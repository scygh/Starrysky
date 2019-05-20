package com.scy.android.starrysky;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;

import com.plattysoft.leonids.ParticleSystem;
import com.plattysoft.leonids.modifiers.AlphaModifier;
import com.plattysoft.leonids.modifiers.ScaleModifier;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    ViewPager mViewPager;
    List<View> mViews;
    View nv,nan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mViewPager = findViewById(R.id.vp);
        mViews = new ArrayList<>();
        View view = getLayoutInflater().inflate(R.layout.pager_first,null);
        mViews.add(view);
        View view1 = getLayoutInflater().inflate(R.layout.activity_main,null);
        mViews.add(view1);
        mViewPager.setAdapter(new MyAdapter());
        nv= view.findViewById(R.id.emiter_nv);
        nan = view.findViewById(R.id.emiter_nan);
        nv.setOnClickListener(this);
        nan.setOnClickListener(this);
        final TitanicTextView tv = view1.findViewById(R.id.my_text_view);

        // set fancy typeface
        tv.setTypeface(Typefaces.get(this, "Satisfy-Regular.ttf"));

        // start animation
        new Titanic().start(tv);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                AnimatorSet set = new AnimatorSet();
                set.playTogether(
                        ObjectAnimator.ofFloat(tv,"rotation",0f,90f),
                        ObjectAnimator.ofFloat(tv,"translationX",0f,180f)
                );
                set.setDuration(2000).start();
            }
        });
    }

    class MyAdapter extends PagerAdapter {
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(mViews.get(position));
            return mViews.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(mViews.get(position));
        }

        @Override
        public int getCount() {
            return mViews.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }
    }


    @Override
    public void onClick(View v) {
       switch (v.getId()) {
           case R.id.emiter_nv:
               new ParticleSystem(this, 4, R.drawable.dust, 3000)
                       .setSpeedByComponentsRange(-0.025f, 0.025f, -0.06f, -0.08f)
                       .setAcceleration(0.00001f, 30)
                       .setInitialRotationRange(0, 360)
                       .addModifier(new AlphaModifier(255, 0, 1000, 3000))
                       .addModifier(new ScaleModifier(0.1f, 0.3f, 0, 1000))
                       .oneShot(v, 2);
               break;
           case R.id.emiter_nan:
               new ParticleSystem(this, 4, R.drawable.dust, 3000)
                       .setSpeedByComponentsRange(-0.025f, 0.025f, -0.06f, -0.08f)
                       .setAcceleration(0.00001f, 30)
                       .setInitialRotationRange(0, 360)
                       .addModifier(new AlphaModifier(255, 0, 1000, 3000))
                       .addModifier(new ScaleModifier(0.1f, 0.8f, 0, 1000))
                       .oneShot(v, 4);
               break;
       }
    }
}
