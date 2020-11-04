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
public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
}
