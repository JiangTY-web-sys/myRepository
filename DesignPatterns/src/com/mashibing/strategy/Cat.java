package com.mashibing.strategy;

/**
 * @description :
 * @author：jty
 * @date: 2020-11-03
 * @sine: 0.0.1
 */
public class Cat implements Comparable<Cat>{
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int compareTo(Cat c) {
        if (this.weight     < c.weight) return -1;
        else if (this.weight > c.weight) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
