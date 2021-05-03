/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author willi
 * @param <T>
 */
public class AVL<T> {

    private NodoAVL<T> raiz;
    private int no_nodos;
    static final String INICIO_GRAFICO = "digraph G{\n"
            + "node [shape = record,height=.1];";

    public AVL() {
        raiz = null;
        no_nodos = 0;
    }

    public T buscar(int id, NodoAVL<T> r) {
        if (raiz == null) {
            return null;
        } else if (r.getId() == id) {
            return r.getData();
        } else if (r.getId() < id) {
            return buscar(id, r.getDerecha());
        } else {
            return buscar(id, r.getIzquierda());
        }
    }

    public int obtener_factor(NodoAVL<T> nodo) {
        if (nodo == null) {
            return -1;
        } else {
            return nodo.getFactor();
        }
    }
    
    public NodoAVL<T> rotacion_izquierda(NodoAVL<T> nodo){
        NodoAVL<T> aux = nodo.getIzquierda();
        nodo.setIzquierda(aux.getDerecha());
        aux.setDerecha(nodo);
        nodo.setFactor(Math.max(obtener_factor(nodo.getIzquierda()),obtener_factor(nodo.getDerecha()))+1);
        aux.setFactor(Math.max(obtener_factor(aux.getIzquierda()),obtener_factor(aux.getDerecha()))+1);
        return aux;
    }
    
    public NodoAVL<T> rotacion_derecha(NodoAVL<T> nodo){
        NodoAVL<T> aux = nodo.getDerecha();
        nodo.setDerecha(aux.getIzquierda());
        aux.setIzquierda(nodo);
        nodo.setFactor(Math.max(obtener_factor(nodo.getIzquierda()),obtener_factor(nodo.getDerecha()))+1);
        aux.setFactor(Math.max(obtener_factor(aux.getIzquierda()),obtener_factor(aux.getDerecha()))+1);
        return aux;
    }
    
    public NodoAVL<T> rotacion_doble_izquierda(NodoAVL<T> nodo){
        NodoAVL<T> temp;
        nodo.setIzquierda(rotacion_derecha(nodo.getIzquierda()));
        temp = rotacion_izquierda(nodo);
        return temp;
    }
    
    public NodoAVL<T> rotacion_doble_derecha(NodoAVL<T> nodo){
        NodoAVL<T> temp;
        nodo.setDerecha(rotacion_izquierda(nodo.getDerecha()));
        temp = rotacion_derecha(nodo);
        return temp;
    }
    
    public NodoAVL<T> insertarAVL(NodoAVL<T> nuevo, NodoAVL<T> subAr) {
        NodoAVL<T> nuevoPadre = subAr;
        if (nuevo.getId() < subAr.getId()) {
            if (subAr.getIzquierda() == null) {
                subAr.setIzquierda(nuevo);
            } else {
                subAr.setIzquierda(insertarAVL(nuevo, subAr.getIzquierda()));
                if ((obtener_factor(subAr.getIzquierda()) - obtener_factor(subAr.getDerecha())) == 2) {
                    if (nuevo.getId() < subAr.getIzquierda().getId()) {
                        nuevoPadre = rotacion_izquierda(subAr);
                    } else {
                        nuevoPadre = rotacion_doble_izquierda(subAr);
                    }
                }
            }
        } else if (nuevo.getId() > subAr.getId()) {
            if (subAr.getDerecha() == null) {
                subAr.setDerecha(nuevo);
            } else {
                subAr.setDerecha(insertarAVL(nuevo, subAr.getDerecha()));
                if ((obtener_factor(subAr.getDerecha()) - obtener_factor(subAr.getIzquierda())) == 2) {
                    if (nuevo.getId() > subAr.getDerecha().getId()) {
                        nuevoPadre = rotacion_derecha(subAr);
                    } else {
                        nuevoPadre = rotacion_doble_derecha(subAr);
                    }
                }
            }
        } else {
            System.out.println("Nodo duplicado");
        }
        if ((subAr.getIzquierda() == null) && (subAr.getDerecha() != null)) {
            subAr.setFactor(subAr.getDerecha().getFactor() + 1);
        } else if ((subAr.getDerecha() == null) && (subAr.getIzquierda() != null)) {
            subAr.setFactor(subAr.getIzquierda().getFactor() + 1);
        } else {
            subAr.setFactor((Math.max(obtener_factor(subAr.getIzquierda()), obtener_factor(subAr.getDerecha())) + 1));
        }
        return nuevoPadre;
    }
    
    public void insertar(T datos, int id){
        if (raiz == null){
            raiz = new NodoAVL(id,datos,null,null);
            no_nodos++;
        } else {
            raiz = insertarAVL(new NodoAVL(id,datos,null,null),raiz);
            no_nodos++;
        }
    }
    
    public String recorrido(NodoAVL<T> recorrida) {
        String retorno = "";
        if (recorrida != null) {
            retorno += recorrido(recorrida.getIzquierda());
            retorno += "node" + recorrida.getId() + "[label = \"<f0> |<f1> " + recorrida.getData().toString() + "|<f2> \"];\n";
            if (recorrida.getIzquierda() != null) {
                retorno += "\"node" + recorrida.getId() + "\":f0 -> \"node" + recorrida.getIzquierda().getId() + "\":f1;\n";
            }
            if (recorrida.getDerecha() != null) {
                retorno += "\"node" + recorrida.getId() + "\":f2 -> \"node" + recorrida.getDerecha().getId() + "\":f1;\n";
            }
            retorno += recorrido(recorrida.getDerecha());
        }
        return retorno;
    }
    
    public void crear_doc(){
        System.out.println(INICIO_GRAFICO+recorrido(raiz)+"}");
    }
    
    public NodoAVL<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAVL<T> raiz) {
        this.raiz = raiz;
    }

    public int getNo_nodos() {
        return no_nodos;
    }

    public void setNo_nodos(int no_nodos) {
        this.no_nodos = no_nodos;
    }

    public class NodoAVL <T> {

        private NodoAVL <T> izquierda;
        private NodoAVL <T> derecha;
        private T data;
        private int id;
        private int factor;

        public NodoAVL(){
            this.izquierda = null;
            this.derecha = null;
            this.data = null;
            this.id = -1;
            this.factor = 0;
        }
        
        public NodoAVL(int id, T data, NodoAVL<T> izquierda, NodoAVL<T> derecha) {
            this.izquierda = izquierda;
            this.derecha = derecha;
            this.data = data;
            this.id = id;
        }

        public NodoAVL<T> getIzquierda() {
            return izquierda;
        }

        public void setIzquierda(NodoAVL<T> izquierda) {
            this.izquierda = izquierda;
        }

        public NodoAVL<T> getDerecha() {
            return derecha;
        }

        public void setDerecha(NodoAVL<T> derecha) {
            this.derecha = derecha;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFactor() {
            return factor;
        }

        public void setFactor(int factor) {
            this.factor = factor;
        }
    }
}
