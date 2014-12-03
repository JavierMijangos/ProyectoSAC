/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

/**
 *
 * @author Asus
 */
public class ControladorFactory {

    public ControladorFactory() {
    }
    
    public ControladorAcceso obtenerControladorAcceso(){
        return new ControladorAcceso();
    }
    
    public ControladorDeudas obtenerControladorDeudas(){
        return new ControladorDeudas();
    }
    
    public ControladorEmpleado obtenerControladorEmpleado(){
        return new ControladorEmpleado();
    }
    
    public ControladorInventario obtenerControladorInventario(){
        return new ControladorInventario();
    }
    
    public ControladorVentas obtenerControladorVentas(){
        return new ControladorVentas();
    }
    
    public ControladorVistas obtenerControladorVistas(){
        return new ControladorVistas();
    }
}
