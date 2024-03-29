/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import POJOS.Estudiante;

/**
 *
 * @author willi
 * @param <T>
 */
public class Hash<T> {

    private int size;
    private int ocupadas;
    private NodoHash<T> raiz;
    public static final double CARGA = 0.55;
    public static final String INICIO_GRAPH = "digraph G{\n" +
"	nodesep=0.1;\n" +
"	rankdir=LR;\n" +
"	node [shape=record, width = .1, height = .1];\n	node[width = 1.5];\n";

    public Hash() {
        size = 37;
        raiz = null;
    }

    /**
     * Método que rellena todos los espacios de la tabla con null
     */
    public void rellenar() {
        NodoHash<T> temp = raiz;
        for (int i = 0; i < size; i++) {
            if (raiz == null) {
                raiz = new NodoHash(i, null, null);
                temp = raiz;
            } else {
                temp.setSiguiente(new NodoHash(i, null, null));
                temp = temp.getSiguiente();
            }
        }
    }

    /**
     * Método de prueba para ver si efectivamente se generan los encabezados
     * para los datos en las tablas hash
     */
    public void imprimir() {
        NodoHash<T> temp = raiz;
        while (temp != null && temp.getSiguiente() != null) {
            System.out.println(temp.getId() + "->" + temp.getSiguiente().getId());
            temp = temp.getSiguiente();
        }
    }

    /**
     * Método que imprime todas las llaves y los valores que contiene la tabla
     * hash
     */
    public void imprimir2() {
        NodoHash<T> temp = raiz;
        while (temp != null) {
            if (temp.getData() != null) {
                System.out.println("key: " + temp.getId() + " value: " + temp.getData().toString());
            }
            temp = temp.getSiguiente();
        }
    }
    
    public String escribir_doc() {
        NodoHash<T> temp = raiz;
        String retorno = INICIO_GRAPH+"node0B[label =\"";
        //[label = "<f0> 1|<f1> 2|<f2> 3|<f3> 4|<f4> 5|<f5> 6|<f6> 7|<f7> 8",height=4];
        for (int i = 0; i < size; i++) {
            retorno += "<f"+i+"> "+i+" ";
            if (i!=size-1){
                retorno+="| ";
            }
        }
        retorno+="\", height=2.5];\n";
        while (temp != null) {
            if (temp.getData() != null) {
                retorno+="node"+temp.getId()+"[label = \"{<n> | "+temp.getData().toString()+" | <m> }\", width=5];\n";
                retorno+="node0B:f"+temp.getId()+" -> node"+temp.getId()+":n;\n";
            }
            temp = temp.getSiguiente();
        }
        retorno+="}";
        return retorno;
    }

    /**
     * Método para insertar a la tabla los datos enviados
     *
     * @param id el id de los datos
     * @param data los datos a ingresar
     * @return 
     */
    public boolean insertar(int id, T data) {
        //Revisa si se ha sobrepasado el porcentaje de carga máxima para la tabla
        System.out.println("llega acá");
        if (porcentaje_max()) {
            int llave = getKey(id);
            if (ocupada(llave)) {
                return doble_dispercion(id, data, 0);
            } else {
                System.out.println("inserta");
                agregar(llave, data);
                return true;
            }
        } else {
            int temp = size + 1;
            while (true) {
                if (primo(temp)) {
                    break;
                }
                temp++;
            }
            rehashing(temp);
            return insertar(id, data);
        }
    }

    /**
     * Método que resuelve los conflictos por colisiones mediante el metodo de
     * doble dispercion
     *
     * @param id el id del nodo a colocar
     * @param data el POJO a almacenar
     * @param conteo las veces que el método se repite
     * @return 
     */
    public boolean doble_dispercion(int id, T data, int conteo) {
        int key = ((id % 7) + 1) * conteo;
        if (key > size) {
            if (ocupada(key)) {
                return doble_dispercion(id, data, conteo + 1);
            } else {
                agregar(key, data);
                return true;
            }
        } else {
            return false;
        }
    }

    public Estudiante buscar(int id) {
        int key = getKey(id);
        NodoHash<T> obtener = obtener(key);
        if (obtener.data != null) {
            Estudiante te = (Estudiante) obtener.getData();
            if (te.getCarnet() == id) {
                return te;
            } else {
                return buscar(id,0);
            }
        } else {
            return null;
        }
    }
    
