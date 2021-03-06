package com.ui.questionPage;

import com.jfoenix.controls.JFXButton;
import com.ui.utility.alert.AlertMaker;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class questionPageController implements Initializable {

    @FXML
    private Label closeLabel, minimizeLabel;

    @FXML
    private StackPane rootPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
