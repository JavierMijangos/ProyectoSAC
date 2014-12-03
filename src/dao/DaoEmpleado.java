/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Empleado;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabriel
 */
public class DaoEmpleado extends Dao{
    
    private static final String QUERY_CREAR = "INSERT INTO Empleados (nombre," +
            "apellido, edad, direccion, email, telefono, salario," +
            "comisionMensual, tipo) VALUES (?, ?, ?, ? ,?, ?, ?, ?, ?)";
    private static final String QUERY_OBTENER_POR_ID = "SELECT * FROM " +
            "Empleados WHERE idEmpleado = ?";
    private static final String QUERY_ACTUALIZAR = "UPDATE Empleados SET " +
            "nombre = ?, apellido = ?, edad = ?, direccion = ?, email = ?, " +
            "telefono = ?, salario = ?, comisionMensual = ?, tipo = ? WHERE " +
            "idEmpleado = ?";
    private static final String QUERY_ELIMINAR = "DELETE FROM Empleados " +
            "WHERE idEmpleado = ?";

    
    /**
     * Método para agregar un empleado a la base de datos
     * @param empleado El empleado a agregar
     * @return el valor del id del empleado agregado
     */
    public int guardar(Empleado empleado) throws SQLException{
        int posicionDelPrimerDato = 1;
        int inicioDelArreglo = -1;
        
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_CREAR,
                    Statement.RETURN_GENERATED_KEYS);
            query.setString(1, empleado.getNombre());
            query.setString(2, empleado.getApellido());
            query.setInt(3, empleado.getEdad());
            query.setString(4, empleado.getDireccion());
            query.setString(5, empleado.getEmail());
            query.setString(6, empleado.getTelefono());
            query.setFloat(7, empleado.getSalario());
            query.setFloat(8, empleado.getComision());
            query.setString(9, empleado.getTipo());
            query.execute();
            listaDeResultados = query.getGeneratedKeys();
            
            if (listaDeResultados.next()) {
                return listaDeResultados.getInt(posicionDelPrimerDato);
            }else{
                //Se considera, pero no es necesario
            }
        
            cerrarListaDeResultados(listaDeResultados);
            cerrarSentencia(query);
            cerrarConexion(conexion);
               
        return inicioDelArreglo;
    }
    
    /**
     * Método para obtener un empleado basado en su id
     * @param id El identificador numérico del empleado
     * @return El empleado encontrado que coincide con el id
     */
    public Empleado obtenerPorId(int id) throws SQLException{
        Empleado empleado = null;

        conexion = DaoFactory.crearConexion();
        query = conexion.prepareStatement(QUERY_OBTENER_POR_ID);

        query.setInt(1, id);
        query.execute();
        listaDeResultados = query.getResultSet();

        if (listaDeResultados.next()) {
            empleado = new Empleado();
            empleado.setIdEmpleado(listaDeResultados.getInt(1));
            empleado.setNombre(listaDeResultados.getString(2));
            empleado.setApellido(listaDeResultados.getString(3));
            empleado.setEdad(listaDeResultados.getInt(4));
            empleado.setDireccion(listaDeResultados.getString(5));
            empleado.setEmail(listaDeResultados.getString(6));
            empleado.setTelefono(listaDeResultados.getString(7));
            empleado.setSalario(listaDeResultados.getFloat(8));
            empleado.setComision(listaDeResultados.getFloat(9));
            empleado.setTipo(listaDeResultados.getString(10));
        } else {
            //Se considera el if, pero no es necesario
        }

        cerrarListaDeResultados(listaDeResultados);
        cerrarSentencia(query);
        cerrarConexion(conexion);


        return empleado;
    }
    
    /**
     * Método que actualiza la información de un empleado
     * @param empleado El empleado a modificar
     * @return true si el empleado se actualizó correctamente, false en
     *  caso contrario
     */
    public boolean actualizar(Empleado empleado) throws SQLException{

        conexion = DaoFactory.crearConexion();
        query = conexion.prepareStatement(QUERY_ACTUALIZAR);
        query.setString(1, empleado.getNombre());
        query.setString(2, empleado.getApellido());
        query.setInt(3, empleado.getEdad());
        query.setString(4, empleado.getDireccion());
        query.setString(5, empleado.getEmail());
        query.setString(6, empleado.getTelefono());
        query.setFloat(7, empleado.getSalario());
        query.setFloat(8, empleado.getComision());
        query.setString(9, empleado.getTipo());
        query.setInt(10, empleado.getIdEmpleado());
        query.execute();

        return true;

    }
    
    /**
     * Método que borrar un empleado de la base de datos basado en su id
     * @param id El identificador del empleado a borrar
     * @return true si el empleado se borró, false en caso contrario
     */
    public boolean borrar(int id) throws SQLException{
        conexion = DaoFactory.crearConexion();
        query = conexion.prepareStatement(QUERY_ELIMINAR);
        
        query.setInt(1, id);
        query.execute();
        cerrarSentencia(query);
        cerrarConexion(conexion);

        return true;
 
    }
    
}
