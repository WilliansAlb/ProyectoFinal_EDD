/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import POJOS.Curso;
import POJOS.Horario;
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class B {

    NodoB raiz;
    int t;
    public final String INICIO_GRAPH = "digraph G{\n" + "nodesep=1;\nrankdir=TB;\nnode[shape=record,width = 1, height = 1];\n";
    public final String INICIO_GRAPH2 = "digraph G{\n" + "nodesep=1;\ncompound=true;\nrankdir=TB;\nnode[shape=record,width = 1, height = 1];\n";

    //Constructor
    public B(int t) {
        this.t = t;
        raiz = new NodoB(t);
    }

    public int buscar_clave_mayor() {
        int clave_maxima = obtener_clave_mayor(this.raiz);

        return clave_maxima;
    }

    private int obtener_clave_mayor(NodoB actual) {
        if (actual == null) {
            return 0;//Si es cero no existe
        }

        //Mientras no sea una hoja
        while (!actual.hoja) {
            //Se accede al hijo mas a la derecha
            actual = actual.hijos[actual.n];
        }

        return clave_mayor_por_nodo(actual);
    }

    private int clave_mayor_por_nodo(NodoB actual) {
        //Devuelve el valor mayor, el que esta mas a la derecha
        return actual.llaves[actual.n - 1];
    }

    public void mostrar_claves_nodo_minimo() {
        NodoB temp = buscar_nodo_minimo(raiz);

        if (temp == null) {
            System.out.println("Sin minimo");
        } else {
            temp.imprimir();
        }
    }

    public NodoB buscar_nodo_minimo(NodoB nodoActual) {
        if (raiz == null) {
            return null;
        }

        NodoB aux = raiz;

        //Mientras no sea una hoja
        while (!aux.hoja) {
            //Se accede al primer hijo
            aux = aux.hijos[0];
        }

        //Devuelve el nodo menor, el que esta mas a la izquierda
        return aux;
    }

    //Busca el valor ingresado y muestra el contenido del nodo que contiene el valor
    public void buscar_nodo_por_clave(int llave) {
        NodoB temp = buscar(raiz, llave);

        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            print(temp);
        }
    }

    public Horario obtener(int llave) {
        NodoB temp = buscar(raiz, llave);

        if (temp == null) {
            return null;
        } else {
            int lugar = temp.find(llave);
            return temp.getData()[lugar];
        }
    }

    //Search
    private NodoB buscar(NodoB actual, int llave) {
        int i = 0;//se empieza a buscar siempre en la primera posicion

        //Incrementa el indice mientras el valor de la clave del nodo sea menor
        while (i < actual.n && llave > actual.llaves[i]) {
            i++;
        }

        //Si la clave es igual, entonces retornamos el nodo
        if (i < actual.n && llave == actual.llaves[i]) {
            return actual;
        }

        //Si llegamos hasta aqui, entonces hay que buscar los hijos
        //Se revisa primero si tiene hijos
        if (actual.hoja) {
            return null;
        } else {
            //Si tiene hijos, hace una llamada recursiva
            return buscar(actual.hijos[i], llave);
        }
    }

    public NodoB buscar_clave(NodoB actual, int llave) {
        int i = 1;
        while ((i <= actual.getN()) && (llave > actual.getLlaves()[i - 1])) {
            i++;
        }

        if ((i <= actual.getN()) && (llave == actual.getLlaves()[i - 1])) {
            return actual;
        }

        if (actual.isHoja()) {
            return null;
        } else {
            return buscar_clave(actual.getHijos()[i - 1], llave);
        }
    }

    public void eliminar(int llave) {
        if (buscar_clave(this.raiz, llave) != null) {
            NodoB encontrado = buscar_clave(this.raiz, llave);
            int i = 1;

            while (encontrado.getLlaves()[i - 1] < llave) {
                i++;
            }
            if (encontrado.isHoja()) {
                for (int j = i + 1; j <= encontrado.getN(); j++) {
                    encontrado.getLlaves()[j - 2] = encontrado.getLlaves()[j - 1];
                }
                encontrado.setN(encontrado.getN() - 1);
                if (encontrado != this.raiz) {
                    System.out.println("entra a raiz");
                    balancear_hoja(encontrado);
                }
            } else {
                NodoB padre = anterior(this.raiz, llave);
                int y = padre.getLlaves()[padre.getN() - 1];
                padre.setN(padre.getN() - 1);
                encontrado.getLlaves()[i - 1] = y;
                System.out.println("balancea 2");
                balancear_hoja(padre);
            }
        }
    }

    private NodoB anterior(NodoB N, int llave) {
        int i = 1;
        while (i <= N.getN() && N.getLlaves()[i - 1] < llave) {
            i++;
        }
        if (N.isHoja()) {
            return N;
        } else {
            return anterior(N.getHijos()[i - 1], llave);
        }
    }

    private NodoB obtener_padre(NodoB T, NodoB N) {
        if (this.raiz == N) {
            return null;
        }
        for (int j = 0; j <= T.getN(); j++) {
            if (T.getHijos()[j] == N) {
                return T;
            }
            if (T.getHijos()[j] != null) {
                if (!T.getHijos()[j].isHoja()) {
                    NodoB X = obtener_padre(T.getHijos()[j], N);
                    if (X != null) {
                        return X;
                    }
                }
            }
        }
        return null;
    }

    private void balancear_hoja(NodoB desbalanceado) {
        if (desbalanceado.getN() < (t - 1)) {
            System.out.println("antes de balancear");
            mostrar_arbol();
            NodoB padre = obtener_padre(raiz, desbalanceado);
            int j = 1;
            while (padre.getHijos()[j - 1] != desbalanceado) {
                j++;
            }

            if (j == 1 || (padre.getHijos()[j - 2].getN() == (t - 1))) {
                if (j == padre.getN() + 1 || padre.getHijos()[j].getN() == (t - 1)) {
                    System.out.println("disminuido");
                    disminuir_altura(desbalanceado);
                } else {
                    System.out.println("balanceo izquierda");
                    balancear_izquierda(padre, j - 1, padre.getHijos()[j], desbalanceado);
                }
            } else {
                System.out.println("balanceo derecha");
                balancear_derecha(padre, j - 2, padre.getHijos()[j - 2], desbalanceado);
            }
        }
    }

    private void disminuir_altura(NodoB seleccionado) {
        int j;
        NodoB nuevo = new NodoB(t);
        if (seleccionado != null) {
            if (seleccionado == this.raiz) {
                if (seleccionado.getN() == 0) {
                    this.raiz = seleccionado.getHijos()[0];
                    seleccionado.getHijos()[0] = null;
                }
            } else {
                if (seleccionado.getN() < t) {
                    nuevo = obtener_padre(raiz, seleccionado);
                    j = 1;

                    while (nuevo.getHijos()[j - 1] != seleccionado) {
                        j++;
                    }

                    if (j > 1) {
                        System.out.println(j);
                        nuevo.imprimir();
                        juntar_nodos(obtener_padre(raiz, seleccionado), j - 1);
                        mostrar_arbol();
                        for (int i = 0; i < 3; i++) {
                            System.out.println(j);
                        }
                    } else {
                        System.out.println(j);
                        nuevo.imprimir();
                        juntar_nodos(obtener_padre(raiz, seleccionado), j);
                        mostrar_arbol();
                        for (int i = 0; i < 3; i++) {
                            System.out.println(j);
                        }
                    }
                    disminuir_altura(obtener_padre(raiz, seleccionado));
                }
            }
        }
    }

    private void balancear_derecha(NodoB padre, int e, NodoB izquierda, NodoB derecha) {
        for (int i = 0; i < derecha.getN(); i++) {
            derecha.getLlaves()[i + 1] = derecha.getLlaves()[i];
        }

        if (!derecha.isHoja()) {
            for (int i = 0; i < derecha.getN(); i++) {
                derecha.getHijos()[i + 1] = derecha.getHijos()[i];
            }
        }
        derecha.setN(derecha.getN() + 1);
        derecha.getLlaves()[0] = padre.getLlaves()[e];
        padre.getLlaves()[e] = izquierda.getLlaves()[izquierda.getN() - 1];
        derecha.getHijos()[0] = izquierda.getHijos()[izquierda.getN()];
        izquierda.setN(izquierda.getN() - 1);
        System.out.println("balanceo derecha");
    }

    private void balancear_izquierda(NodoB padre, int e, NodoB derecha, NodoB izquierda) {
        izquierda.setN(izquierda.getN() + 1);
        izquierda.getLlaves()[izquierda.getN() - 1] = padre.getLlaves()[e];
        padre.getLlaves()[e] = derecha.getLlaves()[0];
        izquierda.getHijos()[izquierda.getN()] = derecha.getHijos()[0];

        for (int j = 1; j < derecha.getN(); j++) {
            derecha.getLlaves()[j - 1] = derecha.getLlaves()[j];
        }

        if (!derecha.isHoja()) {
            for (int i = 1; i < derecha.getN(); i++) {
                derecha.getHijos()[i - 1] = derecha.getHijos()[i];
            }
        }

        derecha.setN(derecha.getN() - 1);
        System.out.println("balanceo izquierda");
    }

    private void juntar_nodos(NodoB padre, int i) {
        NodoB izquierda = padre.getHijos()[i - 1];
        NodoB derecha = padre.getHijos()[i];

        int k = izquierda.getN();
        izquierda.getLlaves()[k] = padre.getLlaves()[i - 1];

        for (int j = 1; j <= derecha.getN(); j++) {
            izquierda.getLlaves()[j + k] = derecha.getLlaves()[j - 1];
        }

        if (!derecha.isHoja()) {
            for (int j = 1; j <= derecha.getN() + 1; j++) {
                izquierda.getHijos()[j + k] = derecha.getHijos()[j - 1];
            }
        }
        izquierda.setN(izquierda.getN() + derecha.getN() + 1);
        padre.getHijos()[i] = null;
        for (int j = i; j <= padre.getN() - 1; j++) {
            padre.getLlaves()[j - 1] = padre.getLlaves()[j];
            padre.getHijos()[j] = padre.getHijos()[j + 1];
        }
        padre.setN(padre.getN() - 1);
    }

    public void insertar(int llave) {
        NodoB r = raiz;

        //Si el nodo esta lleno lo debe separar antes de insertar
        if (r.n == ((2 * t) - 1)) {
            NodoB nuevo = new NodoB(t);
            raiz = nuevo;
            nuevo.hoja = false;
            nuevo.n = 0;
            nuevo.hijos[0] = r;
            dividir(nuevo, 0, r);
            insertarB(nuevo, llave);
        } else {
            insertarB(r, llave);
            NodoB encontrado = buscar(r, llave);
            if (encontrado.n == (2 * t) - 1 && encontrado == raiz) {
                NodoB s = new NodoB(t);
                raiz = s;
                s.hoja = false;
                s.n = 0;
                s.hijos[0] = encontrado;
                dividir(s, 0, encontrado);
            } else {
                if (encontrado.n == (2 * t - 1)) {
                    NodoB padre = encontrado.getPadre();
                    int j = 0;
                    //Busca la posicion del hijo
                    while (j < padre.n && encontrado.llaves[t] > padre.llaves[j]) {
                        j++;
                    }
                    dividir(padre, j, encontrado);
                }
            }
        }
    }

    public void insertar_horario(int llave, Horario insertar) {
        NodoB r = raiz;

        //Si el nodo esta lleno lo debe separar antes de insertar
        if (r.n == ((2 * t) - 1)) {
            NodoB nuevo = new NodoB(t);
            raiz = nuevo;
            nuevo.hoja = false;
            nuevo.n = 0;
            nuevo.hijos[0] = r;
            dividir_horario(nuevo, 0, r);
            insertarB_horario(nuevo, llave, insertar);
        } else {
            insertarB_horario(r, llave, insertar);
            NodoB encontrado = buscar(r, llave);
            if (encontrado.n == (2 * t) - 1 && encontrado == raiz) {
                NodoB s = new NodoB(t);
                raiz = s;
                s.hoja = false;
                s.n = 0;
                s.hijos[0] = encontrado;
                dividir_horario(s, 0, encontrado);
            } else {
                if (encontrado.n == (2 * t - 1)) {
                    NodoB padre = encontrado.getPadre();
                    int j = 0;
                    //Busca la posicion del hijo
                    while (j < padre.n && encontrado.llaves[t] > padre.llaves[j]) {
                        j++;
                    }
                    dividir_horario(padre, j, encontrado);
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
    private void dividir(NodoB padre, int i, NodoB izquierda) {
        //Nodo temporal que sera el hijo i + 1 de x
        NodoB derecha = new NodoB(t);
        derecha.hoja = izquierda.hoja;
        derecha.n = (t - 1);

        //Copia las ultimas (t - 1) claves del nodo y al inicio del nodo z      // z = |40|50| | | |
        for (int j = 0; j < (t - 1); j++) {
            derecha.llaves[j] = izquierda.llaves[(j + t)];
        }

        //Si no es hoja hay que reasignar los nodos hijos
        if (!izquierda.hoja) {
            for (int k = 0; k < t; k++) {
                derecha.hijos[k] = izquierda.hijos[(k + t)];
            }
        }

        //nuevo tamanio de y                                                    // x =            | | | | | |
        izquierda.n = (t - 1);                                                          //               /   \
        //  |10|20| | | |
        //Mueve los hijos de x para darle espacio a z
        for (int j = padre.n; j > i; j--) {
            padre.hijos[(j + 1)] = padre.hijos[j];
        }
        //Reasigna el hijo (i+1) de x                                           // x =            | | | | | |
        padre.hijos[(i + 1)] = derecha;                                                   //               /   \
        //  |10|20| | | |     |40|50| | | |
        //Mueve las claves de x
        for (int j = padre.n; j > i; j--) {
            padre.llaves[(j + 1)] = padre.llaves[j];
        }

        //Agrega la clave situada en la mediana                                 // x =            |30| | | | |
        padre.llaves[i] = izquierda.llaves[(t - 1)];                                              //               /    \
        padre.n++;                                                                  //  |10|20| | | |      |40|50| | | |
        if (padre == raiz) {
            padre.setPadre(null);
        }
        derecha.setPadre(padre);
        izquierda.setPadre(padre);
        if (padre.getPadre() == null && padre.n == (2 * t - 1)) {
            NodoB s = new NodoB(t);
            NodoB r = raiz;
            raiz = s;
            s.hoja = false;
            s.n = 0;
            s.hijos[0] = r;
            dividir(s, 0, r);
        } else {
            if (padre.n == (2 * t - 1)) {
                NodoB p = padre.getPadre();
                int j = 0;
                //Busca la posicion del hijo
                while (j < p.n && padre.llaves[t] > p.llaves[j]) {
                    j++;
                }
                dividir(p, j, padre);
            }
        }
    }

    private void insertarB(NodoB destino, int llave) {
        //Si es una hoja
        if (destino.hoja) {
            int i = destino.n; //cantidad de valores del nodo
            //busca la posicion i donde asignar el valor
            while (i >= 1 && llave < destino.llaves[i - 1]) {
                destino.llaves[i] = destino.llaves[i - 1];//Desplaza los valores mayores a key
                i--;
            }
            destino.llaves[i] = llave;//asigna el valor al nodo
            destino.n++; //aumenta la cantidad de elementos del nodo
        } else {
            int j = 0;
            //Busca la posicion del hijo
            while (j < destino.n && llave > destino.llaves[j]) {
                j++;
            }

            //Si el nodo hijo esta lleno lo separa
            if (destino.hijos[j].n == (2 * t - 1)) {
                dividir(destino, j, destino.hijos[j]);
                if (llave > destino.llaves[j]) {
                    j++;
                }
            }
            //System.out.println("insertar llave " + key + " en " + Arrays.toString(x.key));
            insertarB(destino.hijos[j], llave);
        }
    }

    private void insertarB_horario(NodoB destino, int llave, Horario insertar) {
        //Si es una hoja
        if (destino.hoja) {
            int i = destino.n; //cantidad de valores del nodo
            //busca la posicion i donde asignar el valor
            while (i >= 1 && llave < destino.llaves[i - 1]) {
                destino.llaves[i] = destino.llaves[i - 1];//Desplaza los valores mayores a key
                destino.data[i] = destino.data[i - 1];
                i--;
            }
            destino.llaves[i] = llave;//asigna el valor al nodo
            destino.data[i] = insertar;
            destino.n++; //aumenta la cantidad de elementos del nodo
        } else {
            int j = 0;
            //Busca la posicion del hijo
            while (j < destino.n && llave > destino.llaves[j]) {
                j++;
            }

            //Si el nodo hijo esta lleno lo separa
            if (destino.hijos[j].n == (2 * t - 1)) {
                dividir_horario(destino, j, destino.hijos[j]);
                if (llave > destino.llaves[j]) {
                    j++;
                }
            }
            //System.out.println("insertar llave " + key + " en " + Arrays.toString(x.key));
            insertarB_horario(destino.hijos[j], llave, insertar);
        }
    }

    private void dividir_horario(NodoB padre, int i, NodoB izquierda) {
        //Nodo temporal que sera el hijo i + 1 de x
        NodoB derecha = new NodoB(t);
        derecha.hoja = izquierda.hoja;
        derecha.n = (t - 1);

        //Copia las ultimas (t - 1) claves del nodo y al inicio del nodo z      // z = |40|50| | | |
        for (int j = 0; j < (t - 1); j++) {
            derecha.llaves[j] = izquierda.llaves[(j + t)];
            derecha.data[j] = izquierda.data[j + t];
        }

        //Si no es hoja hay que reasignar los nodos hijos
        if (!izquierda.hoja) {
            for (int k = 0; k < t; k++) {
                derecha.hijos[k] = izquierda.hijos[(k + t)];
            }
        }

        //nuevo tamanio de y                                                    // x =            | | | | | |
        izquierda.n = (t - 1);                                                          //               /   \
        //  |10|20| | | |
        //Mueve los hijos de x para darle espacio a z
        for (int j = padre.n; j > i; j--) {
            padre.hijos[(j + 1)] = padre.hijos[j];
        }
        //Reasigna el hijo (i+1) de x                                           // x =            | | | | | |
        padre.hijos[(i + 1)] = derecha;                                                   //               /   \
        //  |10|20| | | |     |40|50| | | |
        //Mueve las claves de x
        for (int j = padre.n; j > i; j--) {
            padre.llaves[(j + 1)] = padre.llaves[j];
            padre.data[(j + 1)] = padre.data[j];
        }

        //Agrega la clave situada en la mediana                                 // x =            |30| | | | |
        padre.llaves[i] = izquierda.llaves[(t - 1)];                                              //               /    \
        padre.data[i] = izquierda.data[(t - 1)];
        padre.n++;                                                                  //  |10|20| | | |      |40|50| | | |

        if (padre == raiz) {
            padre.setPadre(null);
        }
        derecha.setPadre(padre);
        izquierda.setPadre(padre);
        if (padre.getPadre() == null && padre.n == (2 * t - 1)) {
            NodoB s = new NodoB(t);
            NodoB r = raiz;
            raiz = s;
            s.hoja = false;
            s.n = 0;
            s.hijos[0] = r;
            dividir_horario(s, 0, r);
        } else {
            if (padre.n == (2 * t - 1)) {
                NodoB p = padre.getPadre();
                int j = 0;
                //Busca la posicion del hijo
                while (j < p.n && padre.llaves[t] > p.llaves[j]) {
                    j++;
                }
                dividir_horario(p, j, padre);
            }
        }
    }

    public void mostrar_arbol() {
        print(raiz);
    }

    public String crear_doc() {
        return INICIO_GRAPH + graphviz(this.raiz) + "}";
    }
    
    public String escribir_doc() {
        return INICIO_GRAPH + graphviz_con(this.raiz) + "}";
    }

    //Print en preorder
    private void print(NodoB n) {
        n.imprimir();
        System.out.println("");
        //System.out.println(Arrays.toString(n.getKey()));
        System.out.println("node" + n.llaves[0] + "[label =" + n.graphviz() + "];");

        //Si no es hoja
        if (!n.hoja) {
            //System.out.println("");
            //recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
                if (n.hijos[j] != null) {
                    print(n.hijos[j]);
                    System.out.println("node" + n.llaves[0] + ":f" + j + "->node" + n.hijos[j].llaves[0] + ";");
                }
            }
        }
    }

    private String graphviz(NodoB n) {
        String retorno = "\n";
        retorno += "node" + n.llaves[0] + "[label =" + n.graphviz() + "];\n";
        //Si no es hoja
        if (!n.hoja) {
            //System.out.println("");
            //recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
                if (n.hijos[j] != null) {
                    retorno += graphviz(n.hijos[j]);
                    retorno += "node" + n.llaves[0] + ":f" + j + "->node" + n.hijos[j].llaves[0] + ";\n";
                }
            }
        }
        return retorno;
    }

    public String graphviz_con(NodoB n) {
        String retorno = "\n";
        retorno += "node" + n.llaves[0] + "[label =" + n.graphviz() + "];\n";
        for (int i = 0; i < n.n; i++) {
            Horario temp = (Horario) n.getData()[i];
            if (temp != null) {
                String al = "subgraph cluster"+n.llaves[i]+"{";
                Circular cir = temp.getAsignaciones();
                al += cir.estructura_graphviz_asignacion("A");
                al += "}";
                al += "node"+n.llaves[0]+":n"+n.llaves[i]+" -> nodeCA"+cir.raiz.getId()+";";
                retorno += al;
            }
        }
        if (!n.hoja) {
            //System.out.println("");
            //recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
                if (n.hijos[j] != null) {
                    retorno += graphviz_con(n.hijos[j]);
                    retorno += "node" + n.llaves[0] + ":f" + j + "->node" + n.hijos[j].llaves[0] + ";\n";
                }
            }
        }
        return retorno;
    }
    
    public SimpleEnlazada listado(){
        ArrayList<Horario> retorno = listado_horarios(raiz);
        SimpleEnlazada lista = new SimpleEnlazada();
        for (int i = 0; i < retorno.size(); i++) {
            lista.ingresar(i, retorno.get(i));
        }
        return lista;
    }
    
    public ArrayList<Horario> listado_horarios(NodoB n) {
        ArrayList<Horario> retorno = new ArrayList<>();
        for (int i = 0; i < n.n; i++) {
            Horario temp = (Horario) n.getData()[i];
            if (temp != null) {
                retorno.add(temp);
            }
        }
        if (!n.hoja) {
            //System.out.println("");
            //recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
                if (n.hijos[j] != null) {
                    ArrayList<Horario> ob = listado_horarios(n.hijos[j]);
                    if (!ob.isEmpty()){
                        retorno.addAll(ob);
                    }
                }
            }
        }
        return retorno;
    }

    public NodoB getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoB raiz) {
        this.raiz = raiz;
    }

    public class NodoB<T> {

        int n; //numero de claves almacenadas en el nodo
        boolean hoja; //Si el nodo es hoja (nodo hoja=true; nodo interno=false)
        int[] llaves;  //almacena las claves en el nodo
        NodoB[] hijos; //arreglo con referencias a los hijos
        NodoB padre;
        Horario data[];

        //Constructores
        public NodoB(int t, T data) {
            n = 0;
            hoja = true;
            llaves = new int[((2 * t) - 1)];
            hijos = new NodoB[(2 * t)];
            this.padre = null;
            this.data = new Horario[((2 * t) - 1)];
        }

        public NodoB(int t) {
            n = 0;
            hoja = true;
            llaves = new int[((2 * t) - 1)];
            hijos = new NodoB[(2 * t)];
            data = new Horario[((2 * t) - 1)];
        }

        public void imprimir() {
            System.out.print("[");
            for (int i = 0; i < n; i++) {
                if (i < n - 1) {
                    System.out.print(llaves[i] + " | ");
                } else {
                    System.out.print(llaves[i]);
                }
            }
            System.out.print("]");
        }

        public String graphviz() {
            String retorno = "";
            retorno += "\"";
            for (int i = 0; i < n; i++) {
                System.out.println(i);
                if (i != 0) {
                    retorno += " | ";
                }
                retorno += "<f" + i + ">";
                if (i < n - 1) {
                    retorno += "| <n" + llaves[i] + ">" + data[i].toString();
                } else {
                    retorno += "| <n" + llaves[i] + ">" + data[i].toString() + " |<f" + (i + 1) + ">";
                }
            }
            retorno += "\"";
            return retorno;
        }

        public SimpleEnlazada datos() {
            SimpleEnlazada retorno = new SimpleEnlazada();
            for (int i = 0; i < n; i++) {
                retorno.ingresar(llaves[i], (Horario) data[i]);
            }
            return retorno;
        }

        public int find(int k) {
            for (int i = 0; i < n; i++) {
                if (llaves[i] == k) {
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

        public boolean isHoja() {
            return hoja;
        }

        public void setHoja(boolean hoja) {
            this.hoja = hoja;
        }

        public int[] getLlaves() {
            return llaves;
        }

        public void setLlaves(int[] llaves) {
            this.llaves = llaves;
        }

        public NodoB[] getHijos() {
            return hijos;
        }

        public void setHijos(NodoB[] hijos) {
            this.hijos = hijos;
        }

        public NodoB getPadre() {
            return padre;
        }

        public void setPadre(NodoB padre) {
            this.padre = padre;
        }

        public Horario[] getData() {
            return data;
        }

        public void setData(Horario[] data) {
            this.data = data;
        }
    }
}
