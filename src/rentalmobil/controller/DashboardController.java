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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import rentalmobil.Main;
import rentalmobil.jdbc.UserJdbc;
import rentalmobil.jdbc.UserJdbcImpl;

/**
 * FXML Controller class
 *
 * @author Khanza
 */
public class DashboardController implements Initializable {

    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonView;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonLogout;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void performAdd(ActionEvent event) throws IOException {
        Main.setRoot("Add");
    }

    @FXML
    private void performView(ActionEvent event) throws IOException {
        Main.setRoot("View");
    }

    @FXML
    private void performDelete(ActionEvent event) throws IOException {
        Main.setRoot("Delete");
    }

    @FXML
    private void performBack(ActionEvent event) throws IOException {
        Main.setRoot("Login");
    }

}
