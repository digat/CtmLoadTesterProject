/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctm.db;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author TareqSaleh
 */
public class DataBaseClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataBaseClient.class);
    private HikariDataSource hikariDataSource;

    public DataBaseClient() {
        LOGGER.info("-------- Oracle JDBC Connection Testing ------");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            LOGGER.error("Where is your Oracle JDBC Driver?");
        }
    }
    
    private HikariDataSource connectionPool() {
        String connString = "jdbc:sqlserver://172.20.0.156:1433;"
                + "DatabaseName=EFAWATEERCOM_BillerList_2.11;"
                + "encrypt=true;trustServerCertificate=true";
        //172.22.3.135
        //EFAWATEERCOMDB
        connString = "jdbc:sqlserver://172.22.3.135:1433;"
                + "DatabaseName=EFAWATEERCOMDB;"
                + "encrypt=true;trustServerCertificate=true";
        final HikariDataSource ds = new HikariDataSource();
        //ds.setMaximumPoolSize(Functions.calculateBoolSize());
        ds.setMaximumPoolSize(500);
        ds.setMinimumIdle(200);
        ds.setIdleTimeout(60000L);
        ds.setConnectionTimeout(6000000);
        ds.setLeakDetectionThreshold(60000);
        ds.setMaxLifetime(600000);
        ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ds.setJdbcUrl(connString);
        ds.setUsername("CTMUser");
        ds.setPassword("CTMUser");
        return ds;
    }
        public Connection getConnectionEx() {
        try {
            return hikariDataSource.getConnection();
        } catch (SQLException ex) {
            LOGGER.error("{}", ex);
            return null;
        }
    }

    public boolean isClosed() {
        return hikariDataSource.isClosed();
    }

    void closeDb() {
        if (hikariDataSource != null) {
            hikariDataSource.close();
        }
    }
    
    public void openDb() {
        hikariDataSource = connectionPool();
    }
    
}
