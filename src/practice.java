import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class practice {
    public static void main(String[] args) {
        try {
            File file = new File("Resources\\2023_Template.png");
            BufferedImage bufferedImage = ImageIO.read(file);
            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.setColor(Color.black);
            g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 8));
            g2d.drawString("hi", 100, 100);
            g2d.dispose();
            file = new File("SampleBracket.png");

            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
