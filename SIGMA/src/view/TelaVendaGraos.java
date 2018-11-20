/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Graphics;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Movimento;
import model.bean.Produto;
import model.dao.MovimentoDAO;
import model.dao.ProdutoDAO;
import static view.TelaCompraProdutos.telaE;

/**
 *
 * @author ramires
 */
public class TelaVendaGraos extends javax.swing.JFrame {
    
    private int id;
    public static TelaEstoque telaE;
    
    /** Creates new form TelaAltProduto
     * @param p */
    public TelaVendaGraos() {
        initComponents();
        
        List<String> listaTipos = new ArrayList<String>();
        String tipo;
        
        int i;
        
        ProdutoDAO tDAO = new ProdutoDAO();
        for(Produto t: tDAO.read()){
                tipo = t.getTipo();
                
                i = 0;
                while(i < listaTipos.size() && listaTipos.get(i).equals(tipo)){
                    i++;
                }
                
                //Chegou até o final, ou seja, ainda não encontrou o tipo
                //Se achou no BD um tipo diferente de semente ou defensivo, colocar
                if(i == listaTipos.size() && (!tipo.equals("Semente") && !tipo.equals("Defensivo"))) {
                    listaTipos.add(tipo);
                }
                
        }
        
        if(listaTipos.isEmpty()){ //Não encontrou nenhum tipo, ou seja, não tem cadastro algum
            new TelaCompraProdutosErro().setVisible(true);
            this.dispose();
        }
        
        for(i = 1; i <= listaTipos.size() ; i++){
            boxTipo.addItem(listaTipos.get(i));
        }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
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
        }

        ;
        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        boxTipo = new javax.swing.JComboBox<>();
        textPreco = new javax.swing.JTextField();
        botaoConfirma = new javax.swing.JButton();
        botaoVolta = new javax.swing.JButton();
        textQtde = new javax.swing.JTextField();
        textNF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        boxMes = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        boxAno = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        boxDia = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        botaoAjuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Venda de Grãos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));
        jPanel1.setToolTipText("");

        titulo.setFont(new java.awt.Font("Chilanka", 1, 48)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Venda de Grãos");

        jLabel1.setFont(new java.awt.Font("Chilanka", 1, 12)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Chilanka", 1, 12)); // NOI18N
        jLabel2.setText("Tipo");

        jLabel3.setFont(new java.awt.Font("Chilanka", 1, 12)); // NOI18N
        jLabel3.setText("Preço (un)");

        jLabel4.setFont(new java.awt.Font("Chilanka", 1, 12)); // NOI18N
        jLabel4.setText("Quantidade");

        boxTipo.setEditable(true);

        botaoConfirma.setBackground(new java.awt.Color(51, 153, 255));
        botaoConfirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check.png"))); // NOI18N
        botaoConfirma.setToolTipText("Confirmar");
        botaoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmaActionPerformed(evt);
            }
        });

        botaoVolta.setBackground(new java.awt.Color(51, 153, 255));
        botaoVolta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow(1).png"))); // NOI18N
        botaoVolta.setToolTipText("Voltar");
        botaoVolta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Chilanka", 1, 12)); // NOI18N
        jLabel5.setText("Nº Nota fiscal");

        boxMes.setEditable(true);
        boxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        boxMes.setSelectedIndex(-1);

        jLabel10.setFont(new java.awt.Font("Chilanka", 1, 12)); // NOI18N
        jLabel10.setText("Ano");

        boxAno.setEditable(true);
        boxAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
        boxAno.setSelectedIndex(-1);

        jLabel6.setFont(new java.awt.Font("Chilanka", 1, 12)); // NOI18N
        jLabel6.setText("Dia");

        boxDia.setEditable(true);
        boxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        boxDia.setSelectedIndex(-1);

        jLabel7.setFont(new java.awt.Font("Chilanka", 1, 12)); // NOI18N
        jLabel7.setText("Mês");

        jLabel8.setFont(new java.awt.Font("Chilanka", 1, 12)); // NOI18N
        jLabel8.setText("Data");

        botaoAjuda.setBackground(new java.awt.Color(51, 153, 255));
        botaoAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/faq.png"))); // NOI18N
        botaoAjuda.setToolTipText("Voltar");
        botaoAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAjudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(botaoAjuda)
                .addGap(27, 27, 27)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(botaoVolta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botaoConfirma))
                                    .addComponent(textNF, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(boxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(boxAno, 0, 1, Short.MAX_VALUE)))
                                .addGap(15, 76, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(180, 180, 180))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(textQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo)
                    .addComponent(botaoAjuda))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(boxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(boxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoConfirma)
                    .addComponent(botaoVolta))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltaActionPerformed
        // TODO add your handling code here:
        new TelaEstoque().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltaActionPerformed

    private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
        // TODO add your handling code here:
        int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja realmente alterar os dados?");
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String dia, mes, ano;
        
        if(confirmacao == JOptionPane.YES_OPTION){
            Produto p1 = new Produto();
            
            p1.setLogin(Cliente.getNome());
            p1.setNome(textNome.getText());
            p1.setPreco(Double.parseDouble(textPreco.getText()));
            p1.setTipo(boxTipo.getSelectedItem().toString());
            p1.setQtde(Double.parseDouble(textQtde.getText()));
            
            Movimento mov1 = new Movimento();
            
            dia = (String) boxDia.getSelectedItem();
            mes = (String) boxMes.getSelectedItem();
            ano = (String) boxAno.getSelectedItem();
            String dataString = ano+"/"+mes+"/"+dia;
            
            java.sql.Date dataSql = null;
            try {
                dataSql = new java.sql.Date(formato.parse(dataString).getTime());
            } catch (ParseException ex) {
                Logger.getLogger(TelaCompraProdutos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            mov1.setLogin(Cliente.getNome());
            mov1.setNome(textNome.getText());
            mov1.setPreco_un(Double.parseDouble(textPreco.getText()));
            mov1.setTipo(boxTipo.getSelectedItem().toString());
            mov1.setQtde(Double.parseDouble(textQtde.getText()));
            mov1.setNf(textNF.getText());
            mov1.setDescricao("Venda");
            mov1.setData(dataSql);
            
            ProdutoDAO pDAO = new ProdutoDAO();
            MovimentoDAO movDAO = new MovimentoDAO();
            
            int idProdutoAtual;
            idProdutoAtual = pDAO.verificaVendaGrao(p1.getNome(), p1.getTipo(), p1.getQtde());
            
            if(idProdutoAtual != -1){
                p1.setQtde(0 - p1.getQtde());
                
                pDAO.update(idProdutoAtual, p1);
                movDAO.create(mov1);

                telaE.readJTable();
                new TelaEstoque().setVisible(true);
                this.dispose();
                
            }
            
            else {
                new TelaVendaGraosErro().setVisible(true);
                this.dispose();
            }
                    
        }
        
    }//GEN-LAST:event_botaoConfirmaActionPerformed

    private void botaoAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAjudaActionPerformed
        // TODO add your handling code here:
        new TelaVendaGraosAjuda().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoAjudaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaVendaGraos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVendaGraos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVendaGraos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVendaGraos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVendaGraos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAjuda;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.JButton botaoVolta;
    private javax.swing.JComboBox<String> boxAno;
    private javax.swing.JComboBox<String> boxDia;
    private javax.swing.JComboBox<String> boxMes;
    private javax.swing.JComboBox<String> boxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textNF;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textPreco;
    private javax.swing.JTextField textQtde;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

}
