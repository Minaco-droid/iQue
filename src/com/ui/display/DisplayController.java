package com.ui.display;

import com.jfoenix.controls.JFXButton;
import com.ui.utility.style.WindowStyle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class DisplayController implements Initializable {

    @FXML
    private JFXButton proceedButton;

    private RunThread runThread;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        runThread = new RunThread(2000);
        runThread.start();
    }

    @FXML
    public void proceedButtonPressed() throws Exception {
        Stage primaryStage = (Stage) proceedButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/ui/loginPage/login_page.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        runThread.stop();
        WindowStyle.allowDrag(root, primaryStage);
        primaryStage.show();
    }


    //      Inner class to handle welcome_label on a separate thread.
    class RunThread implements Runnable {
        private final AtomicBoolean threadInterrupted = new AtomicBoolean(false);
        private final int interval;
        private Thread thread;

        public RunThread(int sleepInterval) {
            interval = sleepInterval;
        }

        public void start() {
            thread = new Thread(this);
            thread.start();
        }

        public void stop() {
            threadInterrupted.set(false);
            thread.interrupt();
        }

        public void run() {
            threadInterrupted.set(true);
            while (threadInterrupted.get()) {
                try {
                    Thread.sleep(interval);
                }catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

