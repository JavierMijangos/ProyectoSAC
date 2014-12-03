/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class DaoUsuario extends Dao{
    
    private static final String QUERY_CREAR = "INSERT INTO Usuarios (" +
            "nombreUsuario, clave) VALUES (?, ?)";
    private static final String QUERY_VERIFICAR_USUARIO = "SELECT * FROM " +
            "Usuarios WHERE nombreUsuario = ? AND clave = ?";
    private static final String QUERY_OBTENER_POR_ID = "SELECT * FROM " +
            "Usuarios WHERE idUsuario = ?";
    private static final String QUERY_ACTUALIZAR = "UPDATE Usuarios SET " +
            "nombreUsuario = ?, clave = ? WHERE idUsuario = ?";
    private static final String QUERY_ELIMINAR = "DELETE FROM Usuarios " +
            "WHERE idUsuario = ?";
    
    /**
     * Método para agregar un usuario a la base de datos
     * @param usuario El usuario a agregar
     * @return el valor del id del usuario agregado
     */
    public int guardar(Usuario usuario) throws SQLException{
        int posicionDelPrimerDato = 1;
        int inicioDelArreglo = -1;

        conexion = DaoFactory.crearConexion();
        query = conexion.prepareStatement(QUERY_CREAR,
                Statement.RETURN_GENERATED_KEYS);
        
        query.setString(1, usuario.getNombreUsuario());
        query.setString(2, usuario.getClave());
        query.execute();
        listaDeResultados = query.getGeneratedKeys();

        if (listaDeResultados.next()) {
            return listaDeResultados.getInt(posicionDelPrimerDato);
        } else {
            //Se considera, pero no es necesario
        }

        cerrarListaDeResultados(listaDeResultados);
        cerrarSentencia(query);
        cerrarConexion(conexion);


        return inicioDelArreglo;
    }
    
    /**
     * Método que verifica la identidad de un usuario
     * @param usuario El usuario a verificar
     * @return true si la información del usuario es correcta, false en caso 
     *  contrario
     */
    public boolean existe(Usuario usuario) throws SQLException{
        conexion = DaoFactory.crearConexion();
        query = conexion.prepareStatement(QUERY_VERIFICAR_USUARIO);
        
        query.setString(1, usuario.getNombreUsuario());
        query.setString(2, usuario.getClave());
        query.execute();
        listaDeResultados = query.getResultSet();

        if (listaDeResultados.next()) {
            return true;
        } else {
            //Se considera el if, pero no es necesario
        }

        cerrarListaDeResultados(listaDeResultados);
        cerrarSentencia(query);
        cerrarConexion(conexion);

        return false;
    }

    /**
     * Método para obtener un usuario basado en su id
     *
     * @param id El identificador numérico del usuario
     * @return El usuario encontrado que coincide con el id
     */
    public Usuario obtenerPorId(int id) throws SQLException {
        Usuario usuario = null;
        conexion = DaoFactory.crearConexion();
        query = conexion.prepareStatement(QUERY_OBTENER_POR_ID);
        
        query.setInt(1, id);
        query.execute();
        listaDeResultados = query.getResultSet();

        if (listaDeResultados.next()) {
            usuario = new Usuario();
            usuario.setIdUsuario(listaDeResultados.getInt(1));
            usuario.setNombreUsuario(listaDeResultados.getString(2));
            usuario.setClave(listaDeResultados.getString(3));
        } else {
            //Se considera el if, pero no es necesario
        }

        cerrarListaDeResultados(listaDeResultados);
        cerrarSentencia(query);
        cerrarConexion(conexion);


        return usuario;
    }
    
    /**
     * Método que actualiza la información de un usuario
     * @param usuario El usuario a modificar
     * @return true si el usuario se actualizó correctamente, false en
     *  caso contrario
     */
    public boolean actualizar(Usuario usuario) throws SQLException{
        conexion = DaoFactory.crearConexion();
        query = conexion.prepareStatement(QUERY_ACTUALIZAR);
        
        query.setString(1, usuario.getNombreUsuario());
        query.setString(2, usuario.getClave());
        query.setInt(3, usuario.getIdUsuario());
        query.execute();

        return true;
    }
    
    /**
     * Método que elimina un usuario de la base de datos basado en su id
     * @param id El identificador del usuario a eliminar
     * @return true si el usuario se eliminó, false en caso contrario
     */
    public boolean eliminar(int id) throws SQLException{
        conexion = DaoFactory.crearConexion();
        query = conexion.prepareStatement(QUERY_ELIMINAR);
        
        query.setInt(1, id);
        query.execute();
        cerrarSentencia(query);
        cerrarConexion(conexion);


        return true;
    }
    

    
}
