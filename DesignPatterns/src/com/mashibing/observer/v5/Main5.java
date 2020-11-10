package com.mashibing.observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-10
 * @sine: 0.0.1
 */

class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeup() {
        cry = true;
        for (Observer o : observers) {
            o.actionOnWakeUp();
        }
    }

}

interface Observer {
    void actionOnWakeUp();
}

class Dad implements Observer {
    public void feed () {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp() {
        feed();
    }
}

class Mum implements Observer {
    public void hug () {
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp() {
        hug();
    }
}

class Dog implements Observer {
    public void wang () {
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWakeUp() {
        wang();
    }
}

public class Main5 {
    public static void main(String[] args) {
        Child c = new Child();
        c.wakeup();
    }
}
