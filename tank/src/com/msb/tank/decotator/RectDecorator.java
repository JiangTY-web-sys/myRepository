package com.msb.tank.decotator;

import com.msb.tank.GameObject;

import java.awt.*;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-10
 * @sine: 0.0.1
 */
public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        x = go.x;
        y = go.y;
        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(x, y, getWidth(), getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return go.getWidth();
    }

    @Override
    public int getHeight() {
        return go.getHeight();
    }
}
