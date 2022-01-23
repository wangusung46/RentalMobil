/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package rentalmobil.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import rentalmobil.Main;
import rentalmobil.jdbc.JenisMobilJdbc;
import rentalmobil.jdbc.JenisMobilJdbcImpl;
import rentalmobil.jdbc.MobilJdbc;
import rentalmobil.jdbc.MobilJdbcImpl;
import rentalmobil.model.JenisMobil;
import rentalmobil.model.Mobil;

/**
 * FXML Controller class
 *
 * @author Khanza
 */
public class AddController implements Initializable {

    private MobilJdbc mobilJdbc;

    private JenisMobilJdbc jenismobilJdbc;

    private Alert alert;

    @FXML
    private TextField fieldNama;
    @FXML
    private TextField fieldKtp;
    @FXML
    private TextField fieldHp;
    @FXML
    private ComboBox comboJenisMobil;
    @FXML
    private TextField fieldPlat;
    @FXML
    private Button buttonTambah;
    @FXML
    private DatePicker dateSewa;
    @FXML
    private DatePicker datePengambilan;
    @FXML
    private Button buttonBack;
    @FXML
    private TextField fieldHarga;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mobilJdbc = new MobilJdbcImpl();
        jenismobilJdbc = new JenisMobilJdbcImpl();
        alert = new Alert(Alert.AlertType.NONE);
        setCombo();
    }

    @FXML
    private void performTambah(ActionEvent event) {
        if (!fieldNama.getText().equals("")
                && !fieldKtp.getText().equals("")
                && !fieldHp.getText().equals("")
                && comboJenisMobil.getSelectionModel().getSelectedItem() != null
                && dateSewa.getValue() != null
                && datePengambilan.getValue() != null
                && !fieldPlat.getText().equals("")
                && !fieldHarga.getText().equals("")) {
            if (isNumeric(fieldHarga.getText())) {
                Long days;
                Mobil mobil = new Mobil(
                        fieldNama.getText(),
                        fieldKtp.getText(),
                        fieldHp.getText(),
                        comboJenisMobil.getSelectionModel().getSelectedItem().toString(),
                        dateSewa.getValue(),
                        datePengambilan.getValue(),
                        fieldPlat.getText(),
                        BigDecimal.valueOf((DAYS.between(dateSewa.getValue(), datePengambilan.getValue()) + 1) * Integer.parseInt(fieldHarga.getText()))
                );
                mobilJdbc.addMobil(mobil);
                setCombo();
                getSuccessMessage("Data Berhasil di simpan");
            } else {
                getWarningMessage("Harga harus berupa angka");
            }
        } else {
            getWarningMessage("Field Text Harus di isi Semua");
        }
    }

    @FXML
    private void performAddJenis(ActionEvent event) {
        if (comboJenisMobil.getSelectionModel().getSelectedItem() != null) {
            JenisMobil jenisMobil = jenismobilJdbc.selectJenisMobil(comboJenisMobil.getSelectionModel().getSelectedItem().toString());
            fieldPlat.setText(jenisMobil.getPlatNomor());
            fieldHarga.setText("" + jenisMobil.getHarga());
        } else {
            fieldPlat.setText("");
            fieldHarga.setText("");
        }

    }

    @FXML
    private void performBack(ActionEvent event) throws IOException {
        Main.setRoot("Dashboard");
    }

    private void setCombo() {
        comboJenisMobil.getItems().clear();
        List<JenisMobil> jenisMobils = jenismobilJdbc.selectJenisMobils();
        for (JenisMobil jenisMobil : jenisMobils) {
            comboJenisMobil.getItems().addAll(jenisMobil.getNama());
        }
    }

    private void getWarningMessage(String string) {
        alert.setAlertType(Alert.AlertType.WARNING);
        alert.setContentText(string);
        alert.show();
    }

    private void getSuccessMessage(String string) {
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setContentText(string);
        alert.show();
    }

    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

}
