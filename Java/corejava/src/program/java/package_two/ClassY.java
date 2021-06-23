package program.java.package_two;
import program.java.package_one.ClassM;
import	program.java.package_one.ClassN;
import program.java.package_two.ClassX;

public class ClassY extends ClassN
{
	public static void main( String args[] ) 
	{
		ClassM instanceM = new ClassM() ;
		ClassN instanceN = new ClassN() ;
		ClassX instanceX = new ClassX() ;
	
		instanceM.methodPublic() ;
		//instanceM.methodProtected() ;
		//instanceM.meethodPrivate() ;
		//instanceM.methodDefault();
		
		//System.out.println( "Value of ClassM:: (default) long l ="+ instanceM.l ) ;
	
		
		instanceN.methodPublic() ;
		//instanceN.methodProtected() ;
		new ClassY().methodProtected();
		
		//instanceN.meethodPrivate() ;
		//instanceN.methodDefault();
		
		//System.out.println( "Value of ClassN::(default) double dd ="+ instanceN.dd ) ;
		
		System.out.println( "Value of ClassM:: public int n ="+ instanceN.n ) ;
		
		instanceX.methodPublic() ;
		
		
	}
}
