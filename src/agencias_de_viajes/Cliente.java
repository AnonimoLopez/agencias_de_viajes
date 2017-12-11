/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencias_de_viajes;
//import Agencias_de_viajes.Conectar;

import java.awt.Image;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author flavioantonio
 */
public class Cliente extends javax.swing.JFrame {
    
    DefaultTableModel mode1;
    Connection conn;
    Statement sent;
    Consultas_sql_1 x = new Consultas_sql_1();
    public User user_data;

    /**
     * Creates new form Cliente
     */
    public Cliente() {
        initComponents();
        conn = Conectar.geConnection();
        
        jTable1.setVisible(false);
        DefaultComboBoxModel model_combox = new DefaultComboBoxModel();
        model_combox.addElement("3-CLIENTE");
        tipo_empleado.setModel(model_combox);
        btnEliminar.setVisible(false);
      btnMenu.setVisible(false);

    }
    
    public Cliente(User user) throws SQLException {
        initComponents();
        conn = Conectar.geConnection();
        user_data = user;
        Llenar_combox();
        btnExit.setVisible(false);
    }
    
    void Llenar_combox() throws SQLException {
        DefaultComboBoxModel model_combox = new DefaultComboBoxModel();
        
        String sql = "";
        if (user_data.getTipo_empleado() == 1) {
            sql = "SELECT CONCAT (CVE_TIPO_EMPLEADO,'-',DESCRIPCION) FROM tipo_usuario";
        } else if (user_data.getTipo_empleado() == 2) {
            sql = "SELECT CONCAT (CVE_TIPO_EMPLEADO,'-',DESCRIPCION) FROM tipo_usuario where cve_tipo_usuario = 3 ";
        } else if (user_data.getTipo_empleado() == 3) {
               sql = "SELECT CONCAT (CVE_TIPO_EMPLEADO,'-',DESCRIPCION) FROM tipo_usuario where cve_tipo_usuario = 3 ";
           // tipo_empleado.setVisible(false);
        }
        
        
        sent = conn.createStatement();
        ResultSet rs = sent.executeQuery(sql);
        while (rs.next()) {
            model_combox.addElement(rs.getString(1));
        }
        tipo_empleado.setModel(model_combox);
        
        Llenar();
    }
    
