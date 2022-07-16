import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void TakeScreenshot(String filePath, String fileName) throws Exception {
        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, "jpg", new File(filePath + fileName + ".jpg"));
            System.out.println("Сделан скриншот" + filePath + fileName);
        } catch (AWTException | IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}