package org.project.util;


import java.sql.*;


public class DBController {

    protected static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    //  Database credentials

    public static final String DB_URL = "jdbc:mysql://localhost:3306/test1";
    public static final String USER = "root";
    public static final String PASS = "argo1985";
    public static Connection conn = null;
    public static PreparedStatement stmt = null;
    public static ResultSet rs = null;


    public static boolean connectDB(String statement) {
        //connessione al server MySQL

        try {
            if(conn == null || conn.isClosed()) {
                Class.forName(JDBC_DRIVER).newInstance();
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.prepareStatement(statement);
                System.out.println("==Connected to MySQL Server==");
            }else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Connection failed!!\n" + e);
            disconnectDB();
            return false;
        }
        return true;
    }

    public static boolean disconnectDB() {
        //chiusura connessione db
        try {
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
            System.out.println("==DB Connection closed==");
            return true;
        } catch (Exception e) {
            System.out.println("Errore chiusura connessione DB!\n"+e);
            return false;
        }
    }


}