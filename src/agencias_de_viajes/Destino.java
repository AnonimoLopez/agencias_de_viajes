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
public class Destino extends javax.swing.JFrame {

    DefaultTableModel mode1;
    Connection conn;
    Statement sent;

    /**
     * Creates new form Destino //
     */
    public Destino() {
        initComponents();
        conn = Conectar.geConnection();
        cargar_continente();
        // Llenar();
    }
//     void Desahabilitar() {
//
//        nom1.setEditable(false);
//        des1.setEditable(false);
//
//    }
//
//    void Limpiar() {
//
//        nom1.setText("");
//        des1.setText("");
//
//    }
//
//    void Habilitar() {
//
//        nom1.setEditable(true);
//        des1.setEditable(true);
//
//        nom1.requestFocus();
//
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_continente = new javax.swing.JTextField();
        txt_pais = new javax.swing.JTextField();
        txt_ciudad = new javax.swing.JTextField();
        cbx_continente = new javax.swing.JComboBox<>();
        txtCve_Continente = new javax.swing.JTextField();
        txt_Cve_pais = new javax.swing.JTextField();
        txt_cve_ciudad = new javax.swing.JTextField();
        cbx_pais = new javax.swing.JComboBox<>();
        cbx_ciudad = new javax.swing.JComboBox<>();
        agregar_cotinente = new javax.swing.JButton();
        agregar_pais = new javax.swing.JButton();
        agregar_ciudad = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Destino", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 24))); // NOI18N

        jLabel1.setText("Continente");

        jLabel2.setText("Pais");

        jLabel3.setText("Ciudad");

