/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * @author ramir
 */
public class ConnectionFactory {
    //BD freemysqlhosting
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10261050";
    private static final String USER = "sql10261050";
    private static final String PASS = "NZHbEHIZ94";
    
    //BD Local
    /*private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/sigmaBD?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "ramires2313";*/
    
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Conexao!");
            throw new RuntimeException("Erro de Conexao!",ex);
        }
    }
    
    public static void closeConnection(Connection con){
        
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro closeConnection",ex);
            }
        }
    
        public static void closeConnection(Connection con, PreparedStatement stnt){
        
            closeConnection(con);
            
            try {
                
                if(stnt != null){
                    stnt.close();
                }
                
            } catch (SQLException ex) {
                throw new RuntimeException("Erro closeConnection stnt",ex);
            }
        }
        
        public static void closeConnection(Connection con, PreparedStatement stnt, ResultSet rs){
        
            closeConnection(con, stnt);
            
            try {
                if(rs != null){
                    rs.close();
                }
                
            } catch (SQLException ex) {
                throw new RuntimeException("Erro closeConnection rs",ex);
            }
        }
}