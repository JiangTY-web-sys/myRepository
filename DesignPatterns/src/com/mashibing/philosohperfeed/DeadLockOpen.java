package com.mashibing.philosohperfeed;

/**
 * @description :科学家就餐问题
 * @author：jty
 * @date: 2020-11-10
 * @sine: 0.0.1
 */
public class DeadLockOpen {
    public static void main(String[] args) {
        ChopStick cs0 = new ChopStick();
        ChopStick cs1 = new ChopStick();
        ChopStick cs2 = new ChopStick();
        ChopStick cs3 = new ChopStick();
        ChopStick cs4 = new ChopStick();

        Philosohper p0 = new Philosohper("p0",0,cs0,cs1);
        Philosohper p1 = new Philosohper("p1",1,cs1,cs2);
        Philosohper p2 = new Philosohper("p2",2,cs2,cs3);
        Philosohper p3 = new Philosohper("p3",3,cs3,cs4);
        Philosohper p4 = new Philosohper("p4",4,cs4,cs0);

        p0.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }

    public static class Philosohper extends Thread {
        private ChopStick left, right;
        private int index;

        public Philosohper (String name, int index, ChopStick left, ChopStick right) {
            this.setName(name);
            this.index = index;
            this.left = left;
            this.right = right;
        }

        @Override
        public void run ()  {
            if (index == 0) {
                synchronized (left)  {
                    try {
                        this.sleep(1000 + index * 1000);
                        synchronized (right) {
                            this.sleep(1000);
                            System.out.println(index + "吃完了！");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                synchronized (right)  {
                    try {
                        this.sleep(1000 + index * 1000);
                        synchronized (left) {
                            this.sleep(1000);
                            System.out.println(index + "吃完了！");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
