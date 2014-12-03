/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabriel
 */
public class DaoProducto extends Dao{
    
    private static final String QUERY_CREAR = "INSERT INTO Productos (" +
            "nombre, modelo, marca, tipo, precio, cantidad) " +
            "VALUES ( ?, ?, ?, ?, ?, ? )";
    private static final String QUERY_OBTENER_POR_ID = "SELECT * FROM Productos" +
            " WHERE idProducto = ? ";
    private static final String QUERY_ACTUALIZAR = "UPDATE Productos " +
            "SET nombre = ?, modelo = ?, marca = ?, tipo = ?, precio = ?, " +
            "cantidad = ? WHERE idProducto = ?";
    private static final String QUERY_ELIMINAR = "DELETE FROM Productos " +
            "WHERE idProducto = ?";
    
    /**
     * Método para agregar un producto a la base de datos
     * @param producto El producto a guardar
     * @return el valor del id del producto agregado
     */
    public int guardar(Producto producto){
        int posicionDelPrimerDato = 1;
        int inicioDelArreglo = -1;
        
        try{
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_CREAR,
                    Statement.RETURN_GENERATED_KEYS);
            query.setString(1, producto.getNombre());
            query.setString(2, producto.getMarca());
            query.setString(3, producto.getModelo());
            query.setString(4, producto.getTipo());
            query.setFloat(5, producto.getPrecio());
            query.setInt(6, producto.getCantidad());
            query.execute();
            listaDeResultados = query.getGeneratedKeys();
            
            if (listaDeResultados.next()) {
                return listaDeResultados.getInt(posicionDelPrimerDato);
            }else{
                return inicioDelArreglo;
            }
        }catch(SQLException excepcion){
            System.out.println("Ocurrió un error" + excepcion.getMessage());
        }finally{
            cerrarListaDeResultados(listaDeResultados);
            cerrarSentencia(query);
            cerrarConexion(conexion);
        }
        return inicioDelArreglo;
    }
    
    /**
     * Método para obtener un producto basado en su id
     * @param id El identificador numérico del producto
     * @return El producto encontrado que coincide con el id
     */
    public Producto obtenerPorId(int id){
        Producto producto = null;
        
        try{
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_OBTENER_POR_ID);
            query.setInt(1, id);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            if (listaDeResultados.next()) {
                producto = new Producto();
                producto.setIdProducto(listaDeResultados.getInt(1));
                producto.setNombre(listaDeResultados.getString(2));
                producto.setMarca(listaDeResultados.getString(3));
                producto.setModelo(listaDeResultados.getString(4));
                producto.setTipo(listaDeResultados.getString(5));
                producto.setPrecio(listaDeResultados.getFloat(6));
                producto.setCantidad(listaDeResultados.getInt(7));
            }
            else{
                //Se considera el if, pero no es necesario
            }
            
        }catch(SQLException excepcion){
            System.out.println("Ocurrió un error" + excepcion.getMessage());
        }finally{
            cerrarListaDeResultados(listaDeResultados);
            cerrarSentencia(query);            
            cerrarConexion(conexion);
        }
        
        return producto;
    }
    
    /**
     * Método que actualiza la información de un producto
     * @param producto El producto a modificar
     * @return true si el producto se actualizó correctamente, false en
     *  caso contrario
     */
    public boolean actualizar(Producto producto){
        
        try{
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_ACTUALIZAR);
            query.setString(1, producto.getNombre());
            query.setString(2, producto.getMarca());
            query.setString(3, producto.getModelo());
            query.setString(4, producto.getTipo());
            query.setFloat(5, producto.getPrecio());
            query.setInt(6, producto.getCantidad());
            query.setInt(7, producto.getIdProducto());
            query.executeQuery();
            
            return true;
        }catch(SQLException excepcion){
            System.out.println("Ocurrio un error" + excepcion.getMessage());
        }finally{
            cerrarSentencia(query);
            cerrarConexion(conexion);
            
        }
        
        return false;
    }
    
    /**
     * Método que borra un producto de la base de datos basado en su id
     * @param id El identificador del producto a borrar
     * @return true si el producto se borró, false en caso contrario
     */
    public boolean borrar(int id){
        
        try{
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_ELIMINAR);
            query.setInt(1, id);
            query.execute();
            return true;
        }catch(SQLException excepcion){
            System.out.println("Ocurrio un error" + excepcion.getMessage());
        }finally{
            cerrarSentencia(query);
            cerrarConexion(conexion);           
        }
        
        return false;
    }

    
}
