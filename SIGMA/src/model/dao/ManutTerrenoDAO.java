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
import model.bean.ManutTerreno;

/**
 *
 * @author ramires
 */
public class ManutTerrenoDAO {
    
    public List<ManutTerreno> readTerreno(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<ManutTerreno> manutTerrenos = new ArrayList<>();
        
        try{
            stnt = con.prepareStatement("SELECT * FROM manut_terreno WHERE idTerreno = ?");
            stnt.setInt(1, id);
            
            rs = stnt.executeQuery();
            
            while(rs.next()){
                ManutTerreno mt = new ManutTerreno();
                
                mt.setIdManut_terreno(rs.getInt("idManut_terreno"));
                mt.setNome(rs.getString("nome"));
                mt.setDefensivo(rs.getString("defensivo"));
                mt.setData(rs.getDate("data"));
                mt.setIdTerreno(rs.getInt("idTerreno"));
                
                manutTerrenos.add(mt);
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return manutTerrenos;
            
    }
    
    public List<ManutTerreno> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<ManutTerreno> manutTerrenos = new ArrayList<>();
        
        try{
            stnt = con.prepareStatement("SELECT * FROM manut_terreno WHERE login = ?");
            stnt.setString(1, Cliente.getNome());
            
            rs = stnt.executeQuery();
            
            while(rs.next()){
                ManutTerreno mt = new ManutTerreno();
                
                mt.setIdManut_terreno(rs.getInt("idManut_terreno"));
                mt.setNome(rs.getString("nome"));
                mt.setDefensivo(rs.getString("defensivo"));
                mt.setData(rs.getDate("data"));
                mt.setIdTerreno(rs.getInt("idTerreno"));
                
                manutTerrenos.add(mt);
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return manutTerrenos;
            
    }
    
    public List<ManutTerreno> readFiltro(String de, String ate){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<ManutTerreno> manutTerrenos = new ArrayList<>();
        
        try{
            stnt = con.prepareStatement("SELECT * FROM manut_terreno WHERE login = ? and data >= ? AND data <= ?");
            stnt.setString(1, Cliente.getNome());
            stnt.setString(2, de);
            stnt.setString(3, ate);
            
            rs = stnt.executeQuery();
            
            while(rs.next()){
                ManutTerreno mt = new ManutTerreno();
                
                mt.setIdManut_terreno(rs.getInt("idManut_terreno"));
                mt.setNome(rs.getString("nome"));
                mt.setDefensivo(rs.getString("defensivo"));
                mt.setData(rs.getDate("data"));
                mt.setIdTerreno(rs.getInt("idTerreno"));
                
                manutTerrenos.add(mt);
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return manutTerrenos;
            
    }
}
