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
import model.bean.Plantio;

/**
 *
 * @author ramires
 */
public class PlantioDAO {
    public List<Plantio> readTerreno(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Plantio> plantios = new ArrayList<>();
        
        try{
            stnt = con.prepareStatement("SELECT * FROM colheita WHERE idTerreno = ?");
            stnt.setInt(1, id);
            
            rs = stnt.executeQuery();
            
            while(rs.next()){
                Plantio p = new Plantio();
                
                p.setIdPlantio(rs.getInt("idPlantio"));
                p.setSementes(rs.getString("sementes"));
                p.setQtde_sementes(rs.getDouble("qtde_sementes"));
                
                p.setData(rs.getDate("data"));
                p.setIdTerreno(rs.getInt("idTerreno"));
                p.setCultura(rs.getString("cultura"));
                
                plantios.add(p);
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return plantios;
            
    }
    
    public List<Plantio> readFiltro(String de, String ate){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Plantio> plantios = new ArrayList<>();
        
        try{
            stnt = con.prepareStatement("SELECT * FROM plantio WHERE idTerreno IN (SELECT idTerreno FROM terreno WHERE login = ?) AND data >= ? AND data <= ?");
            stnt.setString(1,Cliente.getNome());
            stnt.setString(2,de);
            stnt.setString(3,ate);    
            
            rs = stnt.executeQuery();
            
            while(rs.next()){
                Plantio p = new Plantio();
                
                p.setIdPlantio(rs.getInt("idPlantio"));
                p.setIdTerreno(rs.getInt("idTerreno"));
                p.setData(rs.getDate("data"));
                p.setSementes(rs.getString("sementes"));
                p.setQtde_sementes(rs.getDouble("qtde_sementes"));
                p.setCultura(rs.getString("cultura"));
                
                plantios.add(p);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return plantios;
    }
    
    public List<Plantio> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Plantio> plantios = new ArrayList<>();
        
        try{
            stnt = con.prepareStatement("SELECT * FROM plantio WHERE idTerreno IN (SELECT idTerreno FROM terreno WHERE login = ?)");
            stnt.setString(1,Cliente.getNome());
            rs = stnt.executeQuery();
            
            while(rs.next()){
                Plantio p = new Plantio();
                
                p.setIdPlantio(rs.getInt("idPlantio"));
                p.setIdTerreno(rs.getInt("idTerreno"));
                p.setData(rs.getDate("data"));
                p.setSementes(rs.getString("sementes"));
                p.setQtde_sementes(rs.getDouble("qtde_sementes"));
                p.setCultura(rs.getString("cultura"));
                
                plantios.add(p);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return plantios;
    }
    
    public void delete(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("DELETE FROM plantio WHERE idPlantio = ?");
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
