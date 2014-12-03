/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Asus
 */
public class Producto {
    protected int idProducto;
    private String tipo;
    private String nombre;
    private String modelo;
    private String marca;
    private float precio;
    private int cantidad;
    private boolean existencia;

    public Producto() {
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipoProducto the tipo to set
     */
    public void setTipo(String tipoProducto) {
        this.tipo = tipoProducto;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombreProducto the nombreto set
     */
    public void setNombre(String nombreProducto) {
        this.nombre = nombreProducto;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + 
                ", tipo=" + tipo + ", nombre=" + nombre + ", modelo=" + 
                modelo + ", marca=" + marca + ", precio=" + precio + 
                ", cantidad=" + cantidad + '}';
    }

    /**
     * @return the existencia
     */
    public boolean isExistencia() {
        return existencia;
    }

    /**
     * @param existencia the existencia to set
     */
    public void setExistencia(boolean existencia) {
        this.existencia = existencia;
    }
    
    
    
}
