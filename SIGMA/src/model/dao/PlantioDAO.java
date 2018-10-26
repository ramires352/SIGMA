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
import model.bean.Produto;

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
                p.setNomeTerreno(rs.getString("nomeTerreno"));
                
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
    
   
    public void plantar(Produto semente, double qtd, int idTerreno, String nomesemente, String cultura, String nometerreno){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        try{
            stnt = con.prepareStatement("INSERT INTO plantio (idTerreno, data, sementes, qtde_sementes, cultura, nomeTerreno) values (?,?,?,?,?,?)");
            stnt.setInt(1, idTerreno);
            
            java.util.Date dia = new java.util.Date();
            java.sql.Date dataSql = new java.sql.Date(dia.getTime());
            stnt.setDate(2, dataSql);
            stnt.setString(3, nomesemente);
            stnt.setDouble(4, qtd);
            stnt.setString(5, cultura);
            stnt.setString(6, nometerreno);
            stnt.executeUpdate();
            
            stnt = con.prepareStatement("UPDATE produto SET qtde = qtde - ? WHERE idProduto = ?");
            stnt.setDouble(1, qtd);
            stnt.setInt(2, semente.getIdProduto());
            stnt.executeUpdate();
            
            stnt = con.prepareStatement("UPDATE terreno SET estado = ?, gastos = gastos + ?, cultura = ? WHERE idTerreno = ?");
            stnt.setString(1, "Plantado");
            stnt.setDouble(2, qtd*semente.getPreco());
            stnt.setString(3, cultura);
            stnt.setInt(4, idTerreno);
            stnt.executeUpdate();
            
            stnt = con.prepareStatement("INSERT INTO movimento (nome, tipo, qtde, descricao, preco_un, login, data, idTerreno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stnt.setString(1, nomesemente);
            stnt.setString(2, "Plantio");
            stnt.setDouble(3, qtd);
            stnt.setString(4, nometerreno);
            stnt.setDouble(5, semente.getPreco());
            stnt.setString(6, Cliente.getNome());
            stnt.setDate(7, dataSql);
            stnt.setInt(8, idTerreno);
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
