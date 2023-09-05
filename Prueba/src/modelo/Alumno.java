
package modelo;


public class Alumno {
    
     private int idAlumno;
     private String dni;
     private String apellido;
     private String nombre;
     private String fechaNacimiento;
     private String estado;

     
    public Alumno(int idAlumno, String dni, String apellido, String nombre, String fechaNacimiento, String estado) {
    this.idAlumno = idAlumno;
    this.dni = dni;
    this.apellido = apellido;
    this.nombre = nombre;
    this.fechaNacimiento = fechaNacimiento;
    this.estado = estado;
}

    Alumno() {
        
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

         
}
