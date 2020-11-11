package com.msb.tank;

import com.msb.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * @description :坦克类
 * @author：jty
 * @date: 2020-09-17
 * @sine: 0.0.1
 */
public class Tank extends GameObject{
    public Dir dir = Dir.DOWN;
    private static final int SPEED = PropertyMgr.getInt("tankSpeed");
    public static final int WIDTH = ResourceMgr.tankU.getWidth();
    public static final int HEIGHT = ResourceMgr.tankU.getHeight();

    public Group group = Group.BAD;
    public Rectangle rect = new Rectangle();
    private boolean moving = true;
    private boolean living = true;

    private Random random = new Random();

    int oldX, oldY;

//    TankFrame tf;
//    FireStrategy fs = new DefaultFireStrategy();
    FireStrategy fs;

    public Tank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

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
        GameModel.getInstance().add(this);
    }

    public void paint(Graphics g) {
        if (!living) GameModel.getInstance().remove(this);
        switch (dir) {
            case LEFT:
            g.drawImage(this.group == Group.GOOD? ResourceMgr.tankL : ResourceMgr.enemyL,x,y,null);
            break;
            case UP:
            g.drawImage(this.group == Group.GOOD? ResourceMgr.tankU : ResourceMgr.enemyU,x,y,null);
            break;
            case RIGHT:
            g.drawImage(this.group == Group.GOOD? ResourceMgr.tankR : ResourceMgr.enemyR,x,y,null);
            break;
            case DOWN:
            g.drawImage(this.group == Group.GOOD? ResourceMgr.tankD : ResourceMgr.enemyD,x,y,null);
            break;
        }

        move();
    }

    @Override
    public int getWidth() {
        return WIDTH;

    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    private void move() {
        oldX = x;
        oldY = y;

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
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH -2) x = TankFrame.GAME_WIDTH - Tank.WIDTH -2;
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT -2) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT -2;
    }

    public void fire() {
//        fs.fire(this);
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            //装饰器运用
//            GameModel.getInstance().add(
//                    new RectDecorator(
//                            new TailDecorator(
//                                    new Bullet(bX, bY, dir, this.group))));

            new Bullet(bX, bY, dir, this.group);
            if (this.group == Group.GOOD)
                new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
        }
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void back() {
        x = oldX;
        y = oldY;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void die() {
        this.living = false;
    }

}
