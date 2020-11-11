package com.msb.tank;


import java.awt.*;

/**
 * @description :子弹类
 * @author：jty
 * @date: 2020-09-17
 * @sine: 0.0.1
 */
public class Bullet extends GameObject{
    private static final int SPEED = PropertyMgr.getInt("bulletSpeed");
    public static final int WIDTH = ResourceMgr.btD.getWidth();
    public static final int HEIGHT = ResourceMgr.btD.getHeight();

    public Rectangle rect = new Rectangle();
    public Group group = Group.BAD;
//    private TankFrame tf;

    private Dir dir;
    private boolean living = true;

    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        GameModel.getInstance().add(this);
    }

    public void paint(Graphics g) {
        if (!living) GameModel.getInstance().remove(this);

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

    @Override
    public int getWidth() {
        return WIDTH;

    }

    @Override
    public int getHeight() {
        return HEIGHT;
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

//    public boolean collideWith(Tank t) {
//        if (this.group == t.getGroup()) return false;
//
//        if (rect.intersects(t.rect)){
//            t.die();
//            this.die();
//
//            int tX = t.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
//            int tY = t.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
//            gm.add(new Explode(tX, tY, gm));
//            return true;
//        }
//            return false;
//
//    }

    public void die() {
        this.living = false;
    }

}
