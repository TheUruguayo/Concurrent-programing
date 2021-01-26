
package semaforo1;

// java program to demonstrate  
// use of semaphores Locks 
import java.util.concurrent.*; 
  
//Nuestros recursos compartidos 

abstract class Philosofer extends Thread 
{   //public static Visuales a=new Visuales();
   
    int count=0;
    int comer=0;         //sacar
    Semaphore modifcar ; //modificar palitos, modifies palitos (sticks)
    Semaphore servicios; //accede a los platos, protects acces/reads/writes plates
    Semaphore comedor;   //entrada al comedor, poroteje el recuros, the comedor (diner) implements extra protection
    Semaphore cubiertos; //proteje el limite, protects the amount of sticks
    Shared recurso;      //recursos compartidos, shared resources
    String threadName;   //
    boolean bandera=false;
    static int cuantos=0;
    //constructor , pide 2 semaforos
    
    public Philosofer(Semaphore sem, String threadName,Semaphore unosCubiertos,Shared recurso,Semaphore readywrite, Semaphore cuidaplatos)  
    { 
        super(threadName); 
        this.comedor = sem; 
        this.cubiertos = unosCubiertos; 
        this.threadName = threadName; 
        this.recurso = recurso;
        this.modifcar = readywrite;
        this.servicios = cuidaplatos;
    } 
 public void GrabStick( String palito){
       try{//lee y modifica palitos
                    this.cubiertos.acquire();
                    // System.out.println(this.threadName+ " agarra " + palito);
                    
                    this.modifcar.acquire();     //limite 1                    
                    recurso.setPalitos(recurso.getPalitos()-1);
                    System.out.println(this.threadName+ " takes " + palito+   " left "+ recurso.getPalitos() +" sticks");
                     
                    //System.out.println( " quedan "+ recurso.getPalitos() +" palitos");
                    this.modifcar.release();
         }
                catch (InterruptedException exc){};
  }

 public void DropStick( String palito){
       try{//lee y modifica palitos
                    this.modifcar.acquire();     //limite 1
                    // System.out.println(this.threadName+ " deja " + palito);
                    
                    recurso.setPalitos(recurso.getPalitos()+1);
                    System.out.println(this.threadName+ " drops " + palito+   " left "+ recurso.getPalitos() +" sticks");
                    
                    //System.out.println( " quedan "+ recurso.getPalitos() +" palitos");
                    this.modifcar.release();
                    
                    this.cubiertos.release();
                    
                }
                catch (InterruptedException exc){};
  }

   public void Eat( ){
   }
    @Override
    public void run() { 
          
         
        
    } 
} 