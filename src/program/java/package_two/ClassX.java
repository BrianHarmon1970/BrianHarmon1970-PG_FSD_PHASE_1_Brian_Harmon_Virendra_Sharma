package program.java.package_two;

public class ClassX
{
	private int n = 333 ;
	long l = 1111222233334444L ;
	protected float f = 321.654321f ;
	public char	ch = 'B' ;
	
	public void methodPublic( )
	{
		System.out.println( "ClassX.methodPublic()") ;
		methodDefault() ;
		methodProtected() ;
		methodPrivate() ;
	}
	void methodDefault() 
	{
		System.out.println( "ClassX.methodDefault()") ;
		System.out.println( "Value of (default) long l = "+ l ) ;
	}
	protected void methodProtected() 
	{
		System.out.println( "ClassX.methodProtected()") ;
		System.out.println( "Value of protected float f = "+ f ) ;
	}
	private void methodPrivate()
	{
		System.out.println( "ClassX.methodPrivate()") ;
		System.out.println( "Value of private int n = "+ n ) ;
	}

}
