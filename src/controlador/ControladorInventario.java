/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dao.DaoFactory;
import modelo.Producto;

/**
 *
 * @author Asus
 */
public class ControladorInventario {
    
    private Producto producto;
    private DaoFactory daoFactory;

    public ControladorInventario() {
    }
    
    public void registrarProducto(Producto producto){
        daoFactory.obtenerDaoProductos().guardar(producto);
    }
    
    private void modificarProducto(){
        
    }
    
    private void eliminarProducto(){
        
    }
    
    private void listarProductoPorTipo(){
        
    }
    
    private void buscarProducto(){
        
    }
    
    private void reportarEscacez(){
        
    }
    
    private void mostrarPopularidad(){
        
    }
    
      
}
