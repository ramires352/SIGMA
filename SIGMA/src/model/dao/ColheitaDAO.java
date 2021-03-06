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
import model.bean.Colheita;


/**
 *
 * @author ramires
 */
public class ColheitaDAO {
    
    public List<Colheita> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Colheita> colheitas = new ArrayList<>();
        
        try{
            stnt = con.prepareStatement("select * from colheita where idTerreno in (select idTerreno from terreno where login = ?)");
            stnt.setString(1,Cliente.getNome());
            
            rs = stnt.executeQuery();
            
            while(rs.next()){
                Colheita c = new Colheita();
                
                c.setData(rs.getDate("data"));
                c.setIdColheita(rs.getInt("idColheita"));
                c.setIdTerreno(rs.getInt("idTerreno"));
                c.setNomeTerreno(rs.getString("nomeTerreno"));
                c.setQtde(rs.getDouble("qtde"));
                c.setCultura(rs.getString("cultura"));
                
                colheitas.add(c);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return colheitas;
    }
    
    public List<Colheita> readFiltro(String de, String ate){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Colheita> colheitas = new ArrayList<>();
        
        try{
            stnt = con.prepareStatement("SELECT * FROM colheita WHERE idTerreno IN (SELECT idTerreno FROM terreno WHERE login = ?) AND data >= ? AND data <= ?");
            stnt.setString(1,Cliente.getNome());
            stnt.setString(2,de);
            stnt.setString(3,ate);    
            
            rs = stnt.executeQuery();
            
            while(rs.next()){
                Colheita c = new Colheita();
                
                c.setData(rs.getDate("data"));
                c.setIdColheita(rs.getInt("idColheita"));
                c.setIdTerreno(rs.getInt("idTerreno"));
                c.setNomeTerreno(rs.getString("nomeTerreno"));
                c.setQtde(rs.getDouble("qtde"));
                c.setCultura(rs.getString("cultura"));
                
                colheitas.add(c);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return colheitas;
    }
    
    public List<Colheita> readTerreno(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Colheita> colheitas = new ArrayList<>();
        
        try{
            stnt = con.prepareStatement("SELECT * FROM colheita WHERE idTerreno = ?");
            stnt.setInt(1, id);
            
            rs = stnt.executeQuery();
            
            while(rs.next()){
                Colheita c = new Colheita();
                
                c.setData(rs.getDate("data"));
                c.setIdColheita(rs.getInt("idColheita"));
                c.setIdTerreno(rs.getInt("idTerreno"));
                c.setNomeTerreno(rs.getString("nomeTerreno"));
                c.setQtde(rs.getDouble("qtde"));
                c.setCultura(rs.getString("cultura"));
                
                colheitas.add(c);
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return colheitas;
            
    }

    public void delete(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("DELETE FROM colheita WHERE idColheita = ?");
            stnt.setInt(1,id);
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Removido com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Remover! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    
}
