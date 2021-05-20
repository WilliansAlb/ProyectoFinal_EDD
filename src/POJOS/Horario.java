/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import Estructuras.Circular;

/**
 *
 * @author willi
 */
public class Horario {
    private int codigo;
    private String rango;
    private String dia;
    private Curso curso;
    private Edificio edificio;
    private Salon salon;
    private Catedratico catedratico;
    private Circular asignaciones;

    public Horario(int codigo, String rango, String dia, Curso curso, Salon salon, Edificio edificio, Catedratico catedratico) {
        this.codigo = codigo;
        this.rango = rango;
        this.dia = dia;
        this.curso = curso;
        this.edificio = edificio;
        this.salon = salon;
        this.catedratico = catedratico;
        this.asignaciones = new Circular();
    }

    
    
    public Horario(int codigo, String rango, String dia, Curso curso, Salon salon, Edificio edificio, Catedratico catedratico, Circular asignaciones) {
        this.codigo = codigo;
        this.rango = rango;
        this.dia = dia;
        this.curso = curso;
        this.edificio = edificio;
        this.salon = salon;
        this.catedratico = catedratico;
        this.asignaciones = asignaciones;
    }

    public Horario() {
        
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Catedratico getCatedratico() {
        return catedratico;
    }

    public void setCatedratico(Catedratico catedratico) {
        this.catedratico = catedratico;
    }

    public Circular getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(Circular asignaciones) {
        this.asignaciones = asignaciones;
    }
    
    @Override
    public String toString(){
        return codigo+"\\n"+rango+"\\n"+dia+"\\n"+curso.getCodigo()+"\\n"+edificio.getNombre()+"\\n"+salon.getNumero()+"\\n"+catedratico.getNombre();
    }
}
