package com.mashibing.strategy;

/**
 * @description :猫的重量比较器
 * @author：jty
 * @date: 2020-11-03
 * @sine: 0.0.1
 */
public class CatWeightComparator implements Comparator<Cat>{
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.weight < o2.weight) return -1;
        else if (o1.weight > o2.weight) return 1;
        return 0;
    }
}
