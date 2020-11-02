package com.mashibing.singletone;

/**
 * @description :饿汉式 线程不安全
 * @author：jty
 * @date: 2020-11-02
 * @sine: 0.0.1
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {}

    public static Mgr03 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->{
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
