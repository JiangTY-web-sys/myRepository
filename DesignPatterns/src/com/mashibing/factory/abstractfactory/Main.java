package com.mashibing.factory.abstractfactory;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-03
 * @sine: 0.0.1
 */
public class Main {
    public static void main(String[] args) {
        AbastractFactory factory = new ModernFactory();
        Vehicle c = factory.createVehicle();
        c.go();
        Weapon w = factory.createWeapon();
        w.shoot();
        Food b = factory.createFood();
        b.printName();
    }
}
