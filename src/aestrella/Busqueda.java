package aestrella;

import java.awt.Point;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Segurity
 */
public class Busqueda {
    public PriorityQueue<Estado> abierto;
    private ArrayList<Estado> cerrado;
    public ArrayList<Point> metas;
    private Estado actual,meta;
    private boolean busqueda;
    
    public Busqueda(Estado actual,Estado meta){
        Point punto;
        this.actual = actual;
        this.meta = meta;
        this.metas = new ArrayList<>();
        punto = new Point(2,4);
        this.metas.add(punto);
        punto = new Point(4,8);
        this.metas.add(punto);
        punto = new Point(1,9);
        this.metas.add(punto);
        abierto = new PriorityQueue<Estado>();
        cerrado = new ArrayList<Estado>();
    }
    
    public void iniciarBusqueda() {
        boolean esEstadoMeta = false;
        ArrayList<Estado> resultado;
       
        abierto.add(actual);
        
  
        while(!abierto.isEmpty() && !esEstadoMeta) {
              actual = abierto.poll();
              if(!cerrado.contains(actual)) {
          
                cerrado.add(actual);
           
                expandir(actual);

                if(actual.equals(meta)){
                    if(actual.getX()==1 && actual.getY()==9)esEstadoMeta = true;
                    else{
                    meta.setX(metas.get(0).x);
                    meta.setY(metas.get(0).y);
                    metas.remove(0);
                    
                    cerrado.clear();
                    abierto.clear();
                    expandir(actual);
                    }
                }
                  
            }
            
              abierto.remove(0); // busqueda en anchura
        }
            
        resultado = new ArrayList<>();
      
        while(actual.getAntecesor() != null) {
            resultado.add(0, actual);
            actual = actual.getAntecesor();
        }
        
        actual.printMapa();
        actual.printResultado(resultado);
    }

    
    public void expandir(Estado actual){
        Estado opcion;
     if(actual.moverArriba()){
           opcion = new Estado(actual.getX()-1,actual.getY(), 0,"Se movio Arriba ("+(actual.getX()-1)+")("+actual.getY()+"):",actual);
           opcion.calcularF(actual, meta);
           abierto.add(opcion); // busqueda en anchura;

        }
        
        if(actual.moverDerecha()){
           opcion = new Estado(actual.getX(),actual.getY()+1, 0,"Se movio Derecha ("+(actual.getX())+")("+(actual.getY()+1)+"):",actual);
           opcion.calcularF(actual, meta);
           abierto.add(opcion); // busqueda en anchura;
        }   
        
        if(actual.moverAbajo()){
           opcion = new Estado(actual.getX()+1,actual.getY(), 0,"Se movio Abajo ("+(actual.getX()+1)+")("+(actual.getY())+"):",actual);
           opcion.calcularF(actual, meta);
           abierto.add(opcion); // busqueda en anchura;
        }
        
        if(actual.moverIzquierda()){
           opcion = new Estado(actual.getX(),actual.getY()-1, 0,"Se movio Izquierda ("+(actual.getX())+")("+(actual.getY()-1)+"):",actual);
           opcion.calcularF(actual, meta);
           abierto.add(opcion); 
    } 
  }
    

}
