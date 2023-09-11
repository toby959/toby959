
package uniejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import uniejemplo.Entidades.Alumno;
import uniejemplo.Entidades.Materia;




public class MateriaData {


    private Connection con = null;
    
public MateriaData(){
    con = Conexion.getConexion();
}

public void guardarMateria(Materia materia) {
    
    String sql = "INSERT INTO materia (nombre, anio, estado)" + "VALUES(?,?,?)";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS );
        
        ps.setString(1, materia.getNombre());
        ps.setDate(2, Date.valueOf(materia.getAnio()));
        ps.setBoolean(3, materia.isActivo());
        ps.executeUpdate();
        
        ResultSet rs = ps.getGeneratedKeys();
        
        if (rs.next()) {
            materia.setIdMateria(rs.getInt(1));
            
            JOptionPane.showMessageDialog(null, "Materia guardada");
            
        }
        ps.close();
        
    } catch (SQLException e) {
        
              JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia"+e.getMessage());       
    }
    
}

    public void modificarMateria(Materia materia) {
        
        String sql = "UPDATE materia SET nombre = ?, anio = ?" + "WHERE idMateria = ?";
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setDate(2, Date.valueOf(materia.getAnio()));
            ps.setInt(3, materia.getIdMateria());
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                
                JOptionPane.showMessageDialog(null, "Materia modificada"); 
                
            }
            
            
            
            
        } catch (SQLException e) {
            
               JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia"+e.getMessage());
            
        }
    }
        public void eliminarMateria(int id) {
            
             String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";
            try {
                
              PreparedStatement ps = con.prepareStatement(sql);
              ps.setInt(1, id);
              int exito = ps.executeUpdate();
              
              
                if (exito == 1) {
                      JOptionPane.showMessageDialog(null, "Materia  eliminada");
                }
  
                
            } catch (SQLException e) {
                
                  JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia"+e.getMessage());
            }
        }
        
        
        public Materia buscarMateria(int id){
            
            String sql = "SELECT idMateria, nombre, anio FROM materia WHERE idMateria = ? AND estado = 1"; 
            Materia materia = null; // inicializado
            try {
                
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    
                    materia = new Materia();
                    materia.setIdMateria(rs.getInt("idMateria"));
                    materia.setNombre(rs.getString("nombre"));
                    materia.setAnio(rs.getDate("anio").toLocalDate());
                    materia.setActivo(true);
                    
                } else {
                     JOptionPane.showMessageDialog(null, "No existe esa materia"); 
                }
                ps.close();
                
                
            } catch (SQLException e) {
                
                 JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia" + e.getMessage());
            }
            return materia;
        }
        
     
        public Materia buscarMateriaPorId(int id) {
            
            String sql = "SELECT idMateria, nombre, anio, estado FROM materia WHERE id = ? AND estado = 1";
            Materia materia = null;  // inicializado   
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    
                    materia = new Materia();
                    materia.setIdMateria(rs.getInt("idMateria"));
                    materia.setNombre(rs.getString("nombre"));
                    materia.setAnio(rs.getDate("anio").toLocalDate());
                    materia.setActivo(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe esa materia");
                }
                ps.close();
                
            } catch (SQLException e) {
                
                 JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia" + e.getMessage());
            }
            return materia;
        }
        
        public List<Materia> listarMaterias(){
            
            String sql = "SELECT idMateria, nombre, anio FROM materia WHERE estado = 1";
            ArrayList<Materia> materias = new ArrayList<>(); // lista vacia plural materias-*-
            
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    
                    Materia materia = new Materia();
                    materia.setIdMateria(rs.getInt("idMateria"));
                    materia.setNombre(rs.getString("nombre"));
                    materia.setAnio(rs.getDate("anio").toLocalDate());
                    materia.setActivo(true);
                    
                    materias.add(materia);  // en plural!!!! -*-
                }
                ps.close();
                
            } catch (SQLException e) {
                
                 JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia" + e.getMessage());
            }
            return materias; // en plural!!!! -*-
        }
        
    }

