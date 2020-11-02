package com.msb.tank;

import java.awt.*;
import java.util.Random;

/**
 * @description :敌人坦克类
 * @author：jty
 * @date: 2020-09-17
 * @sine: 0.0.1
 */
public class Enemy {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 1;
    public static final int WIDTH = ResourceMgr.tankD.getWidth();
    public static final int HEIGHT = ResourceMgr.tankD.getHeight();

    private Group group = Group.BAD;
    private Random random = new Random();

    private boolean moving = true;
    private boolean living = true;

    Rectangle rect = new Rectangle();
    private TankFrame tf;

    public Enemy(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }


    public void paint(Graphics g) {

//        if (!living) tf.es.remove(this);
        /*switch (dir) {
            case LEFT:
            g.drawImage(ResourceMgr.enemyL,x,y,null);
            break;
            case UP:
            g.drawImage(ResourceMgr.enemyU,x,y,null);
            break;
            case RIGHT:
            g.drawImage(ResourceMgr.enemyR,x,y,null);
            break;
            case DOWN:
            g.drawImage(ResourceMgr.enemyD,x,y,null);
            break;
        }*/

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


        if (random.nextInt(100) > 98) this.fire();

        if (random.nextInt(100) > 98) randomDir();

        boundsCheck();
        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    //边界检测
    private void boundsCheck() {
        if (this.x < 0) x = 0;
        if (this.y < 30) y = 30;
        if (this.x > TankFrame.GAME_WIDTH - Enemy.WIDTH) x = TankFrame.GAME_WIDTH - Enemy.WIDTH;
        if (this.y > TankFrame.GAME_HEIGHT - Enemy.HEIGHT) y = TankFrame.GAME_HEIGHT - Enemy.HEIGHT;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        tf.bs.add(new Bullet(bX, bY, this.dir, Group.BAD, this.tf));
    }



    public boolean isMoving() {
        return moving;
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

    public void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
