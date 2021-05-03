/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Estructuras.AVL;
import Estructuras.Circular;
import Estructuras.Hash;
import Estructuras.SimpleEnlazada;
import POJOS.Catedratico;
import POJOS.Estudiante;
import POJOS.Usuario;
import java.util.Scanner;

/**
 *
 * @author willi
 */
public class Tests {

    public Tests() {

    }

    public void probar_circular() {
        Circular lista = new Circular();
        int contador = 0;
        while (contador < 11) {
            System.out.println("Ingresa los datos del usuario (id-nombre-contraseña-tipo)");
            Scanner s = new Scanner(System.in);
            String ingreso = s.next();
            String[] datos = ingreso.split("-");
            int id = Integer.parseInt(datos[0]);
            Usuario nuevo = new Usuario(id, datos[1], datos[2], datos[3].equalsIgnoreCase("colaborador"));
            lista.agregar_nodo(nuevo, id);
            System.out.println(contador);
            lista.imprimir();
            contador++;
        }
    }

    public void probar_AVL() {
        AVL lista = new AVL();
        int contador = 0;
        while (contador < 5) {
            System.out.println("Ingresa los datos del usuario (numero-nombre-direccion)");
            Scanner s = new Scanner(System.in);
            String ingreso = s.next();
            String[] datos = ingreso.split("-");
            int id = Integer.parseInt(datos[0]);
            Catedratico nuevo = new Catedratico(id, datos[1], datos[2]);
            lista.insertar(nuevo, id);
            System.out.println(contador);
            contador++;
        }
        lista.crear_doc();
    }

    public void probar_hash() {
        Hash tabla = new Hash();
        tabla.rellenar();
        tabla.imprimir();
        tabla.insertar(201830221, new Estudiante(201830221, "Willians", "San Lorenzo"));
        tabla.insertar(201830258, new Estudiante(201830258, "Conflicto", "San Lorenzo"));
        tabla.insertar(201830322, new Estudiante(201830322, "Alberto", "San Lorenzo"));
        tabla.insertar(201830521, new Estudiante(201830521, "Orozco", "San Lorenzo"));
        tabla.insertar(201830921, new Estudiante(201830921, "Lopez", "San Lorenzo"));
        tabla.insertar(201830222, new Estudiante(201830222, "Marco", "San Lorenzo"));
        tabla.insertar(201831221, new Estudiante(201831221, "Polo", "San Lorenzo"));
        tabla.insertar(201930221, new Estudiante(201930221, "Fernandez", "San Lorenzo"));
        tabla.insertar(200830221, new Estudiante(200830221, "Lesly", "San Lorenzo"));
        tabla.insertar(211830221, new Estudiante(211830221, "Aguilar", "San Lorenzo"));
        System.out.println(tabla.getOcupadas());
        tabla.imprimir2();
    }
    
    public void probar_lista(){
        SimpleEnlazada lista = new SimpleEnlazada();
        lista.ingresar(201830221, new Estudiante(201830221, "Willians", "San Lorenzo"));
        lista.ingresar(201830258, new Estudiante(201830258, "Conflicto", "San Lorenzo"));
        lista.ingresar(201830322, new Estudiante(201830322, "Alberto", "San Lorenzo"));
        lista.ingresar(201830521, new Estudiante(201830521, "Orozco", "San Lorenzo"));
        lista.imprimir();
        lista.ingresar(201830921, new Estudiante(201830921, "Lopez", "San Lorenzo"));
        lista.ingresar(201830222, new Estudiante(201830222, "Marco", "San Lorenzo"));
        lista.ingresar(201831221, new Estudiante(201831221, "Polo", "San Lorenzo"));
        lista.imprimir();
        lista.ingresar(201930221, new Estudiante(201930221, "Fernandez", "San Lorenzo"));
        lista.ingresar(200830221, new Estudiante(200830221, "Lesly", "San Lorenzo"));
        lista.ingresar(211830221, new Estudiante(211830221, "Aguilar", "San Lorenzo"));
        lista.imprimir();
        lista.eliminar(211830221);
        lista.imprimir();
        Estudiante will = (Estudiante)lista.obtener(201830221);
        will.setNombre("Willians Alberto Orozco López");
        will.setDireccion("San Lorenzo Suchitepequez");
        lista.modificar(201830221, will);
        lista.imprimir();
    }
}
