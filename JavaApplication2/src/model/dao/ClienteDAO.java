/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Cliente;

/**
 *
 * @author ramir
 */
public class ClienteDAO {
    
    public void create(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try {
            stnt = con.prepareStatement("INSERT INTO cliente (login, senha) VALUES (?,?)");
            stnt.setString(1, c.getLogin());
            stnt.setString(2, c.getSenha());
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso! ");
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    public boolean checkLogin(String login, String senha){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null; 
        boolean check = false;
        try {
            stnt = con.prepareStatement("SELECT * FROM cliente WHERE login = ? and senha = ?");
            stnt.setString(1, login);
            stnt.setString(2, senha);
            rs = stnt.executeQuery();
            if(rs.next()){  
                check = true;
            }
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        } 
        return check;
    }

}       