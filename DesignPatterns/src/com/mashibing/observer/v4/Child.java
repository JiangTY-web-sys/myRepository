package com.mashibing.observer.v4;


/**
 * @description :
 * @author：jty
 * @date: 2020-11-10
 * @sine: 0.0.1
 */
public class Child {
    private boolean cry = false;
    private Dad dad = new Dad();
    private Mum mum = new Mum();
    private Dog dog = new Dog();

    public boolean isCry() {
        return cry;
    }

    public void wakeup() {
        cry = true;
        dad.feed();
        dog.wang();
        mum.hug();
    }

}
