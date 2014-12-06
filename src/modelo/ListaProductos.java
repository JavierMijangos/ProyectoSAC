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
public class ListaProductos {
    public ArrayList<Producto> listaProductos = new ArrayList<>();

    public ListaProductos() {
        listaProductos.add(new Producto(1, "Lentes", "Lentes transition", "Transition", "Del ojo", 800f, 20, true));
        listaProductos.add(new Producto(2, "Lentes", "Lentes oscuros", "Aviador", "Del ojo", 950f, 20, true));
        listaProductos.add(new Producto(3, "Micas", "Micas transition", "Transition", "Eagle eyes", 200f, 20, true));
        listaProductos.add(new Producto(4, "Micas", "Micas antireflejo", "3.2", "Patito", 230.50f, 20, true));
        listaProductos.add(new Producto(5, "Micas", "Micas de oro", "G34", "Rey", 340f, 20, true));
        listaProductos.add(new Producto(6, "Lentes", "Lentes hipster", "Hippster", "Trans", 800f, 20, true));
        listaProductos.add(new Producto(7, "Micas", "Micas vacias", "123", "Eagle eyes", 500f, 20, true));
        listaProductos.add(new Producto(8, "Armazones", "Armazones negros", "N32", "Del ojo", 100f, 20, true));
        listaProductos.add(new Producto(9, "Armazones", "Armazones metalicos", "Metalix", "Del ojo", 765f, 20, true));
        listaProductos.add(new Producto(10, "Armazones", "Armazones plasticos", "Playdo", "Patito", 945f, 20, true));
        listaProductos.add(new Producto(11, "Contactos", "Contactos normales", "Norlam", "Trans", 123f, 20, true));
        listaProductos.add(new Producto(12, "Contactos", "Contactos de color", "Faroles", "Patito", 349f, 20, true));
        listaProductos.add(new Producto(13, "Soluciones", "Solucion azul", "Normal", "Del ojo", 697f, 20, true));
        listaProductos.add(new Producto(14, "Contactos", "Contactos noob", "noob69", "Del ojo", 235f, 20, true));
        listaProductos.add(new Producto(15, "Soluciones", "Lagrimas de sirena", "Ariel", "Del ojo", 576f, 20, true));
        listaProductos.add(new Producto(16, "Lentes", "Lentes harry", "Potter", "Trans", 1234f, 20, true));
        listaProductos.add(new Producto(17, "Lentes", "Monóculo", "GatoMalvado", "Patito", 2543f, 20, true));
        listaProductos.add(new Producto(18, "Lentes", "Lentes estrella", "Stars", "Trans", 845f, 20, true));
        listaProductos.add(new Producto(19, "Lentes", "Lentes 2015", "2015", "Eagle eyes", 670f, 20, true));
    }
    
}
