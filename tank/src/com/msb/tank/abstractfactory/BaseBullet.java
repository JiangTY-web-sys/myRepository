package com.msb.tank.abstractfactory;

import java.awt.*;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-04
 * @sine: 0.0.1
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank tank);
}
