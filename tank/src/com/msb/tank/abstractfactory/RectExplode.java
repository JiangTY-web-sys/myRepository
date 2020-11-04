package com.msb.tank.abstractfactory;

import com.msb.tank.Audio;
import com.msb.tank.TankFrame;

import java.awt.*;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-04
 * @sine: 0.0.1
 */
public class RectExplode extends BaseExplode {

    private TankFrame tf;

    private int x, y;
//    private boolean living = true;

    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(()-> new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
//        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10*step, 10*step);
        step++;
//        if (step >= ResourceMgr.explodes.length){
        if (step >= 10){
            tf.explodes.remove(this);
        }
        g.setColor(c);

    }
}
