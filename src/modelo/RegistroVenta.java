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
public class RegistroVenta {
    
    
    private String nombreVendedor;
    private String nombrePaciente;
    private double pagoDeContado;
    private double montoTotal;
    private double anticipo;
    private double pagoAbonos;
    private boolean pagado;
    private double comision;

    public RegistroVenta() {
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
     * @return the nombrePaciente
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     * @param nombrePaciente the nombrePaciente to set
     */
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    /**
     * @return the montoTotal
     */
    public double getMontoTotal() {
        return montoTotal;
    }

    /**
     * @param montoTotal the montoTotal to set
     */
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * @return the anticipo
     */
    public double getAnticipo() {
        return anticipo;
    }

    /**
     * @param anticipo the anticipo to set
     */
    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    /**
     * @return the pagoAbonos
     */
    public double getPagoAbonos() {
        return pagoAbonos;
    }

    /**
     * @param pagoAbonos the pagoAbonos to set
     */
    public void setPagoAbonos(double pagoAbonos) {
        this.pagoAbonos = pagoAbonos;
    }

    /**
     * @return the pagado
     */
    public boolean isPagado() {
        return pagado;
    }

    /**
     * @param pagado the pagado to set
     */
    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    /**
     * @return the comision
     */
    public double getComision() {
        return comision;
    }

    /**
     * @param comision the comision to set
     */
    public void setComision(double comision) {
        this.comision = comision;
    }

    /**
     * @return the pagoDeContado
     */
    public double getPagoDeContado() {
        return pagoDeContado;
    }

    /**
     * @param pagoDeContado the pagoDeContado to set
     */
    public void setPagoDeContado(double pagoDeContado) {
        this.pagoDeContado = pagoDeContado;
    }
    
    
    
    
}
