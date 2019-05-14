package com.scy.android.starrysky;

import android.graphics.Point;

/**
 * 沈程阳
 * created by scy on 2019/4/30 09:16
 * 邮箱：1797484636@qq.com
 */
public class SpiderPoint extends Point{

    // x 方向加速度
    public int aX;

    // y 方向加速度
    public int aY;

    // 小球颜色
    public int color;

    // 小球半径
    public int r;

    // x 轴方向速度
    public float vX;

    // y 轴方向速度
    public float vY;

    // 点
    /*public float x;
    public float y;*/



    public SpiderPoint(int x, int y) {
        super(x, y);
    }

    public SpiderPoint() {
    }
}
