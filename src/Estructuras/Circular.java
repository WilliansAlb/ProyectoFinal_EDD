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
public class Circular<T> {

    private NodoCircular<T> raiz;

    public Circular() {
        raiz = null;
    }
    
    public void agregar_nodo(T data, int id) {
        if (raiz == null) {
            raiz = new NodoCircular(id,data,null,null);
            raiz.setSiguiente(raiz);
            raiz.setAnterior(raiz);
        } else {
            NodoCircular<T> temp = raiz;
            do {
                if (temp.getSiguiente() == raiz) {
                    if (temp.getId() > id) {
                        NodoCircular<T> nuevo = new NodoCircular(id,data,temp,temp.getAnterior());
                        temp.getAnterior().setSiguiente(nuevo);
                        raiz = nuevo;
                        break;
                    } else {
                        NodoCircular<T> nuevo = new NodoCircular(id,data,raiz,temp);
                        temp.setSiguiente(nuevo);
                        temp.setAnterior(nuevo);
                        break;
                    }
                } else {
                    if (temp == raiz && temp.getId() > id) {
                        NodoCircular<T> nuevo = new NodoCircular(id,data,temp.getAnterior(),temp);
                        nuevo.getAnterior().setSiguiente(nuevo);
                        temp.setAnterior(nuevo);
                        raiz = nuevo;
                        break;
                    } else {
                        if (temp.getId() < id && temp.getSiguiente().getId() > id) {
                            NodoCircular<T> nuevo = new NodoCircular(id,data,temp.getSiguiente(),temp);
                            temp.setSiguiente(nuevo);
                            temp.setAnterior(nuevo);
                            break;
                        }
                    }
                }
                temp = temp.getSiguiente();
            } while (temp != raiz);
        }
    }
    
    public void imprimir() {
        NodoCircular<T> reco = raiz;
        do {
            System.out.println(reco.getData().toString());
            System.out.println("-----------------------");
            reco = reco.getSiguiente();
        } while (reco != raiz && reco!=null);
    }

    
    private class NodoCircular<T>{
        private NodoCircular<T> siguiente;
        private NodoCircular<T> anterior;
        private T data;
        private int id;
        
        private NodoCircular(int id, T data, NodoCircular<T> siguiente, NodoCircular<T> anterior){
            this.data = data;
            this.siguiente = siguiente;
            this.anterior = anterior;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        
        private NodoCircular<T> getSiguiente(){
            return this.siguiente;
        }
        
        private NodoCircular<T> getAnterior(){
            return this.anterior;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setSiguiente(NodoCircular<T> siguiente) {
            this.siguiente = siguiente;
        }

        public void setAnterior(NodoCircular<T> anterior) {
            this.anterior = anterior;
        }
    }
}