    public boolean editar(int id, T nueva){
        NodoHash<T> temp = raiz;
        while (temp != null) {
            if (temp.getId() == id) {
                temp.setData(nueva);
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
    }

    public Estudiante buscar(int id, int conteo) {
        int key = ((id % 7) + 1) * conteo;
        if (key < size) {
            NodoHash<T> obtener = obtener(key);
            if (obtener.getData() != null) {
                Estudiante te = (Estudiante) obtener.getData();
                if (te.getCarnet() == id) {
                    return te;
                } else {
                    return buscar(id, conteo + 1);
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public NodoHash<T> obtener(int id) {
        NodoHash<T> temp = raiz;
        while (temp != null) {
            if (temp.getId() == id) {
                return temp;
            }
            temp = temp.getSiguiente();
        }
        return null;
    }
    
    public Estudiante obtener_index(int id) {
        NodoHash<T> temp = raiz;
        while (temp != null) {
            if (temp.getId() == id) {
                return (Estudiante)temp.getData();
            }
            temp = temp.getSiguiente();
        }
        return null;
    }

    /**
     * Método que hace un rehashing cuando se ha llegado al factor de carga
     *
     * @param resize el nuevo tamaño de la tabla hash
     */
    public void rehashing(int resize) {
        Hash nuevo = new Hash();
        nuevo.setSize(resize);
        nuevo.setRaiz(llenar(nuevo));
        size = nuevo.getSize();
        raiz = nuevo.getRaiz();
    }

    /**
     * Método que llena la tabla hash con los datos de la anterior tabla
     *
     * @param vacio
     * @return
     */
    public NodoHash<T> llenar(Hash vacio) {
        NodoHash<T> temp = raiz;
        while (temp != null) {
            if (temp.getData() != null) {
                vacio.insertar(temp.getId(), temp.getData());
            }
        }
        return vacio.getRaiz();
    }

    /**
     * Método que comprueba si un número es primo o compuesto
     *
     * @param numero el numero a comprobar
     * @return true si el numero enviado es primo
     */
    public boolean primo(int numero) {
        int contador = 2;
        boolean primo = true;

        while ((primo) && (contador != numero)) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }

    /**
     * Método que comprueba si se ha sobrepasado el factor de carga de la tabla
     * hash
     *
     * @return true si no se ha sobrepasado el factor
     */
    public boolean porcentaje_max() {
        return (ocupadas / size) <= CARGA;
    }

    /**
     * Método que genera la llave cuando la situación es ideal y no se tiene
     * conflictos
     *
     * @param id el id al cual se le hará el hash
     * @return la llave generada
     */
    public int getKey(int id) {
        return id % size;
    }

    /**
     * Método que comprueba que el lugar donde se insertarán los datos está
     * libre en la tabla hash
     *
     * @param id la llave a comprobar
     * @return true si la llave esta libre para ingresar datos
     */
    public boolean ocupada(int id) {
        NodoHash<T> temp = raiz;
        while (temp != null) {
            if (temp.getId() == id && temp.getData() != null) {
                return true;
            }
            System.out.println("iteracion");
            temp = temp.getSiguiente();
        }
        return false;
    }

    /**
     * Método que ingresa los datos a su lugar correspondiente en la tabla hash
     *
     * @param llave la llave generada
     * @param data los datos a ingresar
     */
    public void agregar(int llave, T data) {
        NodoHash<T> temp = raiz;
        while (temp != null) {
            if (temp.getId() == llave) {
                temp.setData(data);
                ocupadas++;
                break;
            }
            System.out.println("a ver");
            temp = temp.getSiguiente();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOcupadas() {
        return ocupadas;
    }

    public void setOcupadas(int ocupadas) {
        this.ocupadas = ocupadas;
    }

    public NodoHash<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoHash<T> raiz) {
        this.raiz = raiz;
    }

    public class NodoHash<T> {

        private NodoHash<T> siguiente;
        private int id;
        private T data;

        public NodoHash(int id, T data, NodoHash<T> siguiente) {
            this.siguiente = siguiente;
            this.id = id;
            this.data = data;
        }

        public NodoHash<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoHash<T> siguiente) {
            this.siguiente = siguiente;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
