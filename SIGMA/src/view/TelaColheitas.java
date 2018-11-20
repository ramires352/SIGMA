/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import file.ManipularArquivos;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Colheita;
import model.dao.ColheitaDAO;

/**
 *
 * @author ramires
 */
public class TelaColheitas extends javax.swing.JFrame {
    
    public static boolean filtro;
    
    public void readJTable(){
        DefaultTableModel modelo = (DefaultTableModel) tabelaColheitas.getModel();
        modelo.setNumRows(0);
        ColheitaDAO cDAO = new ColheitaDAO();
        
        for(Colheita c: cDAO.read()){
            modelo.addRow(new Object[]{
                c.getIdColheita(),
                c.getData(),
                c.getNomeTerreno(),
                c.getQtde(),
                c.getCultura()
                    
            });
        }
    }
    
    public void readJTableFiltro(String de, String ate){
        DefaultTableModel modelo = (DefaultTableModel) tabelaColheitas.getModel();
        modelo.setNumRows(0);
        ColheitaDAO cDAO = new ColheitaDAO();
        
        for(Colheita c: cDAO.readFiltro(de, ate)){
            modelo.addRow(new Object[]{
                c.getIdColheita(),
                c.getData(),
                c.getNomeTerreno(),
                c.getQtde(),
                c.getCultura()
                    
            });
        }
        
        //Altera o ícone do botao filtro
        ClassLoader cl = this.getClass().getClassLoader();
        Icon icone = new ImageIcon(cl.getResource("icons/removerFiltro.png"));
        botaoFiltro.setIcon(icone);
        botaoFiltro.setToolTipText("Remover Filtro");
    }


    /**
     * Creates new form TelaColheitas
     */
    public TelaColheitas() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tabelaColheitas.getModel();
        modelo.setNumRows(0);
        tabelaColheitas.setRowSorter(new TableRowSorter(modelo));
        
        filtro = FALSE;
        
        readJTable();
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
        tabelaColheitas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        botaoFiltro = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Colheitas");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));

        tabelaColheitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data", "Terreno", "Quantidade", "Cultura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaColheitas);

        jLabel1.setFont(new java.awt.Font("Chilanka", 1, 48)); // NOI18N
        jLabel1.setText("Colheitas");

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow(1).png"))); // NOI18N
        jButton1.setToolTipText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botaoFiltro.setBackground(new java.awt.Color(51, 153, 255));
        botaoFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/filter.png"))); // NOI18N
        botaoFiltro.setToolTipText("Filtrar");
        botaoFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFiltroActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rubbish.png"))); // NOI18N
        jButton3.setToolTipText("Remover");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoFiltro)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(273, 273, 273))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoFiltro, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new TelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botaoFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFiltroActionPerformed
        // TODO add your handling code here:
        if(filtro == FALSE){
            new TelaFiltrarColheita().setVisible(true);
            TelaFiltrarColheita.telaC = this;
        }
        else{
            filtro = FALSE;
            ClassLoader cl = this.getClass().getClassLoader();
            Icon icone = new ImageIcon(cl.getResource("icons/filter.png"));
            botaoFiltro.setIcon(icone);
            botaoFiltro.setToolTipText("Filtrar");
            readJTable();
        }
        
    }//GEN-LAST:event_botaoFiltroActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(tabelaColheitas.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Selecione uma colheita!");
        }
        else{
            int id = (int) tabelaColheitas.getValueAt(tabelaColheitas.getSelectedRow(), 0);
            ColheitaDAO cDAO = new ColheitaDAO();
            
            cDAO.delete(id);
            readJTable();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(tabelaColheitas.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Selecione uma Colheita!");
        }
        else {
            
            int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir a colheita?");
            int id;
            if(confirmacao == JOptionPane.YES_OPTION) {
                ManipularArquivos manip = new ManipularArquivos();
                String arq_id,arq_data, arq_terreno, arq_qtde,arq_cultura;
                arq_id = tabelaColheitas.getValueAt(tabelaColheitas.getSelectedRow(), 0).toString();
                arq_data = tabelaColheitas.getValueAt(tabelaColheitas.getSelectedRow(), 1).toString();
                arq_terreno = tabelaColheitas.getValueAt(tabelaColheitas.getSelectedRow(), 2).toString();
                arq_qtde = tabelaColheitas.getValueAt(tabelaColheitas.getSelectedRow(), 3).toString();
                arq_cultura = tabelaColheitas.getValueAt(tabelaColheitas.getSelectedRow(), 4).toString();
                manip.ArquivoColheitas(arq_id, arq_data, arq_terreno, arq_qtde, arq_cultura);
                
                id = (int) tabelaColheitas.getValueAt(tabelaColheitas.getSelectedRow(), 0);
                ColheitaDAO pDAO = new ColheitaDAO();
                //pDAO.delete(id);
                readJTable();   
            }
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaColheitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaColheitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaColheitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaColheitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaColheitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaColheitas;
    // End of variables declaration//GEN-END:variables
}
