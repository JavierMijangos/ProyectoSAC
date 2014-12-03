/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Empleado;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Gabriel
 */
public class DaoFactory {
    public static final String MANEJADOR = "com.mysql.jdbc.Driver";
    public static final  String URL_BASE_DE_DATOS = 
            "jdbc:mysql://localhost:3307/SACDB1";
    public static final String USUARIO = "root";
    public static final String CLAVE = "toor";
    
    public static Connection crearConexion(){
        Connection conexion = null;
        
        try{
            Class.forName(MANEJADOR);
            conexion = DriverManager.getConnection(URL_BASE_DE_DATOS,
                    USUARIO, CLAVE);
     
        }catch(SQLException excepcion){
            System.out.println("Ocurrió un error al intentar conectarse" + 
                    excepcion.getMessage());
        } catch (ClassNotFoundException excepcion) {
            System.out.println("No se pudo encontrar la clase" + 
                    excepcion.getMessage());
        }
        
        return conexion;
    }
    
    public DaoProducto obtenerDaoProductos(){
        return  new DaoProducto();
    }
    
    public DaoEmpleado obtenerDaoEmpleados(){
        return new DaoEmpleado();
    }
    
    public DaoUsuario obtenerDaoUsuarios(){
        return new DaoUsuario();
    }

    public DaoUsuarioEmpleado obtenerDaoUsuarioEmpleado(){
        return  new DaoUsuarioEmpleado();
    }


    public static void main(String[] args) {
        DaoFactory factory = new DaoFactory();
       DaoUsuarioEmpleado usuarioEmpleado = factory.obtenerDaoUsuarioEmpleado();

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("mrZentaurus");
        usuario.setClave("ninioRatax1000");

        Empleado empleado = new Empleado();
        empleado.setNombre("Javier");
        empleado.setApellido("Mijangos");
        empleado.setComision(.2424f);
        empleado.setDireccion("Por donde vive");
        empleado.setEdad(22);
        empleado.setEmail("gasdga@asdf.com");
        empleado.setSalario(2323.24f);
        empleado.setTelefono("23223432");
        empleado.setTipo("Vendedor");

        try {
            usuarioEmpleado.guardar(empleado, usuario);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
