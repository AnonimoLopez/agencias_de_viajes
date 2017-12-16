/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencias_de_viajes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author flavioantonio
 */
public class venta_Bole extends javax.swing.JFrame {

    /**
     * Creates new form venta_Bole
     */
    DefaultTableModel mode1;
    Connection conn;
    Statement sent;
    double subtotal;
    double total;
    int cve_paquete_destino;
    Consultas_sql_1 x = new Consultas_sql_1();
    public User user_data;

    public venta_Bole() {
        initComponents();
        conn = Conectar.geConnection();
        cargar_Paquete();
        cargar_Destino();
        cargar_Cliente();
        Llenar();

    }

    public venta_Bole(User user) {
        initComponents();
        conn = Conectar.geConnection();
        cargar_Paquete();
        cargar_Destino();
        cargar_Cliente();
        Llenar();
        user_data = user;
    }

    private void cargar_Paquete() {
        try {
            DefaultComboBoxModel model_combox = new DefaultComboBoxModel();

            String sql = "";

            sql = "SELECT DISTINCT(concat(paquete.cve_paquete,'-',NOMBRE)) FROM  paquete_destino inner join paquete on paquete_destino.cve_paquete = paquete.cve_paquete";

            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                model_combox.addElement(rs.getString(1));
            }
            cbxPaquete.setModel(model_combox);

        } catch (SQLException ex) {
            Logger.getLogger(Destino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargar_Destino() {
        try {
            DefaultComboBoxModel model_combox = new DefaultComboBoxModel();

            String sql = "";
            String valor[] = (cbxPaquete.getSelectedItem().toString()).split("-");
            sql = "SELECT paquete_destino.cve_paquete_destino, concat(paquete_destino.cve_paquete_destino, '-' ,ciudad.NOMBRE) , paquete_destino.costo, paquete_destino.Asientos_disponibles FROM  paquete_destino inner join paquete on paquete_destino.cve_paquete = paquete.cve_paquete inner join ciudad on ciudad.CVE_CIUDAD = paquete_destino.cve_ciudad inner join avion on  avion.CVE_AVION  inner join personas on personas.CVE_PERSONA = avion.CVE_PILOTO\n"
                    + "where paquete.cve_paquete = " + valor[0];

            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                model_combox.addElement(rs.getString(2));
            }
            CbxDestino.setModel(model_combox);
            llenar_txt();
        } catch (SQLException ex) {
            Logger.getLogger(Destino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenar_txt() {
        try {
            DefaultComboBoxModel model_combox = new DefaultComboBoxModel();
            String valor[] = (CbxDestino.getSelectedItem().toString()).split("-");
            String sql = "";

            sql = "SELECT paquete_destino.cve_paquete_destino, concat(ciudad.CVE_CIUDAD, '-' ,ciudad.NOMBRE) , paquete_destino.costo, paquete_destino.Asientos_disponibles FROM  paquete_destino inner join paquete on paquete_destino.cve_paquete = paquete.cve_paquete inner join ciudad on ciudad.CVE_CIUDAD = paquete_destino.cve_ciudad inner join avion on  avion.CVE_AVION  inner join personas on personas.CVE_PERSONA = avion.CVE_PILOTO\n"
                    + "where paquete_destino.cve_paquete_destino = " + valor[0];

            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                cve_paquete_destino = Integer.parseInt(rs.getString(1));
                txtCostoDeBoleto.setText(rs.getString(3));
                txtNumeroDeBoletoDisponible.setText(rs.getString(4));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Destino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void Llenar() {

        try {

            conn = Conectar.geConnection();

            String[] titulos = {"PAQUETE", "CIUDAD", "BOLETOS", "CLIENTE"};
            String sql = "select paquete.NOMBRE, ciudad.NOMBRE, venta.NO_BOLETOS, concat('(' , personas.CVE_PERSONA , ')' ,personas.NOMBRE ,' ', personas.PATERNO, ' ', personas.MATERNO ) from venta inner join paquete_destino ON venta.CVE_PAQUETE_DESTINO = paquete_destino.cve_paquete_destino inner join personas on venta.CVE_CLIENTE = personas.CVE_PERSONA join paquete on paquete_destino.cve_paquete = paquete.cve_paquete inner join ciudad on ciudad.CVE_CIUDAD = paquete_destino.cve_ciudad";

            System.out.println(sql);
            mode1 = new DefaultTableModel(null, titulos) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);

            String[] fila = new String[4];
            while (rs.next()) {
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                mode1.addRow(fila);
            }

            jTable1.setModel(mode1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void Llenar_p(String nombre) {

        try {

            conn = Conectar.geConnection();

            String[] titulos = {"PAQUETE", "CIUDAD", "BOLETOS", "CLIENTE"};
            String sql = "select paquete.NOMBRE, ciudad.NOMBRE, venta.NO_BOLETOS, concat('(' , personas.CVE_PERSONA , ')' ,personas.NOMBRE ,' ', personas.PATERNO, ' ', personas.MATERNO ) from venta inner join paquete_destino ON venta.CVE_PAQUETE_DESTINO = paquete_destino.cve_paquete_destino inner join personas on venta.CVE_CLIENTE = personas.CVE_PERSONA join paquete on paquete_destino.cve_paquete = paquete.cve_paquete inner join ciudad on ciudad.CVE_CIUDAD = paquete_destino.cve_ciudad";
            sql += " where personas.nombre like '%" + nombre + "%'";
            System.out.println(sql);
            mode1 = new DefaultTableModel(null, titulos) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);

            String[] fila = new String[4];
            while (rs.next()) {
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                mode1.addRow(fila);
            }

            jTable1.setModel(mode1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cargar_Cliente() {
        try {
            DefaultComboBoxModel model_combox = new DefaultComboBoxModel();

            String sql = "";

            sql = "SELECT CONCAT (CVE_PERSONA,'-',NOMBRE) FROM PERSONAS";
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                model_combox.addElement(rs.getString(1));
            }
            CbxCliente.setModel(model_combox);
        } catch (SQLException ex) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbxPaquete = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        CbxDestino = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumeroDeBoletoDisponible = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNumeroDeBoleto = new javax.swing.JTextField();
        CbxCliente = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCostoDeBoleto = new javax.swing.JTextField();
        TxtSubtotal = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Boletos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 24))); // NOI18N
        jPanel1.setToolTipText("");

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

        jLabel6.setText("Nombre del Paquete");

        cbxPaquete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxPaquete.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPaqueteItemStateChanged(evt);
            }
        });

        jLabel8.setText("Nombre del Destino");

        CbxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbxDestino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxDestinoItemStateChanged(evt);
            }
        });

        jLabel11.setText("CLIENTE");

        jLabel5.setText("Numero de Boletos Disponible");

        txtNumeroDeBoletoDisponible.setEnabled(false);

        jLabel4.setText("Numero de Boletos");

        CbxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroDeBoletoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroDeBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(CbxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(CbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtNumeroDeBoletoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumeroDeBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel1.setText("Costo por boleto");

        jLabel3.setText("SubTotal");

        jLabel10.setText("Total");

        jLabel9.setText("Efectivo");

        jLabel12.setText("Cambio");

        txtCostoDeBoleto.setEnabled(false);

        TxtSubtotal.setEnabled(false);
        TxtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSubtotalActionPerformed(evt);
            }
        });

