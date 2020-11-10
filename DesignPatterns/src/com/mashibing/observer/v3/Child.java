package com.mashibing.observer.v3;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-10
 * @sine: 0.0.1
 */
public class Child {
    private boolean cry = false;
    private Dad d = new Dad();

    public boolean isCry() {
        return cry;
    }

    public void wakeup() {
        cry = true;
        d.feed();
    }

}
