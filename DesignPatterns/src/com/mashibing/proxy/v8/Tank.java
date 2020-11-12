package src.com.mashibing.proxy.v8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @description :动态代理
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
        Tank tank = new Tank();

        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");

        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                                                new Class[]{Movable.class},
                                                new LogProxy(tank)
                );
        m.move();
    }
}

class LogProxy implements InvocationHandler {
    Movable m;

    public LogProxy(Movable m) {
        this.m = m;
    }

    public void before() {System.out.println("method start...");}
    public void after() {System.out.println("method stop...");}

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(m, args);
        after();
        return o;
    }
}

interface Movable{
    void move();
}
