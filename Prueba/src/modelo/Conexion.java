
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Conexion {

public Conexion(){  // cambia x nombre bd
    
}


public Connection getConexion(){
    Connection con = null;
    
    try {
        
        Class.forName("com.mariadb.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mariadb://localhost/universidadulp", "root", "");
        
         JOptionPane.showMessageDialog(null, "Conexion Exitosa");
         } catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar el driver de la base de datos: " + e.getMessage());
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error desconocido: " + e.getMessage());
    }
    
      return con;
    }
  }


//    
//public Connection getConexion() {
//    Connection con = null;
//    
//    try {
//        Class.forName("com.mariadb.jdbc.Driver").newInstance();
//        con = DriverManager.getConnection("jdbc:mariadb://localhost/universidadulp", "root", "");
//        JOptionPane.showMessageDialog(null, "Conexion Exitosa");
//    } catch (ClassNotFoundException e) {
//        JOptionPane.showMessageDialog(null, "Error al cargar el driver de la base de datos: " + e.getMessage());
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Error desconocido: " + e.getMessage());
//    }
// 
//    return con;
//}

//
//
// } catch (Exception e) {
//        
//        JOptionPane.showMessageDialog(null, "Error de Conexion" +e.getMessage());
//    }
// 
 
 