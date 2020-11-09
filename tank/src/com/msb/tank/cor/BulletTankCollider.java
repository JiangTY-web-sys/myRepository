package com.msb.tank.cor;

import com.msb.tank.*;

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
            //TODO copy code from method collideWith
            if (b.group == t.group) return true;

            if (b.rect.intersects(t.rect)){
                t.die();
                b.die();
                int tX = t.x + Tank.WIDTH/2 - Explode.WIDTH/2;
                int tY = t.y + Tank.HEIGHT/2 - Explode.HEIGHT/2;
                new Explode(tX, tY);
                return false;
            }
        }else if (o1 instanceof Tank && o2 instanceof Bullet){
            return collide(o2, o1);
        }
        return true;

    }

}
