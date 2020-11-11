package com.msb.tank;

import com.msb.tank.cor.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-05
 * @sine: 0.0.1
 */
public class GameModel {

    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    public static GameModel getInstance() {
        return INSTANCE;
    }

    Tank myTank;

    ColliderChain chain = new ColliderChain();

    private List<GameObject> objects = new ArrayList<>();

    public void add(GameObject go) {
        objects.add(go);
    }
    public void remove(GameObject go) {
        objects.remove(go);
    }

    public GameModel() {}

    private void init() {
        myTank = new Tank(400,400,Dir.UP, Group.GOOD);

        int initTankCount = PropertyMgr.getInt("initTankCount");

        //初始化敌方坦克
        for (int i = 0; i <initTankCount ; i++) {
            new Tank(50 + i*150, 100, Dir.DOWN, Group.BAD);
        }

        //增加新物体
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));

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
    }

    public Tank getMainTank() {
        return myTank;
    }
}
