/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Produto;

/**
 *
 * @author marlene
 */
public class ProdutoDAO {
    public void create(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("insert into produto (nome, tipo, preco, qtde, login) values (?,?,?,?,?)");
            stnt.setString(1, p.getNome());
            stnt.setString(2, p.getTipo());
            stnt.setDouble(3, p.getPreco());
            stnt.setDouble(4, p.getQtde());
            stnt.setString(5, Cliente.getNome());
            
            
            stnt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        }
        finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
}
