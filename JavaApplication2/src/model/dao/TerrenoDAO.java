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
import model.bean.Terreno;

/**
 *
 * @author ramires
 */
public class TerrenoDAO {
    public void create(Terreno t){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("INSERT INTO terreno (area,nome,login,estado,cultura,gastos) VALUES (?,?,?,?,?,?)");
            stnt.setDouble(1,t.getArea());
            stnt.setString(2,t.getNome());
            stnt.setString(3,t.getLogin());
            stnt.setString(4,t.getEstado());
            stnt.setString(5, t.getCultura());
            stnt.setDouble(6,t.getGastos());
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    
    }
    
    
    public List<Terreno> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Terreno> terrenos = new ArrayList<>();
        
        try{
            stnt = con.prepareStatement("SELECT * FROM terreno WHERE login = ?");
            stnt.setString(1, Cliente.getNome());
            rs = stnt.executeQuery();
            
            while(rs.next()){
                Terreno t = new Terreno();
                
                t.setIdTerreno(rs.getInt("idTerreno"));
                t.setArea(rs.getDouble("area"));
                t.setNome(rs.getString("nome"));
                t.setLogin(rs.getString("nome"));
                t.setEstado(rs.getString("estado"));
                t.setGastos(rs.getDouble("gastos"));
                t.setCultura(rs.getString("cultura"));
                
                terrenos.add(t);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return terrenos;
    }
    
}
