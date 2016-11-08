package servidorbd;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import rmibd.RMIBD;
import rmibd.Alumnos;
import rmibd.Cursos;
import rmibd.Docentes;
/**
 *
 * @author ThermalTake
 */
public class ServidorBD extends UnicastRemoteObject implements RMIBD {

public ServidorBD() throws RemoteException{
    super();
}

public static void main (String [] args){
        try{
            
            Registry registro=LocateRegistry.createRegistry(4567);
            registro.rebind("rmi://localhost:4567/RMIBD",new ServidorBD());
            JOptionPane.showMessageDialog(null, "Servidor Activado con Éxito");
            
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    //* METODO PARA BUSCAR-LISTAR ALUMNOS *//

    @Override
    public ArrayList<Alumnos> BusLis_Alumnos(int codigo) throws RemoteException {

           int cod;  
        String app,apm,nom,email,grado,edad,sexo;
        
        ArrayList<Alumnos>lisAlum=new ArrayList<>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico","root","");
            String sentencia ="select * from alumnos where cod_alumno='"+codigo+"'";
            Statement stm =(Statement)cn.createStatement();
            ResultSet rs=stm.executeQuery(sentencia);
            while(rs.next()){
                cod=rs.getInt(1);
                app=rs.getString(2); 
                apm=rs.getString(3);
                nom=rs.getString(4);
                email=rs.getString(5);
                edad=rs.getString(6);
                grado=rs.getString(7);
                sexo=rs.getString(8);
                Alumnos oempleado=new Alumnos(cod,app,apm,nom,email,edad,grado,sexo);
                lisAlum.add(oempleado);
            }
            cn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
          return lisAlum;  

    }
    
     //* METODO PARA BUSCAR-LISTAR DOCENTES *//

    @Override
    public ArrayList<Docentes> BusLis_Docentes(int codigo) throws RemoteException {
        int cod;
        String nombre,apellido,sexo,direccion,edad,email,telefono;
        
        ArrayList<Docentes>lisDocen=new ArrayList<>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico","root","");
            String sentencia ="select * from docentes where cod_docente='"+codigo+"'";
            Statement stm =(Statement)cn.createStatement();
            ResultSet rs=stm.executeQuery(sentencia);
            while(rs.next()){
                cod=rs.getInt(1);
                nombre=rs.getString(2); 
                apellido=rs.getString(3);
                sexo=rs.getString(4);
                direccion=rs.getString(5);
                edad=rs.getString(6);
                email=rs.getString(7);
                telefono=rs.getString(8);
                Docentes oempleado=new Docentes(cod,nombre,apellido,sexo,direccion,edad,email,telefono);
                lisDocen.add(oempleado);
            }
            cn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
          return lisDocen;  

    }
    
    //* METODO PARA BUSCAR-LISTAR DOCENTES *//

    @Override
    public ArrayList<Cursos> BusLis_Cursos(int codigo) throws RemoteException {

        int cod;
        String nombre,horas,cod_docente,incidencias;
        
        ArrayList<Cursos>lisCur=new ArrayList<>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico","root","");
            String sentencia ="select * from cursos where cod_curso='"+codigo+"'";
            Statement stm =(Statement)cn.createStatement();
            ResultSet rs=stm.executeQuery(sentencia);
            while(rs.next()){
                cod=rs.getInt(1);
                nombre=rs.getString(2); 
                horas=rs.getString(3);
                cod_docente=rs.getString(4);
                incidencias=rs.getString(5);

                Cursos oempleado=new Cursos(cod,nombre,horas,cod_docente,incidencias);
                lisCur.add(oempleado);
            }
            cn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
          return lisCur;  

    }
    
    //* Mostrar Alumnos *//
    
    @Override
    public ArrayList<Alumnos> mostrarAlumnos() throws RemoteException {
            
        int cod;
        String app,apm,nom,email,grado,edad,sexo;
        
        ArrayList<Alumnos>Alum=new ArrayList<>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico","root","");
            String sentencia ="select * from alumnos";
            Statement stm =(Statement)cn.createStatement();
            ResultSet rs=stm.executeQuery(sentencia);
            while(rs.next()){
                cod=rs.getInt(1);
                app=rs.getString(2); 
                apm=rs.getString(3);
                nom=rs.getString(4);
                email=rs.getString(5);
                edad=rs.getString(6);
                grado=rs.getString(7);
                sexo=rs.getString(8);
                Alumnos oempleado=new Alumnos(cod,app,apm,nom,email,edad,grado,sexo);
                Alum.add(oempleado);
            }
            cn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
          return Alum;  
    }

    //* Mostrar Alumnos *//
    
    @Override
    public ArrayList<Cursos> mostrarCursos() throws RemoteException {
            
        int codigo;
        String nombre,horas,cod_docente,incidencias;
        
        ArrayList<Cursos>Curs=new ArrayList<>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico","root","");
            String sentencia ="select * from cursos";
            Statement stm =(Statement)cn.createStatement();
            ResultSet rs=stm.executeQuery(sentencia);
            while(rs.next()){
                
                codigo=rs.getInt(1);
                nombre=rs.getString(2); 
                horas=rs.getString(3);
                cod_docente=rs.getString(4);
                incidencias=rs.getString(5);

                Cursos oempleado=new Cursos(codigo,nombre,horas,cod_docente,incidencias);
                Curs.add(oempleado);
            }
            cn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
          return Curs;  
    }
    
    //* Mostrar Docentes *//
    
    @Override
    public ArrayList<Docentes> mostrarDocentes() throws RemoteException {
            
        int codigo;
        String nombre,apellido,sexo,direccion,edad,email,telefono;
        
        ArrayList<Docentes>Docen=new ArrayList<>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico","root","");
            String sentencia ="select * from persona";
            Statement stm =(Statement)cn.createStatement();
            ResultSet rs=stm.executeQuery(sentencia);
            while(rs.next()){
                codigo=rs.getInt(1);
                nombre=rs.getString(2); 
                apellido=rs.getString(3);
                sexo=rs.getString(4);
                direccion=rs.getString(5);
                edad=rs.getString(6);
                email=rs.getString(7);
                telefono=rs.getString(7);
                
                Docentes oempleado=new Docentes(codigo,nombre,apellido,sexo,direccion,edad,email,telefono);
                Docen.add(oempleado);
            }
            cn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
          return Docen;  
    }

    @Override
    public boolean eliminar(int codigo) throws RemoteException {

            boolean exito;
            exito=false;
            
            try{
              Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico","root","");
            String sentencia ="delete from persona where codigo=?";
           PreparedStatement ps=cn.prepareStatement(sentencia);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            exito=true;
            cn.close();
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            return exito;
            
    }

    @Override
    public boolean modificar(int codigo, String nombre, String apellido, String direccion) throws RemoteException {

    boolean exito;
            exito=false;
            
            try{
              Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico","root","");
            String sentencia ="update persona set nombre=?, apellido=?, direccion=? where codigo=?";
           PreparedStatement ps=cn.prepareStatement(sentencia);
            ps.setString(1, nombre);
             ps.setString(2, apellido);
            ps.setString(3, direccion);
            ps.setInt(4, codigo);

            ps.executeUpdate();
            exito=true;
            cn.close();
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            return exito;
            
 
    }

    //* METODO PARA REGISTRAR ALUMNOS *//
    
    @Override
    public boolean RegistrarAlumnos(int codigo, String nombre, String apellido, String direccion, String email, String edad, String grado, String sexo) throws RemoteException {
            boolean exito;
               exito=false;
               try{
                   Class.forName("com.mysql.jdbc.Driver"); //carga el driver
                   Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico", "root", "");
                   String sentencia = "insert into alumnos(cod_alumno,nombres,apellidos,direccion"
                           + ",email,edad,grado,sexo) values (?,?,?,?,?,?,?,?)";
                   PreparedStatement ps = cn.prepareStatement(sentencia);
                   ps.setInt(1, codigo);
                   ps.setString(2, nombre);
                   ps.setString(3, apellido);
                   ps.setString(4, direccion);
                   ps.setString(5, email);
                   ps.setString(6, edad);
                   ps.setString(7, grado);
                   ps.setString(8, sexo);
                   
                   ps.executeUpdate();
                   exito=true;
                   cn.close();
               }catch (Exception e){
                   System.out.println(e);
               }
               return exito;  
    }

    //* METODO PARA REGISTRAR ALUMNOS *//
    
    @Override
    public boolean RegistrarDocentes(int codigo, String nombre, String apellido, String sexo,String direccion, 
            String edad, String email, String telefono) throws RemoteException {
            boolean exito;
               exito=false;
               try{
                   Class.forName("com.mysql.jdbc.Driver"); //carga el driver
                   Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico", "root", "");
                   String sentencia = "insert into docentes(cod_docente,nombres,apellidos,sexo,direccion"
                           + ",edad,email,telefono) values (?,?,?,?,?,?,?,?)";
                   PreparedStatement ps = cn.prepareStatement(sentencia);
                   ps.setInt(1, codigo);
                   ps.setString(2, nombre);
                   ps.setString(3, apellido);
                   ps.setString(4,sexo);
                   ps.setString(5, direccion);
                   ps.setString(6, edad);
                   ps.setString(7, email);
                   ps.setString(8, telefono);
                   
                   ps.executeUpdate();
                   exito=true;
                   cn.close();
               }catch (Exception e){
                   System.out.println(e);
               }
               return exito;  
    }
    
    //* METODO PARA REGISTRAR CURSOS *//
    
    @Override
    public boolean RegistrarCursos(int codigo, String nombre, String horas, String cod_docente,String incidencias) 
            throws RemoteException {
            boolean exito;
               exito=false;
               try{
                   Class.forName("com.mysql.jdbc.Driver"); //carga el driver
                   Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico", "root", "");
                   String sentencia = "insert into cursos(cod_curso,nombre_curso,num_horas,cod_docente,incidencias"
                           + ") values (?,?,?,?,?)";
                   PreparedStatement ps = cn.prepareStatement(sentencia);
                   ps.setInt(1, codigo);
                   ps.setString(2, nombre);
                   ps.setString(3, horas);
                   ps.setString(4,cod_docente);
                   ps.setString(5, incidencias);

                   
                   ps.executeUpdate();
                   exito=true;
                   cn.close();
               }catch (Exception e){
                   System.out.println(e);
               }
               return exito;  
    }

    @Override
    public boolean ValidarUsuario(String user, String password) throws RemoteException {
        boolean exito;
        exito = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico", "root", "");

            String sql = "select * from administrador where usuario = '"
                    + user + "' and contraseña = '" + password + "' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {

            System.out.println(ex);
        }
        return exito;
    }

}
