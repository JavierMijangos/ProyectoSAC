/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import Vista.FormularioEmpleado;
import Vista.VistaLogIn;
import vista.VistaPrincipal;
import javax.swing.JTabbedPane;

/**
 *
 * @author Asus
 */
public class ControladorVistas {
    private static final int INDICE_PESTAÑA_HISTORIAL = 7;
    private static final int INDICE_PESTAÑA_PACIENTES = 6;
    private static final int INDICE_PESTAÑA_EMPLEADOS = 5;
    private static final int INDICE_PESTAÑA_INVENTARIO = 4;
        
     public ControladorVistas() {
    }
    
    public void generarVista (String tipo){
        switch (tipo){
            case "Optometrista" :
                inicializarVistaOptometrista();
                break;
            case "Administrador" :
                inicializarVistaAdministrador();
                break;
            case "Vendedor" :
                inicializarVistaVendedor();
                break;
            default :
                //Se considera, pero no es necesario
        }   
    }
    
    private void inicializarVistaOptometrista(){
        VistaPrincipal vistaOptometrista = new VistaPrincipal();
        vistaOptometrista.setVisible(true);
    }
    
    private void inicializarVistaAdministrador(){
        VistaPrincipal vistaAdministrador = new VistaPrincipal();
        removerPestañasDeOptometrista(vistaAdministrador.jTabbedPanePestañas);
        vistaAdministrador.setVisible(true);
    }
    
    private void inicializarVistaVendedor(){
        VistaPrincipal vistaVendedor = new VistaPrincipal();
        removerPestañasDeOptometrista(vistaVendedor.jTabbedPanePestañas);
        removerPestañasDeAdministrador(vistaVendedor.jTabbedPanePestañas);
        vistaVendedor.setVisible(true);
    }
    
    private void removerPestañasDeOptometrista(JTabbedPane panelPrincipal){
        panelPrincipal.removeTabAt(INDICE_PESTAÑA_HISTORIAL);
        panelPrincipal.removeTabAt(INDICE_PESTAÑA_PACIENTES);
    }
    
    private void removerPestañasDeAdministrador(JTabbedPane panelPrincipal){
        panelPrincipal.removeTabAt(INDICE_PESTAÑA_EMPLEADOS);
        panelPrincipal.removeTabAt(INDICE_PESTAÑA_INVENTARIO);
    }
    
    public void mostrarLogIn (){
        new VistaLogIn().setVisible(true);
    }
    
    public void mostrarFormularioEmpleado(){
        FormularioEmpleado formularioEmpleado = new FormularioEmpleado();
        formularioEmpleado.setVisible(true);
    }
}
