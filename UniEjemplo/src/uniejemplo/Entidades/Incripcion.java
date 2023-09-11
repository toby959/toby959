
package uniejemplo.Entidades;

public class Incripcion {

     private int idInscripcion;
     private Alumno alumno;
     private Materia materia;
     private int nota;

    public Incripcion(int idInscripcion, Alumno alumno, Materia materia, int nota) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Incripcion() {
    }

    public Incripcion(Alumno alumno, Materia materia, int nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        String insc = idInscripcion+" " +alumno.getApellido()+", "+alumno.getNombre()+" "+materia.getNombre();
        return insc;
    }

    
}