    void Llenar() {
        
        try {
            
            conn = Conectar.geConnection();
            String valor[] = (tipo_empleado.getSelectedItem().toString()).split("-");
            
            String[] titulos = {"CVE_PERSONA", "NOMBRE", "PATERNO", "MATERNO", "TELEFONO", "EMAIL", "USUARIO", "PASSWORD", "ESTATUS"};
            String sql = "SELECT * FROM personas inner join usuario on CVE_PERSONA = CVE_USUARIO WHERE usuario.CVE_TIPO_USUARIO = " + valor[0];
            
            System.out.println(sql);
            mode1 = new DefaultTableModel(null, titulos) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            
            String[] fila = new String[9];
            while (rs.next()) {
                fila[0] = rs.getString("CVE_PERSONA");
                fila[1] = rs.getString("NOMBRE");
                fila[2] = rs.getString("PATERNO");
                fila[3] = rs.getString("MATERNO");
                fila[4] = rs.getString("TELEFONO");
                fila[5] = rs.getString("EMAIL");
                fila[6] = rs.getString("USUARIO");
                fila[7] = rs.getString("PASSWORD");
                
                if (rs.getBoolean("STATUS") == true) {
                    fila[8] = "ACTIVO";
                } else {
                    fila[8] = "INACTIVO";
                }
                mode1.addRow(fila);
            }
            
            jTable1.setModel(mode1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    void Desahabilitar() {
        
        nom1.setEditable(false);
        apa1.setEditable(false);
        ama1.setEditable(false);
        tel1.setEditable(false);
        mai1.setEditable(false);
        
    }
    
    void Limpiar() {
        
        nom1.setText("");
        apa1.setText("");
        ama1.setText("");
        tel1.setText("");
        mai1.setText("");
        cve_persona.setText("");
        txtPassword.setText("");
        txt_usuario.setText("");
        
    }
    
    void Habilitar() {
        
        nom1.setEditable(true);
        apa1.setEditable(true);
        ama1.setEditable(true);
        tel1.setEditable(true);
        mai1.setEditable(true);
        nom1.requestFocus();
        
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
        nom = new javax.swing.JLabel();
        apa = new javax.swing.JLabel();
        ama = new javax.swing.JLabel();
        tel = new javax.swing.JLabel();
        mai = new javax.swing.JLabel();
        tipo_empleado = new javax.swing.JComboBox<>();
        nom1 = new javax.swing.JTextField();
        apa1 = new javax.swing.JTextField();
        ama1 = new javax.swing.JTextField();
        tel1 = new javax.swing.JTextField();
        mai1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        cve_persona = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        label_message_user = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 24))); // NOI18N

        nom.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nom.setText("Nombre");

        apa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        apa.setText("Apellido Paterno");

        ama.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ama.setText("Apellido Materno");

        tel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tel.setText("Telefono");

        mai.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mai.setText("Correo Electronico");

        tipo_empleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Empleado", "Sin Cuenta" }));
        tipo_empleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipo_empleadoItemStateChanged(evt);
            }
        });
        tipo_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_empleadoActionPerformed(evt);
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
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTable1.setUpdateSelectionOnSort(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("DESABILITAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnExit.setText("Menu");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        cve_persona.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("IDENTIFICADOR");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Password");

        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyPressed(evt);
            }
        });

        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(255, 255, 255)
                        .addComponent(btnExit)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(mai)
                                .addComponent(tel)
                                .addComponent(apa)
                                .addComponent(ama)
                                .addComponent(nom)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cve_persona)
                                .addComponent(tipo_empleado, 0, 250, Short.MAX_VALUE)
                                .addComponent(ama1)
                                .addComponent(tel1)
                                .addComponent(mai1)
                                .addComponent(nom1)
                                .addComponent(apa1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_usuario)
                                .addComponent(txtPassword))
                            .addGap(18, 18, 18)
                            .addComponent(label_message_user, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(583, Short.MAX_VALUE)
                    .addComponent(btnMenu)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tipo_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cve_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom)
                    .addComponent(nom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apa)
                    .addComponent(apa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ama)
                    .addComponent(ama1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tel)
                    .addComponent(tel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mai)
                    .addComponent(mai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_message_user, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnExit))
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(457, Short.MAX_VALUE)
                    .addComponent(btnMenu)
                    .addGap(16, 16, 16)))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipo_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipo_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipo_empleadoActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        Login m = new Login();
        m.setVisible(true);
        dispose();
        

    }//GEN-LAST:event_btnExitActionPerformed
    
    private void asigar_datos() {
        int row = jTable1.getSelectedRow();
        cve_persona.setText(jTable1.getValueAt(row, 0).toString());
        nom1.setText(jTable1.getValueAt(row, 1).toString());
        apa1.setText(jTable1.getValueAt(row, 2).toString());
        ama1.setText(jTable1.getValueAt(row, 3).toString());
        tel1.setText(jTable1.getValueAt(row, 4).toString());
        mai1.setText(jTable1.getValueAt(row, 5).toString());
        txt_usuario.setText(jTable1.getValueAt(row, 6).toString());
        txtPassword.setText(jTable1.getValueAt(row, 7).toString());
        if (jTable1.getValueAt(row, 8).toString().equals("ACTIVO")) {
            btnEliminar.setText("DESABILITAR");
        } else {
            btnEliminar.setText("HABILITAR");
        }
        
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            
            asigar_datos();
//            mai1.setText(jTable1.getValueAt(row, 5).toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String valores[][] = new String[6][2];
        valores = new String[2][2];
        String status = "0";
        if (btnEliminar.getText().toString().equals("DESABILITAR")) {
            status = "0";
        } else {
            status = "1";
        }
        
        valores[0][0] = "STATUS";
        valores[0][1] = status;
        valores[1][0] = "CVE_USUARIO";
        valores[1][1] = cve_persona.getText();
        x.update("usuario", valores);
        
        Llenar();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if (cve_persona.getText().equals("")) {
                String valor[] = (tipo_empleado.getSelectedItem().toString()).split("-");
                String valores[][] = new String[5][2];
                valores[0][0] = "NOMBRE";
                valores[0][1] = nom1.getText();
                valores[1][0] = "PATERNO";
                valores[1][1] = apa1.getText();
                valores[2][0] = "MATERNO";
                valores[2][1] = ama1.getText();
                valores[3][0] = "TELEFONO";
                valores[3][1] = tel1.getText();
                valores[4][0] = "Email";
                valores[4][1] = mai1.getText();
                x.insert("personas", valores);
                
                valores = new String[3][2];
                valores[0][0] = "usuario";
                valores[0][1] = txt_usuario.getText();
                valores[1][0] = "password";
                valores[1][1] = txtPassword.getText();
                valores[2][0] = "CVE_TIPO_USUARIO";
                valores[2][1] = valor[0];
                x.insert("usuario", valores);
            } else {
                String valores[][] = new String[6][2];
                valores[0][0] = "NOMBRE";
                valores[0][1] = nom1.getText();
                valores[1][0] = "PATERNO";
                valores[1][1] = apa1.getText();
                valores[2][0] = "MATERNO";
                valores[2][1] = ama1.getText();
                valores[3][0] = "TELEFONO";
                valores[3][1] = tel1.getText();
                valores[4][0] = "e-mail";
                valores[4][1] = mai1.getText();
                valores[5][0] = "CVE_PERSONA";
                valores[5][1] = cve_persona.getText();
                x.update("personas", valores);
                valores = new String[3][2];
                valores[0][0] = "usuario";
                valores[0][1] = txt_usuario.getText();
                valores[1][0] = "password";
                valores[1][1] = txtPassword.getText();
                valores[2][0] = "CVE_USUARIO";
                valores[2][1] = cve_persona.getText();
                x.update("usuario", valores);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
            // Logger.getLogger(Viajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tipo_empleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipo_empleadoItemStateChanged
        if (user_data != null) {
            Llenar();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tipo_empleadoItemStateChanged

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txt_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyPressed
        
        String name_table = "usuario";
        String busqueda[][] = new String[1][2];
        busqueda[0][0] = "usuario";
        busqueda[0][1] = txt_usuario.getText();
        
        ResultSet rs;
        try {
            rs = x.search(name_table, busqueda);
            if (rs != null) {
                while (rs.next()) {
                    label_message_user.setText("USUARIO NO DISPONIBLE");
                }
            } else {
                label_message_user.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txt_usuarioKeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        int row = jTable1.getSelectedRow();
        cve_persona.setText(jTable1.getValueAt(row, 0).toString());
        nom1.setText(jTable1.getValueAt(row, 1).toString());
        apa1.setText(jTable1.getValueAt(row, 2).toString());
        ama1.setText(jTable1.getValueAt(row, 3).toString());
        tel1.setText(jTable1.getValueAt(row, 4).toString());
        mai1.setText(jTable1.getValueAt(row, 5).toString());
        txt_usuario.setText(jTable1.getValueAt(row, 6).toString());
        txtPassword.setText(jTable1.getValueAt(row, 7).toString());
        if (jTable1.getValueAt(row, 8).toString().equals("ACTIVO")) {
            btnEliminar.setText("DESABILITAR");
        } else {
            btnEliminar.setText("HABILITAR");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
   Menu m = new Menu(user_data);
        m.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ama;
    private javax.swing.JTextField ama1;
    private javax.swing.JLabel apa;
    private javax.swing.JTextField apa1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JTextField cve_persona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_message_user;
    private javax.swing.JLabel mai;
    private javax.swing.JTextField mai1;
    private javax.swing.JLabel nom;
    private javax.swing.JTextField nom1;
    private javax.swing.JLabel tel;
    private javax.swing.JTextField tel1;
    private javax.swing.JComboBox<String> tipo_empleado;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
