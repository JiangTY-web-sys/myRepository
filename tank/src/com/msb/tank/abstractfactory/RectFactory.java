package com.msb.tank.abstractfactory;

import com.msb.tank.Dir;
import com.msb.tank.Group;
import com.msb.tank.TankFrame;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-04
 * @sine: 0.0.1
 */
public class RectFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectTank(x, y, dir, group, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x, y, dir, group, tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x, y, tf);
    }
}