        txtTotal.setEnabled(false);

        txt_cambio.setEnabled(false);

        jButton3.setText("Calcular Total");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Calcular Cambio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addComponent(txtCostoDeBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(214, 214, 214))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCostoDeBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImprimir))
        );

        jButton4.setText("BUSCAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("MENU");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(433, 433, 433))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("x");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        calcular_total();
    }//GEN-LAST:event_jButton2ActionPerformed

    void calcular_total() {
        if (validar()) {
            double efectivo = Double.parseDouble(txtEfectivo.getText());
            if (efectivo > total) {
                double cambio = efectivo - total;
                txt_cambio.setText("$" + cambio + "");
            } else {
                JOptionPane.showMessageDialog(this, "EL EFECTIVO DEBE DE SER MAYOR AL TOTAL");
            }
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (txtNumeroDeBoleto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "DEBE DE INGRESAR UN NUMERO DE BOLETO");

        } else {

            double No_Boletos = Double.parseDouble(txtNumeroDeBoleto.getText());
            double Costo = Double.parseDouble(txtCostoDeBoleto.getText());
            int No = Integer.parseInt(txtNumeroDeBoletoDisponible.getText());
            if (No_Boletos < No) {
                subtotal = No_Boletos * Costo;
                TxtSubtotal.setText("$" + subtotal + "");
                total = subtotal * 1.16;
                txtTotal.setText("$" + total + "");
            } else {
                JOptionPane.showMessageDialog(this, "NO SE PUEDE VENDER MAS VOLETO DE LO PERMITIDO");
                txtTotal.setText("");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TxtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSubtotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // String valor[] = (tipo_empleado.getSelectedItem().toString()).split("-");
        String valor[] = (CbxCliente.getSelectedItem().toString()).split("-");
        String valores[][] = new String[6][2];
        valores[0][0] = "CVE_PAQUETE_DESTINO";
        valores[0][1] = cve_paquete_destino + "";
        valores[1][0] = "CVE_CLIENTE";
        valores[1][1] = valor[0];
        valores[2][0] = "SUBTOTAL";
        valores[2][1] = subtotal + "";
        valores[3][0] = "NO_BOLETOS";
        valores[3][1] = txtNumeroDeBoleto.getText();
        valores[4][0] = "EFECTIVO";
        valores[4][1] = txtEfectivo.getText();
        valores[5][0] = "TOTAL";
        valores[5][1] = txtTotal.getText();
        x.insert("venta", valores);

        int N = Integer.parseInt(txtNumeroDeBoletoDisponible.getText());
        int N1 = Integer.parseInt(txtNumeroDeBoleto.getText());

        int r = N - N1;

        valores = new String[2][2];
        valores[0][0] = "Asientos_disponibles";
        valores[0][1] = r + "";
        valores[1][0] = "cve_paquete_destino";
        valores[1][1] = cve_paquete_destino + "";
        x.update("paquete_destino", valores);
        cargar_Paquete();
        cargar_Destino();
        cargar_Cliente();
        Llenar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CbxDestinoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxDestinoItemStateChanged
        llenar_txt();        // TODO add your handling code here:
    }//GEN-LAST:event_CbxDestinoItemStateChanged

    private void cbxPaqueteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPaqueteItemStateChanged
        cargar_Destino();        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPaqueteItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Llenar_p(nombre.getText());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Menu m = new Menu(user_data);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        imprimir();
    }//GEN-LAST:event_btnImprimirActionPerformed

    void limpiar() {
        txtTotal.setText("");
        txtNumeroDeBoleto.setText("");
        TxtSubtotal.setText("");
        txt_cambio.setText("");
        txtEfectivo.setText("");

    }

    boolean validar() {

        if (txtNumeroDeBoleto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "DEBE DE INGRESAR UN NUMERO DE BOLETO");
            return false;
        } else if (TxtSubtotal.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "DEBE DE PRESIONAR EL BOTON DE CALCULAR TOTAL");
            return false;
        } else if (txtEfectivo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "DEBE DE INGRESAR EL MONTO DE PAGO");
            return false;
        }
        return true;
    }

    void imprimir() {
         String valor[] = (CbxCliente.getSelectedItem().toString()).split("-");
              Date date = new Date();
       DateFormat hourFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
    String name = valor[0] +"_" +(hourFormat.format(date).toString());
        Document documento = new Document();
        FileOutputStream ficheroPdf;
        try {
            ficheroPdf = new FileOutputStream("src/"+name+".PDF");
            PdfWriter.getInstance(
                    documento,
                    ficheroPdf
            ).setInitialLeading(20);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        try {
            documento.open();
           
//            documento.add(new Paragraph("CUENTA CLIENTE: " + valor[0]));
//            documento.add(new Paragraph("CLIENTE: " + valor[1]));
//            documento.add(new Paragraph("No de Boletos: " + txtNumeroDeBoleto.getText()));
//            documento.add(new Paragraph("SUBTOTAL: " + TxtSubtotal.getText()));
//            documento.add(new Paragraph("IVA: 0.16%"));
//            documento.add(new Paragraph("TOTAL: " + txtTotal.getText()));
//            documento.add(new Paragraph("EFECTIVO: " + txtEfectivo.getText()));
//            documento.add(new Paragraph("CAMBIO " + txt_cambio.getText()));
//           Paragraph parrafo2 = new Paragraph("nuestro segundo Texto");
//            parrafo2.setAlignment(1);//el 1 es para centrar
//            documento.add(parrafo2);
            documento.add(new Paragraph(" "));
           //AQUÍ EMPIEZA (USA LA IMAGINACIÓN)
                PdfPTable tabla = new PdfPTable(2);
            tabla.addCell("CUENTA CLIENTE:");
            tabla.addCell(valor[0]);
            documento.add(tabla);  
            tabla = new PdfPTable(2);
            tabla.addCell("CLIENTE:");
            tabla.addCell(valor[1]);
            documento.add(tabla);
             tabla = new PdfPTable(2);
            tabla.addCell("No de Boletos:");
            tabla.addCell(txtNumeroDeBoleto.getText());
            documento.add(tabla);
             tabla = new PdfPTable(2);
            tabla.addCell("SUBTOTAL: " );
            tabla.addCell(TxtSubtotal.getText());
            documento.add(tabla);
             tabla = new PdfPTable(2);
            tabla.addCell("IVA: ");
            tabla.addCell("0.16%");
            documento.add(tabla);
             tabla = new PdfPTable(2);
            tabla.addCell("TOTAL: ");
            tabla.addCell(  txtTotal.getText());
            documento.add(tabla);
             tabla = new PdfPTable(2);
            tabla.addCell("EFECTIVO: " );
            tabla.addCell(txtEfectivo.getText());
            documento.add(tabla);
             tabla = new PdfPTable(2);
            tabla.addCell("CAMBIO " );
            tabla.addCell(txt_cambio.getText());
            documento.add(tabla);
            
           
       


            documento.close();
            try {
                File path = new File("src/"+name+".PDF");
                Desktop.getDesktop().open(path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
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
            java.util.logging.Logger.getLogger(venta_Bole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(venta_Bole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(venta_Bole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(venta_Bole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new venta_Bole().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbxCliente;
    private javax.swing.JComboBox<String> CbxDestino;
    private javax.swing.JTextField TxtSubtotal;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox<String> cbxPaquete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField txtCostoDeBoleto;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtNumeroDeBoleto;
    private javax.swing.JTextField txtNumeroDeBoletoDisponible;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txt_cambio;
    // End of variables declaration//GEN-END:variables
}
