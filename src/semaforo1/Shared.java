/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo1;

/**
 *
 * @author Ignac
 */
public class Shared {
          
        
    private  int platos=1000;//cantidad de platos que hay
    //static int count = 0; 
    private  int palitos=5;//palitos

     
    public  void setPlatos(int aPlatos) {
        platos = aPlatos;
    }
 public  int getPlatos() {
        return platos;
    }
    
    public  int getPalitos() {
        return palitos;
    }

   
    public void setPalitos(int aPalitos) {
        palitos = aPalitos;
    }
 
  
}
