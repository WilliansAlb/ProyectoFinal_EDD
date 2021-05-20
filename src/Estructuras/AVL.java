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

    /**
     * Método que retorna un elemento buscado
     * @param id el identificador del elemento buscado
     * @param r el nodo donde se encuentra el método
     * @return el elemento
     */
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

    /**
     * Método que retorna el factor de balance que tiene el nodo para ver si se tiene que balancear o no
     * @param nodo el nodo al cual se le quiere sacar el factor de balance
     * @return el factor de balance
     */
    public int obtener_factor(NodoAVL<T> nodo) {
        if (nodo == null) {
            return -1;
        } else {
            return nodo.getFactor();
        }
    }

    /**
     * Método que balancea el subarbol que se le envia, y retorna el subarbol ya balanceado
     * @param nodo el nodo raiz del subarbol
     * @return el arbol ya balanceado
     */
    public NodoAVL<T> rotacion_izquierda(NodoAVL<T> nodo) {
        NodoAVL<T> aux = nodo.getIzquierda();
        nodo.setIzquierda(aux.getDerecha());
        aux.setDerecha(nodo);
        nodo.setFactor(Math.max(obtener_factor(nodo.getIzquierda()), obtener_factor(nodo.getDerecha())) + 1);
        aux.setFactor(Math.max(obtener_factor(aux.getIzquierda()), obtener_factor(aux.getDerecha())) + 1);
        return aux;
    }

    /**
     * Método que realiza una rotacion a la derecha, y retorna el subarbol balanceado
     * @param nodo el nodo raiz del subarbol enviado
     * @return subarbol balanceado
     */
    public NodoAVL<T> rotacion_derecha(NodoAVL<T> nodo) {
        NodoAVL<T> aux = nodo.getDerecha();
        nodo.setDerecha(aux.getIzquierda());
        aux.setIzquierda(nodo);
        nodo.setFactor(Math.max(obtener_factor(nodo.getIzquierda()), obtener_factor(nodo.getDerecha())) + 1);
        aux.setFactor(Math.max(obtener_factor(aux.getIzquierda()), obtener_factor(aux.getDerecha())) + 1);
        return aux;
    }

    /**
     * Método que realiza una rotacion doble a la izquierda, y retorna el subarbol balanceado
     * @param nodo el nodo raiz del subarbol enviado
     * @return subarbol balanceado
     */
    public NodoAVL<T> rotacion_doble_izquierda(NodoAVL<T> nodo) {
        NodoAVL<T> temp;
        nodo.setIzquierda(rotacion_derecha(nodo.getIzquierda()));
        temp = rotacion_izquierda(nodo);
        return temp;
    }

    /**
     * Método que realiza una rotacion doble a la derecha, y retorna el subarbol balanceado
     * @param nodo el nodo raiz del subarbol enviado
     * @return subarbol balanceado
     */
    public NodoAVL<T> rotacion_doble_derecha(NodoAVL<T> nodo) {
        NodoAVL<T> temp;
        nodo.setDerecha(rotacion_izquierda(nodo.getDerecha()));
        temp = rotacion_derecha(nodo);
        return temp;
    }

    /**
     * Método que encuentra el nodo más a la derecha y abajo del subarbol enviado
     * @param nodo el nodo raiz del subarbol
     * @return nodo más a la derecha y abajo del subarbol enviado
     */
    public NodoAVL<T> encontrar_maximo(NodoAVL<T> nodo) {
        if (nodo == null) {
            return nodo;
        }
        while (nodo.getDerecha() != null) {
            nodo = nodo.getDerecha();
        }
        return nodo;
    }

    /**
     * Método recursivo, que recorre el arbol hasta encontrar la posición donde el nodo pueda ser ingresado
     * @param nuevo el nodo a insertar
     * @param subAr el subarbol generado al buscar la posicion donde el nodo pude ser ingresado
     * @return el arbol con el elemento ingresado
     */
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

    /**
     * Método para insertar un elemento desde otras clases
     * @param id el identificador del elemento
     * @param datos los datos del elemento
     */
    public void insertar(int id, T datos) {
        if (raiz == null) {
            raiz = new NodoAVL(id, datos, null, null);
            no_nodos++;
        } else {
            raiz = insertarAVL(new NodoAVL(id, datos, null, null), raiz);
            no_nodos++;
        }
    }

    /**
     * Método recursivo que recorre el arbol InOrden y va generando el string para graficar con graphviz
     * @param recorrida el nodo actual  
     * @return todo el string para graficar
     */
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
    
    public T obtener(int id) {
        NodoAVL<T> temporal = raiz;
        while (temporal != null) {
            if (id > temporal.getId()) {
                temporal = temporal.getDerecha();
            } else if (id < temporal.getId()) {
                temporal = temporal.getIzquierda();
            } else if (id == temporal.getId()) {
                return temporal.getData();
            }
        }
        return null;
    }

    /**
     * Método para eliminar el elemento con el id que se envia
     * @param id el id a eliminar
     */
    public void eliminar(int id) {
        raiz = eliminar(id, raiz);
    }

    /**
     * Método recursivo que encuentra el elemento a eliminar, lo elimina, y balance el resultado del arbol
     * @param id el identificador del nodo buscado
     * @param nodo el nodo en el que nos encontramos
     * @return el nodo en el que se encuentra ya modificado según sea las condiciones
     */
    public NodoAVL<T> eliminar(int id, NodoAVL<T> nodo) {
        if (nodo == null) {
            System.out.println("Error");
            return null;
        }
        if (id < nodo.getId()) {
            nodo.setIzquierda(eliminar(id, nodo.getIzquierda()));
            int l = nodo.getIzquierda() != null ? nodo.getIzquierda().getFactor() : 0;

            if ((nodo.getDerecha() != null) && (nodo.getDerecha().getFactor() - l >= 2)) {
                int factor_derecha = nodo.getDerecha().getDerecha() != null ? nodo.getDerecha().getDerecha().getFactor() : 0;
                int factor_izquierda = nodo.getDerecha().getIzquierda() != null ? nodo.getDerecha().getIzquierda().getFactor() : 0;

                if (factor_derecha >= factor_izquierda) {
                    nodo = rotacion_izquierda(nodo);
                } else {
                    nodo = rotacion_doble_derecha(nodo);
                }
            }
        } else if (id > nodo.getId()) {
            nodo.setDerecha(eliminar(id, nodo.getDerecha()));
            int r = nodo.getDerecha() != null ? nodo.getDerecha().getFactor() : 0;
            if ((nodo.getDerecha() != null) && (nodo.getDerecha().getFactor() - r >= 2)) {
                int factor_derecha = nodo.getIzquierda().getDerecha() != null ? nodo.getIzquierda().getDerecha().getFactor() : 0;
                int factor_izquierda = nodo.getIzquierda().getIzquierda() != null ? nodo.getIzquierda().getIzquierda().getFactor() : 0;

                if (factor_izquierda >= factor_derecha) {
                    nodo = rotacion_derecha(nodo);
                } else {
                    nodo = rotacion_doble_izquierda(nodo);
                }
            }
        } else if (nodo.getIzquierda() != null) {
            NodoAVL<T> aux = encontrar_maximo(nodo.getIzquierda());
            nodo.setId(aux.getId());
            nodo.setData(aux.getData());
            eliminar(nodo.getId(), nodo.getIzquierda());
            if ((nodo.getDerecha() != null) && (nodo.getDerecha().getFactor() - nodo.getIzquierda().getFactor() >= 2)) {
                int factor_derecha = nodo.getDerecha().getDerecha() != null ? nodo.getDerecha().getDerecha().getFactor() : 0;
                int factor_izquierda = nodo.getDerecha().getIzquierda() != null ? nodo.getDerecha().getIzquierda().getFactor() : 0;

                if (factor_derecha >= factor_izquierda) {
                    nodo = rotacion_izquierda(nodo);
                } else {
                    nodo = rotacion_doble_derecha(nodo);
                }
            }
            int control2 = nodo.getId();
            int control = nodo.getIzquierda()!=null ? nodo.getIzquierda().getId() : -1;
            if (control2==control){
                nodo.setIzquierda(null);
            }
        } else {
            nodo = (nodo.getIzquierda() != null) ? nodo.getIzquierda() : nodo.getDerecha();
        }

        if (nodo != null) {
            int factor_izquierda = nodo.getIzquierda() != null ? nodo.getIzquierda().getFactor() : 0;
            int factor_derecha = nodo.getDerecha() != null ? nodo.getDerecha().getFactor() : 0;
            nodo.setFactor(Math.max(factor_izquierda, factor_derecha) + 1);
        }
        return nodo;
    }

    /**
     * Método que crea el documento para realizar el documento de graphviz
     */
    public void crear_doc() {
        System.out.println(INICIO_GRAFICO + recorrido(raiz) + "}");
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

    public class NodoAVL<T> {

        private NodoAVL<T> izquierda;
        private NodoAVL<T> derecha;
        private T data;
        private int id;
        private int factor;

        public NodoAVL() {
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
