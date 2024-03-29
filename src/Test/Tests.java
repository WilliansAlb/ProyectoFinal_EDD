/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Estructuras.AVL;
import Estructuras.B;
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
        Circular circular = new Circular();
        circular.insertar2(201930221, new Estudiante(201930221, "Willians", "San Lorenzo"));
        circular.insertar2(201830258, new Estudiante(201830258, "Conflicto", "San Lorenzo"));
        circular.insertar2(201030322, new Estudiante(201030322, "Alberto", "San Lorenzo"));
        circular.insertar2(201830521, new Estudiante(201830521, "Orozco", "San Lorenzo"));
        circular.insertar2(21, new Estudiante(21, "Orozco", "San Lorenzo"));
        circular.insertar2(202330521, new Estudiante(202330521, "Orozco", "San Lorenzo"));
        //circular.imprimir();
        circular.imprimir();
        circular.eliminar(201930221);
        System.out.println("\n\n\n---------------------------------------------------------\n\n");
        circular.imprimir();
        //System.out.println(circular.documento());
    }
    
    public void probando_B(){
        B arbol = new B(3);
        arbol.insertar(10);
        arbol.insertar(15);
        arbol.insertar(1);
        arbol.insertar(2);
        arbol.insertar(5);
        arbol.insertar(4);
        arbol.insertar(9);
        arbol.insertar(20);
        arbol.insertar(3);
        arbol.insertar(18);
        arbol.insertar(19);
        arbol.insertar(13);
        arbol.insertar(27);
        arbol.insertar(25);
        arbol.insertar(48);
        arbol.insertar(50);
        arbol.insertar(55);
        arbol.insertar(70);
        arbol.insertar(85);
        arbol.insertar(90);
        arbol.insertar(92);
        arbol.insertar(95);
        arbol.insertar(100);
        arbol.insertar(101);
        arbol.insertar(102);
        arbol.insertar(103);
        arbol.insertar(104);
        arbol.insertar(105);
        arbol.insertar(106);
        arbol.insertar(107);
        arbol.buscar_nodo_por_clave(100);
        arbol.mostrar_arbol();
        arbol.eliminar(101);
        for (int i = 0; i < 10; i++) {
            System.out.println("  ");
        }
        arbol.mostrar_arbol();
    }
    
    public void probar_AVL(){
        AVL arbol = new AVL();
        arbol.insertar(201830221, new Estudiante(201830221, "Willians", "San Lorenzo"));
        arbol.insertar(201830258, new Estudiante(201830258, "Conflicto", "San Lorenzo"));
        arbol.insertar(201830322, new Estudiante(201830322, "Alberto", "San Lorenzo"));
        arbol.insertar(201830521, new Estudiante(201830521, "Orozco", "San Lorenzo"));
        arbol.insertar(201830921, new Estudiante(201830921, "Lopez", "San Lorenzo"));
        arbol.insertar(201830222, new Estudiante(201830222, "Marco", "San Lorenzo"));
        arbol.insertar(201831221, new Estudiante(201831221, "Polo", "San Lorenzo"));
        arbol.insertar(201930221, new Estudiante(201930221, "Fernandez", "San Lorenzo"));
        arbol.insertar(200830221, new Estudiante(200830221, "Lesly", "San Lorenzo"));
        arbol.insertar(211830221, new Estudiante(211830221, "Aguilar", "San Lorenzo"));
        //arbol.crear_doc();
        arbol.eliminar(201830258);
        System.out.println("\n\n\n---------------------------------------------------------\n\n");
        //arbol.crear_doc();
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
