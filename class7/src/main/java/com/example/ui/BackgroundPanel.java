package com.example.ui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class BackgroundPanel extends JPanel{
    private Image backgroundImage;

    public BackgroundPanel() {
        try{
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("background.png");
            if(inputStream != null){
                backgroundImage = ImageIO.read(inputStream);
            }else{
                System.out.println("Failed to Load Background Image");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 重写paincompaint，使其默认输出的背景为自定义图片
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(backgroundImage!= null){
            // 创建一个新的 BufferedImage, 大小与backgroundImage相同
            BufferedImage bufferedImage = new BufferedImage(
                backgroundImage.getWidth(this), 
                backgroundImage.getHeight(this), 
                BufferedImage.TYPE_INT_ARGB);

            // 将原图绘制到 BufferedImage 上
            // 创建画笔，设置画笔格式为50%透明度
            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
            g2d.drawImage(backgroundImage, 0, 0, this);
            g2d.dispose();

            // 将重绘的图像绘制到背景面板上
            g.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
