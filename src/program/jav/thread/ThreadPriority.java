package program.jav.thread;

public class ThreadPriority extends Thread{  
	 
	public void run(){  
	   System.out.println("running thread name is:"+Thread.currentThread().getName());  
	   System.out.println("running thread priority is:"+Thread.currentThread().getPriority());  
	   System.out.println("running thread state is:"+ Thread.currentThread().getState());
	   System.out.println("The thread group is:"+Thread.currentThread().getThreadGroup());
	   System.out.println("The thread id is:"+Thread.currentThread().getId());
	   System.out.println("Is my thread alive or not? :  "+Thread.currentThread().isAlive());
	   System.out.println("Is my thread Daemon or not? :  "+Thread.currentThread().isDaemon());
	  }  
	
	 public static void main(String args[]){  
	  
	  ThreadPriority m1=new ThreadPriority();  
	  ThreadPriority m2=new ThreadPriority();  
	  
	  m1.setName("Abc");
	  m2.setName("XYZ");
	 
	  m1.setPriority(MIN_PRIORITY);  
	  m2.setPriority(MAX_PRIORITY);  
	  
	  m1.start();  
	  m2.start();  
	   
	 }  
	}     
