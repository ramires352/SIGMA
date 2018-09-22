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
import model.bean.ManutTerreno;
import model.bean.Movimento;
import model.bean.Plantio;
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
            stnt.setString(5,t.getCultura());
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
    
    public void update(Terreno t) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try{
            stnt = con.prepareStatement("UPDATE terreno SET area=?,nome=?,estado=?,cultura=?,gastos=? WHERE idTerreno=?");
            stnt.setDouble(1,t.getArea());
            stnt.setString(2,t.getNome());
            stnt.setString(3,t.getEstado());
            stnt.setString(4, t.getCultura());
            stnt.setDouble(5,t.getGastos());
            stnt.setInt(6, t.getIdTerreno());
            
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Alterar! "+ex);
        }finally{
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
                t.setLogin(Cliente.getNome());
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
    
    //Enquanto a função anterior retorna todos os terrenos
    //Essa aqui retorna apenas o terreno do ID que foi passado
    public List<Terreno> readOne(int ID){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        Terreno t = new Terreno();
       
        List<Terreno> retorno = new ArrayList<>();
        
        try{
            stnt = con.prepareStatement("SELECT * FROM terreno WHERE idTerreno = ?");
            stnt.setInt(1, ID);
            rs = stnt.executeQuery();
            
            rs.next();
                
            t.setIdTerreno(rs.getInt("idTerreno"));
            t.setArea(rs.getDouble("area"));
            t.setNome(rs.getString("nome"));
            t.setLogin(Cliente.getNome());
            t.setEstado(rs.getString("estado"));
            t.setGastos(rs.getDouble("gastos"));
            t.setCultura(rs.getString("cultura"));
            
            retorno.add(t);
                            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na Leitura! "+ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return retorno;
    }
    
    public void colher(int id, double q, String nomeT, String cultura, double custo){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        PreparedStatement stnt2 = null;
        PreparedStatement stnt3 = null;
        ResultSet rs = null;
        
        
        try{
            
            //Verifica se ja existe esse grao no estoque, se existir aumenta a quantidade
            //Se nao existir, insere no estoque
            
            stnt3 = con.prepareStatement("select if((select cultura from terreno where idTerreno = ?) in (select tipo from produto where login = ?),'TRUE','FALSE')");
            stnt3.setInt(1, id);
            stnt3.setString(2, Cliente.getNome());
            
            rs = stnt3.executeQuery();
            rs.next();
            
            String resposta = rs.getString(1);
            
            //System.out.println("RESPOSTA -> "+resposta);
            
            //Se jÃ¡ existe esse tipo de grao no estoque
            if(resposta.equals("TRUE")){
                stnt3 = con.prepareStatement("UPDATE produto set qtde = qtde + ? where tipo = ? and login = ?");
                stnt3.setDouble(1, q);
                stnt3.setString(2, cultura);
                stnt3.setString(3, Cliente.getNome());
                
                stnt3.executeUpdate();
            }
            //Se ainda nao existe esse grao no estoque
            else{
                stnt3 = con.prepareStatement("INSERT INTO produto (nome, tipo, preco, login, qtde) VALUES (?,?,?,?,?)");
                stnt3.setString(1, cultura);
                stnt3.setString(2, cultura);
                stnt3.setDouble(3,0);
                stnt3.setString(4, Cliente.getNome());
                stnt3.setDouble(5, q);
                
                stnt3.executeUpdate();
            }
            
            stnt = con.prepareStatement("UPDATE terreno SET estado = 'Limpo', cultura = 'Nenhum', gastos = 0 WHERE idTerreno = ?");
            stnt.setInt(1, id);
            
            java.util.Date dia = new java.util.Date();
            java.sql.Date dataSql = new java.sql.Date(dia.getTime());
            
            stnt2 = con.prepareStatement("INSERT INTO colheita (idTerreno, data, qtde, nomeTerreno, cultura) VALUES (?,?,?,?,?)");
            stnt2.setInt(1,id);
            stnt2.setDate(2, dataSql);
            stnt2.setDouble(3, q);
            stnt2.setString(4, nomeT);
            stnt2.setString(5, cultura);
            
            stnt.executeUpdate();
            stnt2.executeUpdate();
            
            stnt3 = con.prepareStatement("INSERT INTO movimento (nome, tipo, qtde, descricao, preco_un, login, data, idTerreno) VALUES (?,?,?,?,?,?,?,?)");
            stnt3.setString(1,"Colheita");
            stnt3.setString(2, cultura);
            stnt3.setDouble(3, q);
            stnt3.setString(4, nomeT);
            stnt3.setDouble(5, custo/q);
            stnt3.setString(6, Cliente.getNome());
            stnt3.setDate(7, dataSql);
            stnt3.setInt(8, id);
            
            stnt3.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Colheita Registrada!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha no Registro da Colheita! "+ ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stnt);
            ConnectionFactory.closeConnection(con, stnt2);
            ConnectionFactory.closeConnection(con, stnt3, rs);
        }
    }
    
        public void remover(int id) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        List<Colheita> colheitas = new ArrayList<>();
        List<Plantio> plantios = new ArrayList<>();
        List<ManutTerreno> manutencoes = new ArrayList<>();
        List<Movimento> movimentos = new ArrayList<>();
        String msg = "Não é possivel excluir este terreno! \nHá dados relacionados com este terreno!"
                                    + "\nApague todos os dados relacionados a esse terreno e tente novamente.";
        
        try{
            ColheitaDAO cDAO = new ColheitaDAO();
            colheitas = cDAO.readTerreno(id);
            if (!colheitas.isEmpty()){
                JOptionPane.showMessageDialog(null, msg);
            }
            else{
                PlantioDAO pDAO = new PlantioDAO();
                plantios = pDAO.readTerreno(id);
                if(!plantios.isEmpty()){
                    JOptionPane.showMessageDialog(null, msg);
                }
                else{
                    ManutTerrenoDAO mDAO = new ManutTerrenoDAO();
                    manutencoes = mDAO.readTerreno(id);
                    if(!manutencoes.isEmpty()){
                        JOptionPane.showMessageDialog(null, msg);
                    }
                    else{
                        MovimentoDAO movDAO = new MovimentoDAO();
                        movimentos = movDAO.readTerreno(id);
                        if (!movimentos.isEmpty()){
                            JOptionPane.showMessageDialog(null, msg);
                        }
                        else{
                            stnt = con.prepareStatement("DELETE FROM terreno WHERE idTerreno = ?");
                            stnt.setInt(1, id);
                            stnt.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Removido com Sucesso!");
                        }
                    }
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Remover! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    
}
