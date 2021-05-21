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
public class Estudiante {
    private int llave;
    private int carnet;
    private String nombre;
    private String direccion;

    public Estudiante() {
    }

    
    public Estudiante(int carnet, String nombre, String direccion) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "carné: "+carnet+" nombre: "+nombre+" direccion: "+direccion; //To change body of generated methods, choose Tools | Templates.
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }
    
    
    
}
