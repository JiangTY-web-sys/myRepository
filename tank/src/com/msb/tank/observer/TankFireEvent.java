package com.msb.tank.observer;

import com.msb.tank.Tank;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-11
 * @sine: 0.0.1
 */
public class TankFireEvent {
    Tank tank;

    public Tank getSource() {
        return tank;
    }

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }
}
