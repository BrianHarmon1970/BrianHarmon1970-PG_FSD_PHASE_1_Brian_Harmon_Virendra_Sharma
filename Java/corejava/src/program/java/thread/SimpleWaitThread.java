package program.java.thread;
class Customer{
	int amount = 10000 ;
	
	synchronized void withdraw( int amount ) 
	{
		System.out.println("goint to withdraw...") ;
		
		if ( this.amount<amount )
		{
			System.out.println("Less balance; waiting for deposit...") ;
			try {
				wait() ;
			}
			catch( Exception e ) {}
			
		}
		this.amount-=amount ;
		System.out.println("withdraw completed..the left over amount is" + this.amount);
		
	}
	synchronized void deposit(int amount) 
	{
			System.out.println("goin to deposit...") ;
			this.amount+=amount ;
			
			System.out.println("deposit completed..."+this.amount) ;
			notify(); // unlocking of thread
			
	}
}
public class SimpleWaitThread
{
	public static void main( String[] args ) 
	{
		final Customer c = new Customer() ;
		
		new Thread()
		{
			public void run()
			{
				c.withdraw(5000) ;
			}
		}.start();
		
		new Thread()
		{
			public void run()
			{
				c.withdraw(4000) ;
			}
		}.start();
		
		new Thread()
		{
			public void run()
			{
				c.withdraw(1000) ;
			}
		}.start();
		
		new Thread()
		{
			public void run()
			{
				c.deposit(20000) ;
			}
		}.start();
		
	}

}
