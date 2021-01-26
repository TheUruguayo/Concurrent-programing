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
// Driver class 

public class Main
{
    
    public static void Olbligatorio() throws InterruptedException{

}
    
    public static void main(String args[]) throws InterruptedException  
    { 
        
     
        Semaphore comedor = new Semaphore(4); 
        Semaphore cubiertos = new Semaphore(5);  
        Semaphore modificar = new Semaphore(1);
        Semaphore platos= new Semaphore(1);
        Shared s=new Shared();
        
        //just names of philosofers
        Gloton mt1 = new Gloton(comedor, "Gloton",cubiertos,s,modificar,platos); 
        Diablo mt2 = new Diablo(comedor, "Diablo",cubiertos,s,modificar,platos); 
        Normal mt3 = new Normal(comedor, "Nacho",cubiertos,s,modificar,platos); 
        Normal mt4 = new Normal(comedor, "Bruno",cubiertos,s,modificar,platos); 
        Normal mt5 = new Normal(comedor, "Nico",cubiertos,s,modificar,platos);       
          
         
        // stating threads 
        mt1.start(); 
        mt2.start(); 
        mt3.start();
        mt4.start();
        mt5.start();
        // waiting for threads  
        mt1.join(); 
        mt2.join(); 
        mt3.join();   
        mt5.join();
        
          System.out.println(mt1.threadName+" ate " +mt1.comer+" times");
          System.out.println(mt2.threadName+" ate " +mt2.comer+" times");
          System.out.println(mt3.threadName+" ate " +mt3.comer+" times");
          System.out.println(mt4.threadName+" ate " +mt4.comer+" times");
          System.out.println(mt5.threadName+" ate " +mt5.comer+" times");          
          System.out.println("Total of plates consumed: "+(mt1.comer+mt2.comer+mt3.comer+mt4.comer+mt5.comer));
     
    }       
} 
