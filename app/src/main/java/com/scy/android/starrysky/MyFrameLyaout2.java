package com.scy.android.starrysky;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;

import com.plattysoft.leonids.ParticleSystem;

import java.util.Random;

/**
 * 沈程阳
 * created by scy on 2019/5/10 14:11
 * 邮箱：1797484636@qq.com
 */
public class MyFrameLyaout2 extends FrameLayout {

    private ParticleSystem ps;
    int arg = 1;

    public MyFrameLyaout2(@NonNull Context context) {
        super(context);
    }

    public MyFrameLyaout2(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFrameLyaout2(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case MotionEvent.ACTION_UP:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            /*case MotionEvent.ACTION_DOWN:

                // Create a particle system and start emiting
                ps = new ParticleSystem(this, 100, getResources().getDrawable(R.drawable.star_pink), Long.parseLong("800"));
                ps.setScaleRange(0.7f, 1.3f);
                ps.setSpeedRange(0.05f, 0.1f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.emit((int) event.getX(), (int) event.getY(), 40);
                break;
            case MotionEvent.ACTION_MOVE:
                ps.updateEmitPoint((int) event.getX(), (int) event.getY());
                break;
            case MotionEvent.ACTION_UP:
                ps.stopEmitting();
                break;*/
            case MotionEvent.ACTION_DOWN:
                if (arg == 1) {
                    ParticleSystem ps = new ParticleSystem(this, 100, getResources().getDrawable(R.drawable.fireworks_b), 1500);
                    ps.setScaleRange(0.1f, 0.4f);
                    ps.setSpeedRange(0.02f, 0.08f);
                    ps.setRotationSpeedRange(90, 180);
                    ps.setFadeOut(200, new AccelerateInterpolator());
                    ps.oneShot(this, 90);
                    ParticleSystem ps2 = new ParticleSystem(this, 100, getResources().getDrawable(R.drawable.fireworks_c), 1500);
                    ps2.setScaleRange(0.1f, 0.4f);
                    ps2.setSpeedRange(0.02f, 0.08f);
                    ps2.setRotationSpeedRange(90, 180);
                    ps2.setFadeOut(200, new AccelerateInterpolator());
                    ps2.oneShot(this, 90);
                    arg = 2;
                }
                if (arg == 3){
                    ParticleSystem ps = new ParticleSystem(this, 100, getResources().getDrawable(R.drawable.fireworks_c), 1500);
                    ps.setScaleRange(0.1f, 0.4f);
                    ps.setSpeedRange(0.02f, 0.08f);
                    ps.setRotationSpeedRange(90, 180);
                    ps.setFadeOut(200, new AccelerateInterpolator());
                    ps.oneShot(this, 90);
                    ParticleSystem ps2 = new ParticleSystem(this, 100, getResources().getDrawable(R.drawable.star_pink), 1500);
                    ps2.setScaleRange(0.1f, 0.4f);
                    ps2.setSpeedRange(0.02f, 0.08f);
                    ps2.setRotationSpeedRange(90, 180);
                    ps2.setFadeOut(200, new AccelerateInterpolator());
                    ps2.oneShot(this, 90);
                    arg = 1;
                } if (arg == 2){
                ParticleSystem ps = new ParticleSystem(this, 100, getResources().getDrawable(R.drawable.fireworks_b), 1500);
                ps.setScaleRange(0.1f, 0.4f);
                ps.setSpeedRange(0.02f, 0.08f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(this, 90);
                ParticleSystem ps2 = new ParticleSystem(this, 100, getResources().getDrawable(R.drawable.fireworks_a), 1500);
                ps2.setScaleRange(0.1f, 0.4f);
                ps2.setSpeedRange(0.02f, 0.08f);
                ps2.setRotationSpeedRange(90, 180);
                ps2.setFadeOut(200, new AccelerateInterpolator());
                ps2.oneShot(this, 90);
                arg = 3;
            }
            break;
        }
        return true;
    }
}
