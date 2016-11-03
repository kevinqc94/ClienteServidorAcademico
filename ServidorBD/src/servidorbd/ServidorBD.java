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
import rmibd.persona;
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


    @Override
    public ArrayList<persona> buscar_persona(int codigo) throws RemoteException {

           int cod, edad;  
        String app,apm,nom,email,grado;
        
        ArrayList<persona>lisempleado=new ArrayList<>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico","root","");
            String sentencia ="select * from persona where codigo='"+codigo+"'";
            Statement stm =(Statement)cn.createStatement();
            ResultSet rs=stm.executeQuery(sentencia);
            while(rs.next()){
                cod=rs.getInt(1);
                app=rs.getString(2); 
                apm=rs.getString(3);
                nom=rs.getString(4);
                email=rs.getString(5);
                edad=rs.getInt(6);
                grado=rs.getString(7);
                persona oempleado=new persona(cod,app,apm,nom,email,edad,grado);
                lisempleado.add(oempleado);
            }
            cn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
          return lisempleado;  

    }

    @Override
    public ArrayList<persona> mostrar() throws RemoteException {
            
        int cod, edad;
        String app,apm,nom,email,grado;
        
        ArrayList<persona>lisempleado=new ArrayList<>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico","root","");
            String sentencia ="select * from persona";
            Statement stm =(Statement)cn.createStatement();
            ResultSet rs=stm.executeQuery(sentencia);
            while(rs.next()){
                cod=rs.getInt(1);
                app=rs.getString(2); 
                apm=rs.getString(3);
                nom=rs.getString(4);
                email=rs.getString(5);
                edad=rs.getInt(6);
                grado=rs.getString(7);
                persona oempleado=new persona(cod,app,apm,nom,email,edad,grado);
                lisempleado.add(oempleado);
            }
            cn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
          return lisempleado;  
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

    @Override
    public boolean Ingresar(int codigo, String nombre, String apellido, String direccion, String email, int edad, String grado) throws RemoteException {
            boolean exito;
               exito=false;
               try{
                   Class.forName("com.mysql.jdbc.Driver"); //carga el driver
                   Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-academico", "root", "");
                   String sentencia = "insert into persona(codigo,nombre,apellido,direccion"
                           + ",email,edad,grado) values (?,?,?,?,?,?,?)";
                   PreparedStatement ps = cn.prepareStatement(sentencia);
                   ps.setInt(1, codigo);
                   ps.setString(2, nombre);
                   ps.setString(3, apellido);
                   ps.setString(4, direccion);
                   ps.setString(5, email);
                   ps.setInt(6, edad);
                   ps.setString(7, grado);
                   
                   ps.executeUpdate();
                   exito=true;
                   cn.close();
               }catch (Exception e){
                   System.out.println(e);
               }
               return exito;  
    }




}
