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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import rentalmobil.connection.Conn;
import rentalmobil.model.JenisMobil;

/**
 *
 * @author Rakha
 */
public class JenisMobilJdbcImpl implements JenisMobilJdbc {

    private final Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;
    private final Alert alert;

    public JenisMobilJdbcImpl() {
        connection = Conn.getConnection();
        alert = new Alert(AlertType.NONE);
    }

    @Override
    public List<JenisMobil> selectJenisMobils() {
        List<JenisMobil> jenisMobils = new ArrayList<>();
        try {
            sql = "SELECT * FROM jenis_mobil";
            preparedStatement = connection.prepareStatement(sql);
            System.out.println(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                JenisMobil jenisMobil = new JenisMobil();
                jenisMobil.setKode(resultSet.getLong(1));
                jenisMobil.setNama(resultSet.getString(2));
                jenisMobil.setPlatNomor(resultSet.getString(3));
                jenisMobil.setHarga(resultSet.getBigDecimal(4));
                jenisMobils.add(jenisMobil);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            getWarningMessage(e.getMessage());
        }
        return jenisMobils;
    }
    
    private void getWarningMessage(String string) {
        alert.setAlertType(AlertType.WARNING);
        alert.setContentText(string);
        alert.show();
    }

    @Override
    public JenisMobil selectJenisMobil(String nama) {
        JenisMobil jenisMobil = new JenisMobil();
        try {
            sql = "SELECT * FROM jenis_mobil WHERE nama = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nama);
            System.out.println(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                jenisMobil.setKode(resultSet.getLong(1));
                jenisMobil.setNama(resultSet.getString(2));
                jenisMobil.setPlatNomor(resultSet.getString(3));
                jenisMobil.setHarga(resultSet.getBigDecimal(4));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            getWarningMessage(e.getMessage());
        }
        return jenisMobil;
    }

    @Override
    public void deleteMobil(String nama) {
        try {
            sql = "DELETE FROM jenis_mobil WHERE nama = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nama);
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            getWarningMessage(e.getMessage());
        }
    }

}
