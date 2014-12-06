/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dao.DaoFactory;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import modelo.ListaProductos;
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
    
    private void modificarProducto(Producto producto){
        daoFactory.obtenerDaoProductos().actualizar(producto);
    }
    
    private void eliminarProducto(int id){
        daoFactory.obtenerDaoProductos().borrar(id);
    }
    
    ListaProductos listaProductos = new ListaProductos();
    public void obtenerProductos(String tipoProductos, JTable tablaProductos){
        if (tipoProductos.matches("Todos")){
            //obtenerTodosLosProductos(tablaProductos);
        }else{
            //obtenerEmpleadosPorTipo(tipoProductos, tablaProductos);
        }        
    }
    
    private void listarProductoPorTipo(){
   
    }
    
    private void buscarProducto(){
        
    }
    
    private void reportarEscacez(){
        
    }
    
    private void mostrarPopularidad(){
        
    }

    public void obtenerMarcas(String tipoProducto, JComboBox comboBoxMarca) {
        
        if (tipoProducto.matches("Todos")){
            obtenerTodasLasMarcas(comboBoxMarca);
        }else{
            obtenerMarcasPorTipo(tipoProducto, comboBoxMarca);
        }  
    }

    private void obtenerTodasLasMarcas(JComboBox comboBoxMarca) {
        ArrayList<Producto> listaTodosProductos = listaProductos.listaProductos;
        llenarComboBoxMarca(listaTodosProductos, comboBoxMarca);
    }

    private void llenarComboBoxMarca(ArrayList<Producto> listaDeProductos, JComboBox comboBoxMarca) {
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        modeloCombo.addElement("Escoja una marca");
        for (Producto productos : listaDeProductos) {
            if(!existeMarcaEnCombo(productos, modeloCombo)){
                modeloCombo.addElement(productos.getMarca());
            }                       
        }
        comboBoxMarca.setModel(modeloCombo);
    }

    private boolean existeMarcaEnCombo(Producto productos, DefaultComboBoxModel modeloCombo) {
        for (int i = 0; i<modeloCombo.getSize(); i++ ){
                if (modeloCombo.getElementAt(i).toString().matches(productos.getMarca())){
                    return true;
                }
            }
        return false;
    }

    private void obtenerMarcasPorTipo(String tipoProducto, JComboBox comboBoxMarca) {
        ArrayList<Producto> listaTodosProductos = listaProductos.listaProductos;
        ArrayList<Producto> listaEspecificaProductos = new ArrayList<>();
        for (int i = 0; i < listaTodosProductos.size(); i++){
            if (listaTodosProductos.get(i).getTipo().matches(tipoProducto)){
                listaEspecificaProductos.add(listaTodosProductos.get(i));
            }
        }
        llenarComboBoxMarca(listaEspecificaProductos, comboBoxMarca);
    }

    public void obtenerModelos(String marcaProducto, String tipoProducto, JComboBox comboBoxModelo) {
        if (tipoProducto.matches("Todos")){
            if (marcaProducto.matches("Todos")){
                obtenerTodosLosModelos(comboBoxModelo);
            }else{
                obtenerModelosPorMarcas(marcaProducto, comboBoxModelo);
            }   
        }else if(marcaProducto.matches("Todos")){
            //obtenerModeloPorTipo(tipoProducto, comboBoxModelo);
        }else{
            //obtemerModeloPorTipoYMarca(tipoProducto, marcaProducto, comboBoxModelo);
        }
         
    }

    private void obtenerTodosLosModelos(JComboBox comboBoxModelo) {
        ArrayList<Producto> listaTodosProductos = listaProductos.listaProductos;
        llenarComboBoxModelo(listaTodosProductos, comboBoxModelo);
    }

    private void llenarComboBoxModelo(ArrayList<Producto> listaDeProductos, JComboBox comboBoxModelo) {
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        modeloCombo.addElement("Escoja una marca");
        for (Producto productos : listaDeProductos) {
            if(!existeModeloEnCombo(productos, modeloCombo)){
                modeloCombo.addElement(productos.getModelo());
            }                       
        }
        comboBoxModelo.setModel(modeloCombo);
    }

    private boolean existeModeloEnCombo(Producto productos, DefaultComboBoxModel modeloCombo) {
        for (int i = 0; i<modeloCombo.getSize(); i++ ){
                if (modeloCombo.getElementAt(i).toString().matches(productos.getModelo())){
                    return true;
                }
            }
        return false;
    }

    private void obtenerModelosPorMarcas(String marcaProducto, JComboBox comboBoxModelo) {
         ArrayList<Producto> listaTodosProductos = listaProductos.listaProductos;
        ArrayList<Producto> listaEspecificaProductos = new ArrayList<>();
        for (int i = 0; i < listaTodosProductos.size(); i++){
            if (listaTodosProductos.get(i).getMarca().matches(marcaProducto)){
                listaEspecificaProductos.add(listaTodosProductos.get(i));
            }
        }
        llenarComboBoxModelo(listaEspecificaProductos, comboBoxModelo);
    }
    
      
}
