import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Cam {

    public static void Capture(String filePath, String fileName, int widthx, int heighty) throws IOException {
        Webcam webcam = Webcam.getDefault();
        if (webcam != null) {
            System.out.println("Webcam: " + webcam.getName());
            webcam.setViewSize(new Dimension(widthx, heighty));
            webcam.open();
            ImageIO.write(webcam.getImage(), "PNG", new File(filePath + fileName + ".png"));
            webcam.close();
            System.out.println(filePath + fileName);
        }

    }
}
