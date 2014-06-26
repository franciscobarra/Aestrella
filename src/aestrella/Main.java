/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aestrella;

/**
 *
 * @author Segurity
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estado inicial, fin;
        Busqueda busqueda;
        
        inicial = new Estado(1,0,0,null,null);
        fin = new Estado(1,9,0,null,null);
        
        busqueda = new Busqueda(inicial , fin );
        
        busqueda.iniciarBusqueda();
        
        
        
        
        
    }
    
}
