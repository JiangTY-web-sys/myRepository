package com.mashibing.strategy;

/**
 * @description :狗的比较器
 * @author：jty
 * @date: 2020-11-03
 * @sine: 0.0.1
 */
public class DogComparator implements Comparator<Dog>{
    @Override
    public int compare(Dog o1, Dog o2) {
        if (o1.food < o2.food) return -1;
        else if (o1.food > o2.food) return 1;
        return 0;
    }
}
