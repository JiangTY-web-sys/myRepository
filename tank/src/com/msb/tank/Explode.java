package com.msb.tank;

import java.awt.*;

/**
 * @description :爆炸类
 * @author：jty
 * @date: 2020-09-17
 * @sine: 0.0.1
 */
public class Explode{
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();

    GameModel gm;

    private int x, y;
//    private boolean living = true;

    private int step = 0;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;

        new Thread(()-> new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);

        if (step >= ResourceMgr.explodes.length){
            gm.explodes.remove(this);
        }

    }

}
