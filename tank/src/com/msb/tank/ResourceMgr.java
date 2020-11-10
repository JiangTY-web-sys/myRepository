package com.msb.tank;

import com.msb.tank.util.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @description :图片加载类
 * @author：jty
 * @date: 2020-09-19
 * @sine: 0.0.1
 */
public class ResourceMgr {
    public static BufferedImage tankL, tankU, tankR, tankD;
    public static BufferedImage enemyL, enemyU, enemyR, enemyD;
    public static BufferedImage  btL, btU, btR, btD;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            tankL = ImageUtil.rotateImage(tankU,-90);
            tankR = ImageUtil.rotateImage(tankU,90);
            tankD = ImageUtil.rotateImage(tankU,180);

            enemyU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            enemyL = ImageUtil.rotateImage(enemyU,-90);
            enemyR = ImageUtil.rotateImage(enemyU,90);
            enemyD = ImageUtil.rotateImage(enemyU,180);

            btU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            btL = ImageUtil.rotateImage(btU,-90);
            btR = ImageUtil.rotateImage(btU,90);
            btD = ImageUtil.rotateImage(btU,180);

            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
