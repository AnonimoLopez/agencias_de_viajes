package agencias_de_viajes;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author flavioantonio
 */ 
public class Conectar {
   // private static String dba = "unalm";
private static String user = "root";
    private static String pass = "joselopez156";
    private static String url = "jdbc:mysql://localhost:3306/agencias_de_viajes";
    private static Connection conn;
    private static Connection x;
   
    public static Connection geConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, user, pass);
            //conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/villalida","root","");
          //  System.out.println("exito");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null," Error En La Base De Datos " + e.getMessage());

        }
        return conn;
    }
    
    public static void main(String[] args) {
           geConnection();
           
        
    }
}
