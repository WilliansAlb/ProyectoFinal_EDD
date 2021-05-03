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
    private SimpleEnlazada edificios;

    public Edificio(int id, String nombre, SimpleEnlazada edificios) {
        this.id = id;
        this.nombre = nombre;
        this.edificios = edificios;
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

    public SimpleEnlazada getEdificios() {
        return edificios;
    }

    public void setEdificios(SimpleEnlazada edificios) {
        this.edificios = edificios;
    }
    
    
}
