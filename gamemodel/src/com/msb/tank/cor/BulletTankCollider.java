package com.msb.tank.cor;

import com.msb.tank.Bullet;
import com.msb.tank.Explode;
import com.msb.tank.GameObject;
import com.msb.tank.Tank;

/**
 * @description :
 * @author：jty
 * @date: 2020/11/8
 * @sine: 0.0.1
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            if (b.collideWith(t)) {
                return false;
            }
        }else if (o1 instanceof Tank && o2 instanceof Bullet){
            return collide(o2, o1);
        }
        return true;

    }

//    public boolean collideWith(Bullet b, Tank t) {
//        if (b.getGroup() == t.getGroup()) return false;
//
//        if (b.getRect().intersects(t.getRect())){
//            t.die();
//            b.die();
//
//            int tX = t.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
//            int tY = t.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
//            b.getGm().add(new Explode(tX, tY, gm));
//        }
//
//    }
}
