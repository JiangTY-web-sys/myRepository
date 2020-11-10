package com.mashibing.observer.v2;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-10
 * @sine: 0.0.1
 */
 class Child {
    private boolean cry = false;

    public boolean isCry() {
        return cry;
    }

    public void wakeup() {
        System.out.println("Wake Up! Crying wuwuwuwuwu...");
        cry = true;
    }

}
