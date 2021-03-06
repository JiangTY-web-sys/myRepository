package com.msb.tank;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        TankFrame tf = new TankFrame();
        int initTankCount = PropertyMgr.getInt("initTankCount");

        //初始化敌方坦克
        for (int i = 0; i <initTankCount ; i++) {
            tf.ts.add(tf.gf.createTank(50 + i*150, 100, Dir.DOWN, Group.BAD, tf));
        }

        new Thread(()->new Audio("audio/war1.wav").loop()).start();

        while (true){
            Thread.sleep(50);
            tf.repaint();
        }

    }
}
