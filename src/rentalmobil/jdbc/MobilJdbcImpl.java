/*
 * Copyright (c) 2022 Rakha.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Rakha - initial API and implementation and/or initial documentation
 */
package rentalmobil.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import rentalmobil.connection.Conn;
import rentalmobil.model.Mobil;

/**
 *
 * @author Rakha
 */
public class MobilJdbcImpl implements MobilJdbc {

    private final Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;
    private final Alert alert;

    public MobilJdbcImpl() {
        connection = Conn.getConnection();
        alert = new Alert(Alert.AlertType.NONE);
    }

    @Override
    public List<Mobil> selectMobils() {
        List<Mobil> mobils = new ArrayList<>();
        try {
            sql = "SELECT * FROM mobil";
            preparedStatement = connection.prepareStatement(sql);
            System.out.println(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                Mobil mobil = new Mobil();
                mobil.setKode(resultSet.getLong(1));
                mobil.setNama(resultSet.getString(2));
                mobil.setNomorKtp(resultSet.getString(3));
                mobil.setNomorHp(resultSet.getString(4));
                mobil.setJinisMobil(resultSet.getString(5));
                mobil.setTanggalSewa(resultSet.getDate(6).toLocalDate());
                mobil.setTanggalPengambilan(resultSet.getDate(7).toLocalDate());
                mobil.setPlatNomor(resultSet.getString(8));
                mobil.setHarga(resultSet.getBigDecimal(9));
                mobils.add(mobil);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            getWarningMessage(e.getMessage());
        }
        return mobils;
    }

    @Override
    public void addMobil(Mobil mobil) {
        try {
            sql = "INSERT INTO mobil (nama, nomor_ktp, nomor_hp, jenis_mobil, tanggal_sewa, tanggal_pengambilan, plat_nomor, harga) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mobil.getNama());
            preparedStatement.setString(2, mobil.getNomorKtp());
            preparedStatement.setString(3, mobil.getNomorHp());
            preparedStatement.setString(4, mobil.getJinisMobil());
            preparedStatement.setDate(5, Date.valueOf(mobil.getTanggalSewa()));
            preparedStatement.setDate(6, Date.valueOf(mobil.getTanggalPengambilan()));
            preparedStatement.setString(7, mobil.getPlatNomor());
            preparedStatement.setBigDecimal(8, mobil.getHarga());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            getWarningMessage(e.getMessage());
        }
    }

    @Override
    public void deleteMobil(Long id) {
        try {
            sql = "DELETE FROM mobil WHERE kode = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            getWarningMessage(e.getMessage());
        }
    }

    @Override
    public Mobil selectMobil(Long id) {
        Mobil mobil = new Mobil();
        try {
            sql = "SELECT * FROM mobil WHERE kode = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mobil.setKode(resultSet.getLong(1));
                mobil.setNama(resultSet.getString(2));
                mobil.setNomorKtp(resultSet.getString(3));
                mobil.setNomorHp(resultSet.getString(4));
                mobil.setJinisMobil(resultSet.getString(5));
                mobil.setTanggalSewa(resultSet.getDate(6).toLocalDate());
                mobil.setTanggalPengambilan(resultSet.getDate(7).toLocalDate());
                mobil.setPlatNomor(resultSet.getString(8));
                mobil.setHarga(resultSet.getBigDecimal(9));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            getWarningMessage(e.getMessage());
        }
        return mobil;
    }
    
    private void getWarningMessage(String string) {
        alert.setAlertType(Alert.AlertType.WARNING);
        alert.setContentText(string);
        alert.show();
    }

}
