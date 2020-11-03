package com.mashibing.factory.abstractfactory;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-03
 * @sine: 0.0.1
 */
public class ModernFactory extends AbastractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
