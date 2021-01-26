/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo1;

import java.util.concurrent.Semaphore;


/**
 *
 * @author Ignac
 */
public class Normal extends Philosofer {
    
    public Normal(Semaphore smphr, String string, Semaphore smphr1, Shared shared, Semaphore rw, Semaphore rw2) {
        super(smphr, string, smphr1,shared,rw,rw2);
    }
    
    @Override
   public void Eat( ){
 try{
                this.servicios.acquire();
                
               if (recurso.getPlatos()>0) {
                    recurso.setPlatos(recurso.getPlatos()-1);
                   System.out.println("\u001B[31m"+this.threadName+ " is eating"+"\u001B[30m"+"\n"+
                                         "\u001B[31m"+" left " +recurso.getPlatos()+ " plates"+"\u001B[30m");
                     comer++;
              } else {
                   System.out.println(this.threadName+" Is in the table,couldn't eat , is now hungry"); 
                   bandera=true;
               }
               
               this.servicios.release();
               //Thread.sleep(1000);
               
               }catch (InterruptedException exc){};
               //Shared.servicios.release();
 }
    @Override
    public void run() { 
          
        
       System.out.println(  threadName+" Is thinking about food "); 
       
       while (recurso.getPlatos()>0) { //cantidad de platos es 10, se resta uno cuando comen
          
            try 
            { 
                // Quieren entrar
                System.out.println(threadName + " wants to enter de dinner"); 
                
                comedor.acquire(); //semaforo entra al comedor
               
                this.GrabStick(" stick 1");
                this.GrabStick(" stick 2");
                this.Eat();
                this.DropStick(" stick 1");
                this.DropStick(" stick 2");
                
          } catch (InterruptedException exc) { 
                    System.out.println(exc);
           } //el primer try
            
                comedor.release();//te vas del comedor
                System.out.println(threadName + " Leaves the dinner,"+ " is now thinking");
                            
                if (bandera){ 
                    break;}
               
        }//endwhile 
      
    }  
}