package program.jav.thread;

public class RunnableExample implements Runnable {  
	
	public void run(){  
	System.out.println("thread is running...");  
	}  
	  
	public static void main(String args[]){  
	
	RunnableExample m1=new RunnableExample();  
	Thread t1 =new Thread(m1);  
	t1.start();  
 }  
}  
