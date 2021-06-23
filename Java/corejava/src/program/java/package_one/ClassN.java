package program.java.package_one;

public class ClassN 
{
	protected long l = 6543217654321L ;
	public int n = 202 ;
	double dd = 123.123456789123456789 ; // default access double
	
	public void methodPublic( )
	{
		System.out.println( "ClassN.methodPublic()") ;
		methodDefault() ;
		methodProtected() ;
		methodPrivate() ;
	}
	void methodDefault() 
	{
		System.out.println( "ClassN.methodDefault()") ;
		System.out.println( "Value of (default) double dd = "+ dd ) ;
	}
	protected void methodProtected() 
	{
		System.out.println( "ClassN.methodProtected()") ;
		System.out.println( "Value of protected long l = "+ l ) ;
	}
	private void methodPrivate()
	{
		System.out.println( "ClassN.methodPrivate()") ;
	}
}
