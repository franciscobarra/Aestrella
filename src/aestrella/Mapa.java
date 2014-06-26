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
public class Mapa {
     private Character [][] mapa;
    
    public Mapa(){
          this.mapa = construirMapa();
    }
    
    public Character[][] construirMapa(){
        
        Character [][] mapa = {{'P','P','P','P','P','P','P','P','P','P'},
                               {'V','V','P','V','V','P','V','V','V','V'},
                               {'P','V','V','V','M','P','V','P','V','P'},
                               {'P','V','P','V','V','V','V','V','V','P'},
                               {'P','V','M','V','P','V','V','P','M','P'},
                               {'P','P','P','P','P','P','P','P','P','P'}};
        return mapa;
    }
    
    public Character[][] getMapa(){
        return mapa;
    }

}

