package program.java.innerclass;


public class InnerClass {
	private int data = 30 ;
	void display() 
	{
		System.out.println("i am inside othe outer class method" ) ;
	}
	
	class Inner{
		private int data = 20 ;
		void msg()
		{
			System.out.println("data is " + data ) ;
		
		}
		
		// calling the duplicate method of the outer class
		void display() 
		{
			System.out.println(" i am insid ;the inner class method" ) ;
			
			
		}
	}
	public static void main( String args[]) 
	{
		InnerClass obj = new InnerClass() ;
		InnerClass.Inner in = obj.new Inner() ;
		in.msg() ;
		in.display();
		
	}
}
