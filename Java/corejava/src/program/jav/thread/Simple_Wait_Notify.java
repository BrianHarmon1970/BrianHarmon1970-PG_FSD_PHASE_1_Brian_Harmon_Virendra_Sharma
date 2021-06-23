package program.jav.thread;

class Customer{  
int amount=10000;  
  
	synchronized void withdraw(int amount){  
	System.out.println("going to withdraw...");  
	  
		if(this.amount<amount)
		{  
		System.out.println("Less balance; waiting for deposit...");  		
		try{
			wait();
		   }
		catch(Exception e){}  
		}  
		this.amount-=amount;  
		System.out.println("withdraw completed...the lefft over amount is"+ this.amount);  
	}  
  
	synchronized void deposit(int amount){  
		System.out.println("going to deposit...");  
		this.amount+=amount;  
		
		System.out.println("deposit completed... " + this.amount);  
		notify();  
	}  
}  
  
public class Simple_Wait_Notify{  
	public static void main(String args[]){  
		final Customer c=new Customer();  
		
		new Thread(){  
		  public void run()
		  {
			c.withdraw(15000);
		  }  
		}.start();  
		
		new Thread(){  
		  public void run()
		   {
			 c.deposit(10000);
		   }  
		}.start();  
	  
	}}