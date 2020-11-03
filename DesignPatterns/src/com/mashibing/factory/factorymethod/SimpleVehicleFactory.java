package com.mashibing.factory.factorymethod;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-03
 * @sine: 0.0.1
 */
public class SimpleVehicleFactory {
    public Car createCar() {
        return new Car();
    }
    public Plane createPlane() {
        return new Plane();
    }
    public Broom createBroom() {
        return new Broom();
    }
}