        cbx_continente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_continente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_continenteItemStateChanged(evt);
            }
        });

        txtCve_Continente.setEditable(false);
        txtCve_Continente.setEnabled(false);

        txt_Cve_pais.setEditable(false);
        txt_Cve_pais.setEnabled(false);

        txt_cve_ciudad.setEditable(false);
        txt_cve_ciudad.setEnabled(false);

        cbx_pais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_pais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_paisItemStateChanged(evt);
            }
        });

        cbx_ciudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_ciudad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_ciudadItemStateChanged(evt);
            }
        });

        agregar_cotinente.setText("GUARDAR");
        agregar_cotinente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_cotinenteActionPerformed(evt);
            }
        });

        agregar_pais.setText("GUARDAR");
        agregar_pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_paisActionPerformed(evt);
            }
        });

        agregar_ciudad.setText("GUARDAR");
        agregar_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_ciudadActionPerformed(evt);
            }
        });

        jButton1.setText("NUEVO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("NUEVO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("NUEVO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton4.setText("Menu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)
                        .addGap(119, 119, 119)
                        .addComponent(jLabel2)
                        .addGap(130, 130, 130)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregar_cotinente, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(cbx_continente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_continente)
                    .addComponent(txtCve_Continente))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(agregar_pais, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txt_pais)
                            .addComponent(txt_Cve_pais)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ciudad)
                    .addComponent(txt_cve_ciudad)
                    .addComponent(cbx_ciudad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregar_ciudad, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_continente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCve_Continente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Cve_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cve_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_continente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar_ciudad)
                    .addComponent(agregar_pais)
                    .addComponent(agregar_cotinente))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargar_continente() {
        try {
            DefaultComboBoxModel model_combox = new DefaultComboBoxModel();

            String sql = "";

            sql = "SELECT CONCAT (CVE_CONTINENTE,'-',NOMBRE) FROM continente";

            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                model_combox.addElement(rs.getString(1));
            }
            cbx_continente.setModel(model_combox);

            String valor[] = (cbx_continente.getSelectedItem().toString()).split("-");
            txtCve_Continente.setText(valor[0]);
            txt_continente.setText(valor[1]);

            cargar_pais();
            System.out.println("----entro aqui");
            Llenar();
        } catch (SQLException ex) {
            Logger.getLogger(Destino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargar_pais() {
        try {
            DefaultComboBoxModel model_combox = new DefaultComboBoxModel();
            String valor[] = (cbx_continente.getSelectedItem().toString()).split("-");

            String sql = "";
            sql = "SELECT CONCAT (CVE_PAIS,'-',NOMBRE) FROM pais where cve_continente = " + valor[0];

            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            if (rs != null) {
                Boolean stado = true;
                while (rs.next()) {
                    model_combox.addElement(rs.getString(1));
                    stado = false;
                }
            
            
                if (stado) {
                    System.out.println("----entro is null---");
                    model_combox.addElement("");
                    cbx_pais.setModel(model_combox);
                    txt_Cve_pais.setText("");
                    txt_pais.setText("");
                    limpiar_ciudad();
                    estado_ciudad(false);
                   
                } else {
                    estado_ciudad(true);
                    cbx_pais.setModel(model_combox);
                    valor = (cbx_pais.getSelectedItem().toString()).split("-");
                    txt_Cve_pais.setText(valor[0]);
                    txt_pais.setText(valor[1]);
                    
                   cargar_ciudad();
                  
                }
                 
        }
    }
    catch (SQLException ex

    
        ) {
            Logger.getLogger(Destino.class.getName()).log(Level.SEVERE, null, ex);
    }
}

void estado_ciudad(Boolean estado) {
        cbx_ciudad.enable(estado);
        txt_ciudad.enable(estado);
        txt_cve_ciudad.enable(estado);
        agregar_ciudad.enable(estado);

    }

    void limpiar_ciudad(){
         DefaultComboBoxModel model_combox = new DefaultComboBoxModel();
         model_combox.addElement("");
                    cbx_ciudad.setModel(model_combox);
                    txt_cve_ciudad.setText("");
                    txt_ciudad.setText("");
    }
    public void cargar_ciudad() {
        try {
            DefaultComboBoxModel model_combox = new DefaultComboBoxModel();
            String valor[] = (cbx_pais.getSelectedItem().toString()).split("-");
     
            String sql = "";
            sql = "SELECT CONCAT (CVE_CIuDAD,'-',NOMBRE) FROM ciudad where cve_PAIS  = " + valor[0];
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
                if (stado) {
                    System.out.println("----entro is null---");
                    model_combox.addElement("");
                    cbx_ciudad.setModel(model_combox);
                    txt_cve_ciudad.setText("");
                    txt_ciudad.setText("");
                } else {
                    System.out.println("----entro full hd");
                    cbx_ciudad.setModel(model_combox);
                    valor = (cbx_ciudad.getSelectedItem().toString()).split("-");
                    txt_cve_ciudad.setText(valor[0]);
                    txt_ciudad.setText(valor[1]);
                }

            } else {
                System.out.println("----entro is null---");
                model_combox.addElement("");
                cbx_ciudad.setModel(model_combox);
                txt_cve_ciudad.setText("");
                txt_ciudad.setText("");
            

}

        } catch (SQLException ex) {
            Logger.getLogger(Destino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void cbx_continenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_continenteItemStateChanged
        cargar_pais();
        Llenar();
          String valor[] = (cbx_continente.getSelectedItem().toString()).split("-");
          txtCve_Continente.setText(valor[0]);
         txt_continente.setText(valor[1]);
    }//GEN-LAST:event_cbx_continenteItemStateChanged

    private void agregar_cotinenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_cotinenteActionPerformed
        // TODO add your handling code here:
         String valor[] = (cbx_continente.getSelectedItem().toString()).split("-");
        if (txt_continente.getText().equals("")){
               JOptionPane.showMessageDialog(this, "POR FAVOR INGRESE UNA CONTINENTE");
         
                
             }else{
                   Consultas_sql_1 x = new Consultas_sql_1();
        if (txtCve_Continente.getText().equals("")){
            System.out.println(".........c.......");
       
        String valores[][] = new String[1][2];
        valores[0][0] = "NOMBRE";valores[0][1] = txt_continente.getText();
        //valores[1][0] = "cve_continente";valores[1][1] = valor[0]; 
        x.insert("continente", valores);   // TODO add your handling code here:
        cargar_continente();
            
        }else{
              String valores[][] = new String[2][2];
        valores[0][0] = "NOMBRE";
        valores[0][1] = txt_continente.getText();
        valores[1][0] = "CVE_CONTINENTE";
        valores[1][1] = txtCve_Continente.getText();    
        x.update("continente", valores);
       
       cargar_continente();
        }
        
        Llenar();
             }
    }//GEN-LAST:event_agregar_cotinenteActionPerformed

    private void agregar_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_ciudadActionPerformed
             if (txt_ciudad.getText().equals("")){
               JOptionPane.showMessageDialog(this, "POR FAVOR INGRESE UNA CIUDAD");
         
                
             }else{
                   Consultas_sql_1 x = new Consultas_sql_1();
        if (txt_cve_ciudad.getText().equals("")){
            System.out.println(".........c.......");
        String valor[] = (cbx_pais.getSelectedItem().toString()).split("-");
        String valores[][] = new String[2][2];
        valores[0][0] = "NOMBRE";valores[0][1] = txt_ciudad.getText();
        valores[1][0] = "cve_pais";valores[1][1] = valor[0]; 
        x.insert("ciudad", valores);   // TODO add your handling code here:
        cargar_ciudad();
            
        }else{
              String valores[][] = new String[2][2];
        valores[0][0] = "NOMBRE";
        valores[0][1] = txt_ciudad.getText();
        valores[1][0] = "cve_ciudad";
        valores[1][1] = txt_cve_ciudad.getText();    
        x.update("ciudad", valores);
        cargar_ciudad();
        }
        
        Llenar();
             }
    }//GEN-LAST:event_agregar_ciudadActionPerformed

    private void cbx_paisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_paisItemStateChanged
        // TODO add your handling code here:
         String valor[] = (cbx_pais.getSelectedItem().toString()).split("-");
        cargar_ciudad();
        txt_Cve_pais.setText(valor[0]);
        txt_pais.setText(valor[1]);
    }//GEN-LAST:event_cbx_paisItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txt_ciudad.setText("");
        txt_cve_ciudad.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbx_ciudadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_ciudadItemStateChanged
          String valor[] = (cbx_ciudad.getSelectedItem().toString()).split("-");
                    txt_cve_ciudad.setText(valor[0]);
                    txt_ciudad.setText(valor[1]);   // TODO add your handling code here:
    }//GEN-LAST:event_cbx_ciudadItemStateChanged

    private void agregar_paisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_paisActionPerformed
        // TODO add your handling code here:
         if (txt_pais.getText().equals("")){
               JOptionPane.showMessageDialog(this, "POR FAVOR INGRESE UNA CIUDAD");
         
                
             }else{
                   Consultas_sql_1 x = new Consultas_sql_1();
        if (txt_Cve_pais.getText().equals("")){
            System.out.println(".........c.......");
        String valor[] = (cbx_continente.getSelectedItem().toString()).split("-");
        String valores[][] = new String[2][2];
        valores[0][0] = "NOMBRE";valores[0][1] = txt_pais.getText();
        valores[1][0] = "cve_continente";valores[1][1] = valor[0]; 
        x.insert("pais", valores);   // TODO add your handling code here:
        cargar_pais();
            
        }else{
              String valores[][] = new String[2][2];
        valores[0][0] = "NOMBRE";
        valores[0][1] = txt_pais.getText();
        valores[1][0] = "cve_pais";
        valores[1][1] = txt_Cve_pais.getText();    
        x.update("pais", valores);
        cargar_pais();
        }
        
        Llenar();
             }
    }//GEN-LAST:event_agregar_paisActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txt_continente.setText("");
        txtCve_Continente.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txt_pais.setText("");
        txt_Cve_pais.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:}
        Menu m = new Menu();
        m.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton4ActionPerformed
 void Llenar() {

        try {

            conn = Conectar.geConnection();
            String valor[] = (cbx_continente.getSelectedItem().toString()).split("-");

            String[] titulos = {"CONTINENTE", "PAIS", "CIUDAD"};
            String sql = "SELECT concat(continente.CVE_CONTINENTE,'-' ,continente.NOMBRE),  concat(pais.CVE_PAIS,'-' ,pais.NOMBRE), concat(ciudad.CVE_ciudad,'-' ,ciudad.NOMBRE)\n" +
"FROM CONTINENTE inner join PAIS on continente.cve_continente = pais.cve_continente inner join CIUDAD  on pais. cve_pais=  ciudad.cve_pais\n" +
"where continente.CVE_CONTINENTE = " + valor[0];

            System.out.println(sql);
            mode1 = new DefaultTableModel(null, titulos){
                        @Override
        public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);

            String[] fila = new String[3];
            while (rs.next()) {
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
             

                
                mode1.addRow(fila);
            }
           
            jTable1.setModel(mode1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
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
            java.util.logging.Logger.getLogger(Destino.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Destino.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Destino.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Destino.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Destino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_ciudad;
    private javax.swing.JButton agregar_cotinente;
    private javax.swing.JButton agregar_pais;
    private javax.swing.JComboBox<String> cbx_ciudad;
    private javax.swing.JComboBox<String> cbx_continente;
    private javax.swing.JComboBox<String> cbx_pais;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCve_Continente;
    private javax.swing.JTextField txt_Cve_pais;
    private javax.swing.JTextField txt_ciudad;
    private javax.swing.JTextField txt_continente;
    private javax.swing.JTextField txt_cve_ciudad;
    private javax.swing.JTextField txt_pais;
    // End of variables declaration//GEN-END:variables
}
