package com.msb.tank;

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

    Tank myTank = new Tank(400,400,Dir.UP, Group.GOOD,this);
    public java.util.List<Bullet> bs = new ArrayList<>();
    public java.util.List<Tank> ts = new ArrayList<>();
    public List<Explode> explodes = new ArrayList<>();

    public GameModel() {
        int initTankCount = PropertyMgr.getInt("initTankCount");

        //初始化敌方坦克
        for (int i = 0; i <initTankCount ; i++) {
            ts.add(new Tank(50 + i*150, 100, Dir.DOWN, Group.BAD, this));
        }

    }

    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bs.size(), 10, 60);
        g.drawString("敌人的数量：" + ts.size(), 10, 80);
        g.drawString("爆炸的数量：" + explodes.size(), 10, 100);
        g.setColor(c);

        myTank.paint(g);
        for (int i = 0; i <bs.size() ; i++) {
            bs.get(i).paint(g);
        }
        for (int j = 0; j <ts.size() ; j++) {
            ts.get(j).paint(g);
        }

        for (int i = 0; i < bs.size(); i++) {
            for (int j = 0; j < ts.size(); j++) {
                bs.get(i).collideWith(ts.get(j));
            }
        }
        for (int z = 0; z <explodes.size() ; z++) {
            explodes.get(z).paint(g);
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
