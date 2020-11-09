package com.msb.tank;

import com.msb.tank.cor.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description :
 * @author：jty
 * @date: 2020/11/8
 * @sine: 0.0.1
 */
public class GameModel {
    Tank myTank = new Tank(400,400,Dir.UP, Group.GOOD,this);

//    public List<Bullet> bs = new ArrayList<>();
//    public List<Tank> ts = new ArrayList<>();
//    public List<Explode> explodes = new ArrayList<>();

    ColliderChain chain = new ColliderChain();

    private List<GameObject> objects = new ArrayList<>();

    public void add(GameObject go) {
        objects.add(go);
    }
    public void remove(GameObject go) {
        objects.remove(go);
    }

    public GameModel() {
        int initTankCount = PropertyMgr.getInt("initTankCount");

        //初始化敌方坦克
        for (int i = 0; i <initTankCount ; i++) {
            add(new Tank(50 + i*150, 100, Dir.DOWN, Group.BAD, this));
        }

    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量：" + bs.size(), 10, 60);
//        g.drawString("敌人的数量：" + ts.size(), 10, 80);
//        g.drawString("爆炸的数量：" + explodes.size(), 10, 100);
        g.setColor(c);

        myTank.paint(g);
        for (int i = 0; i <objects.size() ; i++) {
            objects.get(i).paint(g);
        }

        //互相碰撞
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i+1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                chain.collide(o1, o2);
            }
        }
//        for (int i = 0; i < bs.size(); i++) {
//            for (int j = 0; j < ts.size(); j++) {
//                bs.get(i).collideWith(ts.get(j));
//            }
//        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
