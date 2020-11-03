package com.mashibing.strategy;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-03
 * @sine: 0.0.1
 */
public class Dog implements Comparable<Dog> {
    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Dog d) {
        if (this.food < d.food) return -1;
        else if (this.food > d.food) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
