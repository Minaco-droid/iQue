package com.ui.loginPage;

import com.jfoenix.controls.JFXButton;
import com.ui.utility.WindowStyle;
import com.ui.utility.alert.AlertMaker;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private JFXButton loginButton, createNewAccount;

    @FXML
    private Label minimizeLabel, closeLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void openMainAppPage() throws IOException {
        Stage primaryStage = (Stage) loginButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("com.ui.mainAppPage.mainApp_page.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        WindowStyle.allowDrag(root, primaryStage);
        primaryStage.show();
    }

    @FXML
    public void openSignUpPage() throws IOException {
        Stage primaryStage = (Stage) createNewAccount.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("com.ui.signUpPage.signUp_page.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
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
