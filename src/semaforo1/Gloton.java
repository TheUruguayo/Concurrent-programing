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
public class Gloton extends Philosofer {
   
    
    public Gloton(Semaphore smphr, String string, Semaphore smphr1, Shared shared, Semaphore rw, Semaphore rw2) {
        super(smphr, string, smphr1,shared,rw,rw2);
    }
     
    @Override
    public void Eat(){
        try{//lee y modifica los platos
                       
                      this.servicios.acquire(); //deja entrar
                      
                       if (recurso.getPlatos()>0) {            //lecutra
                              recurso.setPlatos(recurso.getPlatos()-1);        //escribe
                              comer++;
                             System.out.println("\u001B[31m"+this.threadName+ " is eating"+"\u001B[30m"+"\n"+
                                           "\u001B[31m"+" there are " +recurso.getPlatos()+ " plates"+"\u001B[30m");
                             if (recurso.getPlatos()%2==0&&recurso.getPlatos()>0){ //lectrua
                                 comer++;
                                   recurso.setPlatos(recurso.getPlatos()-1);      //escritura
                                   System.out.println("\u001B[31m"+this.threadName+ " is too hungry, asked for another plate "+"\u001B[30m"+"\n"+
                                                        "\u001B[31m"+" quedan " +recurso.getPlatos()+ " platos"+"\u001B[30m");
                      }

                 }    else {
                           
                           System.out.println(this.threadName+" Is in the table,couldn't eat , is now hungry");
                       bandera=true;
                       }

                    this.servicios.release();
                    //Thread.sleep(1000);
                    
                     
               }catch (InterruptedException exc){};
    
    }
    
    @Override
    public void run() { 
          
        
       System.out.println(  threadName+" Is thinking about food "); 
       
       while (recurso.getPlatos()>0) { //cantidad de platos es 10, se resta uno cuando comen, asincronico, los platos se acaban dentro
                                       //del comedor
            
           try 
            { 
                // Quieren entrar
              System.out.println(threadName + " wants to enter de dinner"); 
              comedor.acquire(); //semaforo entra al comedor
              
              System.out.println(threadName + " is in the dinner"); 
                
              this.GrabStick(" Cutlery 1");
              this.GrabStick("Cutlery 2");
              this.Eat();
              this.DropStick(" Cutlery 1");
              this.DropStick(" Cutlery 2");
            }catch (InterruptedException exc) { 
                    System.out.println(exc); 
                } //el primer try
           
            comedor.release();//te vas del comedor
            System.out.println(threadName + " Leaves the dinner,"+ " is now thinking");
            
            
                 
        } 
        System.out.println(this.threadName+ " Wants better company");  
        
    }  
}
