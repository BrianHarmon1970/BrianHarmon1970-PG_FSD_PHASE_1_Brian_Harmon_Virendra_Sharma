package program2.java.package_one;

public class ClassM 
{
	private int n = 101 ;
	long		l = 1234567890L ;
	protected float f = 123.56f ; 
	
	public void methodPublic( )
	{
		System.out.println( "ClassM.methodPublic()") ;
		methodDefault() ;
		methodPrivate() ;
		methodProtected() ;
	}
	void methodDefault() 
	{
		System.out.println( "ClassM.methodDefault()") ;
		System.out.println( "Value of (default) long l = "+ l ) ;
	}
	protected void methodProtected() 
	{
		System.out.println( "ClassM.methodProtected()") ;
		System.out.println( "Value of protected float f = "+ f ) ;
	}
	private void methodPrivate()
	{
		System.out.println( "ClassM.methodPrivate()") ;
		System.out.println( "Value of private int n = "+ n ) ;
	}
}
