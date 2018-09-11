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
import java.util.ArrayList;
import java.util.List;
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
    public List<Produto> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Produto> prod = new ArrayList<>();
        try{
            stnt = con.prepareStatement("select *from produto where login = ?");
            stnt.setString(1, Cliente.getNome());
            rs = stnt.executeQuery();
            
                while(rs.next()){
                    
                    Produto t = new Produto();

                    t.setIdProduto(rs.getInt("idProduto"));
                    t.setNome(rs.getString("nome"));
                    t.setTipo(rs.getString("tipo"));
                    t.setPreco(rs.getDouble("preco"));
                    t.setQtde(rs.getDouble("qtde"));
                    
  

                    prod.add(t);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return prod;
    }
}
