# Concurrent-programing
Study, analysis and creation of mixed problem. Focused on the problem of commensal philosophers, a classic problem of concurrency. The second problem used, it is also a classic:  readers and writers
## Java
The Main class is where the methods to initialize processes are found, through start () and
join (). In this instance, "import java.util.concurrent.Semaphore;" is used. This library allows the use and
traffic light management. You need to use exception handling for correct operation. Every time that an attempt is made to request “entry” from a semaphore, we will have to add the corresponding try and catch to this exception.
In Share, the variables are declared to establish the shared resources, which will be acquired by the
processes: plates and sticks. The use of semofores will then be to protect these two variables.
"Philosopher" is the abstract class (not instantiated) where the philosopher is defined, along with the sleep () methods,
Grab Stick () and Drop Stick (). Sleep () is implemented to be able to appreciate in detail the execution of the
program through the interface,

Gloton, Diablo and Normal inherit from the Philosopher class, therefore they inherit all their behaviors and
they must rewrite all those that distinguish them. In this case, it is the eating method, which is different
for each class.
This way, everyone needs to go through the semafores, dining room (capacity 4), cutlery (capacity 5),
modify (capacity 1) and plates (capacity 1) to fulfill all your tasks in each run.
All classes inherit the run method, which sets the executions concurrently. 
The method must be used in the following way "@Override" that allows it to be differentiated and used, "public
"Void run () {" enter code "}.
In the main class we have the "start", which starts the processes to run concurrently and
the “join” that awaits the eventual culmination of the processes. Interactions are shown via print
screen.
