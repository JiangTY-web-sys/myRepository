package com.mashibing.factory.factorymethod;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-03
 * @sine: 0.0.1
 */
public class CarFactory {
    public Moveable create() {
        System.out.println("a car created!");
        return new Car();
    }
}
