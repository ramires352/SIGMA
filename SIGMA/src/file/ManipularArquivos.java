/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Maquina;
import model.bean.Produto;
import model.bean.Terreno;
import model.dao.MaquinaDAO;
import model.dao.ProdutoDAO;
import model.dao.TerrenoDAO;
import view.TelaTerreno;

/**
 *
 * @author Renato
 */
public class ManipularArquivos {
    public void ArquivoTerreno(String id, String nome, String area, String estado, String cultura, String gastos){
        int verificar_p = 0;
        File diretorio = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados"); 
        try {
            if (!diretorio.exists()) {
                diretorio.mkdir();
            }
            File Arquivodeletado = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados\\TerrenosDeletados.txt"); 
            if (!Arquivodeletado.exists()){
                Arquivodeletado.createNewFile();
                verificar_p = 1;
            }
            FileWriter fw = new FileWriter(Arquivodeletado, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (verificar_p == 1){
                bw.write("ID");
                bw.write("\t");
                bw.write("Nome");
                bw.write("\t");
                bw.write("Área");
                bw.write("\t");
                bw.write("Estado");
                bw.write("\t");
                bw.write("Cultura");
                bw.write("\t");
                bw.write("Gastos");
                bw.newLine();
            }
            bw.write(id);
            bw.write("\t");
            bw.write(nome);
            bw.write("\t");
            bw.write(area);
            bw.write("\t");
            bw.write(estado);
            bw.write("\t");
            bw.write(cultura);
            bw.write("\t");
            bw.write(gastos);
            bw.newLine();
                    
            bw.close();
            fw.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(TelaTerreno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ArquivoPlantio(String id, String terreno, String data, String sementes, String qtde, String cultura){
        int verificar_p = 0;
        File diretorio = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados"); 
        try {
            if (!diretorio.exists()) {
                diretorio.mkdir();
            }
            File Arquivodeletado = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados\\PlantiosDeletados.txt"); 
            if (!Arquivodeletado.exists()){
                Arquivodeletado.createNewFile();
                verificar_p = 1;
            }
            FileWriter fw = new FileWriter(Arquivodeletado, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (verificar_p == 1){
                bw.write("ID");
                bw.write("\t");
                bw.write("Terreno");
                bw.write("\t");
                bw.write("Data");
                bw.write("\t");
                bw.write("Sementes");
                bw.write("\t");
                bw.write("Quantidade de Sementes");
                bw.write("\t");
                bw.write("Cultura");
                bw.newLine();
            }
            bw.write(id);
            bw.write("\t");
            bw.write(terreno);
            bw.write("\t");
            bw.write(data);
            bw.write("\t");
            bw.write(sementes);
            bw.write("\t");
            bw.write(qtde);
            bw.write("\t");
            bw.write(cultura);
            bw.newLine();
                    
            bw.close();
            fw.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(TelaTerreno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ArquivoProdutos(String id, String nome, String tipo, String preco, String qtde){
        int verificar_p = 0;
        File diretorio = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados"); 
        try {
            if (!diretorio.exists()) {
                diretorio.mkdir();
            }
            File Arquivodeletado = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados\\ProdutosDeletados.txt"); 
            if (!Arquivodeletado.exists()){
                Arquivodeletado.createNewFile();
                verificar_p = 1;
            }
            FileWriter fw = new FileWriter(Arquivodeletado, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (verificar_p == 1){
                bw.write("ID");
                bw.write("\t");
                bw.write("Nome");
                bw.write("\t");
                bw.write("Tipo");
                bw.write("\t");
                bw.write("Preço");
                bw.write("\t");
                bw.write("Quantidade");
                bw.newLine();
            }
            bw.write(id);
            bw.write("\t");
            bw.write(nome);
            bw.write("\t");
            bw.write(tipo);
            bw.write("\t");
            bw.write(preco);
            bw.write("\t");
            bw.write(qtde);
            bw.newLine();

            bw.close();
            fw.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(TelaTerreno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ArquivoMaquinas(String id, String num, String nome){
        int verificar_p = 0;
        File diretorio = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados"); 
        try {
            if (!diretorio.exists()) {
                diretorio.mkdir();
            }
            File Arquivodeletado = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados\\MaquinasDeletadas.txt"); 
            if (!Arquivodeletado.exists()){
                Arquivodeletado.createNewFile();
                verificar_p = 1;
            }
            FileWriter fw = new FileWriter(Arquivodeletado, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            if (verificar_p == 1){
                bw.write("ID");
                bw.write("\t");
                bw.write("Numero");
                bw.write("\t");
                bw.write("Nome");
                bw.newLine();
            }
            bw.write(id);
            bw.write("\t");
            bw.write(num);
            bw.write("\t");
            bw.write(nome);
            bw.newLine();
                    
            bw.close();
            fw.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(TelaTerreno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ArquivoColheitas(String id, String data, String terreno, String qtde, String cultura){
        int verificar_p = 0;
        File diretorio = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados"); 
        try {
            if (!diretorio.exists()) {
                diretorio.mkdir();
            }
            File Arquivodeletado = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados\\ColheitasDeletadas.txt"); 
            if (!Arquivodeletado.exists()){
                Arquivodeletado.createNewFile();
                verificar_p = 1;
            }
            FileWriter fw = new FileWriter(Arquivodeletado, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (verificar_p == 1){
                bw.write("ID");
                bw.write("\t");
                bw.write("Data");
                bw.write("\t");
                bw.write("Terreno");
                bw.write("\t");
                bw.write("Quantidade");
                bw.write("\t");
                bw.write("Cultura");
                bw.newLine();
            }
            bw.write(id);
            bw.write("\t");
            bw.write(data);
            bw.write("\t");
            bw.write(terreno);
            bw.write("\t");
            bw.write(qtde);
            bw.write("\t");
            bw.write(cultura);
            bw.newLine();
                    
            bw.close();
            fw.close();
        }
        catch (IOException ex) {
            Logger.getLogger(TelaTerreno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void RestaurarTerreno(int nlinha,String nome, String area, String estado, String cultura, String gastos){
        Terreno t = new Terreno();
        t.setLogin(Cliente.getNome());
        
        t.setArea(Double.parseDouble(area));
        t.setNome(nome);
        t.setEstado(estado);
        t.setCultura(cultura);
        t.setGastos(Double.parseDouble(gastos));
        
        TerrenoDAO tDAO = new TerrenoDAO();
        tDAO.create(t);
        
        File fil = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados\\TerrenosDeletados.txt"); 
        try {
            int cont = 0;
            FileReader fr = new FileReader(fil);
            BufferedReader br = new BufferedReader(fr); 
            
            String linha = br.readLine();
            ArrayList<String> salvar = new ArrayList();
            
            while (linha != null){
                if(cont != nlinha){
                    salvar.add(linha);
                }
            cont++;
            linha = br.readLine();
            }
            
            br.close();
            fr.close();
            FileWriter fw2 = new FileWriter(fil,true);
            fw2.close();
            
            FileWriter fw = new FileWriter(fil);
            BufferedWriter bw  = new BufferedWriter(fw);
            
            for(int i = 0; i<salvar.size(); i++){
                bw.write( salvar.get(i) );
                bw.newLine();
            }
            bw.close();
            fw.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(ManipularArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void RestaurarProdutos(int nlinha, String nome, String tipo, String preco, String qtd){
        Produto p = new Produto();
        p.setNome(nome);
        p.setTipo(tipo);
        p.setPreco(Double.parseDouble(preco));
        p.setQtde(Double.parseDouble(qtd));
        p.setLogin(Cliente.getNome());
        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.create(p);
        
        File fil = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados\\ProdutosDeletados.txt"); 
        try {
            int cont = 0;
            FileReader fr = new FileReader(fil);
            BufferedReader br = new BufferedReader(fr); 
            
            String linha = br.readLine();
            ArrayList<String> salvar = new ArrayList();
            
            while (linha != null){
                if(cont != nlinha){
                    salvar.add(linha);
                }
            cont++;
            linha = br.readLine();
            }
            
            br.close();
            fr.close();
            FileWriter fw2 = new FileWriter(fil,true);
            fw2.close();
            
            FileWriter fw = new FileWriter(fil);
            BufferedWriter bw  = new BufferedWriter(fw);
            
            for(int i = 0; i<salvar.size(); i++){
                bw.write( salvar.get(i) );
                bw.newLine();
            }
            bw.close();
            fw.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(ManipularArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void RestaurarMaquinas(int nlinha, String nome){
        
        Maquina m = new Maquina();
        MaquinaDAO dao = new MaquinaDAO();
        m.setNome(nome);
        dao.create(m);
        
        File fil = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados\\MaquinasDeletadas.txt"); 
        try {
            int cont = 0;
            FileReader fr = new FileReader(fil);
            BufferedReader br = new BufferedReader(fr); 
            
            String linha = br.readLine();
            ArrayList<String> salvar = new ArrayList();
            
            while (linha != null){
                if(cont != nlinha){
                    salvar.add(linha);
                }
            cont++;
            linha = br.readLine();
            }
            
            br.close();
            fr.close();
            FileWriter fw2 = new FileWriter(fil,true);
            fw2.close();
            
            FileWriter fw = new FileWriter(fil);
            BufferedWriter bw  = new BufferedWriter(fw);
            
            for(int i = 0; i<salvar.size(); i++){
                bw.write( salvar.get(i) );
                bw.newLine();
            }
            bw.close();
            fw.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(ManipularArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
