package rmibd;

import java.io.Serializable;

public class Docentes implements Serializable{
    
    private int codigo;
    private String nombre;
    private String apellido;
    private String sexo;
    private String direccion;
    private String edad;
    private String email;
    private String telefono;
    
    public Docentes (int codigo, String nombre, String apellido, String sexo,String direccion
    , String edad, String email, String telefono){
        this.codigo=codigo;
        this.nombre=nombre;
        this.apellido=apellido;
        this.sexo=sexo;
        this.direccion=direccion;
        this.edad=edad;
        this.email=email;
        this.telefono=telefono;
    }

    public int getCodigoDocentes() {
        return codigo;
    }

    public void setCodigoDocentes(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreDocentes() {
        return nombre;
    }

    public void setNombreDocentes(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoDocentes() {
        return apellido;
    }

    public void setApellidoDocentes(String apellido) {
        this.apellido = apellido;
    }
    
    public String getSexoDocentes() {
        return sexo;
    }

    public void setSexoDocentes(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccionDocentes() {
        return direccion;
    }

    public void setDireccionDocentes(String direccion) {
        this.direccion = direccion;
    }
    
    public String getEmailDocentes() {
        return email;
    }

    public void setEmailDocentes(String email) {
        this.email = email;
    }
    
    public String getEdadDocentes() {
        return edad;
    }

    public void setEdadDocentes(String edad) {
        this.edad = edad;
    }
   
    public String getTelefonoDocentes() {
        return telefono;
    }

    public void setTelefonoDocentes(String telefono) {
        this.telefono = telefono;
    }
}
