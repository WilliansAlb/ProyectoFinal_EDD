/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficas;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author willi
 */
public class Modelo extends DefaultTableModel {
    String[] titulos;
    Object[][] datos;

    /**
     * Determina el modelo con el que se va a construir la tabla
     * @param titulos
     * @param datos 
     */
    public Modelo(String[] titulos, Object[][] datos) {
        super();
        this.titulos = titulos;
        this.datos = datos;
        setDataVector(datos,titulos);
    }
    
    public Modelo(){
    
    }
    
    public boolean isCellEditable(int row, int column){
        return false;
    }
    
}
