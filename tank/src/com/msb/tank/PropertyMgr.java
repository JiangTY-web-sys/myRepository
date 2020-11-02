package com.msb.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @description :配置文件类
 * @author：jty
 * @date: 2020-11-02
 * @sine: 0.0.1
 */
public class PropertyMgr {
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int get(String key){
        if (props == null) return 0;
        return Integer.parseInt((String)props.get(key));
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
    }
}
