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
import model.bean.Item;
import model.bean.Manutencao;
import model.bean.Maquina;

/**
 *
 * @author ramir
 */
public class ManutencaoDAO {
     public void create(Manutencao m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        PreparedStatement stnt2 = null;
        java.util.Date dia = new java.util.Date();
        java.sql.Date dataSql = new java.sql.Date(dia.getTime());
        
        try{
            stnt = con.prepareStatement("INSERT INTO manutencao (dia,idItem,preco,horas_dur,marca,idMaquina) VALUES (?,?,?,?,?,?)");
            stnt.setDate(1, dataSql);
            stnt.setInt(2, Item.getChave());
            stnt.setDouble(3,Item.getChavePreco());
            stnt.setInt(4,Item.getChaveHD());
            stnt.setString(5, Item.getChaveMarca());
            stnt.setInt(6, Maquina.getChave());
            
            stnt2 = con.prepareStatement("UPDATE item SET horas_trab = 0, horas_duracao = ?, preco = ? WHERE idItem = ?");
            stnt2.setInt(1, Item.getChaveHD());
            stnt2.setDouble(2, Item.getChavePreco());
            stnt2.setInt(3,Item.getChave());
            
            stnt.executeUpdate();
            stnt2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Salvar! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
            ConnectionFactory.closeConnection(con, stnt2);
        }
    }
     
    public List<Manutencao> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Manutencao> manut = new ArrayList<>();
        
        try {
            stnt = con.prepareStatement("SELECT * FROM manutencao WHERE idMaquina = ANY (SELECT idMaquina FROM maquina WHERE login = ?);");
            stnt.setString(1, Cliente.getNome());
            rs = stnt.executeQuery();
            while(rs.next()){
                Manutencao man = new Manutencao();
                man.setIdManutencao(rs.getInt("idManutencao"));
                man.setDia(rs.getDate("dia"));
                man.setIdItem(rs.getInt("idItem"));
                man.setPreco(rs.getInt("preco"));
                man.setHoras_dur(rs.getInt("horas_dur"));
                man.setMarca(rs.getString("marca"));
                man.setIdMaquina(rs.getInt("idMaquina"));
                manut.add(man);
                
            }
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return manut;
    }
    
    public List<Manutencao> readItens(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Manutencao> manut = new ArrayList<>();
        
        try {
            stnt = con.prepareStatement("SELECT * FROM manutencao WHERE idItem = ?");
            stnt.setInt(1, Item.getChave());
            rs = stnt.executeQuery();
            while(rs.next()){
                Manutencao man = new Manutencao();
                man.setIdManutencao(rs.getInt("idManutencao"));
                man.setDia(rs.getDate("dia"));
                man.setIdItem(rs.getInt("idItem"));
                man.setPreco(rs.getInt("preco"));
                man.setHoras_dur(rs.getInt("horas_dur"));
                man.setMarca(rs.getString("marca"));
                man.setIdMaquina(rs.getInt("idMaquina"));
                manut.add(man);
                
            }
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return manut;
        
   }
    public String readNomeItem(Manutencao it){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        String nomeIt = null;
        
        try {
            stnt = con.prepareStatement("SELECT nome FROM item WHERE idItem = ?");
            stnt.setInt(1,it.getIdItem());
            rs = stnt.executeQuery();
            rs.next();
            nomeIt = rs.getString("nome");
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao Acessar BD! "+ex);
         }
            
    return nomeIt;
    }
    public String readNomeMaq(Manutencao it){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        String nomeMaq = null;
        
        try {
            stnt = con.prepareStatement("SELECT nome FROM maquina WHERE idMaquina = ?");
            stnt.setInt(1,it.getIdMaquina());
            rs = stnt.executeQuery();
            rs.next();
            nomeMaq = rs.getString("nome");
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao Acessar BD! "+ex);
         }
            
    return nomeMaq;
    }
    public void delete(Manutencao man){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("DELETE FROM manutencao WHERE idManutencao = ?");
            stnt.setInt(1,man.getChaveID());
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Removido com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Remover! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    }


}
