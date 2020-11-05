package com.msb.tank;

import java.awt.*;

/**
 * @description :子弹类
 * @author：jty
 * @date: 2020-09-17
 * @sine: 0.0.1
 */
public class Bullet {
    private static final int SPEED = PropertyMgr.getInt("bulletSpeed");
    public static final int WIDTH = ResourceMgr.btD.getWidth();
    public static final int HEIGHT = ResourceMgr.btD.getHeight();

    Rectangle rect = new Rectangle();

    private Group group = Group.BAD;
    GameModel gm;

    private int x, y;
    private Dir dir;
    private boolean living = true;

    public Bullet(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        gm.bs.add(this);
    }

    public void paint(Graphics g) {
        if (!living) gm.bs.remove(this);

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.btL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.btU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.btR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.btD,x,y,null);
                break;
        }
        move();
    }

    private void move() {
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

        //update rect
        rect.x = this.x;
        rect.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    public void collideWith(Tank t) {
        if (this.group == t.getGroup()) return;

        if (rect.intersects(t.rect)){
            t.die();
            this.die();

            int tX = t.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int tY = t.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            gm.explodes.add(new Explode(tX, tY, gm));
        }

    }

    private void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
