package com.msb.test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ImageTest {

    @Test
    void test() {
        try {
            BufferedImage image = ImageIO.read(new File("C:/Users/FengHT/Pictures/球儿.jpg"));
            assertNotNull(image);

            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/球儿.jpg"));
            assertNotNull(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}