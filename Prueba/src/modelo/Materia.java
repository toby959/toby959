      
package modelo;


public class Materia {

private int idMateria;
private String nombre;
private String anio;
private String estado;


public Materia(int idMateria, String nombre, String anio, String estado){
    this.idMateria = idMateria;
    this.nombre = nombre;
    this.anio = anio;
    this.estado = estado;
}

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    
}
