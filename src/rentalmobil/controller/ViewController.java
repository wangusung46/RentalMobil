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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
public class ViewController implements Initializable {

    private MobilJdbc mobilJdbc;

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
    private Button doBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mobilJdbc = new MobilJdbcImpl();
        loadTableMobil();
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
}
