package src.com.mashibing.proxy.v6;


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
        Tank t = new Tank();
        TankTimeProxy ttp = new TankTimeProxy(t);
        TankLogProxy tlp = new TankLogProxy(ttp);
        tlp.move();

//        new TankLogProxy(
//            new TankTimeProxy(
//                new Tank()
//            )
//        ).move();
    }
}

class TankTimeProxy implements Movable {
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move () {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}

class TankLogProxy implements Movable {
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move () {
        System.out.println("start moving...");
        m.move();
        System.out.println("stopped!");
    }
}

interface Movable{
    void move();
}
