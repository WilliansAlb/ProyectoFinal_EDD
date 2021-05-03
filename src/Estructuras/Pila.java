/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author willi
 */
public class Pila <T> {

    private Nodo<T> root;

    public Pila(){
        root = null;
    }

    public void push(T data){
       if (root!=null) {
           Nodo<T> tmp = root;
            root = new Nodo(data, tmp);
       }
       else{
           root = new Nodo(data,null);
       }
    }

    public T pop(){
        if (root != null){
            T data = root.getData();
            root = root.getNext();
            return data;
        }
        else
            return null;
    }

    private class Nodo <T>{

        private Nodo<T> next;
        private T data;

        private Nodo(T data, Nodo<T> next){
            this.next = next;
            this.data = data;
        }

        private Nodo<T> getNext(){
            return this.next;
        }

        private T getData(){
            return this.data;
        }

        public void setNext(Nodo<T> next) {
            this.next = next;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
    
}
