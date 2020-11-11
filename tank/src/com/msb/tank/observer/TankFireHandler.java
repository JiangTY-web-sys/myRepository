package com.msb.tank.observer;

import com.msb.tank.Tank;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-11
 * @sine: 0.0.1
 */
public class TankFireHandler implements TankFireObserver{
    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank t = e.getSource();
        t.fire();
    }
}
