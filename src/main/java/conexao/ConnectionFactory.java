package conexao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private String url;
    private String password;
    private String user;
    private String driver;
    private static ConnectionFactory instance = null;

    public ConnectionFactory() {
        this.url = "jdbc:postgresql://localhost:5432/projetoPw";
        this.password = "123456";
        this.user = "postgres";
        this.driver = "org.postgresql.Driver";
    }

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName(this.driver);
            return DriverManager.getConnection(this.url, this.user, this.password);
        } catch (ClassNotFoundException ex){
            throw new SQLException(ex);
        }
    }
   
    
} 