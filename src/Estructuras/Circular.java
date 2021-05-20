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
    static final String INICIO_GRAFICO = "digraph G{\n"
            + "node [shape = record,height=.1];";
    private NodoCircular<T> raiz;

    public Circular() {
        raiz = null;
    }

    /**
     * Método que insertar el elemento a la lista circular
     *
     * @param id los datos del elemento
     * @param data el identificador del elemento
     */
    public void insertar(long id, T data) {
        if (raiz == null) {
            raiz = new NodoCircular(id, data, null, null);
            raiz.setSiguiente(raiz);
            raiz.setAnterior(raiz);
        } else {
            imprimir();
            System.out.println("ingreso\n\n");
            NodoCircular<T> temp = raiz;
            do {
                if (temp.getSiguiente() == raiz) {
                    if (temp.getId() > id) {
                        System.out.println(id + " fase 1");
                        NodoCircular<T> nuevo = new NodoCircular(id, data, temp, temp.getAnterior());
                        temp.getAnterior().setSiguiente(nuevo);
                        raiz = nuevo;
                        break;
                    } else {
                        System.out.println(id + " fase 2");
                        NodoCircular<T> nuevo = new NodoCircular(id, data, raiz, temp);
                        temp.setSiguiente(nuevo);
                        temp.setAnterior(nuevo);
                        break;
                    }
                } else {
                    if (temp == raiz && temp.getId() > id) {
                        System.out.println(id + " fase 3");
                        NodoCircular<T> nuevo = new NodoCircular(id, data, temp, temp.getAnterior());
                        nuevo.getAnterior().setSiguiente(nuevo);
                        temp.setAnterior(nuevo);
                        raiz = nuevo;
                        imprimir();
                        break;
                    } else {
                        if (temp.getId() < id && temp.getSiguiente().getId() > id) {
                            System.out.println(id + " fase 4");
                            NodoCircular<T> nuevo = new NodoCircular(id, data, temp.getSiguiente(), temp);
                            temp.setSiguiente(nuevo);
                            temp.setAnterior(nuevo);
                            break;
                        }
                        System.out.println(id + " fase f");
                    }
                }
                temp = temp.getSiguiente();
            } while (temp != raiz);
        }
    }

    public void insertar2(long id, T data) {
        NodoCircular<T> nuevo = new NodoCircular(id, data, null, null);
        if (raiz == null) {
            raiz = nuevo;
            raiz.setSiguiente(raiz);
            raiz.setAnterior(raiz);
        } else {
            NodoCircular<T> temp = raiz;
            boolean mayor = false;
            do {
                if (temp.getId() > id) {
                    System.out.println(temp.getId() + " > " + id);
                    mayor = true;
                    break;
                }
                if (temp.getSiguiente() == raiz) {
                    break;
                } else {
                    temp = temp.getSiguiente();
                }
            } while (temp != raiz);
            if (temp == raiz) {
                if (temp.getSiguiente() == raiz) {
                    if (mayor) {
                        nuevo.setSiguiente(temp);
                        nuevo.setAnterior(temp);
                        temp.setSiguiente(nuevo);
                        temp.setAnterior(nuevo);
                        raiz = nuevo;
                    } else {
                        temp.setSiguiente(nuevo);
                        temp.setAnterior(nuevo);
                        nuevo.setSiguiente(raiz);
                        nuevo.setAnterior(raiz);
                    }
                } else {
                    if (mayor) {
                        nuevo.setSiguiente(temp);
                        nuevo.setAnterior(temp.getAnterior());
                        temp.getAnterior().setSiguiente(nuevo);
                        temp.setAnterior(nuevo);
                        raiz = nuevo;
                    } else {
                        nuevo.setSiguiente(temp.getSiguiente());
                        nuevo.setAnterior(temp);
                        temp.getSiguiente().setAnterior(nuevo);
                        temp.setSiguiente(nuevo);
                    }
                }
            } else {
                if (mayor) {
                    nuevo.setAnterior(temp.getAnterior());
                    nuevo.setSiguiente(temp);
                    temp.getAnterior().setSiguiente(nuevo);
                    temp.setAnterior(nuevo);
                } else {
                    nuevo.setAnterior(temp);
                    nuevo.setSiguiente(temp.getSiguiente());
                    temp.getSiguiente().setAnterior(nuevo);
                    temp.setSiguiente(nuevo);
                }
            }
            imprimir();
        }
    }

    public void eliminar(long id) {
        NodoCircular<T> reco = raiz;
        if (raiz == null) {
            System.out.println("No hay datos");
        } else {
            boolean encontrado = false;
            do {
                if (reco.getId() == id) {
                    encontrado = true;
                    break;
                } else {
                    reco = reco.getSiguiente();
                }
            } while (reco != raiz);
            if (encontrado) {
                NodoCircular<T> aux = reco.getAnterior();
                NodoCircular<T> temp = reco.getSiguiente();
                if (reco != raiz) {
                    if (reco.getSiguiente() == raiz) {
                        System.out.println("entra if1" + reco.getId());
                        aux.setSiguiente(raiz);
                        raiz.setAnterior(aux);
                    } else {
                        System.out.println("entra if2" + reco.getId());
                        reco.getAnterior().setSiguiente(reco.getSiguiente());
                        reco.getSiguiente().setAnterior(reco.getAnterior());
                    }
                } else {
                    if (reco.getSiguiente() == raiz) {
                        raiz = null;
                    } else {
                        System.out.println("entra acá");
                        aux.setSiguiente(reco.getSiguiente());
                        reco.getSiguiente().setAnterior(aux);
                        raiz = reco.getSiguiente();
                    }
                }
            } else {
                System.out.println("No hay datos donde buscar");
            }
        }
    }
    
    public T obtener(long id) {
        NodoCircular<T> reco = raiz;
        do {
            if (reco.getId() == id){
                return reco.getData();
            }
            reco = reco.getSiguiente();
        } while (reco != raiz);
        return null;
    }

    public void imprimir() {
        NodoCircular<T> reco = raiz;
        do {
            System.out.println("anterior: " + reco.getAnterior().getId() + " actual: " + reco.getId() + " siguiente: " + reco.getSiguiente().getId());
            System.out.println("-----------------------");
            reco = reco.getSiguiente();
        } while (reco != raiz);
    }
    
    public String documento(){
        return INICIO_GRAFICO+estructura_graphviz()+"}";
    }
    
    public String estructura_graphviz(){
        NodoCircular<T> reco = raiz;
        String retorno = "";
        do {
            retorno += "nodeCIR" + reco.getId() + "[label = \" " + reco.getData().toString() + " \"];\n";
            retorno += "\"nodeCIR" + reco.getId() + "\" -> \"nodeCIR" + reco.getSiguiente().getId() + "\"\n";
            retorno += "\"nodeCIR" + reco.getId() + "\" -> \"nodeCIR" + reco.getAnterior().getId() + "\"\n";
            reco = reco.getSiguiente();
        } while (reco != raiz);
        return retorno;
    }

    private class NodoCircular<T> {

        private NodoCircular<T> siguiente;
        private NodoCircular<T> anterior;
        private T data;
        private long id;

        private NodoCircular(long id, T data, NodoCircular<T> siguiente, NodoCircular<T> anterior) {
            this.data = data;
            this.siguiente = siguiente;
            this.anterior = anterior;
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        private NodoCircular<T> getSiguiente() {
            return this.siguiente;
        }

        private NodoCircular<T> getAnterior() {
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
