/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import file.ManipularArquivos;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author ramires
 */
public class TelaDadosExcluidos extends javax.swing.JFrame {
    
    public void preencheTabelaTerreno(){
        try{
            DefaultTableModel modelo = (DefaultTableModel) tabelaExcluidos.getModel();
            if(modelo.getRowCount() > 0){
                modelo.setRowCount(0);
            }
            String dir = System.getProperty("user.home") + "\\Desktop\\ISS\\SIGMA\\Arquivos Deletados";
            
            String nomeArquivo = "TerrenosDeletados.txt";
            File arquivo = new File (dir, nomeArquivo);
        
            FileInputStream fis = new FileInputStream(arquivo);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
        
            String linha = br.readLine();
            while (linha != null){
                Object[] obj = linha.split("\t");
                modelo.addRow(obj);
                linha = br.readLine();
            }
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Não há nenhum Terreno excluido!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro!"+ex);
        }
    }
   
    public void preencheTabelaPlantios(){
        try{
            DefaultTableModel modelo = (DefaultTableModel) tabelaExcluidos.getModel();
            if(modelo.getRowCount() > 0){
                modelo.setRowCount(0);
            }
            String dir = System.getProperty("user.home") + "\\Desktop\\ISS\\SIGMA\\Arquivos Deletados";
            
            String nomeArquivo = "PlantiosDeletados.txt";
            File arquivo = new File (dir, nomeArquivo);
        
            FileInputStream fis = new FileInputStream(arquivo);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
        
            String linha = br.readLine();
            while (linha != null){
                Object[] obj = linha.split("\t");
                modelo.addRow(obj);
                linha = br.readLine();
            }
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Não há nenhum Plantio excluido!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro!"+ex);
        }
    }
    
    public void preencheTabelaMaquinas(){
        try{
            DefaultTableModel modelo = (DefaultTableModel) tabelaExcluidos.getModel();
            if(modelo.getRowCount() > 0){
                modelo.setRowCount(0);
            }
            String dir = System.getProperty("user.home") + "\\Desktop\\ISS\\SIGMA\\Arquivos Deletados";
            
            String nomeArquivo = "MaquinasDeletadas.txt";
            File arquivo = new File (dir, nomeArquivo);
        
            FileInputStream fis = new FileInputStream(arquivo);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
        
            String linha = br.readLine();
            while (linha != null){
                Object[] obj = linha.split("\t");
                modelo.addRow(obj);
                linha = br.readLine();
            }
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Não há nenhuma Maquina excluida!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro!"+ex);
        }
    }
    
    public void preencheTabelaProdutos(){
        try{
            DefaultTableModel modelo = (DefaultTableModel) tabelaExcluidos.getModel();
            if(modelo.getRowCount() > 0){
                modelo.setRowCount(0);
            }
            String dir = System.getProperty("user.home") + "\\Desktop\\ISS\\SIGMA\\Arquivos Deletados";
            
            String nomeArquivo = "ProdutosDeletados.txt";
            File arquivo = new File (dir, nomeArquivo);
        
            FileInputStream fis = new FileInputStream(arquivo);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
        
            String linha = br.readLine();
            while (linha != null){
                Object[] obj = linha.split("\t");
                modelo.addRow(obj);
                linha = br.readLine();
            }
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Não há nenhum produto excluido!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro!"+ex);
        }
    }

    public void preencheTabelaColheita(){
        try{
            DefaultTableModel modelo = (DefaultTableModel) tabelaExcluidos.getModel();
            if(modelo.getRowCount() > 0){
                modelo.setRowCount(0);
            }
            String dir = System.getProperty("user.home") + "\\Desktop\\ISS\\SIGMA\\Arquivos Deletados";
            
            String nomeArquivo = "ColheitaDeletadas.txt";
            File arquivo = new File (dir, nomeArquivo);
        
            FileInputStream fis = new FileInputStream(arquivo);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
        
            String linha = br.readLine();
            while (linha != null){
                Object[] obj = linha.split("\t");
                modelo.addRow(obj);
                linha = br.readLine();
            }
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Não há nenhuma colheita excluida!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro!"+ex);
        }
    }
   
