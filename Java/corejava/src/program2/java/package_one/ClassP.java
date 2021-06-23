package program2.java.package_one;

public class ClassP 
{
	public static void main( String args[] ) 
	{
		ClassM instanceM = new ClassM() ;
		ClassN instanceN = new ClassN() ;
	
		instanceM.methodPublic() ;
		//instanceN.methodProteced() ;
		//instanceN.meethodPrivate() ;
		instanceM.methodDefault();
		
		System.out.println( "Value of ClassM:: (default) long l ="+ instanceM.l ) ;
	
		
		instanceN.methodPublic() ;
		//instanceN.methodProteced() ;
		//instanceN.meethodPrivate() ;
		instanceN.methodDefault();
		
		System.out.println( "Value of ClassN::(default) double dd ="+ instanceN.dd ) ;
		System.out.println( "Value of ClassM:: public int n ="+ instanceN.n ) ;
		
		
	}
	public void methodPublic( )
	{
		System.out.println( "ClassP.methodPublic()") ;
	}
	void methodDefault() 
	{
		System.out.println( "ClassP.methodDefault()") ;
	}
	protected void meethodProtected() 
	{
		System.out.println( "ClassP.methodProtected()") ;
	}
	private void methodPrivate()
	{
		System.out.println( "ClassP.methodPrivate()") ;
	}
}
