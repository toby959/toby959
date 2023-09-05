
package modelo;

import java.sql.*;
import java.util.ArrayList;


public class AlumnoDAO {

  Conexion conexion;
  
  public AlumnoDAO(){
      
      conexion = new Conexion();
  }

  public String insertAlumno(String dni, String apellido, String nombre, String fechaNacimiento, String estado){

     String rptaRegistro = null;
     
      try {
          
          Connection accesoDB = conexion.getConexion();
             String query = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = accesoDB.prepareStatement(query);
        ps.setString(1, dni);
        ps.setString(2, apellido);
        ps.setString(3, nombre);
        ps.setString(4, fechaNacimiento);
        ps.setString(5, estado);
        int numFAfectas = ps.executeUpdate();  // numFAfectas filas afectadas

            if (numFAfectas > 0) {
                rptaRegistro = "Registro exitoso.";
            }

        } catch (Exception e) {
            
         //   JOptionPane.showMessageDialog(null, "Error de Conexion" +e.getMessage());
            
        }
        return rptaRegistro;
    }


    public ArrayList<Alumno> listAlumno() {

        ArrayList listaAlumno = new ArrayList();
        Alumno alumno;

        try {

            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("select * from alumno");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                alumno = new Alumno();
            
                alumno.setDni(rs.getString(1));
                alumno.setApellido(rs.getString(2));
                alumno.setNombre(rs.getString(3));
                alumno.setFechaNacimiento(rs.getString(4));
                alumno.setEstado(rs.getString(5));
                listaAlumno.add(alumno);

            }

        } catch (Exception e) {
          //  JOptionPane.showMessageDialog(null, "Error de Conexion" +e.getMessage());
        }
        return listaAlumno;
    }

  
  
}
  
  
    


    

