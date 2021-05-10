/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.Arrays;

/**
 *
 * @author willi
 */
public class ArbolB {

    NodoArbolB root;
    int t;

    public static void main(String[] args) {
        ArbolB arbol = new ArbolB(3);
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
        arbol.buscarNodoPorClave(100);
        arbol.showBTree();
        arbol.eliminar(101);
        for (int i = 0; i < 10; i++) {
            System.out.println("  ");
        }
        arbol.showBTree();
    }

    //Constructor
    public ArbolB(int t) {
        this.t = t;
        root = new NodoArbolB(t);
    }

    public int buscarClaveMayor() {
        int claveMaxima = getClaveMayor(this.root);

        return claveMaxima;
    }

    private int getClaveMayor(NodoArbolB current) {
        if (current == null) {
            return 0;//Si es cero no existe
        }

        //Mientras no sea una hoja
        while (!current.leaf) {
            //Se accede al hijo mas a la derecha
            current = current.child[current.n];
        }

        return claveMayorPorNodo(current);
    }

    private int claveMayorPorNodo(NodoArbolB current) {
        //Devuelve el valor mayor, el que esta mas a la derecha
        return current.key[current.n - 1];
    }

    public void mostrarClavesNodoMinimo() {
        NodoArbolB temp = buscarNodoMinimo(root);

        if (temp == null) {
            System.out.println("Sin minimo");
        } else {
            temp.imprimir();
        }
    }

    public NodoArbolB buscarNodoMinimo(NodoArbolB nodoActual) {
        if (root == null) {
            return null;
        }

        NodoArbolB aux = root;

        //Mientras no sea una hoja
        while (!aux.leaf) {
            //Se accede al primer hijo
            aux = aux.child[0];
        }

        //Devuelve el nodo menor, el que esta mas a la izquierda
        return aux;
    }

