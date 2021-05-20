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
    public final int COLABORADOR = 0;
    public final int ESTUDIANTE = 1;
    public final int SUPER = 2;
    private int tipo;
    private int id;
    private String name;
    private String password;

    public Usuario() {
    }

    
    
    public Usuario(int id, String name, String password, int tipo) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.tipo = tipo;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo(int buscado){
        switch(buscado){
            case COLABORADOR:
                return "colaborador";
            case ESTUDIANTE:
                return "estudiante";
            case SUPER:
                return "super";
            default:
                return "super";
        }
    }
    
     public int getTipo(String buscado){
        switch(buscado){
            case "colaborador":
                return COLABORADOR;
            case "estudiante":
                return ESTUDIANTE;
            case "super":
                return SUPER;
            default:
                return SUPER;
        }
    }

    
    @Override
    public String toString(){
        return id+"\\n"+name+"\\n"+password+"\\n"+getTipo(tipo);
    }
}
