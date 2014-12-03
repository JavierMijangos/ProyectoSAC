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
public class Paciente {
    
    private int edad;
    private String oficio;
    private boolean usaLentesContacto;
    private boolean sufreDiabetes;
    private boolean sufrePrecion;

    public Paciente() {
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the oficio
     */
    public String getOficio() {
        return oficio;
    }

    /**
     * @param oficio the oficio to set
     */
    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    /**
     * @return the usaLentesContacto
     */
    public boolean isUsaLentesContacto() {
        return usaLentesContacto;
    }

    /**
     * @param usaLentesContacto the usaLentesContacto to set
     */
    public void setUsaLentesContacto(boolean usaLentesContacto) {
        this.usaLentesContacto = usaLentesContacto;
    }

    /**
     * @return the sufreDiabetes
     */
    public boolean isSufreDiabetes() {
        return sufreDiabetes;
    }

    /**
     * @param sufreDiabetes the sufreDiabetes to set
     */
    public void setSufreDiabetes(boolean sufreDiabetes) {
        this.sufreDiabetes = sufreDiabetes;
    }

    /**
     * @return the sufrePrecion
     */
    public boolean isSufrePrecion() {
        return sufrePrecion;
    }

    /**
     * @param sufrePrecion the sufrePrecion to set
     */
    public void setSufrePrecion(boolean sufrePrecion) {
        this.sufrePrecion = sufrePrecion;
    }
    
    
    
}
