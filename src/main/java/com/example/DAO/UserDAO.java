package com.example.DAO;

import com.example.Data.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by степан on 10.06.2016.
 */
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
        User user = new User();
        List<User> users = new ArrayList<>();
        try {
            con = (Connection) DriverManager.getConnection(url, userName, password);

            // getting Statement object to execute query
            stmt = (Statement) con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSecondname(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setRole(rs.getString(5));
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
