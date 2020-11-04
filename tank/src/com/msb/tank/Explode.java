package com.msb.tank;

import com.msb.tank.abstractfactory.BaseExplode;

import java.awt.*;

/**
 * @description :爆炸类
 * @author：jty
 * @date: 2020-09-17
 * @sine: 0.0.1
 */
public class Explode extends BaseExplode {
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private TankFrame tf;

    private int x, y;
//    private boolean living = true;

    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(()-> new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);

        if (step >= ResourceMgr.explodes.length){
            tf.explodes.remove(this);
        }

    }

}
