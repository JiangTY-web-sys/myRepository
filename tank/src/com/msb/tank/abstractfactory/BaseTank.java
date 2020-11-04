package com.msb.tank.abstractfactory;

import com.msb.tank.Group;

import java.awt.*;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-04
 * @sine: 0.0.1
 */
public abstract class BaseTank {
    public Group group = Group.BAD;
    public Rectangle rect = new Rectangle();

    public abstract void paint(Graphics g);

    public Group getGroup() {
        return this.group;
    }

    public abstract void die();

    public abstract int getX();

    public abstract int getY();
}
