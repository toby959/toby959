
package uniejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "universidadulp";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    
    private static Connection connection; 

    private Conexion() {}
    
public static Connection getConexion(){
    if (connection == null) {
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
                                                             //"?useLegacyDatetimeCode=false&serverTimesone=UTC"+ "&user=" "&password= "  
             
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");                                                 
                                                             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la BD " + e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Drivers " + e.getMessage());
        }
    }
        return connection;
    }
}




    

