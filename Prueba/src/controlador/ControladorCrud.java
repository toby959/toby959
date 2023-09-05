
package controlador;

import modelo.*;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public abstract class ControladorCrud implements ActionListener  {
 
    JFCrud vistaCrud = new JFCrud();
    AlumnoDAO modeloCrud = new AlumnoDAO();
    
    public ControladorCrud(JFCrud vistaCrud, AlumnoDAO modeloCrud) {
        this.modeloCrud = modeloCrud;
        this.vistaCrud = vistaCrud;
        this.vistaCrud.btnRegistrar.addActionListener(this);
        this.vistaCrud.btnListar.addActionListener(this);
        
   }
    
    
    public void InicializarCrud(){
        
    } 
    
    public void LlenarTabla(JTable tablaD){
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("DNI");
        modeloT.addColumn("APELLIDO");
        modeloT.addColumn("NOMBRE");
        modeloT.addColumn("FECHANACIMIENTO");
        modeloT.addColumn("ESTADO");
        
        Object[] columna = new Object[5];
        
        int numRegistros = modeloCrud.listAlumno().size();
        for (int i = 0; i < numRegistros; i++) {
            columna[0] = modeloCrud.listAlumno().get(i).getDni();
            columna[1] = modeloCrud.listAlumno().get(i).getApellido();
            columna[2] = modeloCrud.listAlumno().get(i).getNombre();
            columna[3] = modeloCrud.listAlumno().get(i).getFechaNacimiento();
            columna[4] = modeloCrud.listAlumno().get(i).getEstado();
            
            modeloT.addRow(columna);
            
            
            
            
        }
    }
    
    public void actionPerformed (ActionEvent e) {
        
        if (e.getSource() == vistaCrud.btnRegistrar) {
            String dni = vistaCrud.txtDni.getText();
            String apellido = vistaCrud.txtApellido.getText();
            String nombre = vistaCrud.txtNombre.getText();
            
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fecha =  formatoFecha.format(vistaCrud.jdFecha.getDate());    // recupera datos de la fecha-*-
            
            String estado = vistaCrud.txtEstado.getText();
            
            
            String rptaRegistro = modeloCrud.insertAlumno(dni, apellido, nombre, fecha, estado);
        
            if(rptaRegistro!=null){
              JOptionPane.showMessageDialog(null, rptaRegistro);
                
           } else {
            JOptionPane.showMessageDialog(null, "Registro Erroneo.");
        }
    }
    
    if(e.getSource() == vistaCrud.btnListar){
        LlenarTabla(vistaCrud.jtDatos);
    }
    
   }
}  