    //Busca el valor ingresado y muestra el contenido del nodo que contiene el valor
    public void buscarNodoPorClave(int num) {
        NodoArbolB temp = search(root, num);

        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            print(temp);
        }
    }

    //Search
    private NodoArbolB search(NodoArbolB actual, int key) {
        int i = 0;//se empieza a buscar siempre en la primera posicion

        //Incrementa el indice mientras el valor de la clave del nodo sea menor
        while (i < actual.n && key > actual.key[i]) {
            i++;
        }

        //Si la clave es igual, entonces retornamos el nodo
        if (i < actual.n && key == actual.key[i]) {
            return actual;
        }

        //Si llegamos hasta aqui, entonces hay que buscar los hijos
        //Se revisa primero si tiene hijos
        if (actual.leaf) {
            return null;
        } else {
            //Si tiene hijos, hace una llamada recursiva
            return search(actual.child[i], key);
        }
    }

    public NodoArbolB buscar_clave(NodoArbolB actual, int llave) {
        int i = 1;
        while ((i <= actual.getN()) && (llave > actual.getKey()[i - 1])) {
            i++;
        }

        if ((i <= actual.getN()) && (llave == actual.getKey()[i - 1])) {
            return actual;
        }

        if (actual.isLeaf()) {
            return null;
        } else {
            return buscar_clave(actual.getChild()[i - 1], llave);
        }
    }

    public void eliminar(int key) {
        if (buscar_clave(this.root, key) != null) {
            NodoArbolB encontrado = buscar_clave(this.root, key);
            int i = 1;

            while (encontrado.getKey()[i - 1] < key) {
                i++;
            }
            if (encontrado.isLeaf()) {
                for (int j = i + 1; j <= encontrado.getN(); j++) {
                    encontrado.getKey()[j - 2] = encontrado.getKey()[j - 1];
                }
                encontrado.setN(encontrado.getN() - 1);
                if (encontrado != this.root) {
                    System.out.println("entra a raiz");
                    balancear_hoja(encontrado);
                }
            } else {
                NodoArbolB padre = anterior(this.root, key);
                int y = padre.getKey()[padre.getN() - 1];
                padre.setN(padre.getN() - 1);
                encontrado.getKey()[i - 1] = y;
                System.out.println("balancea 2");
                balancear_hoja(padre);
            }
        }
    }

    private NodoArbolB anterior(NodoArbolB N, int k) {
        int i = 1;
        while (i <= N.getN() && N.getKey()[i - 1] < k) {
            i++;
        }
        System.out.println(Arrays.toString(N.getKey()));
        if (N.isLeaf()) {
            return N;
        } else {
            return anterior(N.getChild()[i - 1], k);
        }
    }

    private NodoArbolB getPadre(NodoArbolB T, NodoArbolB N) {
        if (this.root == N) {
            return null;
        }
        for (int j = 0; j <= T.getN(); j++) {
            if (T.getChild()[j] == N) {
                return T;
            }
            if (T.getChild()[j] != null) {
                if (!T.getChild()[j].isLeaf()) {
                    NodoArbolB X = getPadre(T.getChild()[j], N);
                    if (X != null) {
                        return X;
                    }
                }
            } else {
                System.out.println("El arbol hasta este punto está");
                showBTree();
            }
        }
        return null;
    }

    private void balancear_hoja(NodoArbolB desbalanceado) {
        if (desbalanceado.getN() < (t - 1)) {
            System.out.println("antes de balancear");
            showBTree();
            NodoArbolB padre = getPadre(root, desbalanceado);
            int j = 1;
            while (padre.getChild()[j - 1] != desbalanceado) {
                j++;
            }

            if (j == 1 || (padre.getChild()[j - 2].getN() == (t - 1))) {
                if (j == padre.getN() + 1 || padre.getChild()[j].getN() == (t - 1)) {
                    System.out.println("disminuido");
                    disminuir_altura(desbalanceado);
                } else {
                    System.out.println("balanceo izquierda");
                    balancear_izquierda(padre, j - 1, padre.getChild()[j], desbalanceado);
                }
            } else {
                System.out.println("balanceo derecha");
                balancear_derecha(padre, j - 2, padre.getChild()[j - 2], desbalanceado);
            }
        }
    }

    private void disminuir_altura(NodoArbolB seleccionado) {
        int j;
        NodoArbolB nuevo = new NodoArbolB(t);
        if (seleccionado != null) {
            if (seleccionado == this.root) {
                if (seleccionado.getN() == 0) {
                    this.root = seleccionado.getChild()[0];
                    seleccionado.getChild()[0] = null;
                }
            } else {
                if (seleccionado.getN() < t) {
                    nuevo = getPadre(root, seleccionado);
                    j = 1;

                    while (nuevo.getChild()[j - 1] != seleccionado) {
                        j++;
                    }

                    if (j > 1) {
                        System.out.println(j);
                        nuevo.imprimir();
                        juntar_nodos(getPadre(root, seleccionado), j - 1);
                        showBTree();
                        for (int i = 0; i < 3; i++) {
                            System.out.println(j);
                        }
                    } else {
                        System.out.println(j);
                        nuevo.imprimir();
                        juntar_nodos(getPadre(root, seleccionado), j);
                        showBTree();
                        for (int i = 0; i < 3; i++) {
                            System.out.println(j);
                        }
                    }
                    disminuir_altura(getPadre(root, seleccionado));
                }
            }
        }
    }

    private void balancear_derecha(NodoArbolB padre, int e, NodoArbolB izquierda, NodoArbolB derecha) {
        for (int i = 0; i < derecha.getN(); i++) {
            derecha.getKey()[i + 1] = derecha.getKey()[i];
        }

        if (!derecha.isLeaf()) {
            for (int i = 0; i < derecha.getN(); i++) {
                derecha.getChild()[i + 1] = derecha.getChild()[i];
            }
        }
        derecha.setN(derecha.getN() + 1);
        derecha.getKey()[0] = padre.getKey()[e];
        padre.getKey()[e] = izquierda.getKey()[izquierda.getN() - 1];
        derecha.getChild()[0] = izquierda.getChild()[izquierda.getN()];
        izquierda.setN(izquierda.getN() - 1);
        System.out.println("balanceo derecha");
    }

    private void balancear_izquierda(NodoArbolB padre, int e, NodoArbolB derecha, NodoArbolB izquierda) {
        izquierda.setN(izquierda.getN() + 1);
        izquierda.getKey()[izquierda.getN() - 1] = padre.getKey()[e];
        padre.getKey()[e] = derecha.getKey()[0];
        izquierda.getChild()[izquierda.getN()] = derecha.getChild()[0];

        for (int j = 1; j < derecha.getN(); j++) {
            derecha.getKey()[j - 1] = derecha.getKey()[j];
        }

        if (!derecha.isLeaf()) {
            for (int i = 1; i < derecha.getN(); i++) {
                derecha.getChild()[i - 1] = derecha.getChild()[i];
            }
        }

        derecha.setN(derecha.getN() - 1);
        System.out.println("balanceo izquierda");
    }

    private void juntar_nodos(NodoArbolB X, int i) {
        NodoArbolB Y = X.getChild()[i - 1];
        NodoArbolB Z = X.getChild()[i];

        int k = Y.getN();
        Y.getKey()[k] = X.getKey()[i - 1];

        for (int j = 1; j <= Z.getN(); j++) {
            Y.getKey()[j + k] = Z.getKey()[j - 1];
        }

        if (!Z.isLeaf()) {
            for (int j = 1; j <= Z.getN()+1; j++) {
                Y.getChild()[j + k] = Z.getChild()[j-1];
                System.out.println("loop");
                Z.getChild()[j-1].imprimir();
            }
        }
        Y.setN(Y.getN() + Z.getN() + 1);
        System.out.println("probando");
        print(Y);
        System.out.println("fin de prueba");
        X.getChild()[i] = null;
        for (int j = i; j <= X.getN() - 1; j++) {
            X.getKey()[j - 1] = X.getKey()[j];
            X.getChild()[j] = X.getChild()[j + 1];
        }
        X.setN(X.getN() - 1);
        System.out.println("imprimiendo X");
        X.imprimir();
        print(X);
        System.out.println("imprimiendo Y");
        Y.imprimir();
        print(Y);
        System.out.println("dejando de imprimir");
    }

    public void insertar(int key) {
        NodoArbolB r = root;

        //Si el nodo esta lleno lo debe separar antes de insertar
        if (r.n == ((2 * t) - 1)) {
            NodoArbolB s = new NodoArbolB(t);
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split(s, 0, r);
            nonFullInsert(s, key);
        } else {
            nonFullInsert(r, key);
            NodoArbolB e = search(r, key);
            if (e.n == (2 * t) - 1 && e == root) {
                NodoArbolB s = new NodoArbolB(t);
                root = s;
                s.leaf = false;
                s.n = 0;
                s.child[0] = e;
                split(s, 0, e);
            } else {
                if (e.n == (2 * t - 1)) {
                    NodoArbolB p = e.getPadre();
                    int j = 0;
                    //Busca la posicion del hijo
                    while (j < p.n && e.key[t] > p.key[j]) {
                        j++;
                    }
                    split(p, j, e);
                }
            }
        }
    }

    // Caso cuando la raiz se divide
    // x =          | | | | | |
    //             /
    //      |10|20|30|40|50|
    // i = 0
    // y = |10|20|30|40|50|
    private void split(NodoArbolB x, int i, NodoArbolB y) {
        //Nodo temporal que sera el hijo i + 1 de x
        NodoArbolB z = new NodoArbolB(t);
        z.leaf = y.leaf;
        z.n = (t - 1);

        //Copia las ultimas (t - 1) claves del nodo y al inicio del nodo z      // z = |40|50| | | |
        for (int j = 0; j < (t - 1); j++) {
            z.key[j] = y.key[(j + t)];
        }

        //Si no es hoja hay que reasignar los nodos hijos
        if (!y.leaf) {
            for (int k = 0; k < t; k++) {
                z.child[k] = y.child[(k + t)];
            }
        }

        //nuevo tamanio de y                                                    // x =            | | | | | |
        y.n = (t - 1);                                                          //               /   \
        //  |10|20| | | |
        //Mueve los hijos de x para darle espacio a z
        for (int j = x.n; j > i; j--) {
            x.child[(j + 1)] = x.child[j];
        }
        //Reasigna el hijo (i+1) de x                                           // x =            | | | | | |
        x.child[(i + 1)] = z;                                                   //               /   \
        //  |10|20| | | |     |40|50| | | |
        //Mueve las claves de x
        for (int j = x.n; j > i; j--) {
            x.key[(j + 1)] = x.key[j];
        }

        //Agrega la clave situada en la mediana                                 // x =            |30| | | | |
        x.key[i] = y.key[(t - 1)];                                              //               /    \
        x.n++;                                                                  //  |10|20| | | |      |40|50| | | |
        if (x == root) {
            x.setPadre(null);
        }
        z.setPadre(x);
        y.setPadre(x);
        if (x.getPadre() == null && x.n == (2 * t - 1)) {
            NodoArbolB s = new NodoArbolB(t);
            NodoArbolB r = root;
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split(s, 0, r);
        } else {
            if (x.n == (2 * t - 1)) {
                NodoArbolB p = x.getPadre();
                int j = 0;
                //Busca la posicion del hijo
                while (j < p.n && x.key[t] > p.key[j]) {
                    j++;
                }
                split(p, j, x);
            }
        }
    }

    private void nonFullInsert(NodoArbolB x, int key) {
        //Si es una hoja
        if (x.leaf) {
            int i = x.n; //cantidad de valores del nodo
            //busca la posicion i donde asignar el valor
            while (i >= 1 && key < x.key[i - 1]) {
                x.key[i] = x.key[i - 1];//Desplaza los valores mayores a key
                i--;
            }
            x.key[i] = key;//asigna el valor al nodo
            x.n++; //aumenta la cantidad de elementos del nodo
        } else {
            int j = 0;
            //Busca la posicion del hijo
            while (j < x.n && key > x.key[j]) {
                j++;
            }

            //Si el nodo hijo esta lleno lo separa
            if (x.child[j].n == (2 * t - 1)) {
                split(x, j, x.child[j]);
                if (key > x.key[j]) {
                    j++;
                }
            }
            //System.out.println("insertar llave " + key + " en " + Arrays.toString(x.key));
            nonFullInsert(x.child[j], key);
        }
    }

    public void showBTree() {
        print(root);
    }

    //Print en preorder
    private void print(NodoArbolB n) {
        n.imprimir();
        System.out.println("");
        //System.out.println(Arrays.toString(n.getKey()));
        //System.out.println("node0[label =" + n.graphviz() + "];");

        //Si no es hoja
        if (!n.leaf) {
            //System.out.println("");
            //recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
                if (n.child[j] != null) {
                    print(n.child[j]);
                }
            }
        }
    }

    public class NodoArbolB<T> {

        int n; //numero de claves almacenadas en el nodo
        boolean leaf; //Si el nodo es hoja (nodo hoja=true; nodo interno=false)
        int key[];  //almacena las claves en el nodo
        NodoArbolB child[]; //arreglo con referencias a los hijos
        NodoArbolB padre;
        T data;

        //Constructores
        public NodoArbolB(int t, T data) {
            n = 0;
            leaf = true;
            key = new int[((2 * t) - 1)];
            child = new NodoArbolB[(2 * t)];
            this.data = data;
            this.padre = null;
        }

        public NodoArbolB(int t) {
            n = 0;
            leaf = true;
            key = new int[((2 * t) - 1)];
            child = new NodoArbolB[(2 * t)];
        }

        public void imprimir() {
            System.out.print("[");
            for (int i = 0; i < n; i++) {
                if (i < n - 1) {
                    System.out.print(key[i] + " | ");
                } else {
                    System.out.print(key[i]);
                }
            }
            System.out.print("]");
        }

        public String graphviz() {
            String retorno = "";
            retorno += "\"";
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    retorno += " | ";
                }
                retorno += "<f" + i + ">";
                if (i < n - 1) {
                    retorno += "| " + key[i];
                } else {
                    retorno += "| " + key[i] + " |<f" + (n + 1) + ">";
                }
            }
            retorno += "\"";
            return retorno;
        }

        public int find(int k) {
            for (int i = 0; i < n; i++) {
                if (key[i] == k) {
                    return i;
                }
            }
            return -1;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public boolean isLeaf() {
            return leaf;
        }

        public void setLeaf(boolean leaf) {
            this.leaf = leaf;
        }

        public int[] getKey() {
            return key;
        }

        public void setKey(int[] key) {
            this.key = key;
        }

        public NodoArbolB[] getChild() {
            return child;
        }

        public void setChild(NodoArbolB[] child) {
            this.child = child;
        }

        public NodoArbolB getPadre() {
            return padre;
        }

        public void setPadre(NodoArbolB padre) {
            this.padre = padre;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }
}
