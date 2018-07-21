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
import model.bean.Item;
import model.bean.Maquina;

/**
 *
 * @author ramir
 */
public class ItemDAO {
       public void create(Item i){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("INSERT INTO item (nome, idMaquina, horas_duracao, horas_trab, preco, marca) VALUES (?,?,?,?,?,?)");
            stnt.setString(1, i.getNome());
            stnt.setInt(2, Maquina.getChave());
            stnt.setInt(3, i.getHoras_dur());
            stnt.setInt(4,i.getHoras_trab());
            stnt.setDouble(5,i.getPreco());
            stnt.setString(6,i.getMarca());
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Salvar! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
       
    public List<Item> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Item> itens = new ArrayList<>();
        try {
            stnt = con.prepareStatement("SELECT * FROM item WHERE idMaquina = ?");
            stnt.setInt(1, Maquina.getChave());
            rs = stnt.executeQuery();
            while(rs.next()){
                Item item = new Item();
                item.setIdItem(rs.getInt("idItem"));
                item.setNome(rs.getString("nome"));
                item.setHoras_dur(rs.getInt("horas_duracao"));
                item.setHoras_trab(rs.getInt("horas_trab"));
                item.setPreco(rs.getDouble("preco"));
                item.setMarca(rs.getString("marca"));
                itens.add(item);
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return itens;
        
   }
    public void update(Item it){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("UPDATE item SET nome = ?, horas_duracao = ?, horas_trab = ?, preco = ?, marca = ? WHERE idItem = ?");
            stnt.setString(1, it.getNome());
            stnt.setInt(2,it.getHoras_dur());
            stnt.setInt(3, it.getHoras_trab());
            stnt.setDouble(4,it.getPreco());
            stnt.setString(5,it.getMarca());
            stnt.setInt(6,Item.getChave());
            
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Alterar! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    public void updateManut(Item it){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("UPDATE item SET horas_duracao = ?, preco = ?, marca = ? WHERE idItem = ?");
            stnt.setInt(1,it.getHoras_dur());
            stnt.setDouble(2,it.getPreco());
            stnt.setString(3,it.getMarca());
            stnt.setInt(4,Item.getChave());
            
            
            stnt.executeUpdate();
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Alterar! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    public void delete(Item it){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("DELETE FROM item WHERE idItem = ?");
            stnt.setInt(1,Item.getChave());
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Removido com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Remover! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    
       public void horas(Item it){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("UPDATE item SET horas_trab = horas_trab + ? WHERE idMaquina = ?");
            stnt.setInt(1,it.getHoras_trab());
            stnt.setInt(2,Maquina.getChave());
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    
}
