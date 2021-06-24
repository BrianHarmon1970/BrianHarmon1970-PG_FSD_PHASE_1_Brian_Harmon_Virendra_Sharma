package program.jav.thread;

public class JoinThread extends Thread{  
	
	 public void run(){  
	  for(int i=1;i<=5;i++){  
	   try{  
	    Thread.sleep(500);  
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }  
	  System.out.println(i);  
	  }  
	 }  
	 
	public static void main(String args[]){  
	
	 JoinThread t1=new JoinThread();  
	 JoinThread t2=new JoinThread();  
	 JoinThread t3=new JoinThread();  
	 t1.start();  
	 
	 try{  
	  t1.join();  
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }  
	  
	 t2.start();  
	 t3.start();  
	 }  
	}  
