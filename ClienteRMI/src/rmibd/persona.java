package rmibd;

import java.io.Serializable;

public class persona implements Serializable{
    
    private int codigo;
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private int edad;
    private String grado;
    
    public persona (int codigo, String nombre, String apellido, String direccion
    , String email, int edad, String grado){
        this.codigo=codigo;
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.email=email;
        this.edad=edad;
        this.grado=grado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
   
    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
}
