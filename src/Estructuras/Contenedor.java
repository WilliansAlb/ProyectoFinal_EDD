/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Estructuras.*;
import POJOS.*;
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class Contenedor {

    public Circular usuarios = new Circular();
    public Circular edificios = new Circular();
    public Circular cursos = new Circular();
    public Hash estudiantes = new Hash();
    public AVL catedraticos = new AVL();
    public B horarios = new B(3);
    public SimpleEnlazada resultado = new SimpleEnlazada();
    public int conteo_res = 0;
    public Usuario tem = new Usuario();
    public int asignaciones = 1;

    public Contenedor() {
        estudiantes.rellenar();
    }

    public void insertar_estudiante(int carnet, String nombre, String direccion) {
        Estudiante temp = new Estudiante(carnet, nombre, direccion);
        if (!estudiantes.insertar(carnet, temp)) {
            System.out.println("estudiante ingresado");
            resultado.ingresar(conteo_res, "Estudiante con el carnet " + carnet + " no ingresado por exceder el numero maximo de llaves");
        } else {
            System.out.println("no ingresado");
            resultado.ingresar(conteo_res, "Estudiante con el carnet " + carnet + " ingresado con exito");
        }
        conteo_res++;
    }

    public void insertar_usuario(int id, String nombre, String password, String tipo) {
        Usuario nuevo = new Usuario(id, nombre, password, tem.getTipo(tipo));
        if (nuevo.getTipo() == nuevo.ESTUDIANTE) {
            Estudiante e = estudiantes.buscar(id);
            if (e == null) {
                resultado.ingresar(conteo_res, "Usuario con el id " + id + " no ingresado por no existir en la hash de estudiantes");
            } else {
                usuarios.insertar2(id, nuevo);
                resultado.ingresar(conteo_res, "Usuario con el id " + id + " ingresado con exito");
            }
        } else {
            usuarios.insertar2(id, nuevo);
            resultado.ingresar(conteo_res, "Usuario con el id " + id + " ingresado con exito");
        }
        conteo_res++;
    }

    public void insertar_catedratico(int id, String nombre, String direccion) {
        Catedratico ca = new Catedratico(id, nombre, direccion);
        catedraticos.insertar(id, ca);
        resultado.ingresar(conteo_res, "Catedratico con el id " + id + " ingresado con exito");
        conteo_res++;
        System.out.println("catedratico ingresado");
    }

    public void insertar_edificio(String numero) {
        Edificio ed = new Edificio(numero.hashCode(), numero);
        edificios.insertar2(numero.hashCode(), ed);
        resultado.ingresar(conteo_res, "Edificio con el id " + numero + " ingresado con exito");
        conteo_res++;
        System.out.println("edificio ingresado");
    }

    public void insertar_salon(String edificio, int numero, int capacidad) {
        Edificio ed = (Edificio) edificios.obtener(edificio.hashCode());
        if (ed != null) {
            Salon nuevo = new Salon(ed, numero, capacidad);
            ((Edificio) edificios.obtener(edificio.hashCode())).getSalones().ingresar(numero, nuevo);
            System.out.println("salon insertado");
            resultado.ingresar(conteo_res, "Salon con el numero " + numero + " ingresado con exito");
        } else {
            resultado.ingresar(conteo_res, "Salon con el numero " + numero + " no fue ingresado por no existir el edificio donde le correspondia");
        }
        conteo_res++;
    }

    public void insertar_curso(int codigo, String nombre, int semestre, int creditos) {
        Curso cu = new Curso(codigo, nombre, semestre, creditos);
        cursos.insertar2(codigo, cu);
        resultado.ingresar(conteo_res, "Curso con el codigo " + codigo + " ingresado con exito");
        conteo_res++;
        System.out.println("insertar curso");
    }

    public void insertar_horario(int codigo, String rango, String dia, int curso, int salon, String edificio, int catedratico) {
        Curso c = (Curso) cursos.obtener(curso);
        Edificio e = (Edificio) edificios.obtener(edificio.hashCode());
        Catedratico ca = (Catedratico) catedraticos.obtener(catedratico);
        if (e != null) {
            Salon s = (Salon) e.getSalones().obtener(salon);
            if (ca != null && s != null && c != null) {
                Horario insertar = new Horario(codigo,rango,dia,c,s,e,ca);
                horarios.insertar_horario(codigo,insertar);
                System.out.println("insertar horario");
                resultado.ingresar(conteo_res, "Horario con el codigo " + codigo + " ingresado con exito");
            } else {
                resultado.ingresar(conteo_res, "Horario con el codigo " + codigo + " no fue ingresado porque faltan algunas referencias");
            }
        } else {
            resultado.ingresar(conteo_res, "Horario con el codigo " + codigo + " no fue ingresado por no existir el edificio indicado");
        }
        conteo_res++;
    }

    public void insertar_asignacion(int carnet, int codigo, int zona, int punteo_final) {
        Estudiante es = (Estudiante) estudiantes.buscar(carnet);
        Horario h = horarios.obtener(codigo);
        if (es != null && h != null) {
            Asignacion a = new Asignacion(asignaciones, es, h, zona, punteo_final);
            horarios.obtener(codigo).getAsignaciones().insertar2(asignaciones, a);
            asignaciones++;
            System.out.println("insertar asignacion");
            resultado.ingresar(conteo_res, "Asignacion del estudiante " + carnet + " al horario " + codigo + " ingresada con exito");
        } else {
            if (es==null){
                System.out.println("el estudiante no existe");
            }
            if (h==null){
                System.out.println("el horario no existe");
            }
            resultado.ingresar(conteo_res, "Asignacion del estudiante " + carnet + " al horario " + codigo + " no fue ingresada por no existir alguno de los dos, estudiante u horario");
        }
        conteo_res++;
    }
}
