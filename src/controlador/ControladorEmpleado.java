/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dao.DaoFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.ListaEmpleados;
import modelo.Usuario;

/**
 *
 * @author Asus
 */
public class ControladorEmpleado {
    private Empleado empleado;
    private final DaoFactory daoFactory = new DaoFactory();
    
    public void registrarEmpleado(Empleado empleado, Usuario usuario,
            String claveAConfirmar){
          if (formularioValido(empleado, usuario, claveAConfirmar)){
            try {
                daoFactory.obtenerDaoUsuarioEmpleado().guardar(empleado,
                        usuario);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorEmpleado.class.getName()).
                        log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "El empleado no se ha podido"
                        + "registrar en la base de datos");
            }                       
        }
        else{
            JOptionPane.showMessageDialog(null, "Lo sentimos pero alguno de "
                    + "sus campos no es valido");
        }
    }
    
    public void modificarEmpleado(Empleado empleado){
        try {
            daoFactory.obtenerDaoEmpleados().actualizar(empleado);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.
                    SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se ha podido modificar el "
                    + "empleado en la base de datos");
        }
    }
    
    public void eliminarEmpleado(int id){
        try {
            daoFactory.obtenerDaoEmpleados().borrar(id);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.
                    SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar el"
                    + "empleado de la base de datos");
        }
    }
    
    public void buscarEmpleado(int id){
        try {
            daoFactory.obtenerDaoEmpleados().obtenerPorId(id);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.
                    SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la"
                    + "busqueda en la base de datos");
        }
    }
    
     public String obtenerTipoEmpleado (Usuario usuario) {
        String tipo= "";
        
        try {
            empleado= daoFactory.obtenerDaoUsuarioEmpleado().
                    getInformacionEmpleadoLogueado(usuario);
            tipo = empleado.getTipo();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.
                    SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se ha podido obtener el "
                    + "tipo de empleado de la base de datos");
        }
        
        return tipo;       
    }
    
     private boolean formularioValido(Empleado empleado, Usuario usuario, String claveAConfirmar){        
         return clavesIguales(usuario.getClave(), claveAConfirmar);        
    }
    
    private boolean clavesIguales(String clave, String claveAConfirmar){
        return clave.matches(claveAConfirmar);
    } 
    
    public void obtenerEmpleados(String tipoEmpleados, JTable tablaEmpleados){
        if (tipoEmpleados.matches("Todos")){
            obtenerTodosLosEmpleados(tablaEmpleados);
        }else{
            obtenerEmpleadosPorTipo(tipoEmpleados, tablaEmpleados);
        }        
    }
    
    ListaEmpleados listaEmpleados = new ListaEmpleados();
    //TODO Esto lo deben hacer Querys y no las listas.
    private void obtenerTodosLosEmpleados(JTable tablaEmpleados){
        ArrayList<Empleado> listaTodosEmpleados = listaEmpleados.listaEmpleados;
        llenarTablaEmpleados(listaTodosEmpleados, tablaEmpleados);
    }
    
    private void obtenerEmpleadosPorTipo(String tipo, JTable tablaEmpleados){
        ArrayList<Empleado> listaTodosEmpleados = listaEmpleados.listaEmpleados;
        ArrayList<Empleado> listaEspecificaEmpleados = new ArrayList<>();
        for (int i = 0; i < listaTodosEmpleados.size(); i++){
            if (listaTodosEmpleados.get(i).getTipo().matches(tipo)){
                listaEspecificaEmpleados.add(listaTodosEmpleados.get(i));
            }
        }
        llenarTablaEmpleados(listaEspecificaEmpleados, tablaEmpleados);
    }
    
    private void llenarTablaEmpleados(ArrayList<Empleado> listaDeEmpleados, JTable tablaEmpleados){
        limpiarTabla(tablaEmpleados);
        Object columnasDeDatos[] = new Object[10];
        DefaultTableModel modeloDeLaTabla = (DefaultTableModel) tablaEmpleados.getModel();
        for (Empleado empleados : listaDeEmpleados) {
            
            columnasDeDatos[0] = empleados.getApellido();
            columnasDeDatos[1] = empleados.getNombre();
            columnasDeDatos[2] = empleados.getTipo();
            columnasDeDatos[3] = empleados.getSalario();
            //TODO aquí es donde se debe de calcular la comisión de cada empleado
            columnasDeDatos[4] = empleados.getComision();
            columnasDeDatos[5] = empleados.getTelefono();
            columnasDeDatos[6] = empleados.getEmail();
            columnasDeDatos[7] = empleados.getEdad();
            columnasDeDatos[8] = empleados.getDireccion();
            columnasDeDatos[9] = empleados.getIdEmpleado();
            
            //agregamos los datos de cada columna en cada renglon:
            modeloDeLaTabla.addRow(columnasDeDatos);
        }
        tablaEmpleados.setModel(modeloDeLaTabla);
    }
    
    private void limpiarTabla(JTable tablaEmpleados) {
        DefaultTableModel modeloDeLaTabla = (DefaultTableModel) tablaEmpleados.getModel();
        for (int i = 0; i < tablaEmpleados.getRowCount(); i++) {
            modeloDeLaTabla.removeRow(0);
            i -= 1;
        }
    }
    
    private float calcularComision(){
        return 0;        
    }
}
