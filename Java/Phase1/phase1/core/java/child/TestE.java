package program.java.accessmodifer.child;

import phase1.core.jav.TestB;

public class TestE extends TestB
{
	public static void main( String[] args) 
	{
		new TestE().methodPublic() ;
		
		// works, accessing super class protected method using subclass
		//new TestE().methodProtected() ;
	}
}