/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Asus
 */
public class CuentasVentas {
    
    private final ReporteVentaDia reporteDia = new ReporteVentaDia();
    
    private static ArrayList<RegistroVenta> ventas = new ArrayList<>();
    private static final int NUMERO_DE_VENTAS = ventas.size();
    
    public CuentasVentas(ArrayList<RegistroVenta> ventas) {
        this.ventas = ventas;
    }

    private CuentasVentas() {
    }

    public ReporteVentaDia calcularReporteVentaDia(){
        calcularVentas();
        calcularIngresos();
        return reporteDia;        
    }
    
    private void calcularVentas(){
        calcularPagosDeContado();
        calcularTotalASaldar();
        calcularVentasNetas();
    }
    
    private void calcularPagosDeContado(){
        double contado=0;
        
        for (int i = 0; i< NUMERO_DE_VENTAS; i++){
            contado += ventas.get(i).getPagoDeContado();            
        }
       
        reporteDia.setPagoContado(contado);
    }
    
    private void calcularTotalASaldar(){
       double totalASaldar=0;
        
        for (int i = 0; i < NUMERO_DE_VENTAS; i++){
            if (!ventas.get(i).isPagado()){
                totalASaldar += ventas.get(i).getMontoTotal(); 
            }           
        }
        
        reporteDia.setTotalASaldar(totalASaldar);
    }
    
    private void calcularVentasNetas(){
        reporteDia.setVentasNetas(reporteDia.getPagoContado() +
                reporteDia.getTotalASaldar());
    }
    
    private void calcularIngresos (){
        sumarAnticipos();
        sumarAbonos();
    }
    
    private void sumarAnticipos(){
        double totalAnticipo = 0;
        for (int i = 0; i< NUMERO_DE_VENTAS; i++){
            totalAnticipo += ventas.get(i).getAnticipo();            
        }
        
        reporteDia.setAnticipos(totalAnticipo);
    }
    
    private void sumarAbonos(){
        double totalAbonos = 0;
        for (int i = 0; i< NUMERO_DE_VENTAS; i++){
            totalAbonos += ventas.get(i).getAnticipo();            
        }
        
        reporteDia.setPagoAbonados(totalAbonos);
    }
    
    
    
}
