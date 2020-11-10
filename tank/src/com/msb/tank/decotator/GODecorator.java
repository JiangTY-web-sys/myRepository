package com.msb.tank.decotator;

import com.msb.tank.GameObject;

import java.awt.*;

/**
 * @description :装饰模式
 * @author：jty
 * @date: 2020-11-10
 * @sine: 0.0.1
 */
public abstract class GODecorator extends GameObject {

    GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);

}
