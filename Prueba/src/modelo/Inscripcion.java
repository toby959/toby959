
package modelo;

public class Inscripcion {

  private int idInscripcion;
  private String nota;
  private int idAlumno;
  private int idMateria; 
  

  public Inscripcion(int idInscripcion, String nota, int idAlumno, int idMateria){
      this.idInscripcion = idInscripcion;
      this.nota = nota;
      this.idAlumno = idAlumno;
      this.idMateria = idMateria;
            
  }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
  
  
  
    
}
