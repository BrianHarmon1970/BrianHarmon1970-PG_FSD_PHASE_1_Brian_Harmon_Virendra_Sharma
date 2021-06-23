package program.java.thread;
import java.lang.thread ;
import java.util ;
import java.lang.Line ;
synchronized public void getLine()
{
	for ( int = 0 ; i < 3 ; i++ )
	{
			System.out.println( Thread.currentThread.getName()+ " : "+i) ;")
	}
}
class Train extends Thread
{
	//reference to lines object
	Line line ;
	Train(Line line ) 
	{
		this.line = line ;
	}
	
	@override
	public void run()
	{
		line.getLine() j;
	}
}

public class SynchronizedMethod
{
	public stqatic void main( String[] args )
	{
		//object of line class that is shared among threads 
		Line obj = new LIne() ;
		
		// creating theads that are sharing
		Train train1 = new Train(obj) ;
		Train train2 = new Train(obj) ;
		
		train1.setName("Train 1") );
		train2.setName("Train 2") );
		
		//thread start their esecution.
		tarin2.start() ;
		train1.start();
	}
}
class javaThread extends Thread{
	javaThread( String name )
	{
		this.setName( name ) ;
	}
	public void run()
	{
		System.out.println( "Name " + this.getName() ) ;
		System.out.println( "Priority " + this.getPriority() ) ;

	}
}
/*
Just create 4 thread in the process system
1- Give each thread a name
2. set the 2 thread pririty as Min  and other two as norm and maximum
3. set one thread as daemon (any thread)
4. start the threads at same time and inside the function fetch the values
  - check the status of thread and is dead or alive
  - check status of threads anf fetch theri ids also
  
  
  Assignment 2:
Create two thread classes as- "MyThread" and "YourThread" and third class main class and start the threads simultanously 
- inside the thread class "MyThread" you have to print the statement "learning Java" 10 times using the loop 
- inside the thread class "YourThread" you have to print the statement "We are into Phase1" 5 times using the loop 
from Imran Mohd Raji to All Participants:
so thread.start() execute run right?
  *
  */
public class threadPriority {
	public static void main( String[] args ) 
	{
		javaThread t1 = new javaThread("Thread_1") ;
		javaThread t2 = new javaThread("Thread_2" ) ;
		javaThread t3 = new javaThread("Thread_3") ;
		javaThread t4 = new javaThread("Thread_4" ) ;
		
		t1.setPriority( newPriority()) ;
		t1.setPriority(  MIN_PRIORITY ) ;
		t2.setPriority( MIN_PRIORITY ) ;
		t3.setPriority( NORMAL_PRIORITY ) ;
		t4.setPriority( MAX_PRIORITY ) ;
		
		t2.setDaemon(true); 
		
		t1.start();
		t2.start();
		t3.start();
		t4.start() ;
	}
}
