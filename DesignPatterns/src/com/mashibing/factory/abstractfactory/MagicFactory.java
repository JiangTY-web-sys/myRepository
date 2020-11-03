package com.mashibing.factory.abstractfactory;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-03
 * @sine: 0.0.1
 */
public class MagicFactory extends AbastractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
