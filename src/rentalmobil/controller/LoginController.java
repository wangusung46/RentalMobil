/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package rentalmobil.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import rentalmobil.Main;
import rentalmobil.jdbc.UserJdbc;
import rentalmobil.jdbc.UserJdbcImpl;
import rentalmobil.model.User;

/**
 * FXML Controller class
 *
 * @author Khanza
 */
public class LoginController implements Initializable {

    private UserJdbc userJdbc;
    
    private Alert alert;

    @FXML
    private TextField fieldUsername;
    @FXML
    private Button buttonLogin;
    @FXML
    private PasswordField fieldPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userJdbc = new UserJdbcImpl();
        alert = new Alert(Alert.AlertType.NONE);
    }

    @FXML
    private void performLogin(ActionEvent event) throws IOException {
        User user = userJdbc.selectUser(fieldUsername.getText(), fieldPassword.getText());
        if (user != null) {
            Main.setRoot("Dashboard");
        } else {
            getWarningMessage("Username dan Password salah");
        }
    }
    
    private void getWarningMessage(String string) {
        alert.setAlertType(Alert.AlertType.WARNING);
        alert.setContentText(string);
        alert.show();
    }

}
