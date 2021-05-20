/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

/**
 *
 * @author willi
 */
public class Asignacion {
    private int asignacion;
    private Estudiante estudiante;
    private Horario codigo;
    private int zona;
    private int punteo_final;

    public Asignacion(int asignacion, Estudiante estudiante, Horario codigo, int zona, int punteo_final) {
        this.asignacion = asignacion;
        this.estudiante = estudiante;
        this.codigo = codigo;
        this.zona = zona;
        this.punteo_final = punteo_final;
    }

    public int getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(int asignacion) {
        this.asignacion = asignacion;
    }

    

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Horario getCodigo() {
        return codigo;
    }

    public void setCodigo(Horario codigo) {
        this.codigo = codigo;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getPunteo_final() {
        return punteo_final;
    }

    public void setPunteo_final(int punteo_final) {
        this.punteo_final = punteo_final;
    }
    
    
}
