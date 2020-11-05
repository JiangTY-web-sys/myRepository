package com.msb.tank;

/**
 * @description :默认开火策略
 * @author：jty
 * @date: 2020-11-03
 * @sine: 0.0.1
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        new Bullet(bX, bY, t.dir, t.group, t.gm);

        if (t.group == Group.GOOD)
            new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
