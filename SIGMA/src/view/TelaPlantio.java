/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Plantio;
import model.dao.PlantioDAO;

/**
 *
 * @author ramires
 */
public class TelaPlantio extends javax.swing.JFrame {
    
    public void readJTable(){
        DefaultTableModel modelo = (DefaultTableModel) tabelaPlantio.getModel();
        modelo.setNumRows(0);
        PlantioDAO pDAO = new PlantioDAO();
        
        for(Plantio p: pDAO.read()){
            modelo.addRow(new Object[]{
               p.getIdPlantio(),
               p.getIdTerreno(),
               p.getData(),
               p.getSementes(),
               p.getQtde_sementes(),
               p.getCultura()
            });
        }
    }
    
    public void readJTableFiltro(String de, String ate){
        DefaultTableModel modelo = (DefaultTableModel) tabelaPlantio.getModel();
        modelo.setNumRows(0);
        PlantioDAO pDAO = new PlantioDAO();
        
        for(Plantio p: pDAO.readFiltro(de, ate)){
            modelo.addRow(new Object[]{
               p.getIdPlantio(),
               p.getIdTerreno(),
               p.getData(),
               p.getSementes(),
               p.getQtde_sementes(),
               p.getCultura()
            });
        }
    }
    

    /**
     * Creates new form TelaColheitas
     */
    public TelaPlantio() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tabelaPlantio.getModel();
        modelo.setNumRows(0);
        tabelaPlantio.setRowSorter(new TableRowSorter(modelo));
        
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
        tabelaPlantio = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        botaoFiltro = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plantios");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));

        tabelaPlantio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Terreno", "Data", "Sementes", "Quantide de sementes", "Cultura"
            }
        ));
        jScrollPane1.setViewportView(tabelaPlantio);

        jLabel1.setFont(new java.awt.Font("Chilanka", 1, 48)); // NOI18N
        jLabel1.setText("Plantios");

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow(1).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botaoFiltro.setBackground(new java.awt.Color(51, 153, 255));
        botaoFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/filter.png"))); // NOI18N
        botaoFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFiltroActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rubbish.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
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
                                .addGap(303, 303, 303))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
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
     /*   // TODO add your handling code here:
        new TelaFiltrarColheita().setVisible(true);
        TelaFiltrarColheita.telaC = this;*/
    }//GEN-LAST:event_botaoFiltroActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(tabelaPlantio.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Selecione um terreno");
        }
        else{
            int id = (int) tabelaPlantio.getValueAt(tabelaPlantio.getSelectedRow(),0);
            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o plantio?");
            if (confirmacao == JOptionPane.YES_OPTION){
                PlantioDAO pDAO = new PlantioDAO();
                pDAO.delete(id);
                
                readJTable();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPlantio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPlantio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPlantio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPlantio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPlantio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPlantio;
    // End of variables declaration//GEN-END:variables
}
