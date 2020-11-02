package com.mashibing.singletone;

/**
 * @description :懒汉式
 * @author：jty
 * @date: 2020-11-02
 * @sine: 0.0.1
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01(){}

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }
}
