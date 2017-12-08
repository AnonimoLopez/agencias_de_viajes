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
    
    public int search_usuario_existencia(String Usuario){
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

}
