
package crudmvc;
import modelo.*;

import vista.*;

import controlador.*; 
import java.awt.event.ActionEvent;

public class Universidadulp {


    public static void main(String[] args) {
        
        JFCrud vistaC = new JFCrud();
        
        AlumnoDAO modeloC = new AlumnoDAO();
        
       ControladorCrud controlaC = ControladorCrud(vistaC, modeloC); 
        
        vistaC.setVisible(true);
        vistaC.setLocationRelativeTo(null);
        
    }

    private static ControladorCrud ControladorCrud(JFCrud vistaC, AlumnoDAO modeloC) {
    ControladorCrud controladorC = new ControladorCrud(vistaC, modeloC) {};
    vistaC.btnRegistrar.addActionListener(controladorC);
    vistaC.btnListar.addActionListener(controladorC);
//   // vistaC.btnUpdate.addActionListener(controladorC);
//   // vistaC.btnDelete.addActionListener(controladorC);
    return controladorC;
}

 
}
