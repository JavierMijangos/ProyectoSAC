package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Gabriel on 11/11/2014.
 */
public class Dao {
    protected Connection conexion = null;
    protected PreparedStatement query = null;
    protected ResultSet listaDeResultados = null;

    /**
     * Método que cierra la lista de resultados
     * @param lista La lista de tipo ResultSet a cerrar
     */
    protected void cerrarListaDeResultados(ResultSet lista){
        try {
            lista.close();
        } catch (Exception errorDeResultado) {
            System.out.println("Ocurrio Un Error"
                    + errorDeResultado.getMessage());
        }

    }

    /**
     * Método que cierra el query ejecutado.
     * @param query el query a cerrar.
     */
    protected void cerrarSentencia(PreparedStatement query){
        try {
            query.close();
        } catch (Exception errorAlCerrar) {
            System.out.println(errorAlCerrar.getMessage());
        }
    }

    /**
     * Método que cierra la conexión a la base de datos.
     * @param conexion La conexión a cerrar.
     */
    protected void cerrarConexion(Connection conexion){
        try {
            conexion.close();
        } catch (Exception errorAlCerrar) {
            System.out.println(errorAlCerrar.getMessage());
        }
    }
}
