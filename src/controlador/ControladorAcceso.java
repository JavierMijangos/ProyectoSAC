/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dao.DaoFactory;
import modelo.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class ControladorAcceso {

    private final Usuario usuario = new Usuario();
    private final ControladorFactory controlador = new ControladorFactory();
    
    public ControladorAcceso() {
    }
    
     public boolean acceder (String campoUsuario, String campoClave){  
        setUsuarioAValidar(campoUsuario, campoClave);
        
        if (usuarioValido()){
            generarVista();
            return true;
        }else{
            mostrarMensajeDeError();
            return false;
        }        
    }
        
    private boolean usuarioValido() {
        DaoFactory daoFactory = new DaoFactory();
        try {
            return daoFactory.obtenerDaoUsuarios().existe(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorAcceso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
    private void setUsuarioAValidar(String campoUsuario,
            String campoClave){
        usuario.setNombreUsuario(campoUsuario);
        usuario.setClave(campoClave);
    }
    
    private String obtenerTipoUsuario(){
        return controlador.obtenerControladorEmpleado().
                obtenerTipoEmpleado(usuario);        
    }
    
    private void generarVista(){
        controlador.obtenerControladorVistas().
                generarVista(obtenerTipoUsuario());
    }
    
    private void mostrarMensajeDeError(){
        JOptionPane.showMessageDialog(null, "Usuario o contraseña invalidos");
    }
}
