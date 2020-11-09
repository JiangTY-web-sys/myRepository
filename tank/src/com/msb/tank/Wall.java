package com.msb.tank;

import java.awt.*;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-09
 * @sine: 0.0.1
 */
public class Wall extends GameObject {
    int w, h;

    public Rectangle rect;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.rect = new Rectangle(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(c);
    }
}
