package com.msb.tank.cor;

import com.msb.tank.GameObject;
import com.msb.tank.Tank;

/**
 * @description :
 * @author：jty
 * @date: 2020/11/8
 * @sine: 0.0.1
 */
public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank){
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.rect.intersects(t2.rect)){
                t1.back();
                t2.back();
            }
        }
        return true;
    }
}
