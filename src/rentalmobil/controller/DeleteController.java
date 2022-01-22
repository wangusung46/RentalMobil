/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package rentalmobil.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import rentalmobil.Main;
import rentalmobil.jdbc.MobilJdbc;
import rentalmobil.jdbc.MobilJdbcImpl;
import rentalmobil.model.Mobil;

/**
 * FXML Controller class
 *
 * @author Khanza
 */
public class DeleteController implements Initializable {

    private MobilJdbc mobilJdbc;

    private Alert alert;

    @FXML
    private TableView<Mobil> tabelPesanan;
    @FXML
    private TableColumn<Mobil, String> kolomKode;
    @FXML
    private TableColumn<Mobil, String> kolomNama;
    @FXML
    private TableColumn<Mobil, String> kolomKtp;
    @FXML
    private TableColumn<Mobil, String> kolomHp;
    @FXML
    private TableColumn<Mobil, String> kolomMobil;
    @FXML
    private TableColumn<Mobil, String> kolomSewa;
    @FXML
    private TableColumn<Mobil, String> kolomPengembalian;
    @FXML
    private TableColumn<Mobil, String> kolomPlat;
    @FXML
    private TableColumn<Mobil, String> kolomHarga;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonback;
    @FXML
    private ComboBox comboKode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mobilJdbc = new MobilJdbcImpl();
        alert = new Alert(Alert.AlertType.NONE);
        loadTableMobil();
        setCombo();
    }

    @FXML
    private void performDelete(ActionEvent event) {
        if (comboKode.getSelectionModel().getSelectedItem() != null) {
            mobilJdbc.deleteMobil(Long.parseLong(comboKode.getSelectionModel().getSelectedItem().toString()));
            getSuccessMessage("Data Berhasil di hapus");
            setCombo();
            loadTableMobil();
        } else {
            getWarningMessage("Pilih salah satu kode mobil");
        }

    }

    @FXML
    private void performBack(ActionEvent event) throws IOException {
        Main.setRoot("Dashboard");
    }

    private void loadTableMobil() {
        kolomKode.setCellValueFactory(new PropertyValueFactory<>("kode"));
        kolomNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kolomKtp.setCellValueFactory(new PropertyValueFactory<>("nomorKtp"));
        kolomHp.setCellValueFactory(new PropertyValueFactory<>("nomorHp"));
        kolomMobil.setCellValueFactory(new PropertyValueFactory<>("jinisMobil"));
        kolomSewa.setCellValueFactory(new PropertyValueFactory<>("tanggalSewa"));
        kolomPengembalian.setCellValueFactory(new PropertyValueFactory<>("tanggalPengambilan"));
        kolomPlat.setCellValueFactory(new PropertyValueFactory<>("platNomor"));
        kolomHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        List<Mobil> mobils = mobilJdbc.selectMobils();
        ObservableList<Mobil> observableList = FXCollections.observableArrayList();
        for (Mobil mobil : mobils) {
            observableList.add(mobil);
            TableViewLoadMobil(observableList);
        }
    }

    private void TableViewLoadMobil(ObservableList<Mobil> observableList) {
        tabelPesanan.setItems(observableList);
    }

    private void setCombo() {
        comboKode.getItems().clear();
        List<Mobil> mobils = mobilJdbc.selectMobils();
        for (Mobil mobil : mobils) {
            comboKode.getItems().addAll(mobil.getKode());
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
