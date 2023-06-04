/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author AD
 */
//DBContext
public class DBContext {
	public Connection getConnection() throws Exception {	       
            String url = "jdbc:sqlserver:// " + serverName+":" + portNumber+";databaseName="+dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, userID, password);
        }
        private final String serverName = "localhost";
        private final String dbName = "testDb";
        private final String portNumber = "1433";
        private final String userID = "sa";
        private final String password = "12345678";
}

