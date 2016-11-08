package rmibd;

import java.io.Serializable;

public class Cursos implements Serializable{
    
    private int codigo;
    private String nombre;
    private String horas;
    private String cod_docente;
    private String incidencias;

    
    public Cursos (int codigo, String nombre, String horas, String cod_docente, String incidencias){
        this.codigo=codigo;
        this.nombre=nombre;
        this.horas=horas;
        this.cod_docente=cod_docente;
        this.incidencias=incidencias;

    }

    public int getCodigoCursos() {
        return codigo;
    }

    public void setCodigoCursos(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCursos() {
        return nombre;
    }

    public void setNombreCursos(String nombre) {
        this.nombre = nombre;
    }
    
    public String getHorasCursos() {
        return horas;
    }

    public void setHorasCursos(String horas) {
        this.horas = horas;
    }
    
    public String getCodigoDocentes() {
        return cod_docente;
    }

    public void setCodigoDocentes(String cod_docente) {
        this.cod_docente = cod_docente;
    }
    
    public String getIncidenciasCursos() {
        return incidencias;
    }

    public void setIncidenciasCursos(String incidencias) {
        this.incidencias = incidencias;
    }

   
}
