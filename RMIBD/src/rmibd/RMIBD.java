package rmibd;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RMIBD  extends Remote{

    //* Login *//
 public boolean ValidarUsuario(String user, String password) throws RemoteException;
    
    //* Buscar-Listar Alumnos *//
 public ArrayList<Alumnos>BusLis_Alumnos(int codigo)throws RemoteException;
 
 //* Buscar-Listar Docentes *//
 public ArrayList<Docentes>BusLis_Docentes(int cod)throws RemoteException;
 
 //* Buscar-Listar Docentes *//
 public ArrayList<Cursos>BusLis_Cursos(int cod)throws RemoteException;

    //*Mostrar Alumnos  *//
 public ArrayList<Alumnos> mostrarAlumnos() throws RemoteException;
 
    //*Mostrar Alumnos  *//
 public ArrayList<Cursos> mostrarCursos() throws RemoteException;
 
 //*Mostrar Alumnos  *//
 public ArrayList<Docentes> mostrarDocentes() throws RemoteException;
 
    //* Eliminar Alumnos *//
  public boolean eliminar (int codigo) throws RemoteException;
  
    //*Modificar Alumnos *//
 public boolean modificar (int codigo, String nombre, String apellido, String direccion) throws RemoteException;
 
    //* Registrar Alumnos *//
 public boolean RegistrarAlumnos (int codigo, String nombre, String apellido, String direccion, String email, 
         String edad, String grado, String sexo) throws RemoteException;
 
         //* Registrar Alumnos *//
 public boolean RegistrarDocentes (int codigo, String nombre, String apellido, String sexo,String direccion, 
            String edad, String email, String telefono) throws RemoteException;
 
        //* Registrar Alumnos *//
 public boolean RegistrarCursos(int codigo, String nombre, String horas, String cod_docente,String incidencias) throws RemoteException;
    
    
}
