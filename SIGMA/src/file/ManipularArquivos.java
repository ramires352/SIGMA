/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.TelaTerreno;

/**
 *
 * @author Renato
 */
public class ManipularArquivos {
    public void ArquivoTerreno(int id, String nome, float area, String estdado, String cultura, float gastos){
                /*File diretorio = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados"); 
                try {
                    if (!diretorio.exists()) {
                        diretorio.mkdir();
                    }
                    File Arquivodeletado = new File("C:\\Users\\Renato\\Desktop\\ISS\\SIGMA\\Arquivos Deletados\\TerrenosDeletados.txt"); 
                    if (!Arquivodeletado.exists()){
                        Arquivodeletado.createNewFile();
                    }
                    FileWriter fw = new FileWriter(Arquivodeletado, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(tabelaTerreno.getValueAt(tabelaTerreno.getSelectedRow(), 0).toString());
                    bw.write(" ");
                    bw.write(tabelaTerreno.getValueAt(tabelaTerreno.getSelectedRow(), 1).toString());
                    bw.write(" ");
                    bw.write(tabelaTerreno.getValueAt(tabelaTerreno.getSelectedRow(), 2).toString());
                    bw.write(" ");
                    bw.write(tabelaTerreno.getValueAt(tabelaTerreno.getSelectedRow(), 3).toString());
                    bw.write(" ");
                    bw.write(tabelaTerreno.getValueAt(tabelaTerreno.getSelectedRow(), 4).toString());
                    bw.write(" ");
                    bw.write(tabelaTerreno.getValueAt(tabelaTerreno.getSelectedRow(), 5).toString());
                    bw.newLine();
                    
                    bw.close();
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(TelaTerreno.class.getName()).log(Level.SEVERE, null, ex);
                }
    */}
}
