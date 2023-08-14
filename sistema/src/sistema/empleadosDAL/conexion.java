
package sistema.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author toby959
 */
public class conexion {
 
    String strConexionDB = "jdbc:sqlite:C:/Users/Usuario/Desktop/db/sistema.s3db";
    Connection conn = null;
    
    
    public conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionDB);
            
            System.out.println("Conexión Establecida");    
        
        } catch (Exception e) {
        
            System.out.println("Error de conexión"+e);
                       
        }
        
    }
    
    public int ejecutarSentenciaSQL(String strSentenciaSQL){
        
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    
}
