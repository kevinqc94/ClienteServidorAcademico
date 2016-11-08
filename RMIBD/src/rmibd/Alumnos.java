package rmibd;

import java.io.Serializable;

public class Alumnos implements Serializable{
    
    private int codigo;
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private String edad;
    private String grado;
    private String sexo;
    
    public Alumnos (int codigo, String nombre, String apellido, String direccion
    , String email, String edad, String grado, String sexo){
        this.codigo=codigo;
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.email=email;
        this.edad=edad;
        this.grado=grado;
        this.sexo=sexo;
    }

    public int getCodigoAlumnos() {
        return codigo;
    }

    public void setCodigoAlumnos(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreAlumnos() {
        return nombre;
    }

    public void setNombreAlumnos(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoAlumnos() {
        return apellido;
    }

    public void setApellidoAlumnos(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccionAlumnos() {
        return direccion;
    }

    public void setDireccionAlumnos(String direccion) {
        this.direccion = direccion;
    }
    
    public String getEmailAlumnos() {
        return email;
    }

    public void setEmailAlumnos(String email) {
        this.email = email;
    }
    
    public String getEdadAlumnos() {
        return edad;
    }

    public void setEdadAlumnos(String edad) {
        this.edad = edad;
    }
   
    public String getGradoAlumnos() {
        return grado;
    }

    public void setGradoAlumnos(String grado) {
        this.grado = grado;
    }
    
    public String getSexoAlumnos() {
        return sexo;
    }

    public void setSexoAlumnos(String sexo) {
        this.sexo = sexo;
    }
}
