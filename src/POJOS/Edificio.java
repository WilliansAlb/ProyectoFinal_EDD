/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import Estructuras.SimpleEnlazada;

/**
 *
 * @author willi
 */
public class Edificio {
    private int id;
    private String nombre;
    private SimpleEnlazada salones;

    public Edificio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.salones = new SimpleEnlazada();
    }
    
    public Edificio(int id, String nombre, SimpleEnlazada edificios) {
        this.id = id;
        this.nombre = nombre;
        this.salones = edificios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public SimpleEnlazada getSalones() {
        return salones;
    }

    public void setSalones(SimpleEnlazada salones) {
        this.salones = salones;
    }
    
    
}
