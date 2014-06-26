/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aestrella;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Segurity
 */
public class Estado implements Comparable<Estado> {
    
    private int x,y;
    private Estado antecesor;
    private String movimiento;
    public Character[][] mapa;
    private Mapa map;
    private double f,g,h;
    
    public Estado( int x , int y ,double f, String movimiento , Estado antecesor){
        this.x = x;
        this.y = y;
        this.g = 0;
        this.h = 0;
        this.f = f;
        this.movimiento = movimiento;
        this.antecesor = antecesor;
        this.map = new Mapa();
        this.mapa = map.construirMapa();
   }
    
    public void calcularF(Estado actual, Estado meta) {

        this.g = actual.getG()
                + Math.sqrt(((Math.pow(Math.abs(actual.getX() - this.getX()), 2))
                        + (Math.pow(Math.abs(actual.getY() - this.getY()), 2))));

        this.h = Math.sqrt(((Math.pow(Math.abs(meta.getX() - this.getX()), 2))
                + (Math.pow(Math.abs(meta.getY() - this.getY()), 2))));

        this.f = this.g + this.h;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void printMapa(){
        System.out.println("Mapa Inicial : ");
        for(int i=0;i<6;i++){
            for(int j=0; j<10; j++){
                if(i==this.x && j==this.y){
                    System.out.print("  *"); 
                }
                else{
                System.out.print("  "+mapa[i][j]);
                }
            }
            System.out.print("\n");
         }
    }
    
    public void printResultado(ArrayList<Estado> actual){
       for(int x=0;x<actual.size();x++){
           System.out.println(actual.get(x).movimiento+" || paso -> "+(x+1)); 
            for(int i=0;i< 6;i++){
               for(int j=0; j< 10; j++){
                   if(i==actual.get(x).x && j==actual.get(x).y){
                      mapa[i][j]='V'; 
                      System.out.print("  *");  
                    }
                    else{
                      System.out.print("  "+mapa[i][j]);
                    }
                }
                System.out.print("\n");
            }
        }
    }
    
    public double getG() {
        return g;
    }

    public double getH() {
        return h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Estado getAntecesor() {
        return antecesor;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public double getF() {
        return f;
    }
    
    public boolean moverArriba(){
        if(this.x-1>=0){
           return mapa[this.x-1][this.y]=='V' || mapa[this.x-1][this.y]=='M';
        }
        return false;
    }
     public boolean moverAbajo(){
         if(this.x+1 < 5){
           return mapa[this.x+1][this.y]=='V' || mapa[this.x+1][this.y]=='M';
        }
        return false;
    }
      public boolean moverIzquierda(){
          if(this.y-1>=0){
           return mapa[this.x][this.y-1]=='V' || mapa[this.x][this.y-1]=='M' ;
        }
        return false;
    }
       public boolean moverDerecha(){
         if(this.y+1 < 10){
           return mapa[this.x][this.y+1]=='V' || mapa[this.x][this.y+1]=='M' ;
         }
         return false;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object x) {
        Estado e = (Estado) x;
        return this.x == e.x && this.y == e.y;
    }

    @Override
    public int compareTo(Estado o) {
        if (o.getF() == this.getF()) {
            return 0;
        } else if (this.getF() > o.getF()) {
            return 1;
        }

        return -1;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.x;
        hash = 89 * hash + this.y;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.f) ^ (Double.doubleToLongBits(this.f) >>> 32));

        return hash;
    }

}