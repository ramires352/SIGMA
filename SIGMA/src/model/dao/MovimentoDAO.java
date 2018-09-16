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
import model.bean.Movimento;

/**
 *
 * @author ramires
 */
public class MovimentoDAO {
    
    public List<Movimento> readTerreno(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Movimento> movimentos = new ArrayList<>();
        
        try{
            stnt = con.prepareStatement("SELECT * FROM movimento WHERE idTerreno = ?");
            stnt.setInt(1, id);
            
            rs = stnt.executeQuery();
            
            while(rs.next()){
                Movimento m = new Movimento();
                
                m.setIdMov(rs.getInt("idMov"));
                m.setNf(rs.getString("nf"));
                m.setNome(rs.getString("nome"));
                m.setTipo(rs.getString("tipo"));
                m.setDescricao(rs.getString("descricao"));
                m.setPreco_un(rs.getDouble("preco_un"));
                m.setLogin(rs.getString("login"));
                
                m.setData(rs.getDate("data"));
                m.setIdTerreno(rs.getInt("idTerreno"));
                m.setQtde(rs.getDouble("qtde"));
                
                movimentos.add(m);
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return movimentos;
            
    }
    
    public List<Movimento> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Movimento> movimentos = new ArrayList<>();
        
        try{
            stnt = con.prepareStatement("SELECT * FROM movimento WHERE login = ?");
            stnt.setString(1, Cliente.getNome());
            rs = stnt.executeQuery();
            
            while(rs.next()){
                Movimento m = new Movimento();
                
                m.setIdMov(rs.getInt("idMov"));
                m.setNf(rs.getString("nf"));
                m.setNome(rs.getString("nome"));
                m.setTipo(rs.getString("tipo"));
                m.setQtde(rs.getDouble("qtde"));
                m.setDescricao(rs.getString("descricao"));
                m.setPreco_un(rs.getDouble("preco_un"));
                m.setLogin(rs.getString("login"));
                m.setData(rs.getDate("data"));
                
                m.setIdTerreno(rs.getInt("idTerreno"));
   
                
                movimentos.add(m);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return movimentos;
    }
    
}
