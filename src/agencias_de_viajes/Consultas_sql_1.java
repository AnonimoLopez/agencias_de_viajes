/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencias_de_viajes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Lopez
 */
public class Consultas_sql_1 {

    Connection conn;
    Statement s;
    ResultSet rs;
    PreparedStatement ps;

    //   private PreparedStatement ps;
    // private Connection conn;
    private Statement st;
    //  private ResultSet rs;

    public Consultas_sql_1() {
        conn = Conectar.geConnection();
    }

    public int search_usuario(String Usuario, String Password) throws SQLException {
        int id = 0;
        s = conn.createStatement();
        String query = "SELECT CVE_USUARIO FROM USUARIO WHERE USUARIO = '" + Usuario + "' AND PASSWORD = '" + Password + "'";
        rs = s.executeQuery(query);

        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    public int insert_usuario(String usuario, String nombre, String email, String password) {
        try {
            ps = conn.prepareStatement("INSERT INTO USUARIOS (USUARIO, PASSWORD, NOMBRE, EMAIL ) VALUES (?,?,?,?)");
            ps.setString(1, usuario);
            ps.setString(2, password);
            ps.setString(3, nombre);
            ps.setString(4, email);
            ps.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(Consultas_sql_1.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return 0;
    }

    public int search_usuario_existencia(String Usuario) throws SQLException {
        int id = 0;
        try {
            s = conn.createStatement();
            String query = "SELECT cve_usuario FROM USUARIO WHERE USUARIO = '" + Usuario + "'";
            rs = s.executeQuery(query);

            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas_sql_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public ResultSet search(String name_table, String busqueda[][]) throws SQLException {
        String query = "SELECT * FROM " + name_table + " WHERE ";
        int id = 0;
        st = conn.createStatement();
        if (busqueda != null) {
            for (int i = 0; i < busqueda.length; i++) {
                String temp_b = "";
                String temp;
                temp = "'" + busqueda[i][1] + "'";
                temp_b = busqueda[i][0] + "=" + temp;
                if (i < busqueda.length - 1) {
                    temp_b += " AND ";
                }
                query += temp_b;
            }
        } else {
            query += "TRUE=TRUE";
        }
        rs = st.executeQuery(query);
        return rs;
    }

    public void insert(String name_table, String valores[][]) {
        String sql = "INSERT INTO " + name_table;
        String sql_colum = "(";
        String sql_values = "VALUES (";
        String temp_colum = "";
        String temp_values = "";
        for (int i = 0; i < valores.length; i++) {
            temp_colum += valores[i][0];
            temp_values += "'" + valores[i][1] + "'";
            if (i < valores.length - 1) {
                temp_colum += ",";
                temp_values += ",";
            }
        }
        sql_colum += temp_colum + ")";
        sql_values += temp_values + ")";
        sql += sql_colum + sql_values;

        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas_sql_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sql);
    }

    public void update(String name_table, String valores[][]) {
        String sql = "UPDATE " + name_table + " SET ";
        String colum = "";

        for (int i = 0; i < valores.length; i++) {

            if (i < valores.length - 1) {
                colum += valores[i][0] + "=" + "'" + valores[i][1] + "'";
                if (i < valores.length - 2) {
                    colum += ",";
                }
            } else {
                colum += " WHERE " + valores[i][0] + "=" + "'" + valores[i][1] + "'";
            }
        }

        sql += colum;
        System.out.println(sql);
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas_sql_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sql);

    }

    public static void main(String[] args) throws SQLException {
        Consultas_sql_1 x = new Consultas_sql_1();
//EJEMPLO PARA BUSCAR
//        String name_table = "personas";
//        String busqueda[][] = new String[1][2];
//        busqueda[0][0] = "cve_persona";
//        busqueda[0][1] = "1";
//        busqueda[0][0] = "cve_persona";
//        busqueda[0][1] = "2";
//        busqueda[1][0] = "MATERNO";
//        busqueda[1][1] = "MENDEZ";
//
//        ResultSet rs = x.search(name_table, null);
//        if (rs != null) {
//            while (rs.next()) {
//                System.out.println(rs.getString(1) + "-----" + rs.getString(2) + "------" + rs.getString(4));
//                System.out.println(x);
//            }
//        }
        //EJEMPLO PARA INSERTAR
//        String valores[][] = new String[4][2];
//        valores[0][0] = "NOMBRE";valores[0][1] = "JOSE DEL CARMEN";
//        valores[1][0] = "PATERNO";valores[1][1] = "LOPEZ";
//        valores[2][0] = "MATERNO";valores[2][1] = "MARTINES";
//        valores[3][0] = "TELEFONO";valores[3][1] = "9932004038";
//        
//        x.insert("personas", valores);

//        String valores[][] = new String[5][2];
//        valores[0][0] = "NOMBRE";
//        valores[0][1] = "JOSE1";
//        valores[1][0] = "PATERNO";
//        valores[1][1] = "LOPEZ";
//        valores[2][0] = "MATERNO";
//        valores[2][1] = "MARTINES";
//        valores[3][0] = "TELEFONO";
//        valores[3][1] = "9932004038";
//        valores[4][0] = "CVE_PERSONA";
//        valores[4][1] = "1";
//        x.update("personas", valores);

    }
}
