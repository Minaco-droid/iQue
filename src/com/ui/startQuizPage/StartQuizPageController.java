package com.ui.startQuizPage;

import com.jfoenix.controls.JFXButton;
import com.ui.utility.alert.AlertMaker;
import com.ui.utility.style.WindowStyle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class StartQuizPageController  implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private Button startQuiz;

    @FXML
    private Label minimizeLabel, closeLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void setStartQuiz() throws Exception {
        Stage primaryStage = (Stage) startQuiz.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/ui/questionPage/question_page.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
//        runThread.stop();
        WindowStyle.allowDrag(root, primaryStage);
        primaryStage.show();
    }


    //    Method implementation abstracted using the RequestHandler Singleton class
    @FXML
    public void closeLabelPressed() {
        JFXButton yesButton = new JFXButton("Okay");
        JFXButton cancelButton = new JFXButton("Cancel");
        AlertMaker.showMaterialDialog(rootPane, Arrays.asList(yesButton, cancelButton), "Exit", "Are you sure you want to exit?");
        yesButton.setOnAction(event -> Platform.exit());
    }

    @FXML
    public void minimizeLabelPressed(MouseEvent mouseEvent) {
        AlertMaker.getInstance().handleMinimize((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow());
    }
}