    public TelaDadosExcluidos() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tabelaExcluidos.getModel();
        modelo.setNumRows(0);
        tabelaExcluidos.setRowSorter(new TableRowSorter(modelo));

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){

                ClassLoader cl = this.getClass().getClassLoader();

                ImageIcon im = new ImageIcon(cl.getResource("images/bg.jpg"));
                Image i = im.getImage();

                g.drawImage(i,0,0,this.getSize().width,this.getSize().height,this);

            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaExcluidos = new javax.swing.JTable();
        botaoVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        botaorestaurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Terrenos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        tabelaExcluidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaExcluidos.setToolTipText("");
        tabelaExcluidos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelaExcluidos.setOpaque(false);
        jScrollPane1.setViewportView(tabelaExcluidos);

        botaoVoltar.setBackground(new java.awt.Color(51, 153, 255));
        botaoVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow(1).png"))); // NOI18N
        botaoVoltar.setToolTipText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Chilanka", 1, 48)); // NOI18N
        jLabel1.setText("Dados excluidos");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Terrenos", "Plantios", "Produtos", "Maquina", "Colheitas" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        botaorestaurar.setBackground(new java.awt.Color(51, 153, 255));
        botaorestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/backup.png"))); // NOI18N
        botaorestaurar.setToolTipText("Restaurar");
        botaorestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaorestaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botaoVoltar)
                                .addGap(221, 221, 221)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(194, 194, 194))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaorestaurar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoVoltar)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(botaorestaurar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        // TODO add your handling code here:
        new TelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        switch (jComboBox1.getSelectedIndex()) {
                case 0:
                    preencheTabelaTerreno();
                    break;
                    
                case 1:
                    preencheTabelaPlantios();
                    break;
                    
                case 2:
                    preencheTabelaProdutos();
                    break;
                    
                case 3:
                    preencheTabelaMaquinas();
                    break;
                    
                case 4:
                    preencheTabelaColheita();
                    break;
                    
                default:
                    break;
            }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void botaorestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaorestaurarActionPerformed
        ManipularArquivos manip = new ManipularArquivos();
        if(tabelaExcluidos.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Selecione primeiro o item que deseja restaurar!");
        }     
        else{
            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente restaurar este item?");
            switch (jComboBox1.getSelectedIndex()) {
                case 0:
                    if(confirmacao == JOptionPane.YES_OPTION){
                        String nome, estado, cultura, area, gastos;
                        int nlinha;
                        nlinha = tabelaExcluidos.getSelectedRow();
                        nome = tabelaExcluidos.getValueAt(tabelaExcluidos.getSelectedRow(), 1).toString();
                        area =  tabelaExcluidos.getValueAt(tabelaExcluidos.getSelectedRow(), 2).toString();
                        estado = tabelaExcluidos.getValueAt(tabelaExcluidos.getSelectedRow(), 3).toString();
                        cultura = tabelaExcluidos.getValueAt(tabelaExcluidos.getSelectedRow(), 4).toString();
                        gastos =  tabelaExcluidos.getValueAt(tabelaExcluidos.getSelectedRow(), 5).toString();
                        manip.RestaurarTerreno(nlinha,nome,area,estado,cultura,gastos);
                        preencheTabelaTerreno();
                    }
                    break;
                    
                case 1:
                    if(confirmacao == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null, "Não é possível restaurar um Plantio!");
                    }
                    break;
                    
                case 2:
                    if(confirmacao == JOptionPane.YES_OPTION){
                        String nome, tipo, preco, qtde;
                        int nlinha;
                        nlinha = tabelaExcluidos.getSelectedRow();
                        nome = tabelaExcluidos.getValueAt(tabelaExcluidos.getSelectedRow(), 1).toString();
                        tipo =  tabelaExcluidos.getValueAt(tabelaExcluidos.getSelectedRow(), 2).toString();
                        preco = tabelaExcluidos.getValueAt(tabelaExcluidos.getSelectedRow(), 3).toString();
                        qtde = tabelaExcluidos.getValueAt(tabelaExcluidos.getSelectedRow(), 4).toString();
                        manip.RestaurarProdutos(nlinha,nome,tipo,preco,qtde);
                        preencheTabelaProdutos();
                    }
                    break;
                    
                case 3:
                    if(confirmacao == JOptionPane.YES_OPTION){
                        String nome;
                        int nlinha;
                        nlinha = tabelaExcluidos.getSelectedRow();
                        nome =  tabelaExcluidos.getValueAt(tabelaExcluidos.getSelectedRow(), 2).toString();
                        manip.RestaurarMaquinas(nlinha, nome);
                        preencheTabelaMaquinas();
                    }
                    break;
                    
                case 4:
                    if(confirmacao == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null, "Não é possível restaurar uma Colheita!");
                    }
                    break;
                
                default:
                    break;
            }
        }
    }//GEN-LAST:event_botaorestaurarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDadosExcluidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDadosExcluidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDadosExcluidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDadosExcluidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDadosExcluidos().setVisible(true);
            }
        });

    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JButton botaorestaurar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaExcluidos;
    // End of variables declaration//GEN-END:variables
}
