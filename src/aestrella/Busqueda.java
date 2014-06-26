package aestrella;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Segurity
 */
public class Busqueda {
    public PriorityQueue<Estado> abierto;
    private ArrayList<Estado> cerrado;
    private Estado actual,meta;
    private boolean busqueda;
    
    public Busqueda(Estado actual,Estado meta){
        this.actual = actual;
        this.meta = meta;
        abierto = new PriorityQueue<Estado>();
        cerrado = new ArrayList<Estado>();
    }
    
    /**
     * Metodo que inicia la busqueda
     * @return ArrayList 
     */
    public void iniciarBusqueda() {
        boolean esEstadoMeta = false;
        ArrayList<Estado> resultado;
       
        abierto.add(actual);
        
  
        while(!abierto.isEmpty() && !esEstadoMeta) {
              actual = abierto.poll();
              if(!cerrado.contains(actual)) {
          
                cerrado.add(actual);
           
                expandir(actual);
              
                if(actual.equals(meta)) esEstadoMeta = true;
                  
            }
            abierto.remove(0); 
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
