package com.msb.tank.abstractfactory;

import com.msb.tank.*;

import java.awt.*;
import java.util.Random;

/**
 * @description :坦克类
 * @author：jty
 * @date: 2020-09-17
 * @sine: 0.0.1
 */
public class RectTank extends BaseTank {
    int x, y;
    Dir dir = Dir.DOWN;
    private static final int SPEED = PropertyMgr.getInt("tankSpeed");
    public static final int WIDTH = ResourceMgr.tankU.getWidth();
    public static final int HEIGHT = ResourceMgr.tankU.getHeight();

    Group group = Group.BAD;
    private boolean moving = true;
    private boolean living = true;
    public Rectangle rect = new Rectangle();
    private Random random = new Random();

    TankFrame tf;

//    FireStrategy fs = new DefaultFireStrategy();
    FireStrategy fs;

    public RectTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        if (group == Group.GOOD) {
            String goodFsName = (String) PropertyMgr.get("goodFs");
            try {
                fs = (FireStrategy) Class.forName(goodFsName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String badFsName = (String) PropertyMgr.get("badFs");
            try {
                fs = (FireStrategy) Class.forName(badFsName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if (!living) tf.ts.remove(this);

        Color c = g.getColor();
        g.setColor(group == Group.GOOD ? Color.RED : Color.BLUE);
        g.fillRect(x, y, 40, 40);
        g.setColor(c);

        move();
    }

    private void move() {
        if (!moving) return;
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if (this.group == Group.GOOD)
            new Thread(()->new Audio("audio/tank_move.wav").play()).start();

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            fire();
            randomDir();
        }

        boundsCheck();
        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if (this.x < 2) x = 2;
        if (this.y < 28) y = 28;
        if (this.x > TankFrame.GAME_WIDTH - RectTank.WIDTH -2) x = TankFrame.GAME_WIDTH - RectTank.WIDTH -2;
        if (this.y > TankFrame.GAME_HEIGHT - RectTank.HEIGHT -2) y = TankFrame.GAME_HEIGHT - RectTank.HEIGHT -2;
    }

    public void fire() {
//        fs.fire(this);
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            this.tf.gf.createBullet(bX, bY, dir, this.group, this.tf);

            if (this.group == Group.GOOD)
                new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
        }
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void die() {
        this.living = false;
    }
}
