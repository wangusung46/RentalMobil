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
import javafx.scene.control.Alert;
import rentalmobil.connection.Conn;
import rentalmobil.model.User;

/**
 *
 * @author Rakha
 */
public class UserJdbcImpl implements UserJdbc {

    private final Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;
    private final Alert alert;

    public UserJdbcImpl() {
        connection = Conn.getConnection();
        alert = new Alert(Alert.AlertType.NONE);
    }

    @Override
    public User selectUser(String username, String password) {
        User user = new User();
        try {
            sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setKode(resultSet.getLong(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            } else {
                user = null;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            getWarningMessage(e.getMessage());
        }
        return user;
    }

    private void getWarningMessage(String string) {
        alert.setAlertType(Alert.AlertType.WARNING);
        alert.setContentText(string);
        alert.show();
    }

}
