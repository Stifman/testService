package com.example.dao;

import com.example.data.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import org.springframework.stereotype.Repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDAO {

    private static final String url = "jdbc:mysql://localhost:3306/db";
    private static final String userName = "root";
    private static final String password = "root";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public List<User> getAllUsers() {
        String query = "SELECT u.iduser, u.name, u.secondname, u.email, r.role FROM user u INNER JOIN roles r ON u.fk = r.idroles ";
        User user;
        List<User> users = new ArrayList<>();
        try {
            con = (Connection) DriverManager.getConnection(url, userName, password);

            // getting Statement object to execute query
            stmt = (Statement) con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                user = new User.Builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .secondname(rs.getString(3))
                        .email(rs.getString(4))
                        .role(rs.getString(5)).build();

                users.add(user);


            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return users;
    }
}
