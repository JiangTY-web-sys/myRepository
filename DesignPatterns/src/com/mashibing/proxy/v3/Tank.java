package src.com.mashibing.proxy.v3;

import java.util.Random;

/**
 * @description :代理
 * @author：jty
 * @date: 2020-11-12
 * @sine: 0.0.1
 */
public class Tank implements Movable {
    //模拟坦克移动了一段时间
    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Tank2().move();
    }
}

class Tank2 extends Tank {
    @Override
    public void move () {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}

interface Movable{
    void move();
}
