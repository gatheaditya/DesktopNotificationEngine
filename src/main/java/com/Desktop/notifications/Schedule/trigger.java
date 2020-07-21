package com.Desktop.notifications.Schedule;
import com.Desktop.notifications.model.notification;
import com.Desktop.notifications.service.notificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.awt.*;

@Component
public class trigger {

        @Autowired
         private notificationService notificationService;


    @Scheduled(cron = "${cron.expression}")
    public void  displayNotification() throws AWTException
    {

        if (SystemTray.isSupported()) {

          notification notification= notificationService.getNOtification();
            displayTray(notification.message, notification.title);
        } else {
            System.err.println("System tray not supported!");
        }

        System.out.println("Started Notification Display ");
    }


    public  static void displayTray( String message , String title) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);
        trayIcon.displayMessage(title, message, TrayIcon.MessageType.NONE);


   }



}
