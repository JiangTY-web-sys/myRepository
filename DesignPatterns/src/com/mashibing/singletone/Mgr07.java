package com.mashibing.singletone;

/**
 * @description :静态内部类方式
 *          完美写法之一
 * @author：jty
 * @date: 2020-11-02
 * @sine: 0.0.1
 */
public class Mgr07 {
    private Mgr07 () {}

    private static class Mgr07Holder{
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return Mgr07Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->{
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
    }
}
