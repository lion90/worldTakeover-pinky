package com.uy.lion.worldTakeover.pinky.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author lion
 * @since 18/06/17
 */
public class PersistenceManager {

    //<editor-fold defaulstate="collapsed" desc="CONSTANTS">
    private static final String URL = "jdbc:postgresql://127.0.0.1/worldTakeover";
    private static final String USER = "lion";
    private static final String PASSWORD =
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="PUBLIC METHODS">

    public static PreparedStatement statement(String sSql) {
        try {
            return getConnection().prepareStatement(sSql);
        } catch (SQLException e) {
            System.out.println("Exception caught on PersistenceManager.statement(String)");
            System.out.println("Exception class: " + e.getClass());
            System.out.println("Exception message: " + e.getMessage());
            System.out.println("sSql = [" + sSql + "]");
            //FIXME [LION] Create exceptions.
            throw new RuntimeException();
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="PRIVATE METHODS">
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
//</editor-fold>
}
