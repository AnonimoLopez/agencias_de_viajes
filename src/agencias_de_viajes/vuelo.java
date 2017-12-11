/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencias_de_viajes;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author flavioantonio
 */
public class vuelo extends javax.swing.JFrame {

    DefaultTableModel mode1;
    Connection conn;
    Statement sent;
 Consultas_sql_1 x = new Consultas_sql_1();
    /**
     * Creates new form Viajes
     */
    public vuelo() {
        initComponents();
        conn = Conectar.geConnection();
        //cargar_piloto();
        paquete();
        avion();
        ciudad();
    }

    void paquete() {
        try {
            DefaultComboBoxModel model_combox = new DefaultComboBoxModel();

            String sql = "";
            sql = "SELECT CONCAT (CVE_paquete,'-',NOMBRE) FROM paquete ";
            System.out.println(sql);
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            System.out.println(sql);
            if (rs != null) {
                System.out.println("----x-----");
                System.out.println(rs.getRow());
                Boolean stado = true;
                while (rs.next()) {
                    model_combox.addElement(rs.getString(1));
                    stado = false;
                }
                cbx_paquete.setModel(model_combox);
            }
        } catch (SQLException ex) {
            Logger.getLogger(vuelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void avion() {
        try {
            DefaultComboBoxModel model_combox = new DefaultComboBoxModel();

            String sql = "";
            sql = "SELECT CONCAT (cve_avion,'-',DESCRIPCION) FROM avion ";
            System.out.println(sql);
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            System.out.println(sql);
            if (rs != null) {
                System.out.println("----x-----");
                System.out.println(rs.getRow());
                Boolean stado = true;
                while (rs.next()) {
                    model_combox.addElement(rs.getString(1));

                }
                cbxAvion.setModel(model_combox);
            }
        } catch (SQLException ex) {
            Logger.getLogger(vuelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void ciudad() {
        try {
            DefaultComboBoxModel model_combox = new DefaultComboBoxModel();

            String sql = "";
            sql = "SELECT CONCAT (cve_ciudad,'-',nombre) FROM ciudad ";
            System.out.println(sql);
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            System.out.println(sql);
            if (rs != null) {
                System.out.println("----x-----");
                System.out.println(rs.getRow());
                Boolean stado = true;
                while (rs.next()) {
                    model_combox.addElement(rs.getString(1));

                }
                btn_ciudad.setModel(model_combox);
            }
        } catch (SQLException ex) {
            Logger.getLogger(vuelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargar_piloto() {

        try {
            DefaultComboBoxModel model_combox = new DefaultComboBoxModel();
            conn = Conectar.geConnection();
            String valor[] = (btn_ciudad.getSelectedItem().toString()).split("-");

            String sql = "";
            //   sql = "SELECT CONCAT (CVE_CONTINENTE,'-',NOMBRE) FROM continente";
            sql = "select concat(avion.CVE_PILOTO), concat(personas.CVE_PERSONA,'-', personas.NOMBRE ) from avion inner join personas on avion.CVE_PILOTO = personas.CVE_PERSONA"
                    + "where avion.CVE_PILOTO = " + valor[0];

            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                model_combox.addElement(rs.getString(1));
            }
//            cbx_continente.setModel(model_combox);
//
//            String valor[] = (cbx_continente.getSelectedItem().toString()).split("-");
//            txtCve_Continente.setText(valor[0]);
//            txt_continente.setText(valor[1]);

            //cargar_pais();
            System.out.println("----entro aqui");
            //Llenar();

        } catch (Exception ex) {
            Logger.getLogger(Destino.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        cbxAvion = new javax.swing.JComboBox<>();
        btn_ciudad = new javax.swing.JComboBox<>();
        txtcosto = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        cbx_paquete = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Vuelo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 24))); // NOI18N

        jButton5.setText("Menu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        cbxAvion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_ciudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton9.setText("GUARDAR");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        cbx_paquete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("PAQUETE");

        jLabel2.setText("CIUDAD");

        jLabel3.setText("AVION");

        jLabel4.setText("COSTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2)))
                                .addGap(83, 83, 83)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(btn_ciudad, 0, 236, Short.MAX_VALUE)
                                    .addComponent(cbxAvion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbx_paquete, 0, 236, Short.MAX_VALUE))))
                        .addGap(262, 262, 262))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(329, 329, 329))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_paquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addComponent(jButton9)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Menu m = new Menu();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String ciudad[] = (btn_ciudad.getSelectedItem().toString()).split("-");
        String avion[] = (cbxAvion.getSelectedItem().toString()).split("-");
        String paquete1[] = (cbx_paquete.getSelectedItem().toString() ).split("-");
         String valores[][] = new String[4][2];
        valores[0][0] = "cve_paquete";valores[0][1] = paquete1[0];
        valores[1][0] = "cve_ciudad";valores[1][1] = ciudad[0];
        valores[2][0] = "cve_avion";valores[2][1] = avion[0];
        valores[3][0] = "costo";valores[3][1] = txtcosto.getText();
        
        x.insert("paquete_destino", valores);
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(vuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vuelo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> btn_ciudad;
    private javax.swing.JComboBox<String> cbxAvion;
    private javax.swing.JComboBox<String> cbx_paquete;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtcosto;
    // End of variables declaration//GEN-END:variables
}
