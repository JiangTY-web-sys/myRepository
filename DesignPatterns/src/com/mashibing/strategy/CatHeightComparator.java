package com.mashibing.strategy;

/**
 * @description :猫的高度比较器
 * @author：jty
 * @date: 2020-11-03
 * @sine: 0.0.1
 */
public class CatHeightComparator implements Comparator<Cat>{
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.height > o2.height) return -1;
        else if (o1.height < o2.height) return 1;
        return 0;
    }
}
