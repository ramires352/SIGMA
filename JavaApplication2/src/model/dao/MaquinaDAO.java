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
import model.bean.Maquina;

/**
 *
 * @author ramir
 */
public class MaquinaDAO {
    public void create(Maquina m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("INSERT INTO maquina (nome,login) VALUES (?,?)");
            stnt.setString(1, m.getNome());
            stnt.setString(2, Cliente.getNome());
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Salvar! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    
    public List<Maquina> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Maquina> maquinas = new ArrayList<>();
        
        try {
            stnt = con.prepareStatement("SELECT * FROM maquina WHERE login = ?");
            stnt.setString(1, Cliente.getNome());
            rs = stnt.executeQuery();
            
            
            while(rs.next()){
                Maquina maquina = new Maquina();
                maquina.setIdMaquina(rs.getInt("idMaquina"));
                maquina.setNome(rs.getString("nome"));
                maquinas.add(maquina);
                
            }
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return maquinas;
        
   }
    
    public void update(Maquina m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("UPDATE maquina SET nome = ? WHERE idMaquina = ?");
            stnt.setString(1, m.getNome());
            stnt.setInt(2,Maquina.getChave());
            
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Alterar! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
 
    
    public void delete(Maquina m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        PreparedStatement stnt2 = null;
        PreparedStatement stnt3 = null;
        
        try{
            stnt = con.prepareStatement("DELETE from maquina WHERE idMaquina = ?");
            stnt2 = con.prepareStatement("DELETE from item WHERE idMaquina = ?");
            stnt3 = con.prepareStatement("DELETE from manutencao WHERE idMaquina = ?");
            
            stnt.setInt(1,Maquina.getChave());
            stnt2.setInt(1,Maquina.getChave());
            stnt3.setInt(1,Maquina.getChave());
            
            stnt3.executeUpdate();
            stnt2.executeUpdate();
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Removido com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Remover! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
            ConnectionFactory.closeConnection(con, stnt2);
            ConnectionFactory.closeConnection(con, stnt3);
        }
    }
    
}
