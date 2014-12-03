/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class ListaEmpleados {//Clase de prueba

    public ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    public ListaEmpleados() {
        listaEmpleados.add(new Empleado(1, "Pepe", "Perez", 20, "Dirección", "Telefono", "Email", "Vendedor",  2000, 0));
        listaEmpleados.add(new Empleado(2, "Juan", "Perez", 21, "Dirección", "Telefono", "Email", "Administrador",  2000, 0));
        listaEmpleados.add(new Empleado(3, "Lore", "Perez", 22, "Dirección", "Telefono", "Email", "Vendedor",  2000, 0));
        listaEmpleados.add(new Empleado(4, "Luis", "Perez", 23, "Dirección", "Telefono", "Email", "Vendedor",  2000, 0));
        listaEmpleados.add(new Empleado(5, "Lola", "Perez", 24, "Dirección", "Telefono", "Email", "Vendedor",  2000, 0));
        listaEmpleados.add(new Empleado(6, "Manu", "Perez", 25, "Dirección", "Telefono", "Email", "Optometrista",  2000, 0));
    }
    
}
