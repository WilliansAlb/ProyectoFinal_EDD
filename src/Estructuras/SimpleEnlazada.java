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
public class SimpleEnlazada<T> {

    private NodoSimple<T> raiz;

    public SimpleEnlazada() {
        this.raiz = null;
    }

    /**
     * Método que ingresa el dato a la lista
     *
     * @param id el id de la posicion en la que se iniciará
     * @param data los datos enviados
     */
    public void ingresar(int id, T data) {
        NodoSimple<T> nuevo = new NodoSimple(id, data, null);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            if (existe(id)) {
                System.out.println("Ya existe");
            } else {
                if (id < raiz.getId()) {
                    nuevo.setSiguiente(raiz);
                    raiz = nuevo;
                } else {
                    NodoSimple<T> actual = raiz;
                    NodoSimple<T> anterior = raiz;
                    while (id >= actual.getId() && actual.getSiguiente() != null) {
                        anterior = actual;
                        actual = actual.getSiguiente();
                    }
                    if (id >= actual.getId()) {
                        actual.setSiguiente(nuevo);
                    } else {
                        nuevo.setSiguiente(actual);
                        anterior.setSiguiente(nuevo);
                    }
                }
            }
        }
    }

    /**
     * Método que imprime en orden toda la lista
     */
    public void imprimir() {
        NodoSimple<T> temp = raiz;
        while (temp != null) {
            System.out.println(temp.getData().toString());
            temp = temp.getSiguiente();
        }
        System.out.println("");
    }

    /**
     * Método que retorna si existe o no el dato que se le envia
     *
     * @param id el id de los datos enviados
     * @return true si ya existe el dato enviado
     */
    public boolean existe(int id) {
        NodoSimple<T> temp = raiz;
        while (temp != null) {
            if (temp.getId() == id) {
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
    }

    /**
     * Método que elimina el dato solicitado
     *
     * @param id el id del dato a eliminar
     */
    public void eliminar(int id) {
        NodoSimple<T> temp = raiz;
        NodoSimple<T> anterior = raiz;
        while (temp != null) {
            if (temp == raiz && temp.getId() == id) {
                raiz = temp.getSiguiente();
                break;
            } else {
                if (temp.getId() == id) {
                    anterior.setSiguiente(temp.getSiguiente());
                    break;
                }
            }
            anterior = temp;
            temp = temp.getSiguiente();
        }
    }
    
    /**
     * Método que obtiene el dato que se le solicita y lo devuelve
     * @param id el id del dato requerido
     * @return el dato requerido
     */
    public T obtener(int id) {
        if (existe(id)) {
            NodoSimple<T> temp = raiz;
            while (temp != null) {
                if (temp.getId() == id) {
                    return temp.getData();
                }
                temp = temp.getSiguiente();
            }
            return null;
        } else {
            return null;
        }
    }
    
    public String crear_doc(){
        NodoSimple<T> temp = raiz;
        String retorno = "";
        while (temp != null) {
            retorno+= "nodeS"+temp.getId()+"[label=\""+temp.getData().toString()+"\"];";
            if (temp.getSiguiente()!=null){
                retorno+="nodeS"+temp.getId()+" -> "+"nodeS"+temp.getSiguiente().getId()+";";
            }
            temp = temp.getSiguiente();
        }
        return retorno;
    }
    
    /**
     * Método que modifica el dato que se le envio para modificar
     * @param id el id del dato a modificar
     * @param data el dato a modificar
     */
    public void modificar(int id, T data) {
        if (existe(id)) {
            NodoSimple<T> temp = raiz;
            while (temp != null) {
                if (temp.getId() == id) {
                    temp.setData(data);
                    break;
                }
                temp = temp.getSiguiente();
            }
        } else {
            System.out.println("error");
        }
    }

    public NodoSimple<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoSimple<T> raiz) {
        this.raiz = raiz;
    }

    public class NodoSimple<T> {

        private NodoSimple<T> siguiente;
        private T data;
        private int id;

        public NodoSimple(int id, T data, NodoSimple<T> siguiente) {
            this.siguiente = siguiente;
            this.data = data;
            this.id = id;
        }

        public NodoSimple<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoSimple<T> siguiente) {
            this.siguiente = siguiente;
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

    }
}
