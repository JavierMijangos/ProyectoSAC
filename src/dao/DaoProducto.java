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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private static final String QUERY_OBTENER_MARCAS = "SELECT DISTINCT marca "
            + "FROM productos";
    private static final String QUERY_OBTENER_MARCAS_POR_TIPO = "SELECT "
            + "DISTINCT marca FROM productos WHERE tipo = ?";
    private static final String QUERY_OBTENER_MODELOS = "SELECT DISTINCT modelo"
            + " FROM productos";
    private static final String QUERY_OBTENER_MODELOS_POR_TIPO = "SELECT "
            + "DISTINCT modelo FROM productos WHERE tipo = ?";
    private static final String QUERY_OBTENER_MODELOS_POR_MARCA = "SELECT"
            + " DISTINCT modelo FROM productos WHERE marca = ?";
    private static final String QUERY_OBTENER_MODELOS_POR_TIPO_Y_MARCA =
            "SELECT DISTINCT modelo FROM productos WHERE tipo = ? AND marca = ?";
    private static final String QUERY_OBTENER_PRODUCTOS = "SELECT * FROM "
            + "productos";
    private static final String QUERY_OBTENER_PRODUCTOS_POR_TIPO = "SELECT *"
            + " FROM productos WHERE tipo = ?";
    private static final String QUERY_OBTENER_PRODUCTOS_POR_MARCA = "SELECT *"
            + " FROM productos WHERE marca = ?";
    private static final String QUERY_OBTENER_PRODUCTOS_POR_TIPO_Y_MARCA = 
            "SELECT * FROM productos WHERE tipo = ? AND marca = ?";
    private static final String QUERY_OBTENER_PRODUCTOS_POR_MODELO = "SELECT *"
            + " FROM productos WHERE modelo = ?";
    private static final String QUERY_OBTENER_PRODUCTOS_POR_TIPO_Y_MODELO = 
            "SELECT * FROM productos WHERE tipo= ? AND modelo = ?";
    private static final String QUERY_OBTENER_PRODUCTOS_POR_MARCA_Y_MODELO = 
            "SELECT * FROM productos WHERE marca= ? AND modelo = ?";
    private static final String 
            QUERY_OBTENER_PRODUCTOS_POR_TIPO_MARCA_Y_MODELO = "SELECT * FROM "
            + "productos WHERE tipo = ? AND marca= ? AND modelo = ?";
    
    private ArrayList<Producto> listaProductos = null;
    private ArrayList<String> listaString = null;
    
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
                producto = objetoConstruido(listaDeResultados);
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
    
    public ArrayList<String> obtenerRegistrosDeMarcas(){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_OBTENER_MARCAS);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            return arregloDeResultados(listaDeResultados);      
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<String> obtenerRegistrosDeMarcasPorTipo(String tipo){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_OBTENER_MARCAS_POR_TIPO);
            query.setString(1, tipo);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            return arregloDeResultados(listaDeResultados);        
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public ArrayList<String> obtenerRegistrosDeModelos(){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_OBTENER_MODELOS);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            return arregloDeResultados(listaDeResultados);        
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<String> obtenerRegistrosDeModelosPorTipo(String tipo){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_OBTENER_MODELOS_POR_TIPO);
            query.setString(1, tipo);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            return arregloDeResultados(listaDeResultados);        
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<String> obtenerRegistrosDeModelosPorMarca(String marca){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_OBTENER_MODELOS_POR_MARCA);
            query.setString(1, marca);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            return arregloDeResultados(listaDeResultados);     
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<String> obtenerRegistrosDeModelosPorTipoYMarca(String tipo,
            String marca){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion
                    .prepareStatement(QUERY_OBTENER_MODELOS_POR_TIPO_Y_MARCA);
            query.setString(1, tipo);
            query.setString(2, marca);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            return arregloDeResultados(listaDeResultados);       
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Producto> obtenerRegistrosDeProductos(){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_OBTENER_PRODUCTOS);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            return arregloDeDatos(listaDeResultados);        
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Producto> obtenerRegistrosDeProductosPorTipo(String tipo){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_OBTENER_PRODUCTOS_POR_TIPO);
            query.setString(1, tipo);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            return arregloDeDatos(listaDeResultados);        
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Producto> obtenerRegistrosDeProductosPorMarca(String marca){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_OBTENER_PRODUCTOS_POR_MARCA);
            query.setString(1, marca);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            return arregloDeDatos(listaDeResultados);        
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Producto> obtenerRegistrosDeProductosPorTipoYMarca(String tipo, String marca){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_OBTENER_PRODUCTOS_POR_TIPO_Y_MARCA);
            query.setString(1, tipo);
            query.setString(2, marca);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            return arregloDeDatos(listaDeResultados);        
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Producto> obtenerRegistrosDeProductosPorModelo(String modelo){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_OBTENER_PRODUCTOS_POR_MODELO);
            query.setString(1, modelo);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            return arregloDeDatos(listaDeResultados);       
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Producto> obtenerRegistrosDeProductosPorTipoYModelo
        (String tipo, String modelo){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_OBTENER_PRODUCTOS_POR_TIPO_Y_MODELO);
            query.setString(1, tipo);
            query.setString(2, modelo);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            return arregloDeDatos(listaDeResultados);        
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    public ArrayList<Producto> obtenerRegistrosDeProductosPorMarcaYModelo
        (String marca, String modelo){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion.prepareStatement(QUERY_OBTENER_PRODUCTOS_POR_MARCA_Y_MODELO);
            query.setString(1, marca);
            query.setString(2, modelo);
            query.execute();
            listaDeResultados = query.getResultSet();
            //TODO falta que regrese la lista
            return arregloDeDatos(listaDeResultados);        
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
     
    public ArrayList<Producto> obtenerRegistrosDeProductosPorTipoMarcaYModelo
        (String tipo, String marca, String modelo){
        try {
            conexion = DaoFactory.crearConexion();
            query = conexion.
                    prepareStatement
                    (QUERY_OBTENER_PRODUCTOS_POR_TIPO_MARCA_Y_MODELO);
            query.setString(1, tipo);
            query.setString(2, marca);
            query.setString(3, modelo);
            query.execute();
            listaDeResultados = query.getResultSet();
            
            return arregloDeDatos(listaDeResultados);        
        } catch (SQLException ex) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }      

    private ArrayList<String> arregloDeResultados(ResultSet listaDeResultados) throws SQLException {
        listaString = new ArrayList<>();
        while(listaDeResultados.next()){
            listaString.add(listaDeResultados.getString(1));
        }
        return listaString;
    }
    
    private ArrayList<Producto> arregloDeDatos(ResultSet listaDeResultados) throws SQLException {
        listaProductos = new ArrayList<>();
        while(listaDeResultados.next()){
            listaProductos.add(objetoConstruido(listaDeResultados));
        }
        return listaProductos;
    }
    
    public static void main(String[] args) {
        DaoProducto d = new DaoProducto();
        ArrayList<String> prueba = new ArrayList<>();
        prueba= d.obtenerRegistrosDeMarcas();
        
        for (String marca : prueba){
            System.out.println(marca);
        }
    }

    private Producto objetoConstruido(ResultSet listaDeResultados) throws SQLException {
        Producto producto = new Producto();
        
        producto.setIdProducto(listaDeResultados.getInt(1));
        producto.setNombre(listaDeResultados.getString(2));
        producto.setMarca(listaDeResultados.getString(3));
        producto.setModelo(listaDeResultados.getString(4));
        producto.setTipo(listaDeResultados.getString(5));
        producto.setPrecio(listaDeResultados.getFloat(6));
        producto.setCantidad(listaDeResultados.getInt(7));
        
        return producto;
        
    }
        

    
}
