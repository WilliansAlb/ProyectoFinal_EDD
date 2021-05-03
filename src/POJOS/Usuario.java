/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

/**
 *
 * @author willi
 */
public class Usuario {
    private int id;
    private String name;
    private String password;
    private boolean colaborador;

    public Usuario(int id, String name, String password, boolean colaborador) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.colaborador = colaborador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isColaborador() {
        return colaborador;
    }

    public void setIsColaborador(boolean colaborador) {
        this.colaborador = colaborador;
    }
    @Override
    public String toString(){
        return id+"\\n"+name+"\\n"+password+"\\n"+colaborador;
    }
}
