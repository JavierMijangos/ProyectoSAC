/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.Date;




/**
 *
 * @author Asus
 */
public class Deuda {
    
    private String nombreDeudor;
    private String nombreVendedor;
    private float montoTotal;
    private float montoFaltante;
    private float montoPagadp;
    private Date fechaAdquisicionDeuda;
    private Date fechaVencimiento;

    public Deuda() {
    }

    /**
     * @return the nombreDeudor
     */
    public String getNombreDeudor() {
        return nombreDeudor;
    }

    /**
     * @param nombreDeudor the nombreDeudor to set
     */
    public void setNombreDeudor(String nombreDeudor) {
        this.nombreDeudor = nombreDeudor;
    }

    /**
     * @return the nombreVendedor
     */
    public String getNombreVendedor() {
        return nombreVendedor;
    }

    /**
     * @param nombreVendedor the nombreVendedor to set
     */
    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    /**
     * @return the montoTotal
     */
    public float getMontoTotal() {
        return montoTotal;
    }

    /**
     * @param montoTotal the montoTotal to set
     */
    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * @return the montoFaltante
     */
    public float getMontoFaltante() {
        return montoFaltante;
    }

    /**
     * @param montoFaltante the montoFaltante to set
     */
    public void setMontoFaltante(float montoFaltante) {
        this.montoFaltante = montoFaltante;
    }

    /**
     * @return the montoPagadp
     */
    public float getMontoPagadp() {
        return montoPagadp;
    }

    /**
     * @param montoPagadp the montoPagadp to set
     */
    public void setMontoPagadp(float montoPagadp) {
        this.montoPagadp = montoPagadp;
    }

    /**
     * @return the fechaAdquisicionDeuda
     */
    public Date getFecha() {
        return fechaAdquisicionDeuda;
    }

    /**
     * @param fechaAdquisicionDeuda the fechaAdquisicionDeuda to set
     */
    public void setFecha(Date fecha) {
        this.fechaAdquisicionDeuda = fecha;
    }

    /**
     * @return the fechaVencimiento
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    
}
