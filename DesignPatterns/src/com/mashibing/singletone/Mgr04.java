package com.mashibing.singletone;

/**
 * @description :饿汉式 加锁  效率降低
 * @author：jty
 * @date: 2020-11-02
 * @sine: 0.0.1
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04() {}

    public static synchronized Mgr04 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->{
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }
}
