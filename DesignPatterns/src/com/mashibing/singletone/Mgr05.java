package com.mashibing.singletone;

/**
 * @description :饿汉式
 *    试图减小同步代码块提高效率，不能保证同一个实例
 * @author：jty
 * @date: 2020-11-02
 * @sine: 0.0.1
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05() {}

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr05.class) {
                try {
                    Thread.sleep(1);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->{
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }
}
