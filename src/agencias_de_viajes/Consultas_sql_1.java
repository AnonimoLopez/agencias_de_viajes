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
        String query = "SELECT ID FROM USUARIOS WHERE USUARIO = '" + Usuario + "' AND PASSWORD = '" + Password + "'";
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
            String query = "SELECT ID FROM USUARIOS WHERE USUARIO = '" + Usuario + "'";
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
//                try {
//                    Integer.parseInt(busqueda[i][1]);
//                    temp = busqueda[i][1];
//                } catch (NumberFormatException ex) {
//                    temp = "'" + busqueda[i][1] + "'";
                temp = "'" + busqueda[i][1] + "'";
                temp_b = busqueda[i][0] + "=" + temp;

                if (i < busqueda.length - 1) {
                    temp_b += " AND ";
                }

                query += temp_b;
//                }
            }

        } else {
            query += "TRUE=TRUE";
        }

        //  if ()
        //query += "TRUE = TRUE";
        System.out.println(query);
        rs = st.executeQuery(query);

        return rs;
    }

    public static void main(String[] args) throws SQLException {
        Consultas_sql_1 x = new Consultas_sql_1();
        String name_table = "personas";
        String busqueda[][] = new String[1][2];
        busqueda[0][0] = "cve_persona";
        busqueda[0][1] = "1";
//        busqueda[1][0] = "cve_persona";
//        busqueda[1][1] = "2";
//        busqueda[1][0] = "MATERNO";
//        busqueda[1][1] = "MENDEZ";
        ResultSet rs = x.search(name_table, null);
        if (rs != null) {
            while (rs.next()) {
                System.out.println(rs.getString(1) + "-----" + rs.getString(2) + "------" + rs.getString(4));
            }
        }

    }
}
