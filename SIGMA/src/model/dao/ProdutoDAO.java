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
    
    public List<Produto> readFiltroTipo(String tipo){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Produto> prod = new ArrayList<>();
        try{
            
            if(tipo.equals("Grãos")){
            
                stnt = con.prepareStatement("select * from produto where login = ? AND tipo in ('Soja','Milho','Aveia','Trigo')");
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
            
            if(tipo.equals("Defensivos")){
                prod = readDefensivos();
            }
            
            if(tipo.equals("Sementes")){
                prod = readSementes();
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
    
    public void update(int id, Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("UPDATE produto SET nome = ?, tipo = ?, preco = ?, qtde = ? WHERE idProduto = ?");
            stnt.setString(1, p.getNome());
            stnt.setString(2, p.getTipo());
            stnt.setDouble(3, p.getPreco());
            stnt.setDouble(4, p.getQtde());
            stnt.setInt(5,id);
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
          
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Alterar! "+ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    
    public void delete(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            stnt.setInt(1,id);
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Removido com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Remover! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    
    public List<Produto> readDefensivos(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Produto> prod = new ArrayList<>();
        try{
            stnt = con.prepareStatement("SELECT * FROM produto WHERE login = ? and tipo = 'Defensivo'");
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
    
    public List<Produto> readSementes(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        List<Produto> prod = new ArrayList<>();
        try{
            stnt = con.prepareStatement("SELECT * FROM produto WHERE login = ? and tipo = 'Semente'");
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
    //roda ai de novo e faz da erro
    public int verificaCompraProduto(String nome, String tipo) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        PreparedStatement stnt2 = null;
        PreparedStatement stnt3 = null;
        ResultSet rs = null;
        
        try {
            
            stnt3 = con.prepareStatement("select idProduto from produto where nome = ? and tipo = ? and login = ?");
            stnt3.setString(1, nome);
            stnt3.setString(2, tipo);
            stnt3.setString(3, Cliente.getNome());

            rs = stnt3.executeQuery();
            rs.next();

            if(rs.getString("idProduto") != null) {
                return rs.getInt("idProduto");
            }
        
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na busca do produto! "+ ex);
        }
        
        return -1;
        
    }
    
    public int verificaVendaGrao(String nome, String tipo, double quantidade) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt3 = null;
        ResultSet rs = null;
        
        try {
            
            stnt3 = con.prepareStatement("select * from produto where nome = ? and tipo = ? and login = ?");
            stnt3.setString(1, nome);
            stnt3.setString(2, tipo);
            stnt3.setString(3, Cliente.getNome());

            rs = stnt3.executeQuery();
            rs.next();
            
            Produto t = new Produto();

            t.setIdProduto(rs.getInt("idProduto"));
            t.setNome(rs.getString("nome"));
            t.setTipo(rs.getString("tipo"));
            t.setPreco(rs.getDouble("preco"));
            t.setQtde(rs.getDouble("qtde"));

            if(t.getIdProduto() != 0 && t.getQtde() >= quantidade) {
                return t.getIdProduto();
            }
        
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na busca do produto! "+ ex);
        }
        
        return -1;
        
    }
    
    public Produto getProduto(int idProduto){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        Produto t = new Produto();
        
        try {
            
            stnt = con.prepareStatement("select * from produto where idProduto = ? and login = ?");
            stnt.setInt(1, idProduto);
            stnt.setString(2, Cliente.getNome());

            rs = stnt.executeQuery();
            rs.next();
            
            t.setIdProduto(rs.getInt("idProduto"));
            t.setNome(rs.getString("nome"));
            t.setTipo(rs.getString("tipo"));
            t.setPreco(rs.getDouble("preco"));
            t.setQtde(rs.getDouble("qtde"));

        
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na busca do produto! "+ ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        
        return t;
    }
    
}
