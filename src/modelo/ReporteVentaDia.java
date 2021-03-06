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
public class ReporteVentaDia {
    
    private double pagoContado;
    private double totalASaldar;
    private double ventasNetas;
    private double anticipos;
    private double pagoAbonados;
    private double ingresos;
    private int numeroExamenes;
    private int numeroLentes;
    private int numeroMicas;
    private int numeroArmazones;
    private int numeroLentesContacto;
    private int numeroSoluciones;
    private int totalVentasProductos;

    public ReporteVentaDia() {
    }

    /**
     * @return the pagoContado
     */
    public double getPagoContado() {
        return pagoContado;
    }

    /**
     * @param pagoContado the pagoContado to set
     */
    public void setPagoContado(double pagoContado) {
        this.pagoContado = pagoContado;
    }

    /**
     * @return the pagoAbonados
     */
    public double getPagoAbonados() {
        return pagoAbonados;
    }

    public double getTotalASaldar() {
        return totalASaldar;
    }

    public void setTotalASaldar(double totalASaldar) {
        this.totalASaldar = totalASaldar;
    }   

    /**
     * @param pagoAbonados the pagoAbonados to set
     */
    public void setPagoAbonados(double pagoAbonados) {
        this.pagoAbonados = pagoAbonados;
    }

    /**
     * @return the ventasNetas
     */
    public double getVentasNetas() {
        return ventasNetas;
    }

    /**
     * @param ventasNetas the ventasNetas to set
     */
    public void setVentasNetas(double ventasNetas) {
        this.ventasNetas = ventasNetas;
    }

    /**
     * @return the anticipos
     */
    public double getAnticipos() {
        return anticipos;
    }

    /**
     * @param anticipos the anticipos to set
     */
    public void setAnticipos(double anticipos) {
        this.anticipos = anticipos;
    }

    /**
     * @return the ingresos
     */
    public double getIngresos() {
        return ingresos;
    }

    /**
     * @param ingresos the ingresos to set
     */
    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }

    /**
     * @return the numeroExamenes
     */
    public int getNumeroExamenes() {
        return numeroExamenes;
    }

    /**
     * @param numeroExamenes the numeroExamenes to set
     */
    public void setNumeroExamenes(int numeroExamenes) {
        this.numeroExamenes = numeroExamenes;
    }

    /**
     * @return the numeroLentes
     */
    public int getNumeroLentes() {
        return numeroLentes;
    }

    /**
     * @param numeroLentes the numeroLentes to set
     */
    public void setNumeroLentes(int numeroLentes) {
        this.numeroLentes = numeroLentes;
    }

    /**
     * @return the numeroMicas
     */
    public int getNumeroMicas() {
        return numeroMicas;
    }

    /**
     * @param numeroMicas the numeroMicas to set
     */
    public void setNumeroMicas(int numeroMicas) {
        this.numeroMicas = numeroMicas;
    }

    /**
     * @return the numeroArmazones
     */
    public int getNumeroArmazones() {
        return numeroArmazones;
    }

    /**
     * @param numeroArmazones the numeroArmazones to set
     */
    public void setNumeroArmazones(int numeroArmazones) {
        this.numeroArmazones = numeroArmazones;
    }

    /**
     * @return the numeroLentesContacto
     */
    public int getNumeroLentesContacto() {
        return numeroLentesContacto;
    }

    /**
     * @param numeroLentesContacto the numeroLentesContacto to set
     */
    public void setNumeroLentesContacto(int numeroLentesContacto) {
        this.numeroLentesContacto = numeroLentesContacto;
    }

    /**
     * @return the numeroSoluciones
     */
    public int getNumeroSoluciones() {
        return numeroSoluciones;
    }

    /**
     * @param numeroSoluciones the numeroSoluciones to set
     */
    public void setNumeroSoluciones(int numeroSoluciones) {
        this.numeroSoluciones = numeroSoluciones;
    }

    /**
     * @return the totalVentasProductos
     */
    public int getTotalVentasProductos() {
        return totalVentasProductos;
    }

    /**
     * @param totalVentasProductos the totalVentasProductos to set
     */
    public void setTotalVentasProductos(int totalVentasProductos) {
        this.totalVentasProductos = totalVentasProductos;
    }
    
    
}
