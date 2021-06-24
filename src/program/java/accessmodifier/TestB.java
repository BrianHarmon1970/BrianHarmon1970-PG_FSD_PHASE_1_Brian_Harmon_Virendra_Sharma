package program.java.accessmodifier;
class TestA 
{
	private int y = 10 ; // private variable
	long k = 1000 ; // default variable
	public void methodPublic() 
	{
			methodPrivate() ;
	}
	protected void methodProtected()
	{
		methodPrivate() ;
	}
	void methodDefault()
	{	
		methodPrivate() ;
	}
	private void methodPrivate()
	{
		System.out.println("Class TestA:methodPrivate().") ;
		System.out.println("Value of private value y = "+y) ;
		System.out.println("Value of long K = " + k ) ;
	}
}

public class TestB
{
	public static void main( String args[] ) 
	{
		new TestA().methodPublic() ;
		new TestA().methodProtected();
		new TestA().methodDefault();
		System.out.println("Value of long"+ new TestA().k ) ;
	}
	public void methodPublic() 
	{
		System.out.println("Class TestB: methodPublic()") ;
	}
	protected void methodProtected()
	{
		System.out.println("Class TestB: methodProtected()") ;
	}
	void methodDefault()
	{
		System.out.println("Class TestB: methodDefault()") ;
	}
	private void methodPrivate()
	{
		System.out.println("Calss TestB: methodPrivate()") ;
	}
}

