/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Test.Tests;
import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author willi
 */
public class B {

    private NodoB raiz;
    private int orden;
    private int elementos;

     public static void main(String[] args) {
        B arbol = new B(5);
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
        for (int i = 0; i < 10; i++) {
            System.out.println("  ");
        }
        arbol.buscar(arbol.getRaiz(), 10);
        for (int i = 0; i < 10; i++) {
            System.out.println("  ");
        }
        arbol.buscar(arbol.getRaiz(), 3);
        for (int i = 0; i < 10; i++) {
            System.out.println("  ");
        }
        arbol.buscar(arbol.getRaiz(), 19);
        for (int i = 0; i < 10; i++) {
            System.out.println("  ");
        }
        arbol.buscar(arbol.getRaiz(), 48);
    }
    public B(int n) {
        this.raiz = new NodoB(n);
        this.orden = n;
        this.elementos = 0;
    }

    public void insertar(int id) {
        if (buscar(raiz, id) == null) {
            if (raiz.getN() == 0) {
                raiz.getClave()[0] = id;
                raiz.setN(raiz.getN()+1);
            } else {
                NodoB temp = raiz;
                if (temp.getN() == orden) {
                    NodoB nuevo = new NodoB(orden);
                    raiz = nuevo;
                    nuevo.setHoja(false);
                    nuevo.setN(0);
                    nuevo.getHijo()[0] = temp;
                    dividir(nuevo, 0, temp);
                    insertarB(nuevo, id);
                    System.out.println(Arrays.toString(nuevo.getClave())+" clave: "+id);
                } else {
                    insertarB(temp, id);
                    System.out.println(Arrays.toString(temp.getClave())+" clave: "+id);
                }
            }
            elementos++;
        }
    }

    public void dividir(NodoB nuevo, int id, NodoB antiguo) {
        System.out.println("dividiendo por "+id);
        int t = (int) Math.floor((orden - 1) / 2);
        
        NodoB temp = new NodoB(orden);
        temp.setHoja(antiguo.isHoja());
        temp.setN(t);
        
        for (int i = 0; i < t; i++) {
            if ((orden) % 2 == 0) {
                temp.getClave()[i] = antiguo.getClave()[i + t];
                antiguo.getClave()[i+t] = -1;
                System.out.println("entra acá");
            } else {
                temp.getClave()[i] = antiguo.getClave()[i + t + 1];
                antiguo.getClave()[i+t+1] = -1;
            }
            antiguo.setN(antiguo.getN() - 1);
        }
        if (!antiguo.isHoja()) {
            for (int i = 0; i < t; i++) {
                if ((orden) % 2 == 0) {
                    temp.getHijo()[i] = antiguo.getHijo()[i + t];
                } else {
                    temp.getHijo()[i] = antiguo.getHijo()[i + t + 1];
                }
            }
        }

        antiguo.setN(t);
        System.out.println(t);
        System.out.println(Arrays.toString(antiguo.getClave())+" este es el nodo de la antiguo finalmente que se forma al intentar dividir por el nodo y "+id);
        for (int j = nuevo.getN(); j > id; j--) {
            nuevo.getClave()[j+1] = nuevo.getClave()[j];
        }
        
        nuevo.getHijo()[id+1] = temp;
        
        for (int j = nuevo.getN(); j > id; j--) {
            nuevo.getClave()[j+1] = nuevo.getClave()[j];
        }

        if ((orden) % 2 == 0) {
            nuevo.getClave()[id] = antiguo.getClave()[t - 1];
            antiguo.getClave()[t-1] = -1;
        } else {
            nuevo.getClave()[id] = antiguo.getClave()[t];
            antiguo.getClave()[t] = -1;
        }
        nuevo.setN(nuevo.getN() + 1);
        System.out.println(Arrays.toString(temp.getClave())+" este es el nodo de la izquierda que se forma al intentar dividir por el nodo z "+id);
        System.out.println(Arrays.toString(nuevo.getClave())+" este es el nodo de la izquierda que se forma al intentar dividir por el nodo x "+id);
        System.out.println(Arrays.toString(antiguo.getClave())+" este es el nodo de la izquierda que se forma al intentar dividir por el nodo y "+id);
    }

    public void insertarB(NodoB nuevo, int id) {
        if (nuevo.isHoja()) {
            int i = nuevo.getN();
            System.out.println(i);
            while (i >= 1 && id < nuevo.getClave()[i-1]) {
                nuevo.getClave()[i] = nuevo.getClave()[i-1];
                i--;
            }
            System.out.println(Arrays.toString(nuevo.getClave())+" sin insertar");
            nuevo.getClave()[i] = id;
            nuevo.setN(nuevo.getN() + 1);
            System.out.println(Arrays.toString(nuevo.getClave())+" ya insertado queda");
        } else {
            int i = 0;
            while (i < nuevo.getN() && id > nuevo.getClave()[i]) {
                i++;
            }
            if ((nuevo.getHijo()[i]).getN() == orden) {
                System.out.println(Arrays.toString(nuevo.getHijo()[i].getClave()));
                dividir(nuevo, i, nuevo.getHijo()[i]);
                if (id > nuevo.getClave()[i]) {
                    i++;
                }
            }
            
            System.out.println(Arrays.toString(nuevo.getHijo()[i].getClave())+" clave: "+id);
            insertarB(nuevo.getHijo()[i], id);
        }
    }

    public NodoB buscar(NodoB temp, int id) {
        int i = 1;
        System.out.println(Arrays.toString(temp.getClave()));
        while ((i <= temp.getN()) && (id > temp.getClave()[i-1])) {
            i++;
        }

        if ((i <= temp.getN()) && (id == temp.getClave()[i - 1])) {
            return temp;
        }

        if (temp.isHoja()) {
            return null;
        } else {
            return (buscar(temp.getHijo()[i - 1], id));
        }
    }

    public NodoB getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoB raiz) {
        this.raiz = raiz;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getElementos() {
        return elementos;
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

    public class NodoB {

        private int[] clave;
        private NodoB[] hijo;
        private boolean hoja;
        private int x;
        private int y;
        private int n;
        private int altura;
        final int DIFERENCIA_ALTURA = 30;
        final int DIFERENCIA_HERMANOS = 5;

        public NodoB(int n) {
            this.clave = new int[n];
            for (int i = 0; i < n; i++) {
                this.clave[i] = -1;
            }
            this.hijo = new NodoB[n];
            for (int i = 0; i < n; i++) {
                this.hijo[i] = null;
            }
            this.hoja = true;
            this.n = 0;
        }

        public int[] getClave() {
            return clave;
        }

        public void setClave(int[] clave) {
            this.clave = clave;
        }

        public NodoB[] getHijo() {
            return hijo;
        }

        public void setHijo(NodoB[] hijo) {
            this.hijo = hijo;
        }
        
        

        public boolean isHoja() {
            return hoja;
        }

        public void setHoja(boolean hoja) {
            this.hoja = hoja;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }

    }
}
