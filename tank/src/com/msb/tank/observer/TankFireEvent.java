package com.msb.tank.observer;

import com.msb.tank.Tank;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-11
 * @sine: 0.0.1
 */
public class TankFireEvent {
    Tank t;

    public Tank getSource() {
        return t;
    }

    public TankFireEvent(Tank t) {
        this.t = t;
    }
}
